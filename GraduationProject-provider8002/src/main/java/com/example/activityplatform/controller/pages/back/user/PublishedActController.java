package com.example.activityplatform.controller.pages.back.user;

import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.pojo.entity.User;
import com.example.activityplatform.service.ActivityService;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/12 0012$ 4:09$
 * @Params:
 * @Return
 */
@Controller
public class PublishedActController {

    @Resource
    UserService userService;

    @Resource
    ActivityService activityService;
    /**
    * @Author: qxq
    * @Description: 成功添加活动后跳转发布活动界面
    * @DateTime: 4:09 2020/4/12 0012
    * @Params:
    * @Return
    */
    @GetMapping("PublishedAct")
    String inseract(HttpSession session, Model model){
        String userPhoto=(String) session.getAttribute("userPhoto");
        model.addAttribute("PA",activityService.selectByuserPhoto(userService.getuser(userPhoto).getIduser()));
        return "pages/back/user/PublishedAct";
    }
}
