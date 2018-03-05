package com.wechat.ws;

import java.io.IOException;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint(value="/ws/chat/{userName}/{userId}")
public class WeChat {
	
	@OnOpen
	public  void onOpen(Session session, EndpointConfig config,@PathParam("userName")String userName,@PathParam("userId")String userId){
		System.out.println(userName+" login "+userId);
		ConnectUtils.putSession(userId, new ConnectionClient(session, userName, userId));
	}
	
	@OnMessage
	public void OnMessage(String message) {
		System.out.println(message);
		try {
			ConnectUtils.getConnectionClient(ConnectUtils.View).getSession().getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OnClose
	public void onClose(@PathParam("userId")String userId) {
		ConnectUtils.logout(userId);
	}
	
	@OnError
	public void onError(Session session, Throwable thr,@PathParam("userId")String userId) {
		//ConnectUtils.logout(userId);
		thr.printStackTrace();
    }

}
