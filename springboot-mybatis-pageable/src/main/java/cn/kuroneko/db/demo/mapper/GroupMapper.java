package cn.kuroneko.db.demo.mapper;

import cn.kuroneko.db.demo.domain.Group;
import cn.kuroneko.db.demo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GroupMapper extends Mapper<Group>, ConditionMapper<Group> {
    String querySql="select *,group_name as groupName from test_group ";

    @Select(querySql+"where id=#{0}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "group_name",property = "groupName" ),
//            @Result(column = "shop_id", property = "shop", one = @One(select = "cn.com.crv.somagobiz.dao.mapper.ShopMapper.selectByPrimaryKey", fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "users",
                    many=@Many(select = "cn.kuroneko.db.demo.mapper.UserMapper.selectByGroupId",fetchType = FetchType.EAGER))
    })
    Group selectById(Long id);
}
