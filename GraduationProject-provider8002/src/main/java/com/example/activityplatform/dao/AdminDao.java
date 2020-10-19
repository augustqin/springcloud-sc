package com.example.activityplatform.dao;

import com.example.activityplatform.pojo.entity.Admin;

public interface AdminDao {
    int deleteByPrimaryKey(Integer idadmin);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer idadmin);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
    * @Author: qxq
    * @Description: 
    * @DateTime: 1:55 2020/4/2 0002
    * @Params: 
    * @Return 
    */
    Admin selectByPhone(String phone);
}