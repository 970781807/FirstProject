package com.zz.demo.service.permission;

import com.zz.demo.dao.PermissionDao;
import com.zz.demo.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void add(com.zz.demo.entity.Permission permission) {
        permissionDao.add (permission);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<com.zz.demo.entity.Permission> showAll() {
        List<com.zz.demo.entity.Permission> permissions = permissionDao.showAll ( );
        return permissions;
    }

    @Override
    public List<Permission> showPermissionsForRole(Integer id) {
        List<Permission> permissions = permissionDao.showPermissionsForRole (id);
        return permissions;
    }
}
