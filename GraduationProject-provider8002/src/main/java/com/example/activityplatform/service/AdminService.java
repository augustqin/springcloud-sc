package com.example.activityplatform.service;

import com.example.activityplatform.pojo.entity.Admin;
import com.example.activityplatform.pojo.entity.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qxq
 * @Description:管理员的业务操作
 * @DateTime: 2020/4/2 0002$ 1:46$
 * @Params:
 * @Return
 */
public interface AdminService {


    /**
     * @Author: qxq
     * @Description: 登录方法，如正确为true，否则false
     * @DateTime: 7:10 2020/4/2 0001
     * @Params:
     * @Return
     */
    boolean login(String phone,String password);
/**
* @Author: qxq
* @Description:
* @DateTime: 4:19 2020/4/18 0018
* @Params:
* @Return
*/
    Admin getadmin(String phone);
}
