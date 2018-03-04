package com.wechat.ws;

import java.io.IOException;

import javax.websocket.EndpointConfig;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint(value="/ws/chat")
public class WeChat {
	
	@OnOpen
	public  void onOpen(Session session, EndpointConfig config,@PathParam("userName")String userName){
		ConnectUtils.putSession(userName, session);
	}
	
	public void OnMessage(Session session,@PathParam("message")String message){
		try {
			ConnectUtils.getSession(ConnectUtils.View).getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
