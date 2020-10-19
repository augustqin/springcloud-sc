package com.sc.springcloud.pojo.entity;

import java.io.Serializable;

/**
 * user
 * @author 
 */
public class User implements Serializable {
    private Integer iduser;

    private String username;

    private String userphone;

    private String userpassword;

    private String useridcard;

    private String useradress;

    private Integer attendedactivityid;

    private Integer publishedactivityid;

    /**
     * 参加的活动的完成情况，有已完成，或者未完成
     */
    private String attendedactstatus;

    private static final long serialVersionUID = 1L;

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseridcard() {
        return useridcard;
    }

    public void setUseridcard(String useridcard) {
        this.useridcard = useridcard;
    }

    public String getUseradress() {
        return useradress;
    }

    public void setUseradress(String useradress) {
        this.useradress = useradress;
    }

    public Integer getAttendedactivityid() {
        return attendedactivityid;
    }

    public void setAttendedactivityid(Integer attendedactivityid) {
        this.attendedactivityid = attendedactivityid;
    }

    public Integer getPublishedactivityid() {
        return publishedactivityid;
    }

    public void setPublishedactivityid(Integer publishedactivityid) {
        this.publishedactivityid = publishedactivityid;
    }

    public String getAttendedactstatus() {
        return attendedactstatus;
    }

    public void setAttendedactstatus(String attendedactstatus) {
        this.attendedactstatus = attendedactstatus;
    }
}