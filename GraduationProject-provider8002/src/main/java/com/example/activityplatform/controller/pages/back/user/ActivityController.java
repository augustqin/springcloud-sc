package com.example.activityplatform.controller.pages.back.user;

import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.service.ActivityService;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/8 0008$ 1:39$
 * @Params:
 * @Return
 */
@Controller
public class ActivityController {



    @Resource
    ActivityService activityService;

    @Resource
    UserService userService;
    /**
    * @Author: qxq
    * @Description: 跳转添加活动界面
    * @DateTime: 0:30 2020/4/10 0010
    * @Params:
    * @Return
    */
    @RequestMapping("InsertActPage")
    String inseract(){
        return "pages/back/user/InsertAct";
    }

    /**
    * @Author: qxq
    * @Description: 真正添加活动
    * @DateTime: 0:30 2020/4/10 0010
    * @Params:
    * @Return
    */
    @RequestMapping("insertact")
    String addpre(@RequestParam(value = "activityphoto") MultipartFile activityphoto,
                  @RequestParam(value = "activityclassification") String activityclassification,
                  @RequestParam(value = "activityname") String activityname,
                  @RequestParam(value = "activitydescription") String activitydescription,
                  @RequestParam(value = "activityplace") String activityplace,
                  @RequestParam(value = "activityprice") Integer activityprice,
                  @RequestParam(value = "activitylimit") Integer activitylimit,
                  Model model, HttpSession session){

        String fileName = activityphoto.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://upload//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            activityphoto.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/upload/" + fileName;

        Activity activity = new Activity();
        String userPhoto=(String) session.getAttribute("userPhoto");
        activity.setActivityclassification(activityclassification);
        activity.setActivityname(activityname);
        activity.setActivityphoto(filename);
        activity.setActivitydescription(activitydescription);
        activity.setActivityplace(activityplace);
        activity.setActivityprice(activityprice);
        activity.setActivitylimit(activitylimit);
        activity.setActivitypublishid(userService.getuser(userPhoto).getIduser());

        model.addAttribute("addMsg",activityService.addact(activity));

        return "redirect:/PublishedAct";
    }

}
