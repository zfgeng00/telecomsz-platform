package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.inerface.DataInterface;
import com.jshx.telecomsz.platform.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

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
    public ModelAndView index(@RequestParam(value = "buildingCode",required = false) Integer buildingCode) {

        if (buildingCode == null || buildingCode == 0 || buildingCode.equals(0)) {
            buildingCode = 1;
        }

        ModelAndView modelAndView = new ModelAndView("index");
        List<Building> buildingData = dataInterface.getBuildingData();
        for (Building building : buildingData) {
            if (building.getBuildingCode().equals(buildingCode)) {
                modelAndView.addObject("building", building);
            }
        }

        return modelAndView;
    }


    @GetMapping(value = "/admin")
    public String admin() {
        return "admin-index";
    }
}
