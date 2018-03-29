var stompClient = null;
var socket = new SockJS('/telecomsz/device-alarm');
stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) { //连接

    stompClient.subscribe('/device/test', function (greeting) { //订阅，监听收到消息

        console.log('收到消息', greeting.body);

        //桌面通知 依赖notification.js @param 标题，消息内容，点击事件的回调发法
        showNotification('苏州电信智慧物联网', greeting.body, function (notify) {
            window.focus(); //激活所在窗口
            setTimeout(function () { //延时主动关闭通知消息
                notify.close();
            }, 2000);
        });

    });
});



