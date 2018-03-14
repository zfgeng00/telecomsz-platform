package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.model.DataTableCriterias;
import com.jshx.telecomsz.platform.model.PageData;
import com.jshx.telecomsz.platform.model.User;
import com.jshx.telecomsz.platform.inerface.LoginInterface;
import com.jshx.telecomsz.platform.inerface.PlatformInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/9 16:48.
 *
 * @author 王金
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private PlatformInterface platformInterface;


    @Autowired
    private LoginInterface loginInterface;


    @GetMapping(value = "/list")
    public String list() {

        return "user/list";
    }


    @ResponseBody
    @PostMapping(value = "/data")
    public PageData data(DataTableCriterias dataTableCriterias, String username, String msisdn, String name) {

        User login = loginInterface.login(username, msisdn);

        logger.info("username=>{}", username);
        logger.info("msisdn=>{}", msisdn);
        logger.info("name=>{}", name);
        logger.info("interface=>{}", platformInterface.test(username));
        return null;
    }

}
