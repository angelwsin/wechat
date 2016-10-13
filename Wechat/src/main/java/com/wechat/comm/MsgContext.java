package com.wechat.comm;

import org.dom4j.Document;

import com.wechat.message.WXMessage;

public class MsgContext {
    
    
        private MessageTypeEnum  msgTypeEnum;
        
        private WXMessage                msg;
        
        private Document          document;
        
        private String            msgType;
        
        private String            event;

       

        public WXMessage getMsg() {
            return msg;
        }

        public void setMsg(WXMessage msg) {
            this.msg = msg;
        }

        public MessageTypeEnum getMsgTypeEnum() {
            return msgTypeEnum;
        }

        public void setMsgTypeEnum(MessageTypeEnum msgTypeEnum) {
            this.msgTypeEnum = msgTypeEnum;
        }

        public Document getDocument() {
            return document;
        }

        public void setDocument(Document document) {
            this.document = document;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }
        
        
        
        
        

}
