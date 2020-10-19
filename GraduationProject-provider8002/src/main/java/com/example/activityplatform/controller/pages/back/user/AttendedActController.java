package com.example.activityplatform.controller.pages.back.user;

import com.example.activityplatform.dao.ActivityDao;
import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.pojo.entity.Activityorder;
import com.example.activityplatform.pojo.entity.User;
import com.example.activityplatform.service.ActivityService;
import com.example.activityplatform.service.ActivityorderService;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/12 0012$ 0:12$
 * @Params:
 * @Return
 */
@Controller
public class AttendedActController {


    @Resource
    UserService userService;

    @Resource
    ActivityService activityService;

    @Resource
    ActivityorderService activityorderService;
    /**
    * @Author: qxq
    * @Description: 点击报名活动界面获取用户报名的所有活动信息并跳转界面
    * @DateTime: 0:13 2020/4/12 0012
    * @Params:
    * @Return
    */
    @RequestMapping("AttendedAct")
    String inseract(HttpSession session, Model model){
        String userPhoto=(String) session.getAttribute("userPhoto");
        List<User> AAI = userService.getAteActIdByuserPhoto(userPhoto);
        List<Activity> actlist = new ArrayList<>();
        for (int i = 0; i<AAI.size(); i++){
            Activity AA = activityService.selectById(AAI.get(i).getAttendedactivityid());
            actlist.add(AA);
        }
        model.addAttribute("AA",actlist);
        return "pages/back/user/AttendedAct";
    }

}
