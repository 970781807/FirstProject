package com.zz.demo.dao;

import com.zz.demo.entity.Admin;

import java.util.List;
public interface AdminDao {
    void add(Admin admin);
    void upd(Admin admin);

    void del(String... ids);
    List<Admin> showAll();
    Admin showOneForId(String id);

    Admin showOneForStr(String str);

    Admin showOneForPhone(String str);
}
