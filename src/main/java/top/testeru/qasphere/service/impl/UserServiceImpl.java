package top.testeru.qasphere.service.impl;

import org.springframework.stereotype.Service;
import top.testeru.qasphere.converter.UserConverter;
import top.testeru.qasphere.dao.UserMapper;
import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.entity.User;
import top.testeru.qasphere.service.UserService;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDateTime;

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
    public UserDto selectByName(String userName) {
        User user = new User();
        user.setUsername(userName);
        //从数据库中查找
        User findBySqlUser = userMapper.selectOne(user);
        UserDto userDto = userConverter.userForUserDto(findBySqlUser);
//        return Optional.of(userDto);
        return userDto;
    }

    @Override
    public boolean insertUser(UserDto userDto) {
        System.out.println("userDto:"+userDto);
        User u = new User();
        u.setUsername(userDto.getUsername());
        u.setEmail(userDto.getEmail());
        User selectOneUser = userMapper.selectOne(u);
        if(null == selectOneUser){
            System.out.println("用户未注册，可以进行注册");
            u.setPassword(userDto.getPassword());
            u.setCreateTime(LocalDateTime.now());
            u.setUpdateTime(LocalDateTime.now());
            u.setStatus(1);//账户可以用
            System.out.println(u);
            int i = userMapper.insert(u);
            return true;
        }else {
            System.out.println("当前用户已存在");
            return false;
        }


    }
}
