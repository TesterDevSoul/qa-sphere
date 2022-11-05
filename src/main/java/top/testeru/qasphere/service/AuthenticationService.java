package top.testeru.qasphere.service;

import top.testeru.qasphere.dto.AuthReqestDto;
import top.testeru.qasphere.dto.AuthResponseDto;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 16:13:00
 */
public interface AuthenticationService {
    public AuthResponseDto login(AuthReqestDto authReqestDto);


}
