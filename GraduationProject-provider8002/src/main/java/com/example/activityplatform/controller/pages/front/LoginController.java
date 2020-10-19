package com.example.activityplatform.controller.pages.front;


import com.example.activityplatform.service.AdminService;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录
 * qxq
 * 2020/03/31
 */

@Controller
public class LoginController {

    @Resource
    UserService userService;

    @Resource
    AdminService adminService;

    @RequestMapping("loginPage")
    String loginPage(){
        return "pages/front/loginPage";
    }

/**
* @Author: qxq
* @Description: 判断登录身份
* @DateTime: 5:02 2020/4/1 0001
* @Params:
* @Return
*/
    @RequestMapping("login")
    String login(@RequestParam("status") String status,
                 @RequestParam("phone") String phone,
                 @RequestParam("password") String password, Model model, HttpSession session) {
        if (status != null && status.equals("用户")){
            if("".equals(phone) || phone == null){
                model.addAttribute("errorMsg","请输入手机号！");
                return "pages/front/loginPage";//继续返回登录界面
            }

            boolean loginResult = userService.login(phone,password);
            if(loginResult){//登录成功，返回后台首页
                session.setAttribute("userPhoto", phone);
                model.addAttribute("user",userService.getuser(phone));//返回登录用户的信息
                return "pages/back/user/UserBackHome";
            }
            model.addAttribute("errorMsg","登陆失败，手机号或密码错误！");
            return "pages/front/loginPage";
        }
        else {
            if ("".equals(phone) || phone == null) {
                model.addAttribute("errorMsg", "请输入手机号！");
                return "pages/front/loginPage";//继续返回登录界面
            }

            boolean loginResult = adminService.login(phone, password);
            if (loginResult) {//登录成功，返回后台首页
                session.setAttribute("adminPhone", phone);
                model.addAttribute("admin",adminService.getadmin(phone));//返回登录管理员的信息
                return "pages/back/admin/AdminBackHome";
            }
            model.addAttribute("errorMsg", "登陆失败，手机号或密码错误！");
            return "pages/front/loginPage";
        }
    }




}
