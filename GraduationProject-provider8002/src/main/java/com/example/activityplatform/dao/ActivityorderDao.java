package com.example.activityplatform.dao;

import com.example.activityplatform.pojo.entity.Activityorder;

import java.util.List;

public interface ActivityorderDao {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Activityorder record);

    int insertSelective(Activityorder record);

    Activityorder selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Activityorder record);

    int updateByPrimaryKey(Activityorder record);

    List<Activityorder> selectActidByUserid();
}