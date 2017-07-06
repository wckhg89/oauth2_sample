package com.guppy.oauth2sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by kanghonggu on 2017. 7. 5..
 */

/*

@EnableResourceServer
: API 서버를 Oauth2 인증을 받게 하는 역할을 한다.
: 기본 옵션은 API 의 모든 요청에 대해서 인증을 받게한다.
: ResourceServerConfigurerAdapter 클래스를 상속 받아 커스터 마이징이 가능하다

@EnableAuthorizationServer
: OAuth2 인증서버를 활성화 시켜주는 역할을 한다.
: OAuth2 인증을 위한 엑세스 토큰, 리프레시 토큰 발급과 발급된 토큰을 통한 Oauth2 인증 등 핵심 기능을 활성화 한다.

 */

@Configuration
@EnableResourceServer
@EnableAuthorizationServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // http.headers().frameOptions().disable();
        http.authorizeRequests()
                .anyRequest().permitAll()
                .antMatchers("/authorization-code-test").access("#oauth2.hasScope('read')");
    }

}
