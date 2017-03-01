package com.wechat.material.service;

import java.io.File;

import com.wechat.comm.MaterialTypeEnum;

public interface WechatMaterialService {
    
    
    public void   tempUpload(MaterialTypeEnum type,File file)throws Exception;

}
