package com.example.activityplatform.controller.pages.back.admin;

import com.example.activityplatform.service.AdminService;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/18 0018$ 4:43$
 * @Params:
 * @Return
 */
@Controller
public class AdminIndexController {
    @Resource
    AdminService adminService;

    @RequestMapping("AdminBackHome")
    public String index(HttpSession session, Model model){
        String adminPhone=(String) session.getAttribute("adminPhone");
        model.addAttribute("admin",adminService.getadmin(adminPhone));//返回登录用户的信息
        return "pages/back/admin/AdminBackHome";
    }
}
