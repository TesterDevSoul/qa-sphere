package top.testeru.qasphere.dto;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qa-sphere
 * @Description 登录请求参数实体类
 * @createTime 2022年11月05日 13:15:00
 */
public class AuthReqestDto {
    private String username;

    private String password;

    @Override
    public String toString() {
        return "AuthReqestDto{" +
                "name='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public AuthReqestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
