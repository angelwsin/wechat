package com.wechat.message;

import com.wechat.comm.WechatRespMsgEnum;

public class WXCustTextRespMessage extends WXCustBaseRespMessage{
                   private  WXCustTextMessage text;

				public WXCustTextMessage getText() {
					return text;
				}

				public void setText(WXCustTextMessage text) {
					this.text = text;
				}
				
				@Override
				public String getMsgtype() {
				return  WechatRespMsgEnum.text.name();
				}
                   
}
