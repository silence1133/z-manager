package cn.zxy.zmanager.dao.dataobject;

import lombok.Data;

/**
 * 用户dto
 */
@Data
public class ZUser {


    private Integer id;


    private String account;


    private String password;


    private String createTime;


    private String name;


    private Byte roleType;


    private String updateTime;

}