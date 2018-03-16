package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.inerface.DataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/9 10:51.
 *
 * @author 王金
 * @version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private DataInterface dataInterface;


    @GetMapping(value = "/")
    public ModelAndView index() {


        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("data", dataInterface.getBuildingData());
        return modelAndView;
    }


    @GetMapping(value = "/admin")
    public String admin() {
        return "admin-index";
    }
}
