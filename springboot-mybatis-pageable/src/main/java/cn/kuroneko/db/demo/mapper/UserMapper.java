package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User>, ConditionMapper<User> {
    String querySql = "select *,create_time as createTime from test_user ";

    @Select(querySql+"where name = #{name}")
    List<User> selectByUserName(@Param("name")String name);
}
