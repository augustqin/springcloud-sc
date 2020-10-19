package com.example.activityplatform.pojo.entity;

import java.io.Serializable;

/**
 * admin
 * @author 
 */
public class Admin implements Serializable {
    private Integer idadmin;

    private String adminname;

    private String adminphone;

    private String adminpassword;

    private Integer publishedactivityid;

    private static final long serialVersionUID = 1L;

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminphone() {
        return adminphone;
    }

    public void setAdminphone(String adminphone) {
        this.adminphone = adminphone;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public Integer getPublishedactivityid() {
        return publishedactivityid;
    }

    public void setPublishedactivityid(Integer publishedactivityid) {
        this.publishedactivityid = publishedactivityid;
    }
}