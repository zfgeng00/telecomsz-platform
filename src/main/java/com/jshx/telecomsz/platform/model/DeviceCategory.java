package com.jshx.telecomsz.platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 17:21.
 * 设备类型大类
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class DeviceCategory extends BaseDomain {

    /**
     * 类型名称
     */
    private String categoryName;

    /**
     * 类型值
     */
    private Integer categoryCode;

    private List<Manufacturer> manufacturers;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }
}
