package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.ApplicationTests;
import cn.kuroneko.db.demo.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MybatisXmlTests extends ApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect(){
        List<User> list = userMapper.list();
        System.out.println(list);
    }
}
