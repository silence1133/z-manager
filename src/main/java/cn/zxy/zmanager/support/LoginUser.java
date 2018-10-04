package cn.zxy.zmanager.support;

import lombok.Data;

/**
 * 存放登陆的用户会话信息
 * @author Silence 000996
 * @data 18/9/21
 */
@Data
public class LoginUser {
    private Integer id;
    private String account;
    private String name;
    private Byte roleType;
}
