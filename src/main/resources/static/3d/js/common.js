var bIndex; //建筑code
$(function () {

    mainInit(window); //初始化main

    bIndex = $("body").data("building");
    var trans = '';
    switch (bIndex) {
        case 1:
            trans = 'translateZ(15vmin) rotateX(-69.75deg) rotateY(-45deg) rotateZ(14deg)';
            break;
        case 2:
            trans = 'translateZ(38vmin) rotateX(-69.75deg) rotateY(-32deg) rotateZ(9deg)';
            break;
        case 3:
            trans = 'translateZ(16vmin) rotateX(-69.75deg) rotateY(-32deg) rotateZ(9deg)';
            break;
    }

    // 编辑
    $(document).on('click', '.desc_edit', function (e) {
        var $this = $(e.target), $desc_item = $this.parents(".content__item"),
            $desc_title = $desc_item.find(".content__item-title"),
            $desc_con = $desc_item.find(".content__desc");
        var $obj = $(".pin.pin--active"), oParent = $obj.parent();
        var deviceId = $desc_item.data("deviceid");
        var thisTitle = $desc_title.html(),
            thisDesc = $desc_con.val();
        var vw = $(window).width() / 100
            , vh = $(window).height() / 100
            , vm = vw < vh ? vw : vh;
        var thisX = parseFloat($obj.css("left")) / vm;
        var thisY = parseFloat($obj.css("top")) / vm;
        var $li = $(".list__item.list__item--active[data-space='" + $desc_item.data('space') + "']")
        switch ($this.html()) {
            case "编辑":
                sessionStorage.setItem("editor.thisTitle", thisTitle);
                sessionStorage.setItem("editor.thisDesc", thisDesc);
                sessionStorage.setItem("editor.thisX", thisX);
                sessionStorage.setItem("editor.thisY", thisY);
                $this.html("完成");
                $desc_title.removeAttr("readonly");
                $desc_title.attr("contenteditable", 'true');
                $desc_con.removeAttr("readonly");
                drag($obj, true, oParent);
                break;
            case "完成":
                if (!thisTitle) {
                    layer.msg('未填写名称', {icon: 0});
                    break;
                }
                if (!thisDesc) {
                    layer.msg('未填写详细信息', {icon: 0});
                    break;
                }
                //询问框
                layer.open({
                    title: '编辑',
                    content: '是否保存编辑结果？',
                    btn: ['保存', '不保存'],
                    shadeClose: true,
                    yes: function (index, layero) {
                        //按钮【按钮一】的回调
                        iAjax({
                            url: 'interface/device/modify',
                            type: 'put',
                            data: JSON.stringify({
                                "deviceId": deviceId,
                                "deviceName": thisTitle,
                                "deviceDesc": thisDesc,
                                "leftPoint": thisX,
                                "topPoint": thisY
                            }),
                            contentType: 'application/json',
                            success: function (ret) {
                                if (ret.status == 0) { //成功
                                    layer.msg(ret.desc, {icon: 1});
                                    $this.html("编辑");
                                    $desc_title.attr("readonly", '');
                                    $desc_title.attr("contenteditable", 'false');
                                    $desc_con.attr("readonly", '');
                                    drag($obj, false);
                                    $obj.attr("title", thisTitle);
                                    $li.find("a").text(thisTitle);
                                } else { //失败
                                    layer.alert(ret.desc, {icon: 5, closeBtn: 0, btnAlign: 'c'}, function (index) {
                                        layer.close(index);
                                    });
                                }
                            }
                        });
                    },
                    btn2: function (index, layero) {
                        //按钮【按钮二】的回调
                        $this.html("编辑");
                        $desc_title.attr("readonly", '');
                        $desc_title.attr("contenteditable", 'false');
                        $desc_con.attr("readonly", '');
                        $desc_title.html(sessionStorage.getItem("editor.thisTitle"));
                        $desc_con.val(sessionStorage.getItem("editor.thisDesc"));
                        $obj.css({
                            'left': sessionStorage.getItem("editor.thisX") + 'vmin',
                            'top': sessionStorage.getItem("editor.thisY") + 'vmin'
                        });
                        drag($obj, false);
                        //return false 开启该代码可禁止点击该按钮关闭
                    }
                });
                break;
        }
    });
    //删除
    $(document).on('click', '.desc_delete', function (e) {
        //询问框
        layer.confirm('确认删除吗？', {title: '删除', shadeClose: true}, function (index, layero) {
            //按钮【按钮一】的回调
            var $this = $(e.target),
                $desc_item = $this.parents(".content__item");
            var deviceId = $desc_item.data("deviceid");
            iAjax({
                url: 'interface/device/delete/' + deviceId,
                type: 'delete',
                success: function (ret) {
                    if (ret.status == 0) { //成功
                        layer.alert(ret.desc, {btn: '点击刷新', icon: 1, closeBtn: 0, btnAlign: 'c'}, function (index) {
                            layer.close(index);
                            location.reload();
                        });
                    } else { //失败
                        layer.alert(ret.desc, {icon: 5, closeBtn: 0, btnAlign: 'c'}, function (index) {
                            layer.close(index);
                        });
                    }
                }
            });
        });
    });

    //放大缩小
    var scaleRatio = 1; //系数
    $(document).click(function (e) {
        var $t = $(e.target);
        if ($t.hasClass('switch')) {
            var s = $t.html();
            switch (s) {
                case "+":
                    scaleRatio = scaleRatio + 0.1;
                    break;
                case "o":
                    scaleRatio = 1;
                    break;
                case "-":
                    scaleRatio = scaleRatio - 0.1;
                    break;
            }
            $(".level--current").css({'transform': trans + ' scale(' + scaleRatio + ')'});
        } else {
            $(".level").attr('style', '');
            scaleRatio = 1;
        }
    });
    //鼠标滚轮事件
    $(document).mousewheel(function (event, delta, deltaX, deltaY) {
        var $oc = $(".level--current");
        if (!($oc && $oc.length)) return;
        if (delta > 0) {
            scaleRatio = scaleRatio + 0.1;
        } else {
            scaleRatio = scaleRatio - 0.1;
        }
        $oc.css({'transform': trans + ' scale(' + scaleRatio + ')'});
    });

//保持右边侧边栏收/展一致
    if (localStorage.getItem("asideDown")) {
        $(".asideCtrl").click();
    }
    $(window).bind('beforeunload', function () {
        if ($("body").hasClass("asideDown")) {
            localStorage.setItem("asideDown", true);
        } else {
            localStorage.removeItem("asideDown");
        }
    });

});

