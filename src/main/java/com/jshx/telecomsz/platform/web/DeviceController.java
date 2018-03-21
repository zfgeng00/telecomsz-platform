package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.inerface.DeviceInterface;
import com.jshx.telecomsz.platform.model.DataTableCriterias;
import com.jshx.telecomsz.platform.model.Device;
import com.jshx.telecomsz.platform.model.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/20 10:56.
 *
 * @author 王金
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private DeviceInterface deviceInterface;

    @GetMapping(value = "/list")
    public String list() {
        return "device/list";
    }

    @ResponseBody
    @PostMapping(value = "/data")
    public PageData<Device> data(DataTableCriterias dataTableCriterias) {
        return deviceInterface.pageData(dataTableCriterias);
    }
}
