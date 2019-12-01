package com.zz.demo.controller;

import com.zz.demo.entity.Admin;
import com.zz.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("admin")
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("loginForPassword")
    /*
     *
     * */
    public Map loginForPassword(String oper, String str, String word, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            Admin admin = adminService.loginForPassword (str, word);
            session.setAttribute ("admin", admin.getName ( ));
            map.put ("data", admin);
            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("loginForCode")
    public Map loginForCode(String phone, String code, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            Admin admin = adminService.loginForPhone (phone, code, session);
            session.setAttribute ("admin", admin.getName ( ));
            map.put ("data", admin);
            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }
}
