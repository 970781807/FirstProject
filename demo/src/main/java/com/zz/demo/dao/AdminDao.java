package com.zz.demo.dao;

import com.zz.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
    void add(Admin admin);

    void upd(Admin admin);

    void del(String[] ids);

    List<Admin> showAll();

    Admin showOneForId(String id);
}
