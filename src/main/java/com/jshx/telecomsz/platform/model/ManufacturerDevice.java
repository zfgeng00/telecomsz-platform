package com.jshx.telecomsz.platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/15 15:17.
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class ManufacturerDevice extends BaseDomain {

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * 设备类型
     */
    private String deviceType;

    private Manufacturer manufacturer;

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
