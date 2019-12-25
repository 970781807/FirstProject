package com.zz.demo.dao;

import com.zz.demo.entity.App;

import java.util.List;

public interface AppDao {
    List<App> showAll();

    void remove(int... id);//移到回收站

    void del(int... id);//彻底删除
    List<App> showForType(int... types);

    List<App> showForStatus(int... statues);
    void add(App app);

    void reseton(int... id);
}
