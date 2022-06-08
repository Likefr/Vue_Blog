package com.rz.config.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("dwsm") DefaultSecurityManager dsm) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(dsm);
        Map<String, String> StringMap = new LinkedHashMap<>();
        StringMap.put("/doLogin", "anon");
        StringMap.put("/doLogout", "logout");
//        StringMap.put("/user/**","anon");
// 针对Swagger拦截放行
        StringMap.put("/swagger-ui.html", "anon");
        StringMap.put("/swagger/**", "anon");
        StringMap.put("/swagger-resources/**", "anon");
        StringMap.put("/v2/**", "anon");
        StringMap.put("/webjars/**", "anon");
        StringMap.put("/configuration/**", "anon");
// SWAGGER2过滤【END】
        StringMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(StringMap);
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", new ShiroLoginFilter());
        shiroFilterFactoryBean.setFilters(filterMap);


        return shiroFilterFactoryBean;
    }

    @Bean(name = "dwsm")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }
}

//class ShiroUserFilter extends UserFilter {
//    @Override
//    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
//
//        response.setContentType("application/json; charset=utf-8");//返回json
//        OutputStream os = response.getOutputStream();
//        os.write(new ObjectMapper().writeValueAsString(ResultBean.error(ResultBeanEnum.NOLOGIN_ERROR)).getBytes("UTF-8"));
//        os.flush();
//        os.close();
//
//    }
//}
