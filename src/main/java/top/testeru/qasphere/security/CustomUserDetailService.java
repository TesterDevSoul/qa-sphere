package top.testeru.testerusphere.security.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import top.testeru.testerusphere.dto.UserDto;
import top.testeru.testerusphere.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project autosphere
 * @Description
 * @createTime 2022年11月01日 16:39:00
 */
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Resource
	UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userParm = new UserDto();
        userParm.setUsername(username);
        System.out.println(username);
        System.out.println(userParm);

        UserDto user = userService.selectOne(userParm)
                    .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials provided"));

        System.out.println(user);
        if(null == user){
            throw new UsernameNotFoundException("用户没有找到" + username);// 用户名没有找到
        }
        // 先声明一个权限集合, 因为构造方法里面不能传入null
        Collection<? extends GrantedAuthority> authorities = new ArrayList<>();

//        String username, String password, boolean enabled, boolean accountNonExpired,
//        boolean credentialsNonExpired, boolean accountNonLocked,
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(username,
                        "{bcrypt}" + user.getPassword(),//不使用密码加密 noop代表不加密
                        true,//enabled,用户是否启用
                        true,//accountNonExpired,用户是否过期
                        true, //credentialsNonExpired,用户凭证是否过期
                        true,//accountNonLocked,用户是否锁定 true 代表未锁定
                        authorities);

        //代码框架自动拿前端传入的密码和user对象里面的密码进行匹配，框架自动完成；
        //如果密码一样，登录成功；如果密码不一致，则登录失败
        return userDetails;
    }



}
