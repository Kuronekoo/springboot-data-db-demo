package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.ApplicationTests;
import cn.kuroneko.db.demo.domain.Group;
import cn.kuroneko.db.demo.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisXmlTests extends ApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GroupMapper groupMapper;
    @Test
    public void testSelect(){
        List<User> list = userMapper.list();
        List<Group> list1 = groupMapper.list();

        System.out.println(list);
        System.out.println(list1);
    }
    @Test
    public void testSelect2(){
        Map<String,Object> condition = new HashMap<>();
        condition.put("name","张三");
        condition.put("ids", Arrays.asList(1l));
        List<User> users = userMapper.queryList(condition);
        System.out.println(users);

    }
    @Test
    public void testInsert(){
        User user = User.builder()
                .name("张三四")
                .groupId(2l)
                .build();
        userMapper.insert(user);
    }
    @Test
    public void testDelete(){
        userMapper.delete(1l);
    }
}
