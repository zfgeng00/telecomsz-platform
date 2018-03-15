package com.jshx.telecomsz.platform.model;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/15 19:12.
 *
 * @author 王金
 * @version 1.0
 */
public class Point {


    /**
     *
     */
    private String desc;

    /**
     *
     */
    private String category;

    /**
     *
     */
    private String left;

    /**
     *
     */
    private String top;

    /**
     *
     */
    private String name;



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
