package cn.zxy.zmanager.support;

import lombok.Data;

/**
 * @author Silence 000996
 * @data 18/9/21
 */
@Data
public class LoginUser {
    private Long userId;
    private String account;
    private String name;
    private Integer role;
}
