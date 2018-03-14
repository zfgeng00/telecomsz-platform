package com.jshx.telecomsz.platform.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/24 上午9:10.
 */
public class DataTableCriterias {

    private int draw;
    private int start;
    private int length;

    private Map<SearchCriterias, String> search;

    // private List<HashMap<String, String>> columns;
    private List<HashMap<String, String>> order;


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


    public Map<SearchCriterias, String> getSearch() {
        return search;
    }

    public void setSearch(Map<SearchCriterias, String> search) {
        this.search = search;
    }

    public List<HashMap<String, String>> getOrder() {
        return order;
    }

    public void setOrder(List<HashMap<String, String>> order) {
        this.order = order;
    }

    public enum SearchCriterias {
        value,
        regex
    }

    public enum OrderCriterias {
        column,
        dir
    }

    public enum ColumnCriterias {
        data,
        name,
        search,
        orderable,
        searchValue,
        searchRegex
    }
}
