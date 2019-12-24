package com.zz.demo.service.role;

import com.zz.demo.entity.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);

    List<Role> showRolesForUser(String id);

}
