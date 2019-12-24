package com.zz.demo.service.app;

import com.zz.demo.entity.App;

import java.util.List;

public interface AppService {
    List<App> showAll();

    void del(Integer id);
    void add(App app);
}
