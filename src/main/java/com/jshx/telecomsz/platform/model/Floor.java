package com.jshx.telecomsz.platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/16 15:04.
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Floor extends BaseDomain {

    /**
     * 楼层名称
     */
    private String floorName;

    /**
     * 楼层编号
     */
    private Integer floorCode;

    /**
     * 所属楼宇
     */
    private Building building;

    private List<Device> devices;


    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Integer getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(Integer floorCode) {
        this.floorCode = floorCode;
    }
}
