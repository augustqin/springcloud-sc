package com.example.activityplatform.controller.pages.front.chat;

import java.rmi.ServerError;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.example.activityplatform.config.chat.UserInterceptor;
import com.example.activityplatform.pojo.entity.chat.EasyMessageEntity;
import com.example.activityplatform.pojo.entity.chat.MessageEntity;
import com.example.activityplatform.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
//import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import javax.annotation.Resource;

@Controller
public class ChatController {

	private AtomicLong counter = new AtomicLong();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    ActivityService activityService;


	@Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("chatpage{actid}")
    String chat(Model model,@PathVariable Integer actid){
        model.addAttribute("actchat",activityService.selectById(actid));
        return "pages/front/chat";
    }

    
	/* 群聊：服务器可接收客户端 通过主题 /app/send 发来的消息 ， 客户端需要在 /topic 监听、接收  */
    @MessageMapping("/send/{id}")
    @SendTo("/topic/{id}")
    public MessageEntity sendMessage(@Payload MessageEntity message) throws Exception{
    	System.out.println(message);
    	message.setMid( (Long)counter.incrementAndGet());
    	message.setTime(format.format(new Date()));
        return message;
    }
    
    //私聊
    @MessageMapping("/user/{sendid}/{otherid}")
    @SendTo("/user/{sendid}/{otherid}")
    public MessageEntity sendPrivateMessage(@Payload MessageEntity message,@DestinationVariable("sendid") String sendid,@DestinationVariable("otherid") String otherid) throws Exception{
    	System.out.println(message);
    	message.setMid( (Long)counter.incrementAndGet());
    	message.setTime(format.format(new Date()));
    	messagingTemplate.convertAndSend("/user/"+otherid + "/" + sendid, message); 
        return message;
    }
    
    
    //掉线
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String userid = (String) headerAccessor.getSessionAttributes().get("userid");
        String roomid = (String) headerAccessor.getSessionAttributes().get("roomid");
        String flag = (String) headerAccessor.getSessionAttributes().get("f");
        // 不是输错密码、或重复打开群聊/私聊造成的disconnect
        if(flag == null) {
            EasyMessageEntity message = new EasyMessageEntity();
            message.setType('L');
            message.setSender(userid); 
            System.out.println(userid + " leaves " + roomid);
            if(roomid.length()<=4) messagingTemplate.convertAndSend("/topic/"+roomid, message);    //群聊
            else{
            	messagingTemplate.convertAndSend("/user/"+userid+"/"+roomid, message);
            	messagingTemplate.convertAndSend("/user/"+roomid+"/"+userid, message);
            }
            UserInterceptor.roomuser.get(roomid).remove(userid);
            UserInterceptor.userroom.get(userid).remove(roomid);
        }
      }
    
    @MessageMapping("/add/{id}")
    @SendTo("/topic/{id}")
    public EasyMessageEntity addUser(@Payload EasyMessageEntity message, @DestinationVariable("id") String roomid) throws Exception{
    	EasyMessageEntity m = new EasyMessageEntity();
    	m.setSender(message.getSender());
    	m.setType('M');
    	m.setContent(String.join(" ", UserInterceptor.roomuser.get(roomid)));
    	messagingTemplate.convertAndSend("/member/" + roomid, m);
    	return message;
    }
    //撤回消息
    @MessageMapping("/withdraw/{id}")
    @SendTo("/topic/{id}")
    public EasyMessageEntity withDraw(@Payload EasyMessageEntity message) throws Exception{
        return message;
    }
    
    @MessageMapping("/invite/{id}")
    @SendTo("/invite/{id}")
    public EasyMessageEntity privateChatRequest(@Payload EasyMessageEntity message) throws Exception{
        return message;
    }
    
}
