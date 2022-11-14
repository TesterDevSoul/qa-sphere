package top.testeru.qasphere.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.testeru.qasphere.entity.User;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *   全局验证TOKEN过滤器的编写
 */
@Component
public class JWTTokenFilter extends OncePerRequestFilter {
    @Resource
    JWTUtils jwtUtils;

    //重写实际进行过滤操作的doFilterInternal抽象方法
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {


        //尝试获取TOKEN
        //如果没有请求头，则直接跳转
       if(!hasAuthorizationHeader(httpServletRequest)){
           filterChain.doFilter(httpServletRequest, httpServletResponse);
           return;

       }
        String accessToken = getAccessToken(httpServletRequest);
        System.out.println(accessToken);
        //如果accessToken不正确则直接跳转
        if (!jwtUtils.validateAccessToken(accessToken)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        //token令牌验证成功
        setAuthorizationContext(accessToken,httpServletRequest);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void setAuthorizationContext(String accessToken, HttpServletRequest httpServletRequest) {
        User userDetails = getUserDetails(accessToken);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, null);
        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private User getUserDetails(String accessToken) {
        User user = new User();
        String[] subjectArray = jwtUtils.getSubject(accessToken).split(",");
        user.setId(Integer.parseInt(subjectArray[0]));
        user.setUsername(subjectArray[1]);
        return user;
        

    }


    private boolean hasAuthorizationHeader(HttpServletRequest req){
        String header = req.getHeader("Authorization");
        System.out.println("Authorization-header:" + header);

        if ((ObjectUtils.isEmpty(header)) || !header.startsWith("Bearer "))
            return false;
        return true;
    }
    private String getAccessToken(HttpServletRequest req){
        String header = req.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        System.out.println("token:"+token);
        return token;
    }
}