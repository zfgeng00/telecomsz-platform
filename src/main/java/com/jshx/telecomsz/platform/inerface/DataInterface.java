package com.jshx.telecomsz.platform.inerface;

import com.jshx.telecomsz.platform.model.Building;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/16 15:50.
 *
 * @author 王金
 * @version 1.0
 */
@FeignClient(value = "TELECOMSZ-PLATFORM-INTERFACE")
public interface DataInterface {


    @RequestMapping(value = "/telecomsz/data/getbuildingdata", method = RequestMethod.POST)
    List<Building> getBuildingData();
}
