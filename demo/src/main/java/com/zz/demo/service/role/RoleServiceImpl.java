package com.zz.demo.service.role;

import com.zz.demo.dao.RoleDao;
import com.zz.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public void add(Role role) {
        roleDao.add (role);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Role> showRolesForUser(String id) {
        List<Role> roles = roleDao.showRolesForUser (id);
        return roles;
    }

}
