package com.jshx.telecomsz.platform.inerface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 10:21.
 *
 * @author 王金
 * @version 1.0
 */

@FeignClient(value = "TELECOMSZ-PLATFORM-INTERFACE")
public interface PlatformInterface {


    @RequestMapping(value = "/telecomsz/interface/test")
    String test(@RequestParam(value = "params") String params);
}
