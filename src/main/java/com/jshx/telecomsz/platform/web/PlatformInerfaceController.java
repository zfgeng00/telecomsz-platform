package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.inerface.DeviceInterface;
import com.jshx.telecomsz.platform.model.Device;
import com.jshx.telecomsz.platform.model.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/15 08:59.
 *
 * @author 王金
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/interface")
public class PlatformInerfaceController {

    @Autowired
    private DeviceInterface deviceInterface;


    /**
     * 获取设备类型列表
     *
     * @return
     */
    @RequestMapping(value = "/device/getdevicetype", method = RequestMethod.POST)
    public List<DeviceType> getDeviceType() {
        return deviceInterface.getDeviceType();
    }

    /**
     * 设备注册
     *
     * @param deviceType 设备类型
     * @param deviceName 设备名称
     * @param deviceNo   设备号
     * @return 注册设备信息
     */
    @RequestMapping(value = "/device/register", method = RequestMethod.POST)
    public Device register(@RequestParam(value = "deviceType") String deviceType,
                           @RequestParam(value = "deviceName") String deviceName,
                           @RequestParam(value = "deviceNo") String deviceNo) {
        return deviceInterface.register(deviceType, deviceName, deviceNo);
    }

    /**
     * 操作锁
     *
     * @param operType 操作类型
     * @param deviceNo 设备号
     * @return 操作结果
     */
    @RequestMapping(value = "/device/lockoper", method = RequestMethod.POST)
    public boolean lockOper(@RequestParam(value = "operType") String operType,
                            @RequestParam(value = "deviceNo") String deviceNo) {
        return deviceInterface.lockOper(operType, deviceNo);
    }

    /**
     * 获取设备详细信息
     *
     * @param deviceNo
     * @return
     */
    @RequestMapping(value = "/device/getdeviceinfo", method = RequestMethod.POST)
    public Device getDeviceInfo(@RequestParam(value = "deviceNo") String deviceNo) {
        return deviceInterface.getDeviceInfo(deviceNo);
    }
}
