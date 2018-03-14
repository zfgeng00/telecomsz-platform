package com.jshx.telecomsz.platform.model;


import java.io.Serializable;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/23 下午5:20.
 */
public class PageData implements Serializable {

    private Integer draw;

    private Integer recordsTotal;

    private Integer recordsFiltered;

    private Object data;

    private String error;

    public PageData() {
    }

    public PageData(Integer draw) {
        this.draw = draw;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
