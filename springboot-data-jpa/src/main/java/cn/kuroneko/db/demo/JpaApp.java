package cn.kuroneko.db.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JpaApp {
    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class,args);
    }

}
