package com.wechat.message;

import com.wechat.comm.WechatRespMsgEnum;

public class WXCustVoiceRespMessage extends WXCustBaseRespMessage{
           private  WXCustVoiceMessage voice;

		public WXCustVoiceMessage getVoice() {
			return voice;
		}

		public void setVoice(WXCustVoiceMessage voice) {
			this.voice = voice;
		}

        @Override
        public String getMsgtype() {
            return WechatRespMsgEnum.video.name();
        }
           
}
