package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.ApplicationTests;
import cn.kuroneko.db.demo.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyBatisTest extends ApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public  void testSelectBySql(){
        List<User> users = userMapper.selectByUserName("张三");
        System.out.println(users);
    }
}
