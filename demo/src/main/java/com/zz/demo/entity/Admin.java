package com.zz.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Admin extends Entity {
    private String id;          //ID,唯一标识
    private String username;    //账号    必须含英文
    private String password;    //密码
    private String name;        //真名    必须用中文
    private String phone;       //电话
    private Integer status;     //状态
    private Date creatTime;     //创建时间
    private Date lastTime;      //上一次登陆时间
}
