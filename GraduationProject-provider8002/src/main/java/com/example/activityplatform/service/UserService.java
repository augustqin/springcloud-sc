package com.example.activityplatform.service;

import com.example.activityplatform.dao.UserDao;
import com.example.activityplatform.pojo.entity.Activity;
import com.example.activityplatform.pojo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qxq
 * @Description:用户的业务操作
 * @DateTime: 2020/4/1 0001$ 4:16$
 * @Params:
 * @Return
 */

public interface UserService {





    /**
* @Author: qxq
* @Description: 登录方法，如正确为true，否则false
* @DateTime: 7:10 2020/4/1 0001
* @Params:
* @Return
*/
    boolean login(String phone,String password);


    /**
    * @Author: qxq
    * @Description: 根据登录用户手机号查询此人的全部消息回显到个人信息界面（UserBackHome)
    * @DateTime: 22:39 2020/4/11 0011
    * @Params:
    * @Return
    */
    User getuser(String phone);


    /**
     * @Author: qxq
     * @Description: 查询登录用户的所有已报名活动ID
     * @DateTime: 0:20 2020/4/12 0012
     * @Params:
     * @Return
     */

   List<User> getAteActIdByuserPhoto(String userPhoto);

   /**
   * @Author: qxq
   * @Description: 查询登录用户的所有发布报名活动ID
   * @DateTime: 4:13 2020/4/12 0012
   * @Params:
   * @Return
   */
    List<User> getPAIByuserPhoto(String userPhoto);
/**
* @Author: qxq
* @Description:
* @DateTime: 1:25 2020/4/26 0026
* @Params:
* @Return
*/

    String getDefaultAddress(String userPhoto);



    int addUser(User user) ;
}
