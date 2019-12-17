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
public class App {
    private Integer id;
    private String appName;
    private String href;
    private String img;
    private String about;
    private String author;
    private int status;
    private int type;
    private Date careatTime;
    private Date lastTime;
}
