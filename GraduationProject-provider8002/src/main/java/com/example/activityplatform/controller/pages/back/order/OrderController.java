package com.example.activityplatform.controller.pages.back.order;

import com.example.activityplatform.pojo.entity.Activity;

import com.example.activityplatform.pojo.entity.Activityorder;
import com.example.activityplatform.pojo.entity.User;
import com.example.activityplatform.service.ActivityorderService;
import com.example.activityplatform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * creator：Administrator
 * date:2019/12/17
 */
@Controller
public class OrderController  {

    Logger logger = LoggerFactory.getLogger(OrderController.class);


    @Resource
    ActivityorderService activityorderService;

    @Resource
    UserService userService;

    @RequestMapping("addPre")
    String addPre(Activity activity, Model model, HttpSession session) {


        // 设置用户的默认收获地址
        String userPhoto=(String) session.getAttribute("userPhoto");
        model.addAttribute("user", userService.getuser(userPhoto));
        model.addAttribute("orderact", activity);


        return "pages/back/order/order-addPre";
    }

    @RequestMapping("orderadd")
    String add(Activity activity, User user, Model model) {

        Activityorder actorder = new Activityorder();
        actorder.setStatus("待付款");
        actorder.setCreatetime(new Date());
        actorder.setUserid(user.getIduser());
        actorder.setActivityid(activity.getActivityid());
        actorder.setAllcost(activity.getActivityprice());
        actorder.setReceiveaddress(user.getUseradress());


        activityorderService.addOrder(actorder);
        model.addAttribute("order", actorder);
        model.addAttribute("orderCreateTime", actorder.getCreatetime().getTime());// long类型的订单创建时间

        return "pages/back/pay/payPre";

    }


}
