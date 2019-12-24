package com.zz.demo.service.user;

import com.zz.demo.dao.UserDao;
import com.zz.demo.entity.User;
import com.zz.demo.util.SendSms;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> showAll() {
        List<User> users = userDao.showAll ( );
        return users;
    }

    @Override
    public void add(User user) {
        Integer i = (int) (Math.random ( ) * 1000);
        String salt = i.toString ( );
        user.setSalt (salt);
        System.out.println (salt);
        user.setStatus (0);
        Md5Hash md5Hash = new Md5Hash (user.getPassword ( ), salt, 1024);
        user.setId (UUID.randomUUID ( ).toString ( ));
        user.setPassword (md5Hash.toHex ( ));
        System.out.println ("user = " + user);
        userDao.add (user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)

    @Override
    public User showOne(String str) {
        User user = userDao.showOneForStr (str);
        return user;
    }

    @Override
    public User loginForPassword(String str, String password) {
        if (password == null || str == null) return null;
        User user = userDao.showOneForStr (str);
        if (user != null && user.getPassword ( ) != null && user.getPassword ( ).equals (password)) {
            return user;
        }
        return null;
    }

    @Override
    public User loginForPhone(String phone, String code, HttpSession session) {
        if (code == null) {
            return null;
        } else {
            User user = userDao.showOneForPhone (phone);
            if (SendSms.code (phone, code, session)) {
                return user;
            }
            return null;
        }
    }

    @Override
    public Boolean loginForPhoneSend(String phone, HttpSession session) {
        if (phone != null) {
            //User user = userDao.showOneForPhone (phone);
            String code = SendSms.send (phone, session);
            System.out.println (code);
            /*发送成功*/
            return true;
        }
        /*发送失败*/
        return false;
    }

    @Override
    public User edit(String oper, User user, String[] ids) {

        return null;
    }

    @Override
    public Boolean iscode(String phone, String code, HttpSession session) {
        if (SendSms.code (phone, code, session)) return true;
        else return false;
    }
}
