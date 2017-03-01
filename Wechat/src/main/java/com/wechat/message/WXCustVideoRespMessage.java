package com.wechat.message;

import com.wechat.comm.WechatRespMsgEnum;

public class WXCustVideoRespMessage extends WXCustBaseRespMessage{
           private WXCustVideoMessage video;

		public WXCustVideoMessage getVideo() {
			return video;
		}

		public void setVideo(WXCustVideoMessage video) {
			this.video = video;
		}

        @Override
        public String getMsgtype() {
            return WechatRespMsgEnum.video.name();
        }
           
}
