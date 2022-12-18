package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.UserService;
import com.cy.store.service.exception.UsernameDuplicatedException;
import com.cy.store.service.exception.insertException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * package com.cy.store.controller
 *
 * @author
 * @version v1.0
 * @data 2022/12/11 17:32
 */
@RestController
@RequestMapping("users")
public class UserController extends ExceptionController{
    @Autowired
    private UserService userService;


    @RequestMapping("reg")
    public JsonResult<Void> reg( User user){
//        创建响应结果对象
//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("用户注册成功");
//        } catch (UsernameDuplicatedException e) {
//            result.setState(400);
//            result.setMessage("用户名被占用");
//        }catch (insertException e){
//            result.setState(500);
//            result.setMessage("注册是产生未知的异常");
//        }
//        return result;
        JsonResult<Void> result = new JsonResult<>();
        userService.reg(user);
        return new JsonResult<>(OK);
    }
    @RequestMapping("login")
    public JsonResult<User> login(String username , String password){
        User data = userService.login(username, password);
        return new JsonResult<>(OK,data);
    }
}
