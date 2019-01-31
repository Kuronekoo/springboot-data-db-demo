package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.domain.User;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User>, ConditionMapper<User> {
    String querySql = "select *,create_time as createTime,group_id as groupId from test_user ";

    @Select(querySql+"where name = #{name}")
    List<User> selectByUserName(@Param("name")String name);
    @Select(querySql+"where group_id = #{groupId}")
    List<User> selectByGroupId(@Param("groupId")Long groupId);

    @Update("update test_user set name=#{name} where id=#{id}")
    Boolean updateUser(@Param("name")String name,@Param("id")Long id);

    @Delete("delete from test_user where id=#{id}")
    Boolean deleteUser(@Param("id")Long id);

    String insertColumn = "INSERT INTO test_user" +
            "(name, salary, age, group_id, create_time)";
    String insertValue =
                    " ("
                    + "#{item.name,jdbcType=VARCHAR}"
                    + ",#{item.salary,jdbcType=DECIMAL}"
                    + ",#{item.age,jdbcType=INTEGER}"
                    + ",#{item.groupId,jdbcType=INTEGER}"
                    + ",sysdate()"
                    + ")";

    @Insert("<script>" + insertColumn
            + " values "
            + " <foreach collection = \"list\" item=\"item\" index= \"index\" separator =\",\"> "
            + insertValue
            + " </foreach > "
            + "</script>")
    Integer insertBatch(List<User> orderDiscs);


}
