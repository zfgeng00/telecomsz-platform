package com.jshx.telecomsz.platform.model;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 17:21.
 *
 * @author 王金
 * @version 1.0
 */
public class DeviceType extends BaseDomain {

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型值
     */
    private String typeValue;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
}
