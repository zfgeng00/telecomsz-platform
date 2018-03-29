package com.jshx.telecomsz.platform.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/29 15:20.
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class DoorAlarmRecord extends BaseDomain {


    /**
     * 告警类型 lowBatteryAlarm trialErrorAlarm tamperAlarm lockOpenerAlarm hijackedAlarm
     */
    private String alarmType;

    private Device device;

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
