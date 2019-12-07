package cn.wuaijing.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HttpUtil {
    /**
     * 使用Get请求
     *
     * @param host
     * @param path
     * @return
     */
    public static HttpResponse SendGet(String host, String path,
                                       Map<String, String> headers,
                                       Map<String, String> query) throws IOException {
        //创建客户端请求
        HttpClient httpClient = creatClient(host, path);
        HttpGet httpGet = new HttpGet(buildUrl(host,path,query));
        for(Map.Entry<String,String> entry : headers.entrySet()){
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        return httpClient.execute(httpGet);
    }

    /**
     * 不含请求头部信息的GET请求
     * @param host
     * @param path
     * @param query
     * @return
     * @throws IOException
     */
    public static HttpResponse SendGet(String host, String path,
                                       Map<String, String> query) throws IOException {
        //创建客户端请求
        HttpClient httpClient = creatClient(host, path);
        HttpGet httpGet = new HttpGet(buildUrl(host,path,query));
        return httpClient.execute(httpGet);
    }


    /**
     * POST请求 Body封装成Map
     * @param host
     * @param path
     * @param headers
     * @param query
     * @param body
     * @return
     * @throws IOException
     */
    public  static HttpResponse sendPost(String host,String path,
                                         Map<String,String> headers,
                                         Map<String,String> query,
                                         Map<String,String> body) throws IOException {
            //创建一个客户端请求
            HttpClient httpClient = creatClient(host,path);
            //封装url
            HttpPost httpPost = new HttpPost(buildUrl(host,path,query));
        for (Map.Entry<String,String> entry : headers.entrySet()
             ) {
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        //将数据封装到请求体
        if(null != body){
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for ( String key : body.keySet()
                 ) {
                nameValuePairList.add(new BasicNameValuePair(key,body.get(key)));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList,"utf-8");
            formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
            httpPost.setEntity(formEntity);
        }
        //返回请求的响应
        return  httpClient.execute(httpPost);
    }

    /**
     * POST请求，Body封装成String类型
     * @param host
     * @param path
     * @param headers
     * @param query
     * @param body
     * @return
     * @throws IOException
     */
    public static HttpResponse sendPost(String host, String path,
                                        Map<String,String> headers,
                                        Map<String,String> query,
                                        String body) throws IOException {
        HttpClient httpClient = creatClient(host, path);
        HttpPost httpPost = new HttpPost(buildUrl(host, path, query));
        //往请求里面加入请求头
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        //装入请求体
        if(StringUtils.isNotBlank(body)){
            httpPost.setEntity(new StringEntity(body,"UTF-8"));
        }
        return httpClient.execute(httpPost);
    }

    /**
     *
     * POST请求 Body封装成byte数组
     * @param host
     * @param path
     * @param headers
     * @param query
     * @param body
     * @return
     * @throws IOException
     */
    public  static HttpResponse sendPost(String host,String path,
                                             Map<String,String> headers,
                                             Map<String,String> query,
                                             byte[] body) throws IOException {
        HttpClient httpClient = creatClient(host,path);
        HttpPost httpPost = new HttpPost(buildUrl(host,path,query));
            for (Map.Entry<String,String> entry : headers.entrySet()
                 ) {
                httpPost.addHeader(entry.getKey(),entry.getValue());
            }
            if(null != body){
                httpPost.setEntity(new ByteArrayEntity(body));
            }
            return httpClient.execute(httpPost);
        }
    /**
     * 创建一个httpClient对象
     * @param host
     * @param path
     * @return
     */
    private static HttpClient creatClient(String host, String path) {
        //创建一个http客户端
        HttpClient client = HttpClientBuilder.create().build();
        //删除前后空格并判断起始位置是否是https
        if (host.trim().startsWith("https://")) {
            return sslClient();
            //判断host是否为空并且path不为空，path开头是https
        } else if (StringUtils.isBlank(host) && path != null && path.startsWith("https://")) {
            return sslClient();
        }
        return client;
    }
    /**
     * 访问带有安全证书的请求
     *
     * @param ：httpClient
     */
    private static HttpClient sslClient() {
        //发送客户端请求并关闭
        CloseableHttpClient closeableHttpClient = null;
        try {
            //定义SSL安全套接字的实现,使用TLS证书验证
            SSLContext sslContext = SSLContext.getInstance("TLS");
            //用于验证服务端的安全套接字，设置返回null
            X509TrustManager xtm = new X509TrustManager() {
                //该方法检查客户端的证书，若不信任该证书则抛出异常。由于我们不需要对客户端进行认证，
                //因此我们只需要执行默认的信任管理器的这个方法。JSSE中，默认的信任管理器类为TrustManager。
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                //该方法检查服务器的证书，若不信任该证书同样抛出异常。通过自己实现该方法，可以使之信任我们指定的任何证书。
                //在实现该方法时，也可以简单的不做任何处理，即一个空的函数体，由于不会抛出异常，它就会信任任何证书。
                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                //返回受信任的证书数组
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            //初始化SSLContext
            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());
            //创建一个SSLConnectionSocketFactory 安全连接Socket工厂，并设置为关闭主机名验证
            //NoopHostnameVerifier.INSTANCE:关闭主机名验证
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
            //通过 RequestConfig.custom()方法获取配置器，配置请求的相关配置
            RequestConfig.Builder requestConfig = RequestConfig.custom()
                    //设置请求连接时长
                    .setConnectionRequestTimeout(5000)
                    //设置连接时长
                    .setConnectTimeout(5000)
                    //设置数据传输最长时间
                    .setSocketTimeout(5000)
                    //设置Cookie
                    .setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    //设置100次连续握手
                    //.setExpectContinueEnabled(Boolean.TRUE)
                    //设置目标主机身份验证方案的有限顺序,返回集合类型
                    .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                    //设置代理主机进行身份验证方案的有限顺序,返回集合类型，设置为最基本的验证方案
                    .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC));
            //配置注册http和https
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    //创建普通（未加密）的套接字
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    //创建安全（加密）的套接字
                    .register("https", socketFactory).build();
            //创建一个请求连接，添加链接的信息
            PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager(registry);
            //创建一个http客户端发送链接，并关闭链接
            closeableHttpClient = HttpClients.custom()
                    .setConnectionManager(clientConnectionManager)
                    .setDefaultRequestConfig(requestConfig.build()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return closeableHttpClient;
    }

    /**
     * 构建请求的url
     * @param host
     * @param path
     * @param queries
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String buildUrl(String host, String path, Map<String, String> queries) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder();
        if(StringUtils.isNotBlank(host)){
            url.append(host);
        }
        if (StringUtils.isNotBlank(path)){
            url.append(path);
        }
        if (null != queries){
            StringBuilder subQuery = new StringBuilder();
            for (Map.Entry<String,String> query:queries.entrySet()
            ) {
                //如果subQuery的长度大于0，则追加“&”
                if (0 < subQuery.length()){
                    subQuery.append("&");
                }
                //如果query中的key为空，value不为空，则加入value值
                if (StringUtils.isBlank(query.getKey()) && StringUtils.isNotBlank(query.getValue())){
                    subQuery.append(query.getValue());
                }
                if(StringUtils.isNotBlank(query.getKey())){
                    subQuery.append(query.getKey());
                    if (StringUtils.isNotBlank(query.getValue())){
                        subQuery.append("=");
                        String urlPath = "";
                        try{
                            urlPath =  URLEncoder.encode(query.getValue(), "utf-8");
                        }catch (UnsupportedEncodingException uee){
                            uee.printStackTrace();
                        }
                        subQuery.append(urlPath);

                    }
                }
            }
            if (0 < subQuery.length()){
                url.append("?").append(subQuery);
            }
        }
        return  url.toString();
    }

}
