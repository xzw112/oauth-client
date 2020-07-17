package com.xzw.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "res1";

    @Autowired
    private TokenStore tokenStore;


    @Override
    public void configure(ResourceServerSecurityConfigurer resource) {
        resource.resourceId(RESOURCE_ID) // 资源id
                .tokenStore(tokenStore) // 验证令牌服务
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                //.anyRequest().permitAll() // 允许所有请求通过
                .antMatchers("/**").hasAnyAuthority("p1")
                //.access("#oauth2.hasAnyScope('ROLE_ADMIN')")
                .and()
                .csrf()
                .disable()// 禁用spring security 自带的跨域处理
                .sessionManagement()// 定制我们自己的 session 策略
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 调整为spring security 不创建和使用session
    }

}
