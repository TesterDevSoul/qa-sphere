package top.testeru.qasphere.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.testeru.qasphere.dto.TokenDto;
import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.service.AuthenticationService;
import top.testeru.qasphere.util.R;

import javax.annotation.Resource;

import static top.testeru.qasphere.util.R.ok;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 16:07:00
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Resource
    AuthenticationService authenticationService;

    @PostMapping("login")
    public R login(@Validated @RequestBody UserDto userLoginDto){
        TokenDto loginToken = authenticationService.login(userLoginDto);
        return R.ok().token(loginToken.getAccessToken()).message("登录成功");
    }

}
