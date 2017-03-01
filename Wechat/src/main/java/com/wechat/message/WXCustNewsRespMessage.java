package com.wechat.message;

import com.wechat.comm.WechatRespMsgEnum;

public class WXCustNewsRespMessage extends WXCustBaseRespMessage {
         private WXCustNewsMessage  news;

		public WXCustNewsMessage getNews() {
			return news;
		}

		public void setNews(WXCustNewsMessage news) {
			this.news = news;
		}

        @Override
        public String getMsgtype() {
            return WechatRespMsgEnum.news.name();
        }
         
}
