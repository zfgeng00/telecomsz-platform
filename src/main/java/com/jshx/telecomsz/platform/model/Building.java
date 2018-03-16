package com.jshx.telecomsz.platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/16 15:03.
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Building extends BaseDomain {

    /**
     * 楼宇名称
     */
    private String buildingName;

    /**
     * 楼宇编号
     */
    private Integer buildingCode;

    private List<Floor> floors;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(Integer buildingCode) {
        this.buildingCode = buildingCode;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
