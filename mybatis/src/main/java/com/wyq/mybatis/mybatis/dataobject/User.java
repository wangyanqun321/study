package com.wyq.mybatis.mybatis.dataobject;

import java.util.Date;

/**
 * @author 王艳群
 * @description User
 * @date 2020/7/11
 */
public class User {

    private Integer id;

    private String username;

    private String password;

    private Date dt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
}
