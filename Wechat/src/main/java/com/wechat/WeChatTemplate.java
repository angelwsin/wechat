package com.wechat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;


public class WeChatTemplate {
    
    
    public <T> T execute(ConnectionCallback<T> action) throws ClientProtocolException,IOException {
        CloseableHttpClient  client =  HttpClients.createDefault();
        try {
            return action.doInConnection(client); 
        } finally{
            client.close();
        }
       
       /* Assert.notNull(action, "Callback object must not be null");

        Connection con = DataSourceUtils.getConnection(getDataSource());
        try {
            Connection conToUse = con;
            if (this.nativeJdbcExtractor != null) {
                // Extract native JDBC Connection, castable to OracleConnection or the like.
                conToUse = this.nativeJdbcExtractor.getNativeConnection(con);
            }
            else {
                // Create close-suppressing Connection proxy, also preparing returned Statements.
                conToUse = createConnectionProxy(con);
            }
            return action.doInConnection(conToUse);
        }
        catch (SQLException ex) {
            // Release Connection early, to avoid potential connection pool deadlock
            // in the case when the exception translator hasn't been initialized yet.
            DataSourceUtils.releaseConnection(con, getDataSource());
            con = null;
            throw getExceptionTranslator().translate("ConnectionCallback", getSql(action), ex);
        }
        finally {
            DataSourceUtils.releaseConnection(con, getDataSource());
        }*/
    }
    
    public <T> T execute(final HttpUriRequest request,
                         final ResponseHandler<? extends T> responseHandler, final HttpContext context) throws ClientProtocolException,IOException {
      
        class GetCallback implements ConnectionCallback<T> {

            public T doInConnection(CloseableHttpClient httpClient) throws ClientProtocolException,
                                                                   IOException {
                return   httpClient.execute(request,responseHandler,context);
            }
        }
        return execute(new GetCallback());
    }
    
    public <T> T execute(final HttpUriRequest request,
                         final ResponseHandler<? extends T> responseHandler) throws ClientProtocolException,IOException {
      
        class GetCallback implements ConnectionCallback<T> {

            public T doInConnection(CloseableHttpClient httpClient) throws ClientProtocolException,
                                                                   IOException {
                return   httpClient.execute(request,responseHandler);
            }
        }
        return execute(new GetCallback());
    }
    
    public String doForString(final HttpUriRequest request)throws ClientProtocolException,IOException{
        return execute(request, new StringResponseHandler());
      }
    
    @SuppressWarnings("rawtypes")
    public <T> T doGet(final String url,final ResponseHandler responseHandler) throws ClientProtocolException,IOException {
      
        class GetCallback implements ConnectionCallback<T> {

            @SuppressWarnings("unchecked")
            public T doInConnection(CloseableHttpClient httpClient) throws ClientProtocolException,
                                                                   IOException {
                HttpGet httpGet = new HttpGet();
                httpGet.setHeader("Content-Type", "text/html;charset=utf-8");
                StringBuffer buffer = new StringBuffer(url);
                try {
                    httpGet.setURI(new URI(buffer.toString()));
                } catch (URISyntaxException e) {
                 //   logger.error("", e);
                }
                return  (T) httpClient.execute(httpGet,responseHandler);
            }
        }
        return execute(new GetCallback());
    }
    
    public String doGetForString(String url)throws ClientProtocolException,IOException{
             return doGet(url, new StringResponseHandler());
    }
    
    
    
    
   

}
