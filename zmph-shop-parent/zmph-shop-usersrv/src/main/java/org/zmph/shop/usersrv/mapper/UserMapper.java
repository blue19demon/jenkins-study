package org.zmph.shop.usersrv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zmph.shop.api.response.UserResponse;
import org.zmph.shop.usersrv.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAllUser();

	List<UserResponse> findUserByPage(@Param("start")Integer start,@Param("pageSize") Integer pageSize);

	Integer getTotal();
}