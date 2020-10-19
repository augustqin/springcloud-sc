package com.example.activityplatform.controller.pages.front;

import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qxq
 * @Description:跳转分类页面
 * @DateTime: 2020/4/19 0019$ 3:15$
 * @Params:
 * @Return
 */
@Controller
public class ClassController {

    @Resource
    ActivityService activityService;
/**
* @Author: qxq
* @Description: 跳转分类页面,默认是全部-推荐（每一类都按最新发布（即订单号最大）排序）
* @DateTime: 4:46 2020/4/19 0019
* @Params:
* @Return
*/
    @RequestMapping("classification")
    String classPage(Model model){
        /**
        * @Author: qxq
        * @Description: 由分类取出排好序（按id最大排序）的活动list
        * @DateTime: 4:52 2020/4/19 0019
        * @Params:
        * @Return
        */
        model.addAttribute("sortA",activityService.selectAByBiggestId());

        return "pages/front/classification";
    }

    /**
    * @Author: qxq
    * @Description: 点击分类返回对应活动
    * @DateTime: 7:54 2020/4/19 0019
    * @Params:
    * @Return
    */
    @RequestMapping("sort{clification}")
    @ResponseBody
    List<Activity> sort(Model model, @PathVariable String clification){
//       List<Activity> l = activityService.selectCByBiggestId(clification);
        return activityService.selectCByBiggestId(clification);
    }

}
