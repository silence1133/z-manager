package cn.zxy.zmanager.web;

import cn.zxy.zmanager.common.ZManagerResult;
import cn.zxy.zmanager.support.LoginUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Silence 000996
 * @data 18/9/21
 */
@RestController
@RequestMapping()
public class LoginController {


    @PostMapping("login")
    public ZManagerResult login(String account, String pwd, HttpServletRequest request) {
        LoginUser user = new LoginUser();
        request.getSession().setAttribute("sessionUser", user);
        return ZManagerResult.success(user);
    }
}
