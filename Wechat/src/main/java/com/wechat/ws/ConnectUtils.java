package com.wechat.ws;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

public class ConnectUtils {
	
	private static final Map<String, Session> connections = new ConcurrentHashMap<String,Session>();
	public final static  String View = "system";
	
	
	public static void putSession(String userName,Session session){
		connections.put(userName, session);
	}
	
	
	public static Session getSession(String userName){
		return connections.get(userName);
	}

}
