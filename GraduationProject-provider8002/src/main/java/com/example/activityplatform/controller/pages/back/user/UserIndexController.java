package com.example.activityplatform.controller.pages.back.user;

import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/12 0012$ 4:03$
 * @Params:
 * @Return
 */
@Controller
public class UserIndexController {

    @Resource
    UserService userService;

    @RequestMapping("UserBackHome")
    public String index(HttpSession session, Model model){
        String userPhoto=(String) session.getAttribute("userPhoto");
        model.addAttribute("user",userService.getuser(userPhoto));//返回登录用户的信息
        return "pages/back/user/UserBackHome";
    }
}
