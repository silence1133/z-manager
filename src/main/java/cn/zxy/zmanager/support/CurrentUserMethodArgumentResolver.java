package cn.zxy.zmanager.support;


import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * TODO
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是UserDto并且有CurrentUser注解则支持
/*        if (parameter.getParameterType().isAssignableFrom(AdministratorDTO.class)
                && parameter.hasParameterAnnotation(User.class)) {
            return true;
        }*/
        return false;
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
/*        Object administrator = webRequest.getAttribute("xxx", RequestAttributes.SCOPE_REQUEST);
        if (administrator == null) {
            throw new UnauthorizedException();
        }
        AdministratorDTO administratorDTO = JSON.parseObject(administrator.toString(), AdministratorDTO.class);
        return administratorDTO;*/
        return null;
    }
}
