package com.example.activityplatform.controller.pages.back.admin;

import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.service.ActivityService;
import com.example.activityplatform.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/18 0018$ 4:49$
 * @Params:
 * @Return
 */
@Controller
public class InsertActController {

    @Resource
    ActivityService activityService;

    @Resource
    AdminService adminService;

    @RequestMapping("AdminInserActPage")
    String insert(){
        return "pages/back/admin/InsertAct";
    }

    /**
    * @Author: qxq
    * @Description: 管理员添加活动
    * @DateTime: 4:58 2020/4/18 0018
    * @Params:
    * @Return
    */
    @RequestMapping("admininsertact")
    String addpre(@RequestParam(value = "activityphoto") MultipartFile activityphoto,
                  @RequestParam(value = "activityclassification") String activityclassification,
                  @RequestParam(value = "activityname") String activityname,
                  @RequestParam(value = "time1") String time1,
                  @RequestParam(value = "time2") String time2,
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
        String adminPhone=(String) session.getAttribute("adminPhone");
        activity.setActivityclassification(activityclassification);
        activity.setActivityname(activityname);
        activity.setActivityphoto(filename);
        activity.setActivitydescription(activitydescription);
        activity.setActivityplace(activityplace);
        activity.setActivityprice(activityprice);
        activity.setActivitylimit(activitylimit);
        activity.setActivitypublishid(adminService.getadmin(adminPhone).getIdadmin());

        model.addAttribute("addMsg",activityService.addact(activity));

        return "redirect:/AdminPublishAct";
    }
}
