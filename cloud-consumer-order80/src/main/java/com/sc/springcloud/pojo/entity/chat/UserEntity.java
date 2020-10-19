package com.sc.springcloud.pojo.entity.chat;

public class UserEntity {
    private String userid;
    private String password;
    
    public UserEntity(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
