package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.inerface.UserInterface;
import com.jshx.telecomsz.platform.model.DataTableCriterias;
import com.jshx.telecomsz.platform.model.PageData;
import com.jshx.telecomsz.platform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    private UserInterface userInterface;


    @GetMapping(value = "/list")
    public String list() {

        return "user/list";
    }


    @ResponseBody
    @PostMapping(value = "/data")
    public PageData<User> data(@ModelAttribute DataTableCriterias<User> dataTableCriterias, @ModelAttribute User user) {
        dataTableCriterias.setSearchEntity(user);
        return userInterface.pageData(dataTableCriterias);
    }

    @ResponseBody
    @PostMapping(value = "/add")
    public User add(@RequestBody User user) {

        user.setPassword(new BCryptPasswordEncoder().encode("TelecomSZ@123"));
        user.setDelFlag(0);
        user.setCreateTime(new Date());

        return userInterface.add(user);
    }

    @ResponseBody
    @GetMapping(value = "/get/{id}")
    public User get(@PathVariable(value = "id") long id) {
        return userInterface.get(id);
    }

    @ResponseBody
    @DeleteMapping(value = "/delete/{id}")
    public User delete(@PathVariable(value = "id") long id) {
        return userInterface.delete(id);
    }

    @ResponseBody
    @PutMapping(value = "/modify")
    public User modify(@RequestBody User user) {
        return userInterface.modify(user);
    }

}
