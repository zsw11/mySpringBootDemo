package com.zsw.dao;

import com.zsw.model.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zsw
 * @date 2021/4/9 11:44
 * @description :
 */
public interface UserLoginDao {

    @Select("select id,user_name,password, phone,status,lock_endtime, fail_number from user_info ui where ui.user_name=#{username}")
    UserInfo queryByUserName(String username);

    @Update("update  user_info set lock_endtime = #{lockEndTime}, fail_number = #{failNumber}  where id = #{id}")
    void updateUserInfo(UserInfo userInfo);
}
