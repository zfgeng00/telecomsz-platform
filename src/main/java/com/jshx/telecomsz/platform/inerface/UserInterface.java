package com.jshx.telecomsz.platform.inerface;

import com.jshx.telecomsz.platform.model.DataTableCriterias;
import com.jshx.telecomsz.platform.model.PageData;
import com.jshx.telecomsz.platform.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/22 11:01.
 *
 * @author 王金
 * @version 1.0
 */

@FeignClient(value = "TELECOMSZ-PLATFORM-INTERFACE")
public interface UserInterface {


    @RequestMapping(value = "/telecomsz/user/pagedata", method = RequestMethod.POST)
    PageData<User> pageData(@RequestBody DataTableCriterias<User> dataTableCriterias);

    @RequestMapping(value = "/telecomsz/user/add", method = RequestMethod.POST)
    User add(@RequestBody User user);
}
