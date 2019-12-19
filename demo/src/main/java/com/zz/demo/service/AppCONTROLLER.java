package com.zz.demo.service;

import com.github.pagehelper.PageHelper;
import com.zz.demo.dao.AppDao;
import com.zz.demo.entity.App;
import com.zz.demo.util.PageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AppCONTROLLER")
@Transactional
public class AppCONTROLLER implements AppShowAll {
    @Autowired
    private AppDao appDao;

    @Override
    public PageMap<App> showAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage (0, 4);
        List<App> apps = appDao.showForType (0, 1);
        PageMap<App> pageMap = new PageMap<> (apps);
        return pageMap;
    }
}
