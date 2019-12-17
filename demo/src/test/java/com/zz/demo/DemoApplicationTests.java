package com.zz.demo;

import com.zz.demo.dao.AdminDao;
import com.zz.demo.dao.AppDao;
import com.zz.demo.entity.Admin;
import com.zz.demo.entity.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AppDao appDao;
    @Test
    public void contextLoads() {
        Admin admin = new Admin ( );
        admin.setId (UUID.randomUUID ( ).toString ( ));
        String id = admin.getId ( );
        System.out.println ("id = " + id);
    }

    @Test
    public void AddAdmin() {
        Admin admin = new Admin ( );
        admin.setId (UUID.randomUUID ( ).toString ( ));
        admin.setName ("周臻").setPassword ("13516122561").setPhone ("15522827278").setStatus (0).setUsername ("970781807");
        adminDao.add (admin);
        List<Admin> admins = adminDao.showAll ( );
        for (Admin ad : admins) {
            System.out.println ("admin = " + ad);
        }
    }

    @Test
    public void delAdmin() {
        String[] ids = {"645f51b9-5584-4f24-973a-4e9d48ad0776", "f65ab6db-ad94-412a-973f-00779c21ccea"};
        adminDao.del (ids);
        List<Admin> admins = adminDao.showAll ( );
        for (Admin ad : admins) {
            System.out.println ("admin = " + ad);
        }
    }

    @Test
    public void updAdmin() {
        Admin fadmin = adminDao.showOneForId ("ad90b8a6-3818-4810-baf5-a57cde26d2c2");
        System.out.println ("修改前 = " + fadmin);
        fadmin.setUsername ("970781807@qq.com");
        adminDao.upd (fadmin);
        Admin ladmin = adminDao.showOneForId ("ad90b8a6-3818-4810-baf5-a57cde26d2c2");
        System.out.println ("修改后 = " + ladmin);
    }

    @Test
    public void showOneForStr() {
        Admin admin = adminDao.showOneForStr ("15522827278");
        System.out.println ("admin = " + admin);
    }

    @Test
    public void addApp() {
        App app = new App ( );
        app.setAppName ("GitHub");
        app.setAbout ("My GitHub");
        app.setHref ("https://github.com/970781807");
        app.setAuthor ("周臻");
        app.setImg ("images/github.png");
        System.out.println (app);
        appDao.add (app);
        List<App> apps = appDao.showAll ( );
        for (App app1 : apps) {
            System.out.println ("app1 = " + app1);
        }
    }
}
