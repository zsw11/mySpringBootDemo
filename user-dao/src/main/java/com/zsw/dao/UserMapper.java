package com.zsw.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author zsw
 * @date 2021/3/8 13:50
 * @description :
 */
public interface UserMapper {

    int addUser(@Param("address") String address,
                @Param("age") int age,
                @Param("email") String email,
                @Param("name") String name,
                @Param("phone") String phone,
                @Param("blog") String blog
                 );
}
