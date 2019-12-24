package com.zz.demo.dao;

import com.zz.demo.entity.Role;

import java.util.List;

public interface RoleDao {
    void add(Role role);

    List<Role> showRolesForUser(String id);
}
