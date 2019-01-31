package cn.kuroneko.db.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@MapperScan("cn.kuroneko.db.demo.mapper")
public class MybatisXmlApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisXmlApp.class,args);
    }


}
