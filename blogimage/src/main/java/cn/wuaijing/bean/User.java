package cn.wuaijing.bean;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Date date;
    private Boolean  isTrue;

    public User() {
    }

    public User(Integer id, String name, Date date, Boolean isTrue) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.isTrue = isTrue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTrue(Boolean aTrue) {
        isTrue = aTrue;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", isTrue=" + isTrue +
                '}';
    }
}
