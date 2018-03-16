package com.jshx.telecomsz.platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/15 15:14.
 * 设备厂商
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Manufacturer extends BaseDomain {

    /**
     * 厂商ID
     */
    private String manufacturerId;

    /**
     * 厂商名称
     */
    private String manufacturerName;

    private DeviceCategory deviceCategory;

    private List<ManufacturerDevice> manufacturerDevices;

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public DeviceCategory getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public List<ManufacturerDevice> getManufacturerDevices() {
        return manufacturerDevices;
    }

    public void setManufacturerDevices(List<ManufacturerDevice> manufacturerDevices) {
        this.manufacturerDevices = manufacturerDevices;
    }
}
