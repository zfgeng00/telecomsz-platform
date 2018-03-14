package com.jshx.telecomsz.platform.model;

import java.util.Date;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 14:33.
 *
 * @author 王金
 * @version 1.0
 */
public class BaseDomain {

    protected Long id;

    protected Date createTime;

    protected Date updateTime;

    protected Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
