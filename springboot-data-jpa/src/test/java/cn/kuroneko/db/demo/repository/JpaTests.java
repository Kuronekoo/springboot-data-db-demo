package cn.kuroneko.db.demo.repository;

import cn.kuroneko.db.demo.ApplicationTests;
import cn.kuroneko.db.demo.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JpaTests extends ApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testDDl(){
        User user = User.builder()
                .name("张三")
                .salary(new BigDecimal("23.00"))
                .age(12)
                .createTime(new Date())
                .build();
        User save = userRepository.save(user);
        System.out.println(save.getId());
        List<User> all = userRepository.findAll();
        System.out.println(all);
        userRepository.deleteInBatch(all);
    }

    @Test
    public void testInsert() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        User user = User.builder()
                .name("张三")
                .salary(new BigDecimal("23.00"))
                .age(12)
                .createTime(simpleDateFormat.parse("2019-01-29"))
                .build();
        User user2 = User.builder()
                .name("李四")
                .salary(new BigDecimal("56.00"))
                .age(15)
                .createTime(simpleDateFormat.parse("2019-01-28"))
                .build();
        User user3 = User.builder()
                .name("王五")
                .salary(new BigDecimal("99.00"))
                .age(99)
                .createTime(simpleDateFormat.parse("2019-01-27"))
                .build();
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        userRepository.saveAll(list);
    }


}
