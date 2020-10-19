package com.example.activityplatform.service;


import com.example.activityplatform.pojo.entity.Activityorder;

import java.util.List;

/**
 * @Author: qxq
 * @Description:
 * @DateTime: 2020/4/26 0026$ 4:39$
 * @Params:
 * @Return
 */
public interface ActivityorderService {
/**
* @Author: qxq
* @Description:
* @DateTime: 5:08 2020/4/26 0026
* @Params:
* @Return
*/
    void addOrder(Activityorder Activityorder);
/**
* @Author: qxq
* @Description:
* @DateTime: 5:08 2020/4/26 0026
* @Params:
* @Return
*/

    Activityorder getOrderDetailByOrderId(Integer orderid);

    /**
     * 更新付款状态
     *
     * @param dbOrder
     * @return
     */
    boolean updatePayStatus(Activityorder dbOrder);

    /**
    * @Author: qxq
    * @Description:
    * @DateTime: 23:36 2020/5/19 0019
    * @Params:
    * @Return
    */

    List<Activityorder> selectActidByUserid(Integer userid);
}
