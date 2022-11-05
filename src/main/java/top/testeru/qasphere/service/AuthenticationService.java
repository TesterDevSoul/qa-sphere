package top.testeru.testerusphere.service;

import top.testeru.testerusphere.dto.TokenDto;
import top.testeru.testerusphere.dto.UserDto;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
 * @Description
 * @createTime 2022年11月04日 16:13:00
 */
public interface AuthenticationService {
    public TokenDto login(UserDto userLoginDto);


}
