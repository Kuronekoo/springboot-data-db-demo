package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.ApplicationTests;
import cn.kuroneko.db.demo.domain.Group;
import cn.kuroneko.db.demo.domain.User;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest extends ApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GroupMapper groupMapper;

    @Test
    public void testSelectBySql(){
        User dd = User.builder()
                .name("dd")
                .age(12)
                .salary(new BigDecimal("33"))
                .build();
        List<User> list = new ArrayList<>();
        list.add(dd);
        userMapper.insertBatch(list);
        userMapper.deleteUser(6l);
        userMapper.updateUser("张三丰",6L);
        //只有在startPage方法后面的第一个mybatisSelect方法会被分页
        Page<User> page = PageHelper.startPage(5, 2);
        List<User> users = userMapper.selectByUserName("张三");
        Group group = groupMapper.selectById(1l);
        System.out.println(JSON.toJSONString(users));
        System.out.println(JSON.toJSONString(group));
    }

    @Test
    public void testInsertByObj(){
        User user = User.builder()
                .name("dd3")
                .age(12)
                .salary(new BigDecimal("33"))
                .build();
        userMapper.insert(user);
    }

    @Test
    public void testDeleteByObj(){
        //        userMapper.deleteByPrimaryKey(16l);
        Condition deleteCondition = new Condition(User.class);
        deleteCondition.createCriteria()
                .andEqualTo("id",18l);
        userMapper.deleteByExample(deleteCondition);
    }

    /**
     * 根据某些字段来更新对象的某些字段
     */
    @Test
    public void testUpdateByObj(){
        Condition updateCondition = new Condition(User.class);
        updateCondition.createCriteria()
                .andEqualTo("groupId",1l);
        User user = User.builder()
                .name("Kuroneko")
                .build();
        userMapper.updateByConditionSelective(user,updateCondition);
    }
    @Test
    public void testUpdateByObjPrimaryKey(){
        User user = User.builder()
                .name("Kuroneko")
                .id(7l)
                .build();
        userMapper.updateByPrimaryKeySelective(user);
    }
    @Test
    public void testSelectByObj(){
        Condition selectCondition = new Condition(User.class);
        selectCondition.createCriteria()
                .andEqualTo("groupId",1l)
                .andLike("name",String.format("%%%s%%","苏"))
                .andCondition("group_id in (select id from  test_group)");
        selectCondition.setOrderByClause("create_time desc");
        //只输出部分字段
        selectCondition.selectProperties("id","name");
        //只有在startPage方法后面的第一个mybatisSelect方法会被分页
        Page<User> page = PageHelper.startPage(5, 2);
        List<User> users = userMapper.selectByCondition(selectCondition);
//        page.doSelectPage(() -> userMapper.selectByCondition(selectCondition));
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        System.out.println(JSON.toJSONString(userPageInfo));

    }

}
