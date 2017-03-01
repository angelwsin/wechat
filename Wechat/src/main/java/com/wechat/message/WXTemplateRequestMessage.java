package com.wechat.message;

public class WXTemplateRequestMessage extends WXMessage{
    
    private String Event;
    
    private String MsgID;
    
    private String Status;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
    
    

}
