var stompClient = null;
var socket = new SockJS('/telecomsz/device-alarm');
stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) { //连接

    stompClient.subscribe('/device/test', function (greeting) { //订阅，监听收到消息

        console.log('收到消息', greeting.body);
        showNotification('苏州电信智慧物联网', greeting.body); //桌面弹窗提醒 依赖notification.js

    });
});



