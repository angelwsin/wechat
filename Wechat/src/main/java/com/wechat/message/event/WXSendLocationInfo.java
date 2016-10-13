package com.wechat.message.event;

public class WXSendLocationInfo {
	/*Location_X 	X坐标信息
	Location_Y 	Y坐标信息
	Scale 	精度，可理解为精度或者比例尺、越精细的话 scale越高
	Label 	地理位置的字符串信息
	Poiname 	朋友圈POI的名字，可能为空 */
	private String Location_X ;
	private String Location_Y;
	private int Scale;
	private String Label;
	private String Poiname;
	
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
	public String getPoiname() {
		return Poiname;
	}
	public void setPoiname(String poiname) {
		Poiname = poiname;
	}
	
	
}
