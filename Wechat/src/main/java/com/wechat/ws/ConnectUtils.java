package com.wechat.ws;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.websocket.WebSocketContainer;

import com.wechat.comm.MsgContext;
import com.wechat.message.WXMessage;


public class ConnectUtils {
	
	private static final Map<String, ConnectionClient> connections = new ConcurrentHashMap<String,ConnectionClient>();
	public final static  String View = "system";
	
	public static  ServletContext SERVLET_CONTEXT ;
	
	public static  String         ServerName;
	
	public static  String         port;
	
	public static  String        contextPath;
	
	
	public static void putSession(String userId,ConnectionClient session){
		connections.put(userId, session);
	}
	
	
	public static ConnectionClient getConnectionClient(String userName) {
		return connections.get(userName);
	}

	
	public static void logout(String userId){
		connections.remove(userId);
	}
	
	public static void login(MsgContext msgContext) {
		WXMessage msg = msgContext.getMsg();
		if (ConnectUtils.getConnectionClient(msg.getFromUserName()) == null) {
			// 加入websocket 显示
			WebSocketContainer container = (WebSocketContainer) SERVLET_CONTEXT
					.getAttribute("javax.websocket.server.ServerContainer");
			try {
				// System.out.println("ws://"+request.getContextPath()+"/ws/chat");
				 container.connectToServer(ViewClient.class, new URI("ws://" + ServerName + ":" + port
						+ contextPath + "/ws/chat/" + msg.getFromUserName() + "/" + msg.getFromUserName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(" Session失败", e);
			}
		}

	}
	
	public static  void sendText(String userId,String message){
		try {
			ConnectUtils.getConnectionClient(userId).getSession().getBasicRemote().sendText(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
