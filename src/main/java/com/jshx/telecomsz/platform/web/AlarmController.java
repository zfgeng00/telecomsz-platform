package com.jshx.telecomsz.platform.web;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/dooralarm", method = RequestMethod.POST)
    public boolean doorAlarm(@RequestBody DoorAlarmRecord doorAlarmRecord) throws Exception {
        Alarm<DoorAlarmRecord> alarm = new Alarm<>();
        alarm.setType("doorAlarm");
        alarm.setContent(doorAlarmRecord);
        String message = objectMapper.writeValueAsString(alarm);
        logger.info("发送websocket消息{}", message);
        simpMessagingTemplate.convertAndSend("/device/alarm", message);
        return true;
    }


    @RequestMapping(value = "/dooroper", method = RequestMethod.POST)
    public boolean doorOper(@RequestBody DoorOperRecord doorOperRecord) throws Exception {
        Alarm<DoorOperRecord> alarm = new Alarm<>();
        alarm.setType("doorOper");
        alarm.setContent(doorOperRecord);
        String message = objectMapper.writeValueAsString(alarm);
        logger.info("发送websocket消息{}", message);
        simpMessagingTemplate.convertAndSend("/device/alarm", message);
        return true;
    }
}
