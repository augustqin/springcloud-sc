package com.example.activityplatform.controller.pages.front;

import com.example.activityplatform.dao.ActivityDao;
import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/23 0023$ 13:34$
 * @Params:
 * @Return
 */
@Controller
public class ActDetailController {

    @Resource
    ActivityService activityService;

    @RequestMapping("activityDetail/{activityid}")
    String detail(Model model, @PathVariable Integer activityid){
        model.addAttribute("detail",activityService.selectById(activityid));
        return "pages/front/activityDetail";
    }

    @RequestMapping("activityDetail")
    String detail1(Model model, @RequestParam("activityid") Integer activityid){
        model.addAttribute("detail",activityService.selectById(activityid));
        return "pages/front/activityDetail";
    }
}
