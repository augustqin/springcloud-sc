package com.sc.springcloud.controller;


//import com.example.activityplatform.service.AdminService;
//import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录
 * qxq
 * 2020/03/31
 */

@Controller
public class LoginController {

//    @Resource
//    UserService userService;
//
//    @Resource
//    AdminService adminService;

    public static final String SERVICE_URL = "http://localhost:8002";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("loginPage")
    String loginPage(){
        return "loginPage";
    }

    @RequestMapping("RegisterPage")
    String RegisterPage(){
        return "RegisterPage";
    }


    @GetMapping(value ="/Register/get/{phone}")
    String Register(@PathVariable("phone") String phone
//            ,
//                    @RequestParam("password") String password
                    )
    {
        return restTemplate.getForObject(SERVICE_URL+"/Register/"+phone,String.class);
    }



}
