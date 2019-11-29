package com.zz.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Admin extends Entity {
    private Integer sex;
    private String username;
    private String password;
    private String nickname;
}
