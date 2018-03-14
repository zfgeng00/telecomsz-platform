package com.jshx.telecomsz.platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 15:03.
 *
 * @author 王金
 * @version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
