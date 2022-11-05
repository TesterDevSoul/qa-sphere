package top.testeru.qasphere.util;
/**
 * @author testeru.top
 * @version 1.0.0
 * @Project autosphere
 * @Description
 * @createTime 2022年10月31日 12:06:00
 */
public interface ResultCode {

     static Integer SUCCESS = 0;
     static Integer ERROR = 1;


     static Integer UNREGISTER = 40013; //用户未注册

     static Integer PWDWRONG = 40014; //密码错误

}
