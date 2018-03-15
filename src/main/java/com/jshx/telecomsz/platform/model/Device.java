package com.jshx.telecomsz.platform.model;

import java.util.Date;

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

    private Manufacturer manufacturer;

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * 终端用户
     */
    private String endUserId;

    /**
     * psk码，用于生成设备鉴权参数
     */
    private String psk;

    /**
     * 验证码有效时间，单位秒，设备需要在有效时间内接入平台
     */
    private String timeout;

    /**
     * 设备位置
     */
    private String location;

    /**
     * 临时验证码
     */
    private String verifyCode;

    public Device() {
    }

    public Device(Date createTime, Integer delFlag) {
        this.createTime = createTime;
        this.delFlag = delFlag;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(String endUserId) {
        this.endUserId = endUserId;
    }

    public String getPsk() {
        return psk;
    }

    public void setPsk(String psk) {
        this.psk = psk;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

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


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
