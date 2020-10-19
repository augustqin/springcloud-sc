package com.sc.springcloud.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * activity
 * @author 
 */
public class Activity implements Serializable {
    private Integer activityid;

    private String activityclassification;

    private String activityname;

    private Date applicationtime;

    private Date activitytime;

    private Integer activityprice;

    private String activitydescription;

    private String activityphoto;

    private String activityqrcode;

    private Integer activitylimit;

    private String activityplace;

    private Integer activitypublishid;

    /**
     * 是否为热门活动，如果是为1，否则为2，显示在首页
     */
    private Integer hot;

    private static final long serialVersionUID = 1L;

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getActivityclassification() {
        return activityclassification;
    }

    public void setActivityclassification(String activityclassification) {
        this.activityclassification = activityclassification;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public Date getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(Date applicationtime) {
        this.applicationtime = applicationtime;
    }

    public Date getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(Date activitytime) {
        this.activitytime = activitytime;
    }

    public Integer getActivityprice() {
        return activityprice;
    }

    public void setActivityprice(Integer activityprice) {
        this.activityprice = activityprice;
    }

    public String getActivitydescription() {
        return activitydescription;
    }

    public void setActivitydescription(String activitydescription) {
        this.activitydescription = activitydescription;
    }

    public String getActivityphoto() {
        return activityphoto;
    }

    public void setActivityphoto(String activityphoto) {
        this.activityphoto = activityphoto;
    }

    public String getActivityqrcode() {
        return activityqrcode;
    }

    public void setActivityqrcode(String activityqrcode) {
        this.activityqrcode = activityqrcode;
    }

    public Integer getActivitylimit() {
        return activitylimit;
    }

    public void setActivitylimit(Integer activitylimit) {
        this.activitylimit = activitylimit;
    }

    public String getActivityplace() {
        return activityplace;
    }

    public void setActivityplace(String activityplace) {
        this.activityplace = activityplace;
    }

    public Integer getActivitypublishid() {
        return activitypublishid;
    }

    public void setActivitypublishid(Integer activitypublishid) {
        this.activitypublishid = activitypublishid;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}