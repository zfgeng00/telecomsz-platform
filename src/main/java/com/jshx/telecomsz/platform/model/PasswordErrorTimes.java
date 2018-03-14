package com.jshx.telecomsz.platform.model;

import java.util.Date;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 14:51.
 *
 * @author 王金
 * @version 1.0
 */
public class PasswordErrorTimes {

    private Integer count;

    private Date lastErrorTime;

    public PasswordErrorTimes() {
    }

    public PasswordErrorTimes(Integer count, Date lastErrorTime) {
        this.count = count;
        this.lastErrorTime = lastErrorTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLastErrorTime() {
        return lastErrorTime;
    }

    public void setLastErrorTime(Date lastErrorTime) {
        this.lastErrorTime = lastErrorTime;
    }
}
