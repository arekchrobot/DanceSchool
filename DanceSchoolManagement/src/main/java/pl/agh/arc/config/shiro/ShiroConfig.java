package pl.agh.arc.config.shiro;

import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import pl.agh.arc.config.filters.CsrfFilter;
import pl.agh.arc.config.filters.CsrfHeaderFilter;
import pl.agh.arc.config.shiro.BCryptPasswordService;
import pl.agh.arc.config.shiro.ManagementRealm;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arek on 2016-03-30.
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());

        Map<String, String> filterChainDefinitionMapping = new HashMap<>();
        filterChainDefinitionMapping.put("/auth/login", "anon");
        filterChainDefinitionMapping.put("/auth/logout", "authc");
        filterChainDefinitionMapping.put("/about/**", "perms[perm_read_about]");
        filterChainDefinitionMapping.put("/**", "anon");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);

        Map<String, Filter> filters = new HashMap<>();
        filters.put("anon", new AnonymousFilter());
        filters.put("authc", new FormAuthenticationFilter());
        filters.put("perms", new PermissionsAuthorizationFilter());

        shiroFilter.setFilters(filters);

        shiroFilter.setLoginUrl("#/login");

        return shiroFilter;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        final DefaultWebSecurityManager securityManager
                = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    @Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    public ManagementRealm realm() {
        ManagementRealm realm = new ManagementRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    @Bean(name = "credentialsMatcher")
    public PasswordMatcher credentialsMatcher() {
        PasswordMatcher credentialsMatcher = new PasswordMatcher();
        credentialsMatcher.setPasswordService(passwordService());
        return credentialsMatcher;
    }

    @Bean(name = "passwordService")
    public PasswordService passwordService() {
        return new BCryptPasswordService();
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

//    @Bean
//    public FilterRegistrationBean getCsrfFilter() {
//        FilterRegistrationBean filterRegistrationBean  = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new CsrfFilter(csrfTokenRepository()));
//        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean getCsrfHeaderFilter() {
//        FilterRegistrationBean filterRegistrationBean  = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new CsrfHeaderFilter());
//        filterRegistrationBean.setOrder(Integer.MIN_VALUE + 1);
//        return filterRegistrationBean;
//    }
//
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }
}
