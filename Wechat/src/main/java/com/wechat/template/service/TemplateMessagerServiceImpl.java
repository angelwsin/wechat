package com.wechat.template.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wechat.DefaultHttpPost;
import com.wechat.WeChatTemplate;
import com.wechat.comm.Const;
import com.wechat.err.Message.ErrorMessage;
import com.wechat.manager.TokenServiceManager;
import com.wechat.message.WXTemplateMessage;
import com.wechat.util.JSONUtil;

public class TemplateMessagerServiceImpl implements TemplateMessagerService{
    private static final Logger LOGGER = LogManager.getLogger(TemplateMessagerServiceImpl.class);
    
    private static final String  SEND="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    public void sendTemplateMsg(WXTemplateMessage msg) throws Exception {
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
             LOGGER.error("发送模板异常", e);
         } catch (IOException e) {
             LOGGER.error("", e);
         }
    }
    
    public static void main(String[] args)throws Exception {
        TemplateMessagerService t = new TemplateMessagerServiceImpl();
        WXTemplateMessage msg = new WXTemplateMessage();
        msg.setTouser("oHtBdtxHaMqGvC42WRpe7FeQBOEo");
        msg.setTemplate_id("EbV04-ilK6j-dcf0Z-sZwIQ6Ihc-YyjMXTQEUP8qVb8");
        msg.setUrl("http://weixin.qq.com/download");
        msg.addData("first", "尊敬的客户，您的订单已支付成功", "#173177");
        msg.addData("keyword1", "2014款背包", "#173177");
        msg.addData("keyword2", "201500001", "#173177");
        msg.addData("keyword3", "150元", "#173177");
        msg.addData("keyword4", "2014年10月21日13：00", "#173177");
        msg.addData("remark", "感谢您的光临", "#173177");
        t.sendTemplateMsg(msg);
    }

}
