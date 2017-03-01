package com.wechat.message;

import com.wechat.comm.WechatRespMsgEnum;


public class WXCustMusicRespMessage extends WXCustBaseRespMessage {
          private  WXCustMusicMessage music;

		public WXCustMusicMessage getMusic() {
			return music;
		}

		public void setMusic(WXCustMusicMessage music) {
			this.music = music;
		}

        @Override
        public String getMsgtype() {
            return WechatRespMsgEnum.music.name();
        }
          
}
