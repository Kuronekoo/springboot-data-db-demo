package cn.kuroneko.db.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

@RunWith(SpringRunner.class)
@MapperScan("cn.kuroneko.db.demo.mapper")
@SpringBootTest(classes = MybatisPageableApp.class)
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

}