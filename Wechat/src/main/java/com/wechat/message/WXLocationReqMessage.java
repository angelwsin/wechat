package com.wechat.message;

public class WXLocationReqMessage extends WXBaseMessage{
/*
	Location_X	地理位置维度
	Location_Y	地理位置经度
	Scale	地图缩放大小
	Label	地理位置信息*/
	
	
	private String Location_X;
	private String  Location_Y;
	private int Scale;
	private String Label;
	
	
	public String getLocation_X() {
        return Location_X;
    }
    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }
    public String getLocation_Y() {
        return Location_Y;
    }
    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }
    public int getScale() {
		return Scale;
	}
	public void setScale(int scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	
	
}
