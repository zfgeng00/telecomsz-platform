package com.jshx.telecomsz.platform.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.io.Serializable;
import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/23 下午5:20.
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class PageData<T> implements Serializable {

    private Integer draw;

    private Integer recordsTotal;

    private Integer recordsFiltered;

    private List<T> data;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
