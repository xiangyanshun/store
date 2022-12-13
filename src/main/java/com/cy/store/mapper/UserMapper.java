package com.cy.store.mapper;

import com.cy.store.entity.User;

public interface UserMapper {

    /**
     *  插入用户数据
     * @param user 用户的数据
     * @return 通过影响的行数（根据返回值判断插入是否成功）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户返回用户的数据，没有找到返回null值
     */
    User getByName(String username);
}
