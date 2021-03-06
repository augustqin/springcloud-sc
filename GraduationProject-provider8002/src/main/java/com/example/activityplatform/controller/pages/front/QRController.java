package com.example.activityplatform.controller.pages.front;


import com.example.activityplatform.util.qrcode.QRCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName QRController
 * @Description
 * @Author tengxiao.ma
 * @Date 2020/4/14 19:34
 **/
@Controller
@Slf4j
public class QRController {

    Logger log = LoggerFactory.getLogger(QRController.class);

    @GetMapping("/createQRCode")
    public void getQRCode(String codeContent, HttpServletResponse response){
        try {
            QRCodeUtils.createCodeToOutputStream(codeContent,response.getOutputStream());
        }catch (Exception e){
            log.info("生成二维码失败");
        }
    }

    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
