/*

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class TEST {

        */
/**
         * get
         *
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @return
         * @throws Exception
         *//*

        public static HttpResponse doGet(String host, String path, String method,
                                         Map<String, String> headers,
                                         Map<String, String> querys)
                throws Exception {
            HttpClient httpClient = wrapClient(host);

            HttpGet request = new HttpGet(buildUrl(host, path, querys));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                request.addHeader(e.getKey(), e.getValue());
            }

            return httpClient.execute(request);
        }

        */
/**
         * post form
         *
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @param bodys
         * @return
         * @throws Exception
         *//*

        public static HttpResponse doPost(String host, String path, String method,
                                          Map<String, String> headers,
                                          Map<String, String> querys,
                                          Map<String, String> bodys)
                throws Exception {
            HttpClient httpClient = wrapClient(host);

            HttpPost request = new HttpPost(buildUrl(host, path, querys));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                request.addHeader(e.getKey(), e.getValue());
            }

            if (bodys != null) {
                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();

                for (String key : bodys.keySet()) {
                    nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
                }
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
                formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
                request.setEntity(formEntity);
            }

            return httpClient.execute(request);
        }

        */
/**
         * Post String
         *
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @param body
         * @return
         * @throws Exception
         *//*

        public static HttpResponse doPost(String host, String path, String method,
                                          Map<String, String> headers,
                                          Map<String, String> querys,
                                          String body)
                throws Exception {
            HttpClient httpClient = wrapClient(host);

            HttpPost request = new HttpPost(buildUrl(host, path, querys));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                request.addHeader(e.getKey(), e.getValue());
            }

            if (StringUtils.isNotBlank(body)) {
                request.setEntity(new StringEntity(body, "utf-8"));
            }

            return httpClient.execute(request);
        }

        */
/**
         * Post stream
         *
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @param body
         * @return
         * @throws Exception
         *//*

        public static HttpResponse doPost(String host, String path, String method,
                                          Map<String, String> headers,
                                          Map<String, String> querys,
                                          byte[] body)
                throws Exception {
            HttpClient httpClient = wrapClient(host);

            HttpPost request = new HttpPost(buildUrl(host, path, querys));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                request.addHeader(e.getKey(), e.getValue());
            }

            if (body != null) {
                request.setEntity(new ByteArrayEntity(body));
            }

            return httpClient.execute(request);
        }

        */
/**
         * Put String
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @param body
         * @return
         * @throws Exception
         *//*

        public static HttpResponse doPut(String host, String path, String method,
                                         Map<String, String> headers,
                                         Map<String, String> querys,
                                         String body)
                throws Exception {
            HttpClient httpClient = wrapClient(host);

            HttpPut request = new HttpPut(buildUrl(host, path, querys));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                request.addHeader(e.getKey(), e.getValue());
            }

            if (StringUtils.isNotBlank(body)) {
                request.setEntity(new StringEntity(body, "utf-8"));
            }

            return httpClient.execute(request);
        }

        */
/**
         * Put stream
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @param body
         * @return
         * @throws Exception
         *//*

        public static HttpResponse doPut(String host, String path, String method,
                                         Map<String, String> headers,
                                         Map<String, String> querys,
                                         byte[] body)
                throws Exception {
            HttpClient httpClient = wrapClient(host);

            HttpPut request = new HttpPut(buildUrl(host, path, querys));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                request.addHeader(e.getKey(), e.getValue());
            }

            if (body != null) {
                request.setEntity(new ByteArrayEntity(body));
            }

            return httpClient.execute(request);
        }

        */

