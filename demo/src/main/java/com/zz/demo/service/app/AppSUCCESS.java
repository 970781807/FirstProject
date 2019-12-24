package com.zz.demo.service.app;

import com.github.pagehelper.PageHelper;
import com.zz.demo.dao.AppDao;
import com.zz.demo.entity.App;
import com.zz.demo.util.PageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AppSUCCESS")
@Transactional
public class AppSUCCESS implements AppShowAll {
    @Autowired
    private AppDao appDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageMap<App> showAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage (0, 4);
        List<App> apps = appDao.showForType (0);
        PageMap<App> pageMap = new PageMap<> (apps);
        return pageMap;
    }
}
