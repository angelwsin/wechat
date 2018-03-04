package com.wechat.ws;

import javax.websocket.ClientEndpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

@ClientEndpoint
public class ViewClient {
	
	@OnOpen
	public  void onOpen(Session session, EndpointConfig config){
		System.out.println("client");
	}
	
	public void OnMessage(Session session,@PathParam("message")String message){
		
		System.out.println(message);
		
	}

}
