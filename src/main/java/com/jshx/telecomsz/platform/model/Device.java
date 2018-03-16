package com.jshx.telecomsz.platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.Date;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 17:24.
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
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

    private ManufacturerDevice manufacturerDevice;

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

    private Floor floor;

    /**
     * 左
     */
    private Double leftPoint;

    /**
     * 上
     */
    private Double topPoint;

    /**
     * 设备描述
     */
    private String deviceDesc;


    public Device() {
    }

    public Device(Date createTime, Integer delFlag) {
        this.createTime = createTime;
        this.delFlag = delFlag;
    }


    public ManufacturerDevice getManufacturerDevice() {
        return manufacturerDevice;
    }

    public void setManufacturerDevice(ManufacturerDevice manufacturerDevice) {
        this.manufacturerDevice = manufacturerDevice;
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

    public Double getLeftPoint() {
        return leftPoint;
    }

    public void setLeftPoint(Double leftPoint) {
        this.leftPoint = leftPoint;
    }

    public Double getTopPoint() {
        return topPoint;
    }

    public void setTopPoint(Double topPoint) {
        this.topPoint = topPoint;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
