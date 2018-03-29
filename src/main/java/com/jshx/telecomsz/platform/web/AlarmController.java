package com.jshx.telecomsz.platform.web;

import com.jshx.telecomsz.platform.model.Alarm;
import com.jshx.telecomsz.platform.model.DoorAlarmRecord;
import com.jshx.telecomsz.platform.model.DoorOperRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/29 15:44.
 *
 * @author 王金
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/alarm")
public class AlarmController extends BaseController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping(value = "/dooralarm", method = RequestMethod.POST)
    public String doorAlarm(@RequestBody DoorAlarmRecord doorAlarmRecord) {
        Alarm<DoorAlarmRecord> alarm = new Alarm<>();
        alarm.setType("doorAlarm");
        alarm.setContent(doorAlarmRecord);
        simpMessagingTemplate.convertAndSendToUser("", "", "");
        return "SUCCESS";
    }


    @RequestMapping(value = "/dooroper", method = RequestMethod.POST)
    public String doorOper(@RequestBody DoorOperRecord doorOperRecord) {
        Alarm<DoorOperRecord> alarm = new Alarm<>();
        alarm.setType("doorOper");
        alarm.setContent(doorOperRecord);
        return "SUCCESS";
    }
}
