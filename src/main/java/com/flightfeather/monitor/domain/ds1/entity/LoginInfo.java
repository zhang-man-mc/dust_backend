package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "du_js_t_login_info")
public class LoginInfo {
    @Id
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String cookie;

    @Column(name = "cookie_timestamp")
    private Date cookieTimestamp;

    private String region;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return cookie
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * @param cookie
     */
    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    /**
     * @return cookie_timestamp
     */
    public Date getCookieTimestamp() {
        return cookieTimestamp;
    }

    /**
     * @param cookieTimestamp
     */
    public void setCookieTimestamp(Date cookieTimestamp) {
        this.cookieTimestamp = cookieTimestamp;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }
}