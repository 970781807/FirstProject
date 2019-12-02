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
     * @Param   str       用户名或账号
     * @Param   password  密码
     * @return  {'code' : 200,
     *           'data' : {'admin':admin}
     *          }
     */
    public Map loginForPassword(String str, String password, HttpSession session) {
        System.out.println ("str = [" + str + "], password = [" + password + "], session = [" + session + "]");
        Map map = new HashMap<String, Object> ( );
        try {
            Admin admin = adminService.loginForPassword (str, password);
            if (admin == null) throw new Exception ("失败");
            session.setAttribute ("admin", admin);
            map.put ("data", admin);
            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("loginForCode")
    /*
     * @Param   phone     手机
     * @Param   code      验证码
     * @return  {'code' : 200,
     *           'data' : {'admin':admin}
     *          }
     */
    public Map loginForCode(String phone, String code, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            Admin admin = adminService.loginForPhone (phone, code, session);
            if (admin == null) throw new Exception ( );
            session.setAttribute ("admin", admin);
            map.put ("data", admin);
            map.put ("code", "200");//成功
        } catch (Exception e) {
            map.put ("code", "500");//失败
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("loginForSead")
    /*
     * @Param   phone     手机
     * @return  {'code' : 200 }
     */
    public Map loginForSead(String phone, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            adminService.loginForPhoneSend (phone, session);
            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("loginOut")
    /*
     * @Param   phone     手机
     * @return  {'code' : 200 }
     */
    public Map logout(String phone, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            session.removeAttribute ("admin");
            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("edit")
    /*
     * @Param   oper      操作
     * @Param   admin     参数类 必须包含id
     * @Param   ids       批量删除用
     * @return  {'code' : 200,
     *           'admin': admin}
     */
    public Map edit(String oper, Admin admin, String[] ids, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            Admin edit = adminService.edit (oper, admin, ids);

            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }

}
