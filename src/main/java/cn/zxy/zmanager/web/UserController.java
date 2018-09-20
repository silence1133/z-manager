package cn.zxy.zmanager.web;

import cn.zxy.zmanager.common.ResultCode;
import cn.zxy.zmanager.common.ZManagerResult;
import cn.zxy.zmanager.common.exception.BizException;
import cn.zxy.zmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    public ZManagerResult<String> getUser(Long userId) {
        throw new BizException(ResultCode.PARAMS_IS_NULL);
//        return ZManagerResult.success("cesce");
    }

}
