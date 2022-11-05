package top.testeru.qasphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "top.testeru.qasphere.dao")
//@ComponentScan(basePackages = {"top.testeru.qasphere.converter","top.testeru.qasphere.security"})
public class QasphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(QasphereApplication.class, args);
    }

}
