package top.testeru.testerusphere.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testeru.testerusphere.converter.UserConverter;
import top.testeru.testerusphere.dao.UserMapper;
import top.testeru.testerusphere.dto.UserDto;
import top.testeru.testerusphere.entity.User;
import top.testeru.testerusphere.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
 * @Description
 * @createTime 2022年11月04日 16:36:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserConverter userConverter;
    @Resource
    UserMapper userMapper;

    @Override
    public Optional<UserDto> selectOne(UserDto userDto) {
        User user = userConverter.userDtoForUser(userDto);
        //从数据库中查找
        User findBySqlUser = userMapper.selectOne(user);

        return Optional.of(userConverter.userForUserDto(findBySqlUser));

    }

    @Override
    public Optional<User> selectOneForUser(UserDto userDto) {
        User user = userConverter.userDtoForUser(userDto);
        //从数据库中查找
        User findBySqlUser = userMapper.selectOne(user);

        return Optional.of(findBySqlUser);
    }

    @Override
    public Optional<User> selectOneFromUser(User user) {
        //从数据库中查找
        User findBySqlUser = userMapper.selectOne(user);

        return Optional.of(findBySqlUser);
    }

    @Override
    public Optional<List<UserDto>> selectAll() {
        List<User> userList = userMapper.selectAll();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.forEach(user -> {
            userDtoList.add(userConverter.userForUserDto(user));
        });
        return Optional.of(userDtoList);
    }
}
