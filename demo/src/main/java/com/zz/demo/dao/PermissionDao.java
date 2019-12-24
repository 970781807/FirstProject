package com.zz.demo.dao;

import com.zz.demo.entity.Permission;

import java.util.List;

public interface PermissionDao {
    void add(Permission permission);

    List<Permission> showAll();

    List<Permission> showPermissionsForRole(Integer id);

}
