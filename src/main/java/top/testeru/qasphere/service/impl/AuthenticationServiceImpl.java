package top.testeru.qasphere.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import top.testeru.qasphere.dto.AuthReqestDto;
import top.testeru.qasphere.dto.AuthResponseDto;
import top.testeru.qasphere.entity.User;
import top.testeru.qasphere.service.AuthenticationService;
import top.testeru.qasphere.service.UserService;
import top.testeru.qasphere.security.jwt.JWTUtils;

import javax.annotation.Resource;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 16:14:00
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Resource
    UserService userService;
    @Resource
    JWTUtils jwtUtil;

    @Override
    public AuthResponseDto login(AuthReqestDto authReqestDto) {

//        System.out.println("TokenSuccessResponseDto - login:" + authReqestDto);
//        User user = userConverter.userDtoForUser(userLoginDto);
//        UserDto userDto = null;
        final User endUser = userService.selectByName(authReqestDto.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials provided"));
        //生成token

//        if (!passwordEncoder.matches(userLoginDto.getPassword(), endUserDto.getPassword()))
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials provided");


//        final var accessToken = jwtUtil.generateAccessToken(endUser);
//        final var refreshToken = jwtUtil.generateRefreshToken(endUser);
//        final var accessTokenExpirationTimestamp = jwtUtil.extractExpirationTimestamp(accessToken);
//        TokenDto tokenDto = new TokenDto();
//        tokenDto.setAccessToken(accessToken);
        return null;


    }
}
