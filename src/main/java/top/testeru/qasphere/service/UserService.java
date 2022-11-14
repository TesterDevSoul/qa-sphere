package top.testeru.qasphere.service;

import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.entity.User;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 16:35:00
 */
public interface UserService {
    UserDto selectByName(String UserName);
    boolean insertUser(UserDto user);

}
