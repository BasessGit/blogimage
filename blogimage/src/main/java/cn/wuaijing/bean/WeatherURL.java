package cn.wuaijing.bean;

import java.util.Map;

public class WeatherURL {
    private String host;
    private String path;
    private String method;
    private String appCode;
    Map<String, String> header;
    Map<String, String> query;

    public WeatherURL() {
    }

    public WeatherURL(String host, String path, String method, String appCode, Map<String, String> header, Map<String, String> query) {
        this.host = host;
        this.path = path;
        this.method = method;
        this.appCode = appCode;
        this.header = header;
        this.query = query;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "WeatherURL{" +
                "host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", appCode='" + appCode + '\'' +
                ", header=" + header +
                ", query=" + query +
                '}';
    }
}
