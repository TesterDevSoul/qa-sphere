package top.testeru.qasphere.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.testeru.qasphere.security.jwt.JWTTokenFilter;
import top.testeru.qasphere.service.UserService;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qa-sphere
 * @Description security配置
 * @createTime 2022年11月05日 13:21:00
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    JWTTokenFilter jwtTokenFilter;
    //加密方式声明
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Resource
    CustomUserDetailService customUserDetailService;
    //身份验证管理器 -- 配置用户登录信息，就是前面自动注入的service类
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService);
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }





    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //跨域问题解决
            .cors(withDefaults())
            .csrf().disable()
            .exceptionHandling()
        .and()
            // 既然启用 JWT, 那就彻底点, 不需要 Session
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests()
//                .anyRequest().permitAll()//允许所有请求通过
                .antMatchers(
                        HttpMethod.POST,
                        List.of(ApiPathExclusion.PostApiPathExclusion.values()).stream()
                                .map(apiPath -> apiPath.getPath()).toArray(String[]::new))
                .permitAll()
                .anyRequest().authenticated()
        .and()
                .addFilterAt(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
        ;


    }
}
