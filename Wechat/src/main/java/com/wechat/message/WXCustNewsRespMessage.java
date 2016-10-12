package com.wechat.message;

public class WXCustNewsRespMessage extends WXCustBaseRespMessage {
         private WXCustNewsMessage  news;

		public WXCustNewsMessage getNews() {
			return news;
		}

		public void setNews(WXCustNewsMessage news) {
			this.news = news;
		}
         
}
