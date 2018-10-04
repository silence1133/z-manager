package cn.zxy.zmanager.support;

import cn.zxy.zmanager.support.annotation.AuthorityValue;
import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.constant.AdminConstant;
import cn.zxy.zmanager.support.common.constant.ZUserConstant;
import cn.zxy.zmanager.support.common.exception.BizException;
import cn.zxy.zmanager.support.common.utils.CookieUtils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 校验会话的拦截器
 * @author Silence
 * @data 18/9/21
 */
@Slf4j
public class UserInterceptor extends HandlerInterceptorAdapter {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute(ZUserConstant.USER_LOGIN_SUCCESS);

        HandlerMethod hm = (HandlerMethod) handler;
        if (loginUser == null) {
            throw new BizException(ResultCode.WRONG_PERMISSION);
        }

        return true;
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 检查功能权限
     *
     * @param userInfo 登陆dto
     * @param clazz    c
     * @param method   m
     * @return 是否有权限
     */
    private boolean checkAuth(LoginUser userInfo, Class<?> clazz, Method method) {
        if (userInfo == null || clazz == null || method == null) {
            return false;
        }
        Class<AuthorityValue> ac = AuthorityValue.class;
        //方法注解优先于类注解
        AuthorityValue annotation = method.isAnnotationPresent(ac) ? method.getAnnotation(ac) : clazz.getAnnotation(ac);
        if (annotation == null) {
            return false;
        }

        int type = userInfo.getRoleType();
        //当前方法标注的权限
        int permission = annotation.value();
        if ((permission & (1 << type)) != 0) { //检查权限
            return true;
        }
        return false;
    }
}
