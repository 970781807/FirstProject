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

@Service
@Transactional
public class AppServiceImpl implements AppService {
    @Autowired
    private AppDao appDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageMap<App> showAll(Integer pageNum, Integer pageSize, String userid) {
        /*
         * 应用redis缓存技术 获取user 进而获取id
         * */
        PageHelper.startPage (0, 20);
        List<App> apps = appDao.showAll (userid);
        PageMap<App> pageMap = new PageMap<> (apps);
        return pageMap;
    }

    @Override
    public void del(Integer id) {
        appDao.del (id);
    }

    @Override
    public void add(App app) {
        appDao.add (app);
    }

    @Override
    public void remove(Integer id) {
        appDao.remove (id);
    }

    @Override
    public void reseton(Integer id) {
        appDao.reseton (id);
    }
}
