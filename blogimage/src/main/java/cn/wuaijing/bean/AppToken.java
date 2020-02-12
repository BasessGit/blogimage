package cn.wuaijing.bean;

import java.io.Serializable;

public class AppToken implements Serializable {


    private static final long serialVersionUID = 674367897330837585L;

    private String value;

    public AppToken () {
    }

    public AppToken(String v43alue) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AppToken{" +
                "value='" + value + '\'' +
                '}';
    }
}
