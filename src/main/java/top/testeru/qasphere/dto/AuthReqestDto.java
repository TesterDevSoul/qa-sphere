package top.testeru.qasphere.dto;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qa-sphere
 * @Description 登录请求参数实体类
 * @createTime 2022年11月05日 13:15:00
 */
public class AuthReqestDto {
    private String name;

    private String password;

    @Override
    public String toString() {
        return "AuthReqestDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public AuthReqestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
