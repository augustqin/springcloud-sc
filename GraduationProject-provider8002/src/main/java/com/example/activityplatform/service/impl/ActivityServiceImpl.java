package com.example.activityplatform.service.impl;

import com.example.activityplatform.dao.ActivityDao;
import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/11 0011$ 6:00$
 * @Params:
 * @Return
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    ActivityDao activityDao;

    @Override
    public String addact(Activity activity) {
        String s ;
        int i = activityDao.insertSelective(activity);
        if (i == 1){
            s="添加活动成功";
        } else{
            s="添加活动失败";
        }
        return s;
    }

    @Override
    public Activity selectById(Integer attendedactivityid) {
        return activityDao.selectByPrimaryKey(attendedactivityid);
    }

    @Override
    public List<Activity> selectByuserPhoto(Integer id) {
        return activityDao.selectByactivitypublishid(id);
    }




    /**
    * @Author: qxq
    * @Description: 查出6类热点活动显示在首页
    * @DateTime: 11:07 2020/4/18 0018
    * @Params:
    * @Return
    */
    @Override
    public List<Activity> selectAByhot(String ActivityClassification) {
        return activityDao.selectAByhot(ActivityClassification);
    }

   /**
   * @Author: qxq
   * @Description:
   * @DateTime: 5:20 2020/4/19 0019
   * @Params:
   * @Return
   */

    @Override
    public List<Activity> selectAByBiggestId() {
        return activityDao.selectAByBiggestId();
    }
/**
* @Author: qxq
* @Description:
* @DateTime: 11:44 2020/4/23 0023
* @Params:
* @Return
*/
    @Override
    public List<Activity> selectCByBiggestId(String clification) {
        return activityDao.selectCByBiggestId(clification);
    }

    @Override
    public Activity selectByName(String acname) {
        return activityDao.selectByName(acname);
    }



}