//添加新的传感器节点
function addNew(ele, ev) {
    var $e = $(ele);
    if ($e.hasClass('disable')) return;
    $e.addClass('disable');
    $(".mallnav").addClass("mallnav--hidden");
    var x = 106;
    var y = 60;
    var ht = '<a class="pin byAddNew" data-x="' + x + '" data-y="' + y + '" style="left:' + x + 'vmin;top:' + y + 'vmin;" data-category="0" href="javascript:void(0)">' +
        '<div class="pinBts">' +
        '<div class="pinBtn" onclick="open_addForm(this);">编辑</div>' +
        '<div class="pinBtn" onclick="addCancel();">取消</div>' +
        '</div>' +
        '</a>';
    $('.level__pins--active').append(ht);
    var $obj = $(".level__pins.level__pins--active .pin.byAddNew:last-child"), oParent = $obj.parent();
    drag($obj, true, oParent, function (x, y) {
        var $x = $(".infoX"), $y = $(".infoY");
        $obj.attr("data-x", x);
        $obj.attr("data-y", y);
        $obj.data("x", x);
        $obj.data("y", y);
        if ($x && $x.length && $y && $y.length) {
            $x.val(x);
            $y.val(y);
        }
    });
}

var layerByAddNew;

function open_addForm(e) {
    var $e = $(e), $p = $e.parents(".pin.byAddNew");
    var newPointX = $p.data("x"), newPointY = $p.data("y");
    if ($(".inputGroup") && $(".inputGroup").length) {
        layer.msg("您已经打开了编辑窗口");
        return;
    }
    var html = '<div class="inputGroup">' +
        '<div class="uf"><div class="inputName">名称：</div><input class="uf-f" name="deviceName" type="text" placeholder="设备名称"></div>' +
        '<div class="uf"><div class="inputName">标识码：</div><input class="uf-f" name="deviceNo" type="text" placeholder="MAC或SIM卡号或设备esn号等"></div>' +
        '<div class="uf"><div class="inputName">类型：</div><input class="uf-f" name="deviceType" type="text" placeholder="设备类型"></div>' +
        '<div class="uf"><div class="inputName">型号：</div><input class="uf-f" name="deviceModel" type="text" placeholder="设备型号"></div>' +
        '<div class="uf"><div class="inputName">描述：</div><textarea class="uf-f" rows="5" name="deviceDesc" type="text" placeholder="设备描述"></textarea></div>' +
        '<div class="uf"><div class="inputName">x：</div><input class="uf-f infoX" name="left" onchange="changeByInput(this)" type="number" value="' + newPointX + '"></div>' +
        '<div class="uf"><div class="inputName">y：</div><input class="uf-f infoY" name="top" onchange="changeByInput(this)" type="number" value="' + newPointY + '"></div>' +
        '<div class="uf"><div class="submitBtn" onclick="addSubmit();">提交</div></div>' +
        '</div>';
    layerByAddNew = layer.open({
        type: 1, //层的类型。0：信息框（默认），1：页面层，2：iframe层，3：加载层，4：tips层。
        title: '编辑新设备信息', //控制默认标题栏。title:'标题'，自定义标题样式，可以title: ['标题', 'background:#c00;'] 第二个参数可书写任意css
        // offset: ['', ''], //[纵坐标, 横坐标]，默认为垂直水平居中
        // area: ['50%', '66%'], //[宽度, 高度] 默认自适应
        maxmin: true, //是否输出窗口最小化/全屏/还原按钮,默认false
        shade: false, //控制遮罩[0.5, '#000']（[透明度0~1, '色值']）,设置为false则不显示
        // shadeClose: true, //遮罩显示情况下，控制点击遮罩区域是否关闭层
        // scrollbar: false, //屏蔽浏览器滚动条
        anim: 0, //动画类型0~6 默认0 设置false为不使用动画
        content: html //页面地址
    });
}

