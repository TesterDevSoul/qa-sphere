package top.testeru.qasphere.dto;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
 * @Description
 * @createTime 2022年11月04日 16:17:00
 */

public class AuthResponseDto {
    private static final long serialVersionUID = -8752513311904244663L;
    private String name;

    private  String accessToken;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthResponseDto() {
    }

    public AuthResponseDto(String name, String accessToken) {
        this.name = name;
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "AuthResponseDto{" +
                "name='" + name + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
