package com.jshx.telecomsz.platform.model;

import java.util.List;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 17:21.
 * 设备类型大类
 *
 * @author 王金
 * @version 1.0
 */
public class DeviceType extends BaseDomain {

    /**
     * 类型名称
     */
    private String typeName;

    private List<Manufacturer> manufacturers;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }
}
