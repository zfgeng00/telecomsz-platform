package com.jshx.telecomsz.platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/9 10:51.
 *
 * @author 王金
 * @version 1.0
 */
@Controller
public class IndexController {


    @GetMapping(value = "/")
    public String index() {
        return "index";
    }


    @GetMapping(value = "/admin")
    public String admin() {
        return "admin-index";
    }
}
