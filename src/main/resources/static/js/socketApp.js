/**
 * 日期格式转换
 * @param fmt
 * @returns {*}
 */
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}


var stompClient = null;
var socket = new SockJS('/telecomsz/device-alarm');
stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) { //连接

    stompClient.subscribe('/device/alarm', function (data) { //订阅，监听收到消息

        // console.log('收到消息', data.body);
        var notifyMsg = '设备通知';

        var dataObj = JSOG.parse(data.body);

        var type = dataObj.type;

        switch (type) {
            case 'doorOper': //门锁操作
                var name = dataObj.content.device.deviceName;
                var time = new Date(dataObj.content.createTime * 1).format("yyyy-MM-dd hh:mm:ss");
                var status = dataObj.content.status;
                var openMode = dataObj.content.openMode,
                    openModeStr;
                switch (openMode) {
                    case "Fingerprint Open":
                        openModeStr = "指纹开锁";
                        break;
                    case "Password Open":
                        openModeStr = "密码开锁";
                        break;
                    case "APP Open":
                        openModeStr = "远程开锁";
                        break;
                    default:
                        openModeStr = "刷卡开锁";
                        break;
                }
                notifyMsg = status == 'OPEN' ? '设备【' + name + '】被打开；' + '操作时间：[' + time + ']；开锁方式：[' + openModeStr + ']。' : '设备【' + name + '】被关闭；' + '操作时间：[' + time + ']。';
                break;
            case 'doorAlarm': //门锁告警

                break;
        }


        layer.alert(notifyMsg, {title: '设备通知', icon: 1, closeBtn: 0, btnAlign: 'c'}, function (index) {
            layer.close(index);
        });

        //桌面通知 依赖notification.js @param 标题，消息内容，点击事件的回调发法
        showNotification('苏州电信智慧物联网', notifyMsg, function (notify) {
            window.focus(); //激活所在窗口
            setTimeout(function () { //延时主动关闭通知消息
                notify.close();
            }, 2000);
        });

    });

});



