package cn.wuaijing.bean;

import java.io.Serializable;

public class AccessToken implements Serializable {
    private static final long serialVersionUID = 2173677851669201509L;
    private String host;
        private String path;
        private String grant_type;
        private  String secret;
        private  String appId;

        public AccessToken() {
        }

        public AccessToken(String host, String path, String grant_type, String secret, String appId) {
            this.host = host;
            this.path = path;
            this.grant_type = grant_type;
            this.secret = secret;
            this.appId = appId;
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

        public String getGrant_type() {
            return grant_type;
        }

        public void setGrant_type(String grant_type) {
            this.grant_type = grant_type;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

    }

