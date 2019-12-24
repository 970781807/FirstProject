package com.zz.demo.service.app;

import com.zz.demo.entity.App;
import com.zz.demo.util.PageMap;

public interface AppShowAll {
    PageMap<App> showAll(Integer pageNum, Integer pageSize);
}