import cn.wuaijing.controller.WeatherController;
import cn.wuaijing.service.WeatherService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
         * Delete
         *
         * @param host
         * @param path
         * @param method
         * @param headers
         * @param querys
         * @return
         * @throws Exception
         *//*

        public static HttpResponse doDelete(String host, String path, String method,
                                            Map<String, String> headers,
                                            Map<String, String> querys)
                throws Exception {
            HttpClient httpClient = wrapClient(host);

            HttpDelete request = new HttpDelete(buildUrl(host, path, querys));
            for (Map.Entry<String, String> e : headers.entrySet()) {
                request.addHeader(e.getKey(), e.getValue());
            }

            return httpClient.execute(request);
        }

        private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
            StringBuilder sbUrl = new StringBuilder();
            sbUrl.append(host);
            if (!StringUtils.isBlank(path)) {
                sbUrl.append(path);
            }
            if (null != querys) {
                StringBuilder sbQuery = new StringBuilder();
                for (Map.Entry<String, String> query : querys.entrySet()) {
                    if (0 < sbQuery.length()) {
                        sbQuery.append("&");
                    }
                    if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                        sbQuery.append(query.getValue());
                    }
                    if (!StringUtils.isBlank(query.getKey())) {
                        sbQuery.append(query.getKey());
                        if (!StringUtils.isBlank(query.getValue())) {
                            sbQuery.append("=");
                            sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                        }
                    }
                }
                if (0 < sbQuery.length()) {
                    sbUrl.append("?").append(sbQuery);
                }
            }

            return sbUrl.toString();
        }

        private static HttpClient wrapClient(String host) {
            HttpClient httpClient = new DefaultHttpClient();
            if (host.startsWith("https://")) {
                sslClient(httpClient);
            }

            return httpClient;
        }

        private static void sslClient(HttpClient httpClient) {
            try {
                SSLContext ctx = SSLContext.getInstance("TLS");
                X509TrustManager tm = new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] xcs, String str) {

                    }
                    public void checkServerTrusted(X509Certificate[] xcs, String str) {

                    }
                };
                ctx.init(null, new TrustManager[] { tm }, null);
                SSLSocketFactory ssf = new SSLSocketFactory(ctx);
                ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                ClientConnectionManager ccm = httpClient.getConnectionManager();
                SchemeRegistry registry = ccm.getSchemeRegistry();
                registry.register(new Scheme("https", 443, ssf));
            } catch (KeyManagementException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
*/

/*
* 下面这一行是类，类你可以理解成一个分类吧，就像干垃圾，湿垃圾这样分类
* public: 这个代表这个类是共有的，具体啥意思，就不多解释了，只要知道单词的意思，当然这个词可以省略
* class:只要有class关键字的一定是类
*
 */
/*public */ class 干垃圾 {
   //下面这个呢，是成员变量，也叫属性，这个是这个类的属性，他可以供下面有个叫方法的共同使用
    //private 这个是代表私有的，说明只能供这个类使用，当然有私有的就有共有的:public
    private WeatherService weatherService;

    public int id;

    /**
     * 上面那个叫属性，这个呢，叫方法，方法跟类，有点傻傻分不清楚吧，哈哈，只要看没有class的，或者在class{}里面的
     * 一般都是方法，方法的作用呢，就是来实现一项简单的功能的，所以说要是试下，比较完善的功能的，需要很多方法
     * JSONObject 这个呢叫做返回值： 这个要与下面 return 要对应的，这个有啥用呢，就是刚才，跟你说的，一个完善的
     * 功能需要很多的方法，只有让下一个方法知道，我上一个方法处理的结果，才能走下去
     * 就相当于1+（?）=?,（）里面的就只相当于一个方法与返回的结果，只有知道这个结果，才能整体算出来
     * @return
     */
    public JSONObject getWeatherController() {
        //这个叫集合，跟数学的集合差不多意思
        //String是类型 query 就是对象 new对象嘛
        Map<String,String> query = new HashMap<>();
        //这个put呢就是增加的意思，因为map这个集合比较奇怪他是 key value结构的，

        query.put("area","江海区");
        query.put("city","江门");
        query.put("needday","1");
        query.put("prov","广东");
        //这个也是一个方法 JSONObject jsonObject 这个呢是一个类型，用来接收.getWeatherToJSON(query)
        //这个方法返回的结果
        JSONObject jsonObject = weatherService.getWeatherToJSON(query);
        //这个用来返回这个方法执行的结果
        return  jsonObject;
    }
}
