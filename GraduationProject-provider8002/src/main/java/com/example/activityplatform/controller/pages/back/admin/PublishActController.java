package com.example.activityplatform.controller.pages.back.admin;

import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.pojo.entity.User;
import com.example.activityplatform.service.ActivityService;
import com.example.activityplatform.service.AdminService;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qxq
 * @Description:管理员后台显示已发布活动
 * @DateTime: 2020/4/18 0018$ 4:34$
 * @Params:
 * @Return
 */
@Controller
public class PublishActController {

    @Resource
    ActivityService activityService;

    @Resource
    AdminService adminService;

    @RequestMapping("AdminPublishAct")
    String show(HttpSession session, Model model){
        String adminPhone=(String) session.getAttribute("adminPhone");
        model.addAttribute("APA",activityService.selectByuserPhoto(adminService.getadmin(adminPhone).getIdadmin()));//传管理员发布的活动信息
        return "pages/back/admin/PublishedAct";
    }
}
