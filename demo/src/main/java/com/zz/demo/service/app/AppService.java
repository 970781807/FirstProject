package com.zz.demo.service.app;

import com.zz.demo.entity.App;
import com.zz.demo.util.PageMap;

public interface AppService {
    PageMap<App> showAll(Integer pageNum, Integer pageSize, String userid);

    void del(Integer id);
    void add(App app);

    void remove(Integer id);

    void reseton(Integer id);
}
