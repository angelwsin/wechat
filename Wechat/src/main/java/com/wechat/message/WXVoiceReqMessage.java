package com.wechat.message;

public class WXVoiceReqMessage extends WXBaseMessage{
	/*MediaId	语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	Format	语音格式，如amr，speex等*/
	
	private  String MediaId;
	private  String Format;
	private  String Recognition;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
    public String getRecognition() {
        return Recognition;
    }
    public void setRecognition(String recognition) {
        Recognition = recognition;
    }
	
	
}
