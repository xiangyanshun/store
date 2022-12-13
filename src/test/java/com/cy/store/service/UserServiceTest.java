package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest：注解表示当前的类是一个测试类，不会随同项目一起打包
@SpringBootTest
//@RunWith：表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是springRunner的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    /**
     * 单元测试要求：
     * 1.必须被@test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("tcm");
            user.setPassword("12345");
            userService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getCanonicalName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void login(){
        User user = userService.login("tem", "12345");
        System.out.println(user);
    }
}
