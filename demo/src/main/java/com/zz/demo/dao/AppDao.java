package com.zz.demo.dao;

import com.zz.demo.entity.App;

import java.util.List;

public interface AppDao {
    List<App> showAll();

    List<App> showForType(int... types);
    void add(App app);
}