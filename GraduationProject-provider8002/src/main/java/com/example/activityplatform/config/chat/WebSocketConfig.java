package com.example.activityplatform.config.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.messaging.simp.config.ChannelRegistration;


@Configuration
@EnableWebSocketMessageBroker   //服务端WebSocker 的初始化
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	/*注册一个WebSocker，给客户端连接到WebSocket服务器*/
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();  /*withSockJS: 用来为不支持WebSocket的浏览器启用后备选项*/
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	registry.enableSimpleBroker("/topic","/user","/member","/invite");  //在topic,user 域上可以向客户端发消息；使用内存上的消息代理
    	
    	/*客户端向服务端发送，加 /app 作为前缀*/
        registry.setApplicationDestinationPrefixes("/app");
        
        // 客户一对一，前缀是 /user/ 
        registry.setUserDestinationPrefix("/user/");   //
    }
   
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration){
        registration.interceptors(new UserInterceptor());
    }
    
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        /*
         * 1. setMessageSizeLimit 设置消息的字节数大小 字节
         * 2. setSendBufferSizeLimit 设置websocket会话时，缓存的大小 字节   要与Client.js 中sendPicture的 协调
         * 3. setSendTimeLimit 设置消息发送会话超时时间，毫秒
         */
        registration.setMessageSizeLimit(2048 * 1024)   //default: 64 *1024 (64k)
                    .setSendBufferSizeLimit(2048 * 1024)       //default: 512 *1024
                    .setSendTimeLimit(10000);
    }
}
