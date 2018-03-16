package com.jshx.telecomsz.platform.inerface;

import com.jshx.telecomsz.platform.model.Device;
import com.jshx.telecomsz.platform.model.DeviceCategory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/15 08:54.
 *
 * @author 王金
 * @version 1.0
 */
@FeignClient(value = "TELECOMSZ-PLATFORM-INTERFACE")
public interface DeviceInterface {


    /**
     * 获取设备类型列表
     *
     * @return
     */
    @RequestMapping(value = "/telecomsz/device/getdevicecategory", method = RequestMethod.POST)
    List<DeviceCategory> getDeviceCategory();


    /**
     * 设备注册
     *
     * @param deviceType 设备类型
     * @param deviceName 设备名称
     * @param deviceNo   设备号
     * @return 注册设备信息
     */
    @RequestMapping(value = "/telecomsz/device/register", method = RequestMethod.POST)
    Device register(@RequestParam(value = "manufacturerId", required = false) String manufacturerId,
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
                    @RequestParam(value = "top") Double top);

    /**
     * 操作锁
     *
     * @param operType 操作类型
     * @param deviceId 设备Id
     * @return 操作结果
     */
    @RequestMapping(value = "/telecomsz/device/lockoper", method = RequestMethod.POST)
    boolean lockOper(@RequestParam(value = "operType") String operType,
                     @RequestParam(value = "deviceId") String deviceId);

    /**
     * 获取设备详细信息
     *
     * @param deviceNo
     * @return
     */
    @RequestMapping(value = "/telecomsz/device/getdeviceinfo", method = RequestMethod.POST)
    Device getDeviceInfo(@RequestParam(value = "deviceNo") String deviceNo);
}
