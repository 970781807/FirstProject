package com.zz.demo.service.permission;

import com.zz.demo.entity.Permission;

import java.util.List;

public interface PermissionService {
    void add(Permission permission);

    List<Permission> showAll();

    List<Permission> showPermissionsForRole(Integer id);

}
