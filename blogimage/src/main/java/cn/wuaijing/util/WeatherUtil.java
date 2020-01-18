package cn.wuaijing.util;



import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class WeatherUtil {

    public static String sendGet(String utl, Map<String, String> paramMap) {
        HttpURLConnection connection;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
       StringBuilder param = new StringBuilder();
       param.append("?");
        String result = "";
        Iterator<String> iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
           String  key = iterator.next();
            param.append(key)
                    .append("=")
                    .append(paramMap.get(key))
                    .append("&");
        }
        result = param.delete(param.length()-1,param.length()).toString();
        return result;
    }

    /*
    Post请求Url响应
     */
    public static String sendPost(String postUrl, Map<String, String> paramMap) {
        HttpURLConnection connection;
        PrintWriter printWriter = null;
        BufferedReader reader = null;
        String param = "";
        String result = "";
        //获取Map的迭代器
        Iterator<String> iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
            //获取key
            String key = iterator.next();
            param += key + "=" + paramMap.get(key) + "&";
        }
        try {
            URL url = new URL(postUrl);
            //通过url获取一个连接对象
            connection = (HttpURLConnection) url.openConnection();
            if (paramMap != null) {
                //设置连接请求类型“POST”or“GET”
                connection.setRequestMethod("POST");
                connection.setReadTimeout(5000);
                //设置连接超时时间
                connection.setConnectTimeout(10000);
                //允许写入
                connection.setDoInput(true);
                //允许读出
                connection.setDoOutput(true);
                //设置请求编码为utf-8
                connection.setRequestProperty("Accept-Charset", "utf-8");
                //获得输出流
                printWriter = new PrintWriter(connection.getOutputStream());
                //发送请求参数
                printWriter.print(param);
                //刷新缓冲区
                printWriter.flush();
                //使用BufferedReader读取Url的响应
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                while (reader.readLine() != null) {
                    result += reader.readLine();
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

}
