package cn.zxy.zmanager.configuration;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Silence 000996
 * @data 18/9/13
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 程序出错时的异常
     *
     * @param request 请求
     * @param e       异常
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Throwable.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        return "程序出错了";
    }
}
