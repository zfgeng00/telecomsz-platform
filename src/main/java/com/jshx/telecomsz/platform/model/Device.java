package com.jshx.telecomsz.platform.model;


/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 17:24.
 *
 * @author 王金
 * @version 1.0
 */
public class Device extends BaseDomain {

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备号 MAC或SIM卡号或设备esn号等
     */
    private String deviceNo;

    /**
     * 设备注册后返回IoT平台设备编号
     */
    private String deviceId;

    /**
     * 设备类型
     */
    private DeviceType deviceType;


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
