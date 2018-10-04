package cn.zxy.zmanager.support;


import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.constant.ZUserConstant;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


/**
 * TODO
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是UserDto并且有CurrentUser注解则支持
        if (parameter.getParameterType().isAssignableFrom(LoginUser.class)
                && parameter.hasParameterAnnotation(User.class)) {
            return true;
        }
        return false;
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute(ZUserConstant.USER_LOGIN_SUCCESS);
        return loginUser;
    }
}
