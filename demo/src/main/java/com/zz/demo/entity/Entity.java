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
public class Entity {
    private String id;          //ID,唯一标识
    private Date creatTime;     //创建时间
    private Date lastTime;      //上一次登陆时间
}
