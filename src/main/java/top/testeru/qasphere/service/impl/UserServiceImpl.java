package top.testeru.qasphere.service.impl;

import org.springframework.stereotype.Service;
import top.testeru.qasphere.converter.UserConverter;
import top.testeru.qasphere.dao.UserMapper;
import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.entity.User;
import top.testeru.qasphere.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 16:36:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    UserConverter userConverter;
    @Override
    public Optional<UserDto> selectByName(String userName) {
        User user = new User();
        user.setUsername(userName);
        //从数据库中查找
        User findBySqlUser = userMapper.selectOne(user);
        UserDto userDto = userConverter.userForUserDto(findBySqlUser);
        return Optional.of(userDto);
    }
}
