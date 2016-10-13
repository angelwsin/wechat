package com.wechat.message.event;

public class WXLocationSelectMessage  extends WXBaseEventMessage{
    
    private   WXSendLocationInfo          SendLocationInfo;

    public WXSendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(WXSendLocationInfo sendLocationInfo) {
        SendLocationInfo = sendLocationInfo;
    }
    
    

}
