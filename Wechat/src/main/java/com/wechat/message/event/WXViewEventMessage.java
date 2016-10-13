package com.wechat.message.event;

public class WXViewEventMessage extends WXBaseEventMessage{
	/*EventKey	事件KEY值，设置的跳转URL*/
	
    private String MenuId;

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
    
    
	
	
	
}
