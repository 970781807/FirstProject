package com.zz.demo.service;

import com.zz.demo.dao.AppDao;
import com.zz.demo.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppServiceImpl implements AppService {
    @Autowired
    private AppDao appDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<App> showAll() {
        List<App> apps = appDao.showAll ( );
        return apps;
    }

    @Override
    public void add(App app) {
        appDao.add (app);
    }
}
