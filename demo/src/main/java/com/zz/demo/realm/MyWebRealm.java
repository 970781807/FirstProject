package com.zz.demo.realm;

import com.zz.demo.dao.PermissionDao;
import com.zz.demo.dao.RoleDao;
import com.zz.demo.entity.Permission;
import com.zz.demo.entity.Role;
import com.zz.demo.entity.User;
import com.zz.demo.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyWebRealm extends AuthorizingRealm {//权限
    @Autowired
    private UserService userService;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override   //获取授权信息    获取角色权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal ( );
        System.out.println (primaryPrincipal);
        User user = userService.showOne (primaryPrincipal);
        if (user != null) {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo ( );
            List<Role> roles = roleDao.showRolesForUser (user.getId ( ));
            for (Role role : roles) {
                System.out.println ("role = " + role);
                authorizationInfo.addRole (role.getName ( ));
                List<Permission> permissions = permissionDao.showPermissionsForRole (role.getId ( ));
                for (Permission permission : permissions) {
                    authorizationInfo.addStringPermission (permission.getPermission ( ));
                    System.out.println ("permission = " + permission);
                }
            }
            return authorizationInfo;
        }
        return null;
    }

    @Override   //获取身份验证信息      获取用户角色
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal ( );
        User user = userService.showOne (principal);
        if (user != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo (user.getName ( ), user.getPassword ( ), ByteSource.Util.bytes (user.getSalt ( )), this.getName ( ));
            return authenticationInfo;
        }
        /*短信验证登录*/
        /*需redis缓存*/
        return null;
    }
}
