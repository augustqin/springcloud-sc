package com.example.activityplatform.service;

import com.example.activityplatform.pojo.entity.Activity;

import java.util.List;
import java.util.Map;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/11 0011$ 5:49$
 * @Params:
 * @Return
 */
public interface ActivityService {
    /**
    * @Author: qxq
    * @Description: 增加活动的功能，返回true或false，返回msg为消息
    * @DateTime: 5:58 2020/4/11 0011
    * @Params:
    * @Return
    */
    String addact(Activity activity);
/**
* @Author: qxq
* @Description: 由id查询活动
* @DateTime: 2:30 2020/4/12 0012
* @Params:
* @Return
*/
    Activity selectById(Integer attendedactivityid);

    /**
    * @Author: qxq
    * @Description: 由手机号查询此用户发布的所有活动
    * @DateTime: 5:24 2020/4/12 0012
    * @Params:
    * @Return
    */
    List<Activity> selectByuserPhoto(Integer id);
/**
* @Author: qxq
* @Description: 由hot为1并且和分类查询热点活动显示在首页
* @DateTime: 5:42 2020/4/18 0018
* @Params:
* @Return
*/


    List<Activity> selectAByhot(String ActivityClassification);
/**
* @Author: qxq
* @Description: 由分类取出排好序（按id最大排序）的活动list
* @DateTime: 4:55 2020/4/19 0019
* @Params:
* @Return
*/
    List<Activity> selectAByBiggestId();
    /**
    * @Author: qxq
    * @Description: 取出分类
    * @DateTime: 11:43 2020/4/23 0023
    * @Params:
    * @Return
    */
    List<Activity> selectCByBiggestId(String clification);
/**
* @Author: qxq
* @Description:
* @DateTime: 1:44 2020/4/27 0027
* @Params:
* @Return
*/

    Activity selectByName(String acname);


}
