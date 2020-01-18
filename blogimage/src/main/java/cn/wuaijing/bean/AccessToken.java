package cn.wuaijing.bean;

    public class AccessToken {
        private String host;
        private String path;
        private String grant_type;
        private  String secret;
        private  String appid;

        public AccessToken() {
        }

        public AccessToken(String host, String path, String grant_type, String secret, String appid) {
            this.host = host;
            this.path = path;
            this.grant_type = grant_type;
            this.secret = secret;
            this.appid = appid;
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

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }
    }

