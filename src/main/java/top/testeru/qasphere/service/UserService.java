package top.testeru.qasphere.service;

import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 16:35:00
 */
public interface UserService {
    Optional<User> selectByName(String UserName);


}
