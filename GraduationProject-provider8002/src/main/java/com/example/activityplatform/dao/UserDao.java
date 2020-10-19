package com.example.activityplatform.dao;

import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.pojo.entity.User;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer iduser);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer iduser);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用手机号查询这个用户
     * @param userphone
     * @return
     */
    User selectByPhone(String userPhoto);



    /**
    * @Author: qxq
    * @Description: 由用户手机号查出所有报名的活动
    * @DateTime: 0:32 2020/4/12 0012
    * @Params:
    * @Return
    */
   List<User> selectAAIdByPhone(String userPhone);

   /**
   * @Author: qxq
   * @Description: 由用户手机号查出所有发布的活动
   * @DateTime: 4:14 2020/4/12 0012
   * @Params:
   * @Return
   */
    List<User> selectPAIdByPhone(String userPhoto);
/**
* @Author: qxq
* @Description: 
* @DateTime: 1:27 2020/4/26 0026
* @Params: 
* @Return 
*/
    String selectAddressByPhone(String userPhoto);


    int insertforRegister(User user);
}