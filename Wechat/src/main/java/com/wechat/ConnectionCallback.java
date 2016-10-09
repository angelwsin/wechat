package com.wechat;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;

public interface ConnectionCallback<T> {
    
    T doInConnection(CloseableHttpClient httpClient) throws ClientProtocolException,IOException;

}
