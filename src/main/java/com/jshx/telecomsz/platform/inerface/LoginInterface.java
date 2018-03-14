package com.jshx.telecomsz.platform.inerface;

import com.jshx.telecomsz.platform.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 11:00.
 *
 * @author 王金
 * @version 1.0
 */
@FeignClient(value = "TELECOMSZ-PLATFORM-INTERFACE")
public interface LoginInterface {


    @RequestMapping(value = "/telecomsz/login", method = RequestMethod.POST)
    User login(@RequestParam(value = "username") String username,
               @RequestParam(value = "password") String password);
}
