package cn.zxy.zmanager.configuration;

import cn.zxy.zmanager.common.ResultCode;
import cn.zxy.zmanager.common.ZManagerResult;
import cn.zxy.zmanager.common.exception.BizException;
import cn.zxy.zmanager.common.utils.CommonUtils;
import cn.zxy.zmanager.common.utils.HttpParamUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Silence 000996
 * @data 18/9/13
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({
            BizException.class,
            BindException.class,
            MethodArgumentNotValidException.class,
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ZManagerResult customErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ZManagerResult result;

        Integer errorCode = (Integer) request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
        if (errorCode != null) {
            if (!errorCode.equals(HttpStatus.FORBIDDEN.value())) {
                String errorUrl = (String) request.getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE);
                log.warn("URL:{}, Parameter:{}, ErrorCode:{}", errorUrl, HttpParamUtils.getParameterMap(request), errorCode);
            }
        } else {
            errorCode = HttpStatus.BAD_REQUEST.value();
            log.warn("URL:{}, Parameter:{}, ErrorMsg:{}", request.getServletPath(), HttpParamUtils.getParameterMap(request), e.toString());
        }
        HttpParamUtils.setRealStatusCode(request, errorCode);
        if (e != null && e instanceof BizException) {
            BizException mie = (BizException) e;
            return ZManagerResult.fail(mie.getErrorCode(), mie.getErrorMsg());
        } else if (e != null && e instanceof BindException) {
            result = ZManagerResult.fail(ResultCode.WRONG_PARAMS);
            BindException bindException = (BindException) e;
            List<FieldError> fieldErrorList = bindException.getBindingResult().getFieldErrors();
            if (!CommonUtils.isListEmpty(fieldErrorList)) {
                result.setMsg(fieldErrorList.get(0).getDefaultMessage());
            }
        } else if (e != null && e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            log.warn(methodArgumentNotValidException.getMessage());
            BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
            result = ZManagerResult.fail(ResultCode.WRONG_PARAMS);
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if (!CommonUtils.isListEmpty(fieldErrors)) {
                result.setMsg(fieldErrors.get(0).getField() + fieldErrors.get(0).getDefaultMessage());
            }
        } else {
            log.error(e.getMessage(), e);
            result = ZManagerResult.fail(ResultCode.SERVER_ERROR);
        }
        return result;
    }


    /**
     * 程序出错时的异常
     *
     * @param request 请求
     * @param e       异常
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ZManagerResult defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        log.error("URL:{}, Parameter:{}", request.getRequestURL(), HttpParamUtils.getParameterMap(request), e);
        return ZManagerResult.fail(ResultCode.SERVER_ERROR);
    }
}
