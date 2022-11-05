package top.testeru.testerusphere.service;

import top.testeru.testerusphere.dto.UserDto;
import top.testeru.testerusphere.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
 * @Description
 * @createTime 2022年11月04日 16:35:00
 */
public interface UserService {
    Optional<UserDto> selectOne(UserDto userDto);
    Optional<User> selectOneForUser(UserDto userDto);
    Optional<User> selectOneFromUser(User user);

    Optional<List<UserDto>> selectAll();


}
