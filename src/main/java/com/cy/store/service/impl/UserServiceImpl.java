package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.UserService;
import com.cy.store.service.exception.PasswordNotMatchException;
import com.cy.store.service.exception.UsernameDuplicatedException;
import com.cy.store.service.exception.UsernameNotFoundException;
import com.cy.store.service.exception.insertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import java.util.Date;
import java.util.UUID;

/**
 * package com.cy.store.service.impl
 *
 * @author
 * @version v1.0
 * @data 2022/12/11 14:55
 */
/** 用户模块业务层实现的类*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
//        通过user参数来获取传递过来的username
        String username = user.getUsername();

//        调用getByName（username）判断用户名是否被占用
        User result = userMapper.getByName(username);
//        判断result是否不为null则抛出用户名被占用异常
        if (result != null){
//            抛出异常
            throw new UsernameDuplicatedException("用户名被占用");
        }

//        密码加密处理的实现：md5算法的形式：67dhdsgh-yeuwrey121-yerui374-yrwirei-67123
//        （串 + password + 串）---md5算法进行加密，连续加载三次
//        盐值 + password + 盐值 ---盐值就是一个随机的字符串
        String oldPassword = user.getPassword();
//        获取盐值，随机生成一个盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
//        补全数据：记录盐值
        user.setSalt(salt);
//        将密码和盐值作为一个整体进行加密处理，忽略原有密码提升了数据的安全性
        String password = getMd5Password(oldPassword, salt);
//        将加密之后的密码重新补全设置到user对象中
        user.setPassword(password);

//        补全数据is_delete设置成0
        user.setIsDelete(0);

//        补全数据：日志
        user.setModifiedUser(user.getModifiedUser());
        user.setCreatedUser(user.getCreatedUser());
        Date date = new Date();
        user.setModifiedTime(date);
        user.setCreatedTime(date);

//        执行业务注册功能的实现（rows==1）
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new insertException("在用户注册过程中产生了未知的异常");
        }
    }
    
    @Override
    public User login(String username, String password) {
        //根据用户名称来查询用户的数据是否存在，如果不在抛出异常
        User result = userMapper.getByName(username);
        if (result == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //判断is_delete字段是否为1被标记删除
        if (result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        //检测用户的密码是否匹配
        //1.先获取数据库中加密的密码
        String oldPassword = result.getPassword();
        //2.和用户传递的密码进行比较
        //2.1先获取盐值：上一次在注册的时候自动生成一个盐值
        String salt = result.getSalt();
        //2.2将用户的密码按照相同的md5算法进行加密
        String newMd5Password = getMd5Password(password,salt);
        //3.将密码进行比较
        if (!oldPassword.equals(newMd5Password)){
            throw new PasswordNotMatchException("用户密码错误");
        }
      
        //调用mapper层的getByName来查询用户的数据,提升用户性能
        User user = new User();
        user.setUid(user.getUid());
        user.setUsername(user.getUsername());
        user.setAvatar(user.getAvatar());
        //将当前的用户数据返回，返回的数据是为了辅助其他页面的数据展示
        return user;
    }
    
    //    定义一个md5算法加密处理
    public String getMd5Password(String password, String salt){

        for (int i = 0; i < 3; i++) {
            //md5加密算法方法的调用（进行三次加密）
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
//     返回加密之后的密码
        return password;
    }
}
