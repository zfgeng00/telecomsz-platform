package com.jshx.telecomsz.platform.model;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/16 18:24.
 *
 * @author 王金
 * @version 1.0
 */
public class ApiResult {

    /**
     * 状态 0：正常 1：异常
     */
    private Integer status;

    /**
     * 描述
     */
    private String desc;

    /**
     * 数据
     */
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
