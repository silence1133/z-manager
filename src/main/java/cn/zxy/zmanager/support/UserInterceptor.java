package cn.zxy.zmanager.support;

import cn.zxy.zmanager.support.annotation.AuthorityValue;
import cn.zxy.zmanager.support.common.constant.AdminConstant;
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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //先看request里面有没有
        String token = request.getHeader(AdminConstant.TOKEN_NAME);
        //如果没有看cookie有没有
        if (token == null) {
            token = CookieUtils.getCookieValue(request, AdminConstant.TOKEN_NAME);
        }

        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("");
        Object value;
        HandlerMethod hm = (HandlerMethod) handler;
        if (token == null || ((value = loginVerify(token)) == null) || !checkAuth(value.toString(), hm.getBeanType(), hm.getMethod())) {
            //TODO
            throw new BizException("");
        }
        //TODO
//        request.setAttribute("Mall_Admin_User", value.toString());
//        AdministratorDTO administratorDTO = JSON.parseObject(value.toString(), AdministratorDTO.class);
//        MDC.put("userName",administratorDTO.getContactName());
//        MDC.put("phoneNumber",administratorDTO.getPhoneNumber());
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
        String userName = MDC.get("userName");
        String phoneNumber= MDC.get("phoneNumber");
        MDC.remove("userName");
        MDC.remove("phoneNumber");
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    private Object loginVerify(String token) {
        //TODO
        return null;
    }

    /**
     * 检查功能权限
     *
     * @param userInfo 登陆dto
     * @param clazz    c
     * @param method   m
     * @return 是否有权限
     */
    private boolean checkAuth(String userInfo, Class<?> clazz, Method method) {
        if (StringUtils.isBlank(userInfo) || clazz == null || method == null) {
            return false;
        }
        Class<AuthorityValue> ac = AuthorityValue.class;
        //方法注解优先于类注解
        AuthorityValue annotation = method.isAnnotationPresent(ac) ? method.getAnnotation(ac) : clazz.getAnnotation(ac);
        if (annotation == null) {
            return false;
        }
//        AdministratorDTO administratorDTO = JSON.parseObject(userInfo, AdministratorDTO.class);
        //TODO
        int type = 1;
        int permission = annotation.value();
        if ((permission & (1 << type)) != 0) { //检查权限
            return true;
        }
        return false;
    }
}
