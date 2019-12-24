package com.zz.demo.service.admin;

import com.zz.demo.entity.Admin;

import javax.servlet.http.HttpSession;

public interface AdminService {
    /*用户名密码验证*/
    Admin loginForPassword(String str, String password);

    /*手机验证*/
    Admin loginForPhone(String phone, String code, HttpSession session);

    /*发送验证码到手机*/
    Boolean loginForPhoneSend(String phone, HttpSession session);

    /*增删改操作*/
    Admin edit(String oper, Admin admin, String[] ids);
}
