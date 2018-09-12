package cn.zxy.zmanager.dao.dataobject;

import lombok.Data;

@Data
public class User {

    private Long id;


    private Long uicId;


    private Boolean isNew;

    private Long createTime;


    private Long firstOrderTime;

    private String phoneNumber;

}