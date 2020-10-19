package com.example.activityplatform.service.impl;

import com.example.activityplatform.dao.ActivityorderDao;
import com.example.activityplatform.pojo.entity.Activityorder;
import com.example.activityplatform.service.ActivityorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/26 0026$ 4:40$
 * @Params:
 * @Return
 */
@Service
public class ActivityorderServiceImpl implements ActivityorderService {

    @Resource
    ActivityorderDao activityorderDao;
    @Override
    public void addOrder(Activityorder Activityorder) {
         activityorderDao.insert(Activityorder);
    }

    @Override
    public Activityorder getOrderDetailByOrderId(Integer orderid) {
        return activityorderDao.selectByPrimaryKey(orderid);
    }

    @Override
    public boolean updatePayStatus(Activityorder dbOrder) {
        return activityorderDao.updateByPrimaryKeySelective(dbOrder) == 1;
    }

    @Override
    public List<Activityorder> selectActidByUserid(Integer userid) {
        return activityorderDao.selectActidByUserid();
    }

}
