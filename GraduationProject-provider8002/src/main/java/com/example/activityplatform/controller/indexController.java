package com.example.activityplatform.controller;

import com.example.activityplatform.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author: qxq
 * @Description:首页
 * @DateTime: 2020/4/18 0018$ 3:51$
 * @Params:
 * @Return
 */
@Controller
public class indexController {

    @Resource
    ActivityService activityService;

    @RequestMapping("/")
    String index(Model model){
         // model.addAttribute("loginperson", "登录");
//        model.addAttribute("indexY",activityService.selectAByhot("音乐会"));
//        model.addAttribute("indexW",activityService.selectAByhot("文体活动"));
//        model.addAttribute("indexS",activityService.selectAByhot("实践实习"));
//        model.addAttribute("indexC",activityService.selectAByhot("创新创业"));
//        model.addAttribute("indexZ",activityService.selectAByhot("志愿公益"));
//        model.addAttribute("indexJ",activityService.selectAByhot("技能特长"));

        return "index";
    }

    @RequestMapping("IndexafterLogin")
    String indexafterlogin(Model model, HttpSession session){
        String userPhone=(String) session.getAttribute("userPhoto");
        String adminPhone=(String) session.getAttribute("adminPhone");
        if(userPhone != null){
            model.addAttribute("loginperson",userPhone);
        }
        else if(adminPhone != null){
            model.addAttribute("loginperson",adminPhone);
        }
        else {
            model.addAttribute("loginperson", "登录");
        }
        model.addAttribute("indexY",activityService.selectAByhot("音乐会"));
        model.addAttribute("indexW",activityService.selectAByhot("文体活动"));
        model.addAttribute("indexS",activityService.selectAByhot("实践实习"));
        model.addAttribute("indexC",activityService.selectAByhot("创新创业"));
        model.addAttribute("indexZ",activityService.selectAByhot("志愿公益"));
        model.addAttribute("indexJ",activityService.selectAByhot("技能特长"));

        return "index";
    }
}
