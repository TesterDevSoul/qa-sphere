package top.testeru.qasphere.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.testeru.qasphere.dto.AuthReqestDto;
import top.testeru.qasphere.dto.AuthResponseDto;
import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.service.UserService;
import top.testeru.qasphere.security.jwt.JWTUtils;
import top.testeru.qasphere.util.R;

import javax.annotation.Resource;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 16:07:00
 */
@RestController
public class AuthController {
    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    JWTUtils jwtUtils;

    @Resource
    UserService userService;

    @PostMapping("/auth/login")
    public R login( @RequestBody AuthReqestDto authReqestDto){
        try {
            //返回一个身份认证对象
            Authentication authenticate = authenticationManager.authenticate(
                    //用户名、密码令牌
                    new UsernamePasswordAuthenticationToken(authReqestDto.getUsername(), authReqestDto.getPassword()));
            System.out.println("-----0");
            User user = (User) authenticate.getPrincipal();
            System.out.println("-----1");
            UserDto user1 = userService.selectByName(user.getUsername()).get();
            System.out.println("-----2");
            String accessToken = jwtUtils.generateAccessToken(user1);
            System.out.println("-----3");
            AuthResponseDto authResponseDto = new AuthResponseDto(user.getUsername(), accessToken);
            System.out.println("-----4");
            return R.ok().token(authResponseDto.getAccessToken()).message("登录成功");

        }catch (BadCredentialsException ex){//如果认证失败.authenticate()则返回授权失败
            //401 未授权
           return R.error().code(401).message("授权失败");
        }
    }

}