//确定添加
function addSubmit() {
    var $obj = $(".level__pins.level__pins--active .pin.byAddNew:last-child");
    var buildingCode = $("body").data('building');
    var floorCode = $(".level.level--current").data('floorcode');
    var deviceName = $(".inputGroup input[name='deviceName']").val();
    var deviceType = $(".inputGroup input[name='deviceType']").val();
    var deviceNo = $(".inputGroup input[name='deviceNo']").val();
    var deviceModel = $(".inputGroup input[name='deviceModel']").val();
    var deviceDesc = $(".inputGroup textarea[name='deviceDesc']").val();
    var left = $(".inputGroup input[name='left']").val();
    var top = $(".inputGroup input[name='top']").val();
    if (!deviceName) {
        layer.msg('未填写名称', {icon: 0});
        return;
    }
    if (!deviceNo) {
        layer.msg('未填写编号', {icon: 0});
        return;
    }
    if (!deviceType) {
        layer.msg('未填写类型', {icon: 0});
        return;
    }
    if (!deviceModel) {
        layer.msg('未填写型号', {icon: 0});
        return;
    }
    if (!deviceDesc) {
        layer.msg('未填写描述', {icon: 0});
        return;
    }
    if (!left || !top) {
        layer.msg('坐标不完整', {icon: 0});
        return;
    }

    iAjax({
        url: 'interface/device/register',
        type: 'post',
        data: {
            buildingCode: buildingCode,
            floorCode: floorCode,
            deviceName: deviceName,
            deviceType: deviceType,
            deviceNo: deviceNo,
            deviceModel: deviceModel,
            deviceDesc: deviceDesc,
            left: left,
            top: top
        },
        success: function (ret) {
            if (ret.status == 0) { //成功
                layer.alert(ret.desc, {
                    btn: ['点击刷新', '继续添加'], icon: 1, closeBtn: 0, btnAlign: 'c', end: function () {
                        drag($obj, false);
                        close_addView(deviceName);
                    }
                }, function (index) {
                    layer.close(index);
                    location.reload(); //刷新页面
                });
            } else { //失败
                layer.alert(ret.desc, {icon: 5, closeBtn: 0, btnAlign: 'c'}, function (index) {
                    layer.close(index);
                });
            }
        }
    });
}

//取消添加
function addCancel() {
    close_addView("j");
    $(".level__pins.level__pins--active .pin.byAddNew:last-child").remove();
}

//仅关闭添加视图
function close_addView(j) {
    if (j) {
        // $(".level__pins.level__pins--active .pin.byAddNew:last-child .pinBts").html(j);
        $(".level__pins.level__pins--active .pin.byAddNew:last-child .pinBts").remove();
    }
    $("#addNew").removeClass('disable');
    $(".mallnav").removeClass("mallnav--hidden");
    layer.close(layerByAddNew);
}

//根据输入改变传感器位置和内容
function changeByInput(e) {
    var $e = $(e), $gr = $e.parents(".inputGroup");
    var x = $gr.find(".infoX").val();
    var y = $gr.find('.infoY').val();
    $(".level__pins.level__pins--active .pin.byAddNew:last-child").css({
        'left': x + 'vmin',
        'top': y + 'vmin'
    });
}

//门锁操作
function doorOperate(id, l) {
    var lt = l == 0 ? 'LOCK' : 'OPEN';
    var str = l == 0 ? '关闭' : '打开';
    iAjax({
        url: 'interface/device/lockoper',
        type: 'post',
        data: {
            deviceId: id,
            operType: lt
        },
        success: function (ret) {
            if (ret.status == 0) { //成功
                layer.alert("设备指令【" + str + "】下发成功", {icon: 1, closeBtn: 0, btnAlign: 'c'}, function (index) {
                    layer.close(index);
                });
            } else { //失败
                layer.alert(ret.desc, {icon: 5, closeBtn: 0, btnAlign: 'c'}, function (index) {
                    layer.close(index);
                });
            }
        }
    });
}