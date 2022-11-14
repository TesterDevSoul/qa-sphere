package top.testeru.qasphere.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.testeru.qasphere.dto.AuthReqestDto;
import top.testeru.qasphere.dto.AuthResponseDto;
import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.dto.AuthRegisterDto;
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
                    new UsernamePasswordAuthenticationToken(
                            authReqestDto.getUsername(), authReqestDto.getPassword()));
            User user = (User) authenticate.getPrincipal();
            UserDto user1 = userService.selectByName(user.getUsername());
            String accessToken = jwtUtils.generateAccessToken(user1);
            AuthResponseDto authResponseDto = new AuthResponseDto(user.getUsername(), accessToken);
            return R.ok().token(authResponseDto.getAccessToken()).message("登录成功");

        } catch (UsernameNotFoundException ex){
            System.out.println(ex);
            //401 未授权
            return R.error().code(40013).message("用户未注册");
        } catch (BadCredentialsException ex){//如果认证失败.authenticate()则返回授权失败
            System.out.println(ex);
            //401 未授权
            return R.error().code(40014).message("用户密码错误");
        }

    }


    @PostMapping("/auth/register")
    public R login( @RequestBody AuthRegisterDto authRegisterDto){
        System.out.println("authRegisterDto:"+authRegisterDto);
        UserDto userDto = new UserDto();
        //密码进行加密
        //1.创建解析器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //2.对密码进行加密
        String encodePwd = encoder.encode(authRegisterDto.getPassword());
        userDto.setUsername(authRegisterDto.getUsername());
        userDto.setEmail(authRegisterDto.getEmail());
        userDto.setPassword(encodePwd);
        System.out.println("zhuce:"+userDto);
        return userService.insertUser(userDto)? R.ok().message("注册成功") : R.error().code(40015).message("用户注册失败");


    }

}
