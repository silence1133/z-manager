package cn.zxy.zmanager.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.common.ZManagerResult;
import cn.zxy.zmanager.common.constant.ZUserConstant;
import cn.zxy.zmanager.dao.dataobject.ZUser;
import cn.zxy.zmanager.service.ZUserService;

/**
 * @author Silence 000996
 * @data 18/9/21
 */
@RestController
@RequestMapping()
public class LoginController {
	
	@Autowired
	private ZUserService userService;


    @PostMapping("login")
    public ZManagerResult login(@RequestBody ZUser user, HttpServletRequest request) {
        return userService.login(user, request);
    }
    
    @PostMapping("logout")
    public ZManagerResult logout(HttpServletRequest request) {
    	request.getSession().removeAttribute(ZUserConstant.USER_LOGIN_SUCCESS);
        return ZManagerResult.success();
    }
}
