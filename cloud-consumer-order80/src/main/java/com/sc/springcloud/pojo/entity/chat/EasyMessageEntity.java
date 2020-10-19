package com.sc.springcloud.pojo.entity.chat;

public class EasyMessageEntity {
	private String sender;
	private char type;   //L:离开   E：加入   T：文本  P：图片  W：撤回     M：成员消息
	private String content;
	@Override
	public String toString() {
		return "EasyMessage{" +              
                "sender = "+ sender +
                ",type = " + type + 
                ",content = " + content + 
                '}';
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
}
