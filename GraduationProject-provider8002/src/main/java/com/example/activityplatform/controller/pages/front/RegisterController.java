package com.example.activityplatform.controller.pages.front;

import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.pojo.entity.User;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/5/8 0008$ 2:46$
 * @Params:
 * @Return
 */
@Controller
public class RegisterController {

    @Resource
    UserService userService;

    @RequestMapping("RegisterPage")
    String RegisterPage(){
        return "pages/front/RegisterPage";
    }


    @GetMapping(value ="/Register/get/{phone}")
    String Register(@PathVariable("phone") String phone
//            ,
//                    @RequestParam("password") String password
    )
    {
        User user = new User();
        user.setUserphone(phone);
//        user.setUserpassword(password);
        userService.addUser(user);
        return "注册成功";
    }
}
