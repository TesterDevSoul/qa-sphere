package top.testeru.qasphere.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qa-sphere
 * @Description cors配置
 * @createTime 2022年11月05日 13:21:00
 */
@Configuration
public class CorsConfig {

    //跨域处理 跨域信息源
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        System.out.println("跨域配置");
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true); // 允许cookies跨域
        //允许跨域的站点
        corsConfiguration.addAllowedOriginPattern("*");
        //允许跨域的http方法  允许提交请求的方法，*表示全部允许
        corsConfiguration.setAllowedMethods(Arrays.asList("OPTIONS","GET","POST"));
        corsConfiguration.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许

        //允许跨域的请求头
        corsConfiguration.addAllowedHeader("*");
        //允许带凭证
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }
}
