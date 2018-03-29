package com.jshx.telecomsz.platform.model;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/29 15:57.
 *
 * @author 王金
 * @version 1.0
 */
public class Alarm<T> {

    /**
     *
     */
    private String type;

    /**
     *
     */
    private T content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
