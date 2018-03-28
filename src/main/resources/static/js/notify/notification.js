var a = document.scripts, b = a[a.length - 1], c = b.src;
var NotificationPath = c.substring(0, c.lastIndexOf("/") + 1);
/**
 * 桌面通知
 * @param title
 * @param msg
 */
function showNotification(title, msg) {
    var path = NotificationPath;
    try {

        //if (document.hasFocus())return;//如果页面处于活动窗口则不进行通知

        if (!document.getElementById('NotificationAudio')) {
            //写入声音
            var audioDom = document.createElement('div');
            document.body.appendChild(audioDom);
            //todo：注意文件路径修改
            audioDom.innerHTML = '<audio id="NotificationAudio"><source src="' + path + 'notify.ogg" type="audio/ogg"><source src="' + path + 'notify.mp3" type="audio/mpeg"><source src="' + path + 'notify.wav" type="audio/wav"></audio>';
        }
        ////播放声音
        document.getElementById('NotificationAudio').play();

        var Notification = window.Notification;
        if (Notification) {
            Notification.requestPermission(function (status) {
                console.log('桌面通知状态：' + status);
                //status默认值'default'等同于拒绝 'denied' 意味着用户不想要通知 'granted' 意味着用户同意启用通知
                if (status != "granted")return;

                var notify = new Notification(
                    title,
                    {
                        icon: path + 'notifyIco.ico',//通知的缩略图，支持ico、png、jpg、jpeg格式 todo：注意文件路径修改
                        body: msg //通知的具体内容
                    }
                );
                notify.onclick = function () {
                    //如果通知消息被点击,通知窗口将被激活
                    window.focus();
                    setTimeout(function () {
                        notify.close();//主动关闭
                    }, 300);
                };
                notify.onerror = function () {
                    //console.log("HTML5桌面消息出错！！！");
                };
                notify.onshow = function () {
                    //setTimeout(function () {
                    //    notify.close();//主动关闭
                    //}, 3000)
                };
                notify.onclose = function () {
                    //监听关闭事件
                    //console.log("HTML5桌面消息关闭！！！");
                };
            });
        } else {
            console.log("您的浏览器不支持或拒绝了桌面提醒");
        }
    } catch (e) {
    }
}