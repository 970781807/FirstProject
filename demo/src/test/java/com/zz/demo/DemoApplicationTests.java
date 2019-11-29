package com.zz.demo;

import com.zz.demo.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        Admin admin = new Admin ( );
        admin.setId (UUID.randomUUID ( ).toString ( ));
        String id = admin.getId ( );
        System.out.println ("id = " + id);
    }

}
