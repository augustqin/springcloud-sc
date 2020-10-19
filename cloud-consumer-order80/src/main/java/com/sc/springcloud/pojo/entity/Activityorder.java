package com.sc.springcloud.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * activityorder
 * @author 
 */
public class Activityorder implements Serializable {
    private Integer orderid;

    private Integer userid;

    private Integer activityid;

    private Integer allcost;

    private Date createtime;

    private Date paytime;

    private String paytype;

    private String status;

    private String receiveaddress;

    private static final long serialVersionUID = 1L;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getAllcost() {
        return allcost;
    }

    public void setAllcost(Integer allcost) {
        this.allcost = allcost;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }
}