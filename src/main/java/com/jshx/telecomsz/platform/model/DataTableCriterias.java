package com.jshx.telecomsz.platform.model;


/**
 * Created with Intellij IDEA by 王金 on 2017/2/24 上午9:10.
 */
public class DataTableCriterias<T> {

    private T searchEntity;
    private int draw;
    private int start;
    private int length;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public T getSearchEntity() {
        return searchEntity;
    }

    public void setSearchEntity(T searchEntity) {
        this.searchEntity = searchEntity;
    }
}
