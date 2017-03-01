package com.wechat.message;

import com.wechat.comm.WechatRespMsgEnum;

public class WXCustImageRespMessage extends WXCustBaseRespMessage{
             private WXCustImageMessage image;

			public WXCustImageMessage getImage() {
				return image;
			}

			public void setImage(WXCustImageMessage image) {
				this.image = image;
			}

            @Override
            public String getMsgtype() {
                return WechatRespMsgEnum.image.name();
            }
             
}
