package com.zz.demo.dao;

import com.zz.demo.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User showOne(String name);

    List<User> showAll();

    void upd(User user);

    void del(String... ids);

    User showOneForId(String id);

    User showOneForStr(String str);

    User showOneForPhone(String str);
}
