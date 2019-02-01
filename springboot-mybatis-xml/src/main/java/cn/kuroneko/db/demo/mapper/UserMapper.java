package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> list();
    List<User> queryList(@Param("condition")Map<String,Object> condition);
    Boolean insert(User user);
    void delete(@Param("id")Long id);
}
