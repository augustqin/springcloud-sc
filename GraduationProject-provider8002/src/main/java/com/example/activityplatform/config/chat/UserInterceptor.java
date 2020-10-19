package com.example.activityplatform.config.chat;


import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

import com.example.activityplatform.pojo.entity.chat.FastPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

public class UserInterceptor implements ChannelInterceptor {
	public  Map<String,String> user = new HashMap<String,String>();       //存储用户名、密码
	//记录在线信息
	public static Map<String,Set<String>> userroom = new HashMap<String,Set<String>>();   //用户和群的映射（将单聊的对方的id也看成room）
	public static Map<String,Set<String>> roomuser = new HashMap<String,Set<String>>();   //群和用户的映射（将单聊的对方的id也看成room）
	
	@Autowired
    private  SimpMessagingTemplate messagingTemplate;
	/**
     * 获取包含在stomp中的用户信息
     */
    public Message<?> preSend(Message<?> message, MessageChannel channel){
    	//使用SimpleMessageHeader类好像也可？
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())){
            String userid = accessor.getNativeHeader("userid").get(0);
            String roomid = accessor.getNativeHeader("roomid").get(0);
            boolean flag = roomid.length()<=4? true: false;  //true:群聊  false:私聊
            accessor.getSessionAttributes().put("userid", userid);     // 消息头存入该属性，收到disconnect报文时，可获得该属性值，得知哪位用户掉线
            accessor.getSessionAttributes().put("roomid",roomid);
            String password = accessor.getNativeHeader("password").get(0);
            if(user.get(userid)==null) {  //以前未登录过，刚注册
            	user.put(userid, password);   	
        		System.out.println(userid + " signs up with password " + password);
            }
            else if (!user.get(userid).equals(password)){   //已注册，本次登录密码错误
                accessor.setUser(new FastPrincipal("FP"));   //标记密码错误，让Clien.js 识别，以断开连接
                accessor.getSessionAttributes().put("f","FP");
                System.out.println(userid + " inputs wrong password. Right password: " + user.get(userid));
                return message;
            }
            // 密码正确
            //群聊
            Set<String> roomuserList = roomuser.get(roomid);
            Set<String> userroomList = userroom.get(userid);
            if(flag) {
            	if(userroomList!=null && userroomList.contains(roomid)) {   //已经连接到该房间
            		accessor.setUser(new FastPrincipal("DC"));  //标记重复连接
                	accessor.getSessionAttributes().put("f","DC");
                	System.out.println("( Public chat )" + userid + " inputs right password, but has connected to " + roomid );
                	return message;
            	}                 
            }
            //私聊
            else {
            	Set<String> userroomListOther = userroom.get(roomid);
            	if(userroomListOther == null || userroomListOther.isEmpty()) {             //对方不在线（或该用户不存在）
            		accessor.setUser(new FastPrincipal("OD"));   //标记对方不在线       
        			accessor.getSessionAttributes().put("f","OD");
        			System.out.println("(Private chat )" + userid + " inputs right password, but another user " + roomid + " is not online.");
        			return message;
            	}
            	if(userroomList!=null && userroomList.contains(roomid)) {   //已经连接到对方
            		accessor.setUser(new FastPrincipal("DC"));  //标记重复连接
                	accessor.getSessionAttributes().put("f","DC");
                	System.out.println("( Private chat )" + userid + " inputs right password, but has connected to " + roomid );
                	return message;
            	}   
            	//if(!userroom.get(roomid).contains(userid)) {  }     //对方尚未连接到自己（自己是发起连接请求的人）
            }
            System.out.println(userid + "inputs right password, connecting to " + roomid);
            //信息存入userroom
            if(userroomList==null) {
            	Set<String> a = new HashSet<String>();  
            	a.add(roomid);
            	userroom.put(userid,a);    
            }
            else userroomList.add(roomid);
            //信息存入roomuser
            if(roomuserList==null) {
            	Set<String> a = new HashSet<String>();  
        		a.add(userid);
        		roomuser.put(roomid,a); 
            }
            else roomuserList.add(userid);
        }
     
        return message;
    }
}
