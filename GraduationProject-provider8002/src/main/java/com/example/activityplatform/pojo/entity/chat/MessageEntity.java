package com.example.activityplatform.pojo.entity.chat;

public class MessageEntity {

	private Long mid;
	private String time;
	private String sender;
	private char type;
    private String content;
	
  	
	@Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", time=" + time +
                ", sender="+ sender +
                ", type = " + type +
                ", content=" + content +
                '}';
    }


	public Long getMid() {
		return mid;
	}


	public void setMid(Long mid) {
		this.mid = mid;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
		
}