package com.jshx.telecomsz.platform.model;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/15 19:25.
 *
 * @author 王金
 * @version 1.0
 */
public class Floor {

    /**
     *
     */
    private String name;

    private List<Point> points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
