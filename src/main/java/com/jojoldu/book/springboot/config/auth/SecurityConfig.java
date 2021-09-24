package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomerOAuth2UserService customOAuth2UserService;

    /*
    * HttpSecurity는 스프링 시큐리티의 거의 대부분 설정을 담당하는 객체
    * antMatchers : 특정 리소스에 대해서 권한을 설정
    * permitAll : antMatchers 설정한 리소스의 접근을 인증절차 없이 허용한다는 의미
    * hasRole : 권한을 가진 사용자만 접근 허용
    * anyRequest().authenticated() : 모든 리소스르 의미하며 접근허용 리소스 및 인증후 특정 레벨의 권한을 가진 사용자만 접근 가능한 리소스를
    *                                설정하고 그외 나머지 리소스들은 무조건 인증을 완료해야 접근이 가능
    * 
    * 
    * */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() //h2콘솔 화면을 사용하기 위해 해당 옵션들을 disable
                .and()
                    .authorizeRequests()
                    .antMatchers( "/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                //.antMatchers("/api/v1/**").hasRole(Role.ADMIN.name())
                //.antMatchers("/api/v1/**").hasRole(Role.USER.name() or Role.ADMIN.name())

                .antMatchers("/admin/**").hasRole(Role.ADMIN.name())

            .anyRequest().authenticated()
                .and()
                 .logout().logoutSuccessUrl("/")
                .and()
                    .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }


}
