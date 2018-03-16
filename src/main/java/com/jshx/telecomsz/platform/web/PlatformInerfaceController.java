package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.inerface.DeviceInterface;
import com.jshx.telecomsz.platform.model.ApiResult;
import com.jshx.telecomsz.platform.model.Device;
import com.jshx.telecomsz.platform.model.DeviceCategory;
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
    @RequestMapping(value = "/device/getdevicecategory", method = RequestMethod.POST)
    public List<DeviceCategory> getDeviceCategory() {
        return deviceInterface.getDeviceCategory();
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
    public ApiResult register(@RequestParam(value = "manufacturerId", required = false) String manufacturerId,
                              @RequestParam(value = "manufacturerName", required = false) String manufacturerName,
                              @RequestParam(value = "deviceModel") String deviceModel,
                              @RequestParam(value = "endUserId", required = false) String endUserId,
                              @RequestParam(value = "psk", required = false) String psk,
                              @RequestParam(value = "timeout", required = false) String timeout,
                              @RequestParam(value = "location", required = false) String location,
                              @RequestParam(value = "deviceType") String deviceType,
                              @RequestParam(value = "deviceName", required = false) String deviceName,
                              @RequestParam(value = "deviceNo") String deviceNo,
                              @RequestParam(value = "buildingCode") String buildingCode,
                              @RequestParam(value = "floorCode") String floorCode,
                              @RequestParam(value = "left") Double left,
                              @RequestParam(value = "deviceDesc") String deviceDesc,
                              @RequestParam(value = "top") Double top) {
        return deviceInterface.register(manufacturerId, manufacturerName, deviceModel, endUserId, psk, timeout, location, deviceType, deviceName, deviceNo, buildingCode, floorCode, left, deviceDesc, top);
    }

    /**
     * 操作锁
     *
     * @param operType 操作类型
     * @param deviceId 设备ID
     * @return 操作结果
     */
    @RequestMapping(value = "/device/lockoper", method = RequestMethod.POST)
    public ApiResult lockOper(@RequestParam(value = "operType") String operType,
                              @RequestParam(value = "deviceId") String deviceId) {
        return deviceInterface.lockOper(operType, deviceId);
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
