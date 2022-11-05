package top.testeru.testerusphere.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import top.testeru.testerusphere.converter.UserConverter;
import top.testeru.testerusphere.dao.UserMapper;
import top.testeru.testerusphere.dto.TokenDto;
import top.testeru.testerusphere.dto.UserDto;
import top.testeru.testerusphere.entity.User;
import top.testeru.testerusphere.service.AuthenticationService;
import top.testeru.testerusphere.service.UserService;
import top.testeru.testerusphere.util.JWTUtils;

import javax.annotation.Resource;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
 * @Description
 * @createTime 2022年11月04日 16:14:00
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Resource
    UserConverter userConverter;
    @Resource
    UserService userService;
    @Resource
    JWTUtils jwtUtil;

    @Override
    public TokenDto login(UserDto userLoginDto) {

        System.out.println("TokenSuccessResponseDto - login:" + userLoginDto);
        User user = userConverter.userDtoForUser(userLoginDto);
//        UserDto userDto = null;
        final User endUser = userService.selectOneFromUser(user)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials provided"));
        //生成token

//        if (!passwordEncoder.matches(userLoginDto.getPassword(), endUserDto.getPassword()))
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login credentials provided");


//        final var accessToken = jwtUtil.generateAccessToken(endUser);
//        final var refreshToken = jwtUtil.generateRefreshToken(endUser);
//        final var accessTokenExpirationTimestamp = jwtUtil.extractExpirationTimestamp(accessToken);
        TokenDto tokenDto = new TokenDto();
//        tokenDto.setAccessToken(accessToken);
        return tokenDto;


    }
}
