package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.model.Floor;
import com.jshx.telecomsz.platform.model.Point;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/9 10:51.
 *
 * @author 王金
 * @version 1.0
 */
@Controller
public class IndexController {


    @GetMapping(value = "/")
    public ModelAndView index() {


        List<Floor> floors = new ArrayList<>();
        Floor floor = new Floor();
        floors.add(floor);

        List<Point> points = new ArrayList<>();
        floor.setPoints(points);
        floor.setName("L1");

        Point point = new Point();
        point.setName("名称1");
        point.setCategory("1");
        point.setLeft("43.18744113029827");
        point.setTop("24.68241758241758");
        point.setDesc("描述1");
        points.add(point);

        point = new Point();
        point.setName("名称2");
        point.setCategory("2");
        point.setLeft("43.18744113029827");
        point.setTop("24.68241758241758");
        point.setDesc("描述2");
        points.add(point);


        floor = new Floor();
        floors.add(floor);

        points = new ArrayList<>();
        floor.setPoints(points);
        floor.setName("L2");

        point = new Point();
        point.setName("名称21");
        point.setCategory("1");
        point.setLeft("43.18744113029827");
        point.setTop("24.68241758241758");
        point.setDesc("描述21");
        points.add(point);

        point = new Point();
        point.setName("名称222");
        point.setCategory("1");
        point.setLeft("43.18744113029827");
        point.setTop("24.68241758241758");
        point.setDesc("描述222");
        points.add(point);

        point = new Point();
        point.setName("名称22");
        point.setCategory("3");
        point.setLeft("43.18744113029827");
        point.setTop("24.68241758241758");
        point.setDesc("描述22");
        points.add(point);



        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("floors", floors);

        return modelAndView;
    }


    @GetMapping(value = "/admin")
    public String admin() {
        return "admin-index";
    }
}
