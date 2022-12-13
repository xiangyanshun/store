package com.cy.store.service;

import com.cy.store.entity.User;

/** 用户模块业务层接口*/
public interface UserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void  reg(User user);
    
    /**
     * 用户登录功能
     * @param username 用户名
     * @param password 用户密码
     * @return 当前匹配用户的数据，如果没有则返回null值
     */
    User login(String username, String password);
}
