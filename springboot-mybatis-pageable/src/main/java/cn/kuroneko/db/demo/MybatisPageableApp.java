package cn.kuroneko.db.demo;

import cn.kuroneko.db.demo.domain.User;
import cn.kuroneko.db.demo.mapper.UserMapper;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@SpringBootApplication
@MapperScan("cn.kuroneko.db.demo.mapper")
@RestController("/test")
public class MybatisPageableApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPageableApp.class,args);
    }
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/test")
    public Object test(){
        List<User> users = userMapper.selectByUserName("张三");
        System.out.println(users);
        return ImmutableMap.of("users",users);
    }
}
