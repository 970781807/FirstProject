package com.zz.demo.service.admin;

import com.zz.demo.dao.AdminDao;
import com.zz.demo.entity.Admin;
import com.zz.demo.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Admin loginForPassword(String str, String password) {
        if (password == null || str == null) return null;
        Admin admin = adminDao.showOneForStr (str);
        if (admin != null && admin.getPassword ( ) != null && admin.getPassword ( ).equals (password)) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin loginForPhone(String phone, String code, HttpSession session) {
        if (code == null) {
            return null;
        } else {
            Admin admin = adminDao.showOneForPhone (phone);
            if (SendSms.code (phone, code, session)) {
                return admin;
            }
            return null;
        }
    }

    @Override
    public Boolean loginForPhoneSend(String phone, HttpSession session) {
        if (phone != null) {
            Admin admin = adminDao.showOneForPhone (phone);
            if (admin != null) {
                SendSms.send (phone, session);
                /*发送成功*/
                return true;
            }
        }
        /*发送失败*/
        return false;
    }


    @Override
    public Admin edit(String oper, Admin admin, String[] ids) {

        return null;
    }
}
