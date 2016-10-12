package com.test.wechat;

import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wechat.messager.service.WechatMessagerServiceAdapter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-context.xml")
@WebAppConfiguration("classpath:spring-servlet.xml")
public class WechatMessagerAdapterTest {

    
    @Autowired
    private ApplicationContext  applicationContext;
    
    @Test
    public void BeanTest(){
        String[] beanNames  = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(applicationContext, WechatMessagerServiceAdapter.class, false, true);
        if(CollectionUtils.isNotEmpty(Arrays.asList(beanNames))){
            for(String beanName : beanNames){
                Object  msgService = applicationContext.getBean(beanName);
                System.out.println(beanName);
            }
        }
    }
}
