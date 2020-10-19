package com.example.activityplatform.service.impl;

import com.example.activityplatform.dao.AdminDao;
import com.example.activityplatform.pojo.entity.Admin;
import com.example.activityplatform.pojo.entity.User;
import com.example.activityplatform.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/2 0002$ 1:47$
 * @Params:
 * @Return
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminDao adminDao;

    @Transactional
    @Override
    public boolean login(String phone,String password) {


        Admin dbAdmin = adminDao.selectByPhone(phone);

        if(dbAdmin == null){
            return false;
        }else{
            if(password == null)return false;
            if(password.equals(dbAdmin.getAdminpassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Admin getadmin(String phone) {
        return adminDao.selectByPhone(phone);
    }
}
