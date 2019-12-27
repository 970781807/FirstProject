package com.zz.demo.conf;

import com.zz.demo.realm.MyWebRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroFilterConf {
    @Bean   //shiro过滤器
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean ( );
        /*将安全管理器置入过滤器*/
        filterFactoryBean.setSecurityManager (defaultWebSecurityManager);
        /*创建一个用来配置过滤器资源的map*/
        Map<String, String> map = new LinkedHashMap<> ( );


        map.put ("/index.jsp", "anon");
        map.put ("/user/register.jsp", "anon");
        map.put ("/user/**", "anon");
        map.put ("/boot/**", "anon");
        map.put ("/app/add.jsp", "authc");
        map.put ("/app/**", "anon");
        map.put ("/images/**", "anon");
        map.put ("/document/**", "anon");
        map.put ("/div_images/**", "anon");

        map.put ("/**", "authc");

        filterFactoryBean.setFilterChainDefinitionMap (map);
        filterFactoryBean.setLoginUrl ("/user/login.jsp");

        return filterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(MyWebRealm myWebRealm, MemoryConstrainedCacheManager memoryConstrainedCacheManager) {
        /*默认的安全管理器*/
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager ( );
        defaultWebSecurityManager.setRealm (myWebRealm);
        defaultWebSecurityManager.setCacheManager (memoryConstrainedCacheManager);
        return defaultWebSecurityManager;
    }

    @Bean
    public MyWebRealm myWebRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        /*自定义的Realm*/
        MyWebRealm myWebRealm = new MyWebRealm ( );
        myWebRealm.setCredentialsMatcher (hashedCredentialsMatcher);
        return myWebRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        /*Hash凭证匹配*/
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher ( );
        hashedCredentialsMatcher.setHashAlgorithmName ("md5");
        hashedCredentialsMatcher.setHashIterations (1024);
        return hashedCredentialsMatcher;
    }

    @Bean
    public MemoryConstrainedCacheManager memoryConstrainedCacheManager() {
        /*内存管理器*/
        MemoryConstrainedCacheManager memoryConstrainedCacheManager = new MemoryConstrainedCacheManager ( );
        return memoryConstrainedCacheManager;
    }
}
