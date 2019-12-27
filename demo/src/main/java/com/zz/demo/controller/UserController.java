package com.zz.demo.controller;

import com.zz.demo.entity.User;
import com.zz.demo.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    /*
     * @Param   str       用户名或账号
     * @Param   password  密码
     * @return  {'code' : 200,
     *          }
     */
    public Map loginForPassword(String str, String password, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        Subject subject = SecurityUtils.getSubject ( );
        UsernamePasswordToken token = new UsernamePasswordToken (str, password);
        try {
            subject.login (token);
            User user = userService.showOne (str);
            if (user != null) {
                session.setAttribute ("userid", user.getId ( ));
            }
            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("logout")
    /*
     *
     *
     * */
    public Map logout() {
        Map map = new HashMap<String, Object> ( );
        try {
            Subject subject = SecurityUtils.getSubject ( );
            subject.logout ( );
            map.put ("code", 200);
        } catch (Exception e) {
            map.put ("code", 500);
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("register")
    /*
     *
     *
     * */
    public Map registrer(User user, String code, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            if (userService.iscode (user.getPhone ( ), code, session)) {
                userService.add (user);
            } else throw new Exception ("验证码输入错误");
            map.put ("code", 200);
        } catch (Exception e) {
            e.printStackTrace ( );
            map.put ("code", 500);
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
            User user = userService.loginForPhone (phone, code, session);
            if (user == null) throw new Exception ( );
            session.setAttribute ("user", user);
            map.put ("data", user);
            map.put ("code", "200");//成功
        } catch (Exception e) {
            map.put ("code", "500");//失败
            e.printStackTrace ( );
        }
        return map;
    }

    @RequestMapping("seadCode")
    /*
     * @Param   phone     手机
     * @return  {'code' : 200 }
     */
    public Map seadCode(String phone, HttpSession session) {
        Map map = new HashMap<String, Object> ( );
        try {
            userService.loginForPhoneSend (phone, session);
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
    public Map edit(String oper, User user, String[] ids) {
        Map map = new HashMap<String, Object> ( );
        try {
            User edit = userService.edit (oper, user, ids);
            map.put ("code", "200");
        } catch (Exception e) {
            map.put ("code", "500");
            e.printStackTrace ( );
        }
        return map;
    }

}
