package com.example.activityplatform.dao;

import com.example.activityplatform.pojo.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActivityDao {
    int deleteByPrimaryKey(Integer activityid);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
/**
* @Author: qxq
* @Description: 
* @DateTime: 5:26 2020/4/12 0012
* @Params: 
* @Return 
*/
    List<Activity> selectByactivitypublishid(Integer id);
/**
* @Author: qxq
* @Description: 
* @DateTime: 5:48 2020/4/18 0018
* @Params: 
* @Return 
*/
    List<Activity> selectAByhot(String activityClassification);

/**
* @Author: qxq
* @Description:
* @DateTime: 4:56 2020/4/19 0019
* @Params:
* @Return
*/
    List<Activity> selectAByBiggestId();
/**
* @Author: qxq
* @Description: 
* @DateTime: 11:45 2020/4/23 0023
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