package com.cy.store.controller;

import com.cy.store.service.exception.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * package com.cy.store.controller
 *
 * @author
 * @version v1.0
 * @data 2022/12/11 18:01
 */
public class ExceptionController {
    public static final Integer OK = 200;

    @ExceptionHandler(ServiceException.class)//用于统一处理异常
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(400);
            result.setMessage("用户名被占用");
        }else if (e instanceof UsernameNotFoundException){
            result.setState(501);
            result.setMessage("用户名不存在的异常");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(502);
            result.setMessage("用户密码错误异常");
        } else if (e instanceof insertException){
            result.setState(500);
            result.setMessage("注册是产生未知的异常");
        }
        return result;
    }
}
