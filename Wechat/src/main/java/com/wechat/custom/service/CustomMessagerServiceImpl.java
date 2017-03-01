package com.wechat.custom.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wechat.DefaultHttpPost;
import com.wechat.WeChatTemplate;
import com.wechat.comm.Const;
import com.wechat.err.Message.ErrorMessage;
import com.wechat.manager.TokenServiceManager;
import com.wechat.message.WXCustBaseRespMessage;
import com.wechat.message.WXCustTextMessage;
import com.wechat.message.WXCustTextRespMessage;
import com.wechat.util.JSONUtil;

//客服接口 可以异步发送消息
public class CustomMessagerServiceImpl implements CustomMessagerService{
    private static final Logger LOGGER = LogManager.getLogger(CustomMessagerServiceImpl.class);
    
    private static final String  SEND="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";

    public void sendMsg(WXCustBaseRespMessage msg)throws Exception {
        WeChatTemplate we = new WeChatTemplate();
        DefaultHttpPost post = new DefaultHttpPost(SEND+TokenServiceManager.acessToken());
        post.addHeaderValue("Content-Type", "application/json;charset=utf-8")
        .addHeaderValue("Accept", "application/json").buildStringContent(JSONUtil.encode(msg));;
        try {
            String resp =  we.doForString(post);
            LOGGER.info(resp);
             ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
             if(Const.ERRCODE!=errMsg.getErrcode()){
                 throw new Exception(errMsg.getErrmsg());
             }
           
         } catch (ClientProtocolException e) {
             LOGGER.error(" 创建菜单异常", e);
         } catch (IOException e) {
             LOGGER.error("", e);
         }
        
    }
    
    public static void main(String[] args) throws Exception{
        WXCustTextRespMessage msg = new WXCustTextRespMessage();
        msg.setTouser("oHtBdtxHaMqGvC42WRpe7FeQBOEo");
        WXCustTextMessage text = new WXCustTextMessage();
        text.setContent("哈哈");
        msg.setText(text);
        CustomMessagerService s = new CustomMessagerServiceImpl();
        s.sendMsg(msg);
        System.out.println(JSONUtil.encode(msg));
    }

}
