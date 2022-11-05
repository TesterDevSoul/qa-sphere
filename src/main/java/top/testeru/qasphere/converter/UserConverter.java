package top.testeru.qasphere.converter;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import top.testeru.qasphere.dto.UserDto;
import top.testeru.qasphere.entity.User;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project autosphere
 * @Description 实体类 UserDTO 与 数据库表实体类User 转换
 * @createTime 2022年10月31日 13:59:00
 */
@Mapper(componentModel = "spring")
public interface UserConverter {
//    UserDto ---->  User

    @Mappings({
            @Mapping(target = "username",source = "username"),
            @Mapping(target = "password",source = "password"),
            @Mapping(target = "email",source = "email")
    })
    public User userDtoForUser(UserDto userDto);



    @Mappings({
            @Mapping(target = "username",source = "username"),
            @Mapping(target = "password",source = "password"),
            @Mapping(target = "email",source = "email")
    })
    public UserDto userForUserDto(User user);


//    @Mappings({
//            @Mapping(target = "username",source = "username"),
//            @Mapping(target = "password",source = "password")
//    })
//    public User userLoginDtoForUser(UserLoginDto userLoginDto);

}
