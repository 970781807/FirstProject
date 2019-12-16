package com.zz.demo.controller;

import com.zz.demo.entity.App;
import com.zz.demo.service.AppShowAll;
import com.zz.demo.util.PageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("app")
public class AppController {
    @Autowired
    private Map<String, AppShowAll> appShowAllMap;

    @RequestMapping("showAll")
    public PageMap<App> showAll(Integer pageNum, Integer pageSize, String find) {
        System.out.println ("find = " + find);
        AppShowAll appShowAll = appShowAllMap.get (find);
        PageMap<App> map = appShowAll.showAll (pageNum, pageSize);
        return map;
    }
}
