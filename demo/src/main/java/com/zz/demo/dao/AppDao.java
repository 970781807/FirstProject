package com.zz.demo.dao;

import com.zz.demo.entity.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppDao {
    List<App> showAll(String userid);

    void remove(int... id);//移到回收站

    void del(int... id);//彻底删除
    List<App> showForType(int... types);

    List<App> showForStatus(int... statues);
    void add(App app);

    void addUserApp(@Param("userid") String userid, @Param("appid") String appid);
    void reseton(int... id);
}
