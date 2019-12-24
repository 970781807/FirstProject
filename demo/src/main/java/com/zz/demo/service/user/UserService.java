package com.zz.demo.service.user;

import com.zz.demo.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    List<User> showAll();

    void add(User user);

    User showOne(String name);

    /*用户名密码验证*/
    User loginForPassword(String str, String password);

    /*手机验证*/
    User loginForPhone(String phone, String code, HttpSession session);

    /*发送验证码到手机*/
    Boolean loginForPhoneSend(String phone, HttpSession session);

    /*增删改操作*/
    User edit(String oper, User user, String[] ids);

    Boolean iscode(String phone, String code, HttpSession session);
}
