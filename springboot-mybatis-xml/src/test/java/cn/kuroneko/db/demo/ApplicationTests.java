package cn.kuroneko.db.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MapperScan("cn.kuroneko.db.demo.mapper")
@SpringBootTest(classes = MybatisXmlApp.class)
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

}