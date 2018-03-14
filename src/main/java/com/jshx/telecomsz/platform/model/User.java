package com.jshx.telecomsz.platform.model;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 10:56.
 *
 * @author 王金
 * @version 1.0
 */
public class User extends BaseDomain {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String msisdn;

    /**
     * 登录名
     */
    private String loginAccount;


    private List<UserRole> userRoles;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
