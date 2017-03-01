package com.wechat.material.service;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wechat.HttpRequestBuilder;
import com.wechat.WeChatTemplate;
import com.wechat.comm.Const;
import com.wechat.comm.MaterialTypeEnum;
import com.wechat.err.Message.ErrorMessage;
import com.wechat.manager.TokenServiceManager;
import com.wechat.util.JSONUtil;

public class WechatMaterialServiceImpl implements WechatMaterialService{
    
    private static final Logger LOGGER = LogManager.getLogger(WechatMaterialServiceImpl.class);
    
     private static final String  TEMPUPLOAD="https://api.weixin.qq.com/cgi-bin/media/upload";//ACCESS_TOKEN&type=

    public void tempUpload(MaterialTypeEnum type,File file) throws Exception{
        WeChatTemplate we = new WeChatTemplate();
        HttpPost post=  HttpRequestBuilder.createUpLoadHttpPost(TEMPUPLOAD+"?access_token="+TokenServiceManager.acessToken()+"&type="+type.getCode(),
            file, null);
        try {
            String resp =  we.doForString(post);
            LOGGER.info(resp);
             ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
             if(errMsg.getErrmsg()!=null){
                 throw new Exception(errMsg.getErrmsg());
             }
           
         } catch (ClientProtocolException e) {
             LOGGER.error(" 创建菜单异常", e);
         } catch (IOException e) {
             LOGGER.error("", e);
         }
    }
    
    public static void main(String[] args) throws Exception{
        WechatMaterialService s = new WechatMaterialServiceImpl();
        File file = new File("d://Tulips.jpg");
        s.tempUpload(MaterialTypeEnum.图片, file);
    }

}
