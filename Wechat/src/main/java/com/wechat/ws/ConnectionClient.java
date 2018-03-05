package com.wechat.ws;

import javax.websocket.Session;

public class ConnectionClient {
	
	
	private Session session;
	
	private String  userName;
	
	private String  UserId;
	
	

	public ConnectionClient(Session session, String userName, String userId) {
		this.session = session;
		this.userName = userName;
		UserId = userId;
	}

	public Session getSession() {
		return session;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return UserId;
	}
	
	

}
