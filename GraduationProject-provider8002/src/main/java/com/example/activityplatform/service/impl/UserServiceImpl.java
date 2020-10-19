package com.example.activityplatform.service.impl;

import com.example.activityplatform.dao.UserDao;
import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.pojo.entity.User;
import com.example.activityplatform.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/1 0001$ 22:15$
 * @Params:
 * @Return
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;



    @Override
    public boolean login(String phone,String password) {


        User dbUser = userDao.selectByPhone(phone);

        if(dbUser == null){
            return false;
        }else{
            if(password == null)return false;
            if(password.equals(dbUser.getUserpassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User getuser(String phone) {

        User dbUser = userDao.selectByPhone(phone);
        return dbUser;
    }

    @Override
    public List<User> getAteActIdByuserPhoto(String userPhoto) {
        return userDao.selectAAIdByPhone(userPhoto);
    }

    @Override
    public List<User> getPAIByuserPhoto(String userPhoto) {
        return userDao.selectPAIdByPhone(userPhoto);
    }

    @Override
    public String getDefaultAddress(String userPhoto) {
        return userDao.selectAddressByPhone(userPhoto);
    }

    @Override
    public int addUser(User user) {
        return userDao.insertforRegister(user);
    }
}
