package com.rz.config.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rz.entity.ResultBean;
import com.rz.entity.ResultBeanEnum;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("dwsm") DefaultSecurityManager dsm){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(dsm);
        Map<String,String> StringMap = new LinkedHashMap<>();
        StringMap.put("/user/doLogin","anon");
        StringMap.put("/**","authc");

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", new ShiroUserFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(StringMap);

        return shiroFilterFactoryBean;

    }
    @Bean(name = "dwsm")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return  new UserRealm();
    }
}

class ShiroUserFilter extends UserFilter {
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {

        response.setContentType("application/json; charset=utf-8");//返回json
        OutputStream os = response.getOutputStream();
        os.write(new ObjectMapper().writeValueAsString(ResultBean.error(ResultBeanEnum.NOLOGIN_ERROR)).getBytes("UTF-8"));
        os.flush();
        os.close();

    }
}
