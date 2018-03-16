var bIndex; //本地数据键名

$(function () {

    mainInit(window); //初始化main

    bIndex = $("body").data("building");

    // 编辑
    $(document).on('click', '.desc_edit', function (e) {
        var $this = $(e.target), $desc_item = $this.parents(".content__item"), $desc_title = $desc_item.find(".content__item-title"), $desc_type = $desc_item.find("select"), $desc_con = $desc_item.find(".content__desc");
        var obj = $(".pin.pin--active"), oParent = obj.parent();
        console.log(obj);
        var floor_index = $(".level--current").index(), point_index = obj.index();
        var thisTitle = $desc_title.html(),
            thisType = $desc_type.val(),
            thisDesc = $desc_con.val();
        var vw = $(window).width() / 100
            , vh = $(window).height() / 100
            , vm = vw < vh ? vw : vh;
        var thisX = parseFloat(obj.css("left")) / vm;
        var thisY = parseFloat(obj.css("top")) / vm;
        switch ($this.html()) {
            case "编辑":
                sessionStorage.setItem("editor.thisTitle", thisTitle);
                sessionStorage.setItem("editor.thisType", thisType);
                sessionStorage.setItem("editor.thisDesc", thisDesc);
                sessionStorage.setItem("editor.thisX", thisX);
                sessionStorage.setItem("editor.thisY", thisY);
                $this.html("完成");
                $desc_title.removeAttr("readonly");
                $desc_title.attr("contenteditable", 'true');
                $desc_con.removeAttr("readonly");
                $desc_type.css("display", "inline-block");
                drag(obj, true, oParent);
                break;
            case "完成":
                if (!thisTitle) {
                    layer.msg('未填写名称', {icon: 0});
                    break;
                }
                if (!thisType) {
                    layer.msg('未选择类型', {icon: 0});
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
                        $this.html("编辑");
                        $desc_title.attr("readonly", '');
                        $desc_title.attr("contenteditable", 'false');
                        $desc_con.attr("readonly", '');
                        $desc_type.css("display", "none");
                        drag(obj, false);

                        //todo:记录数据

                        layer.close(index);
                        layer.msg('保存成功', {icon: 1});
                    },
                    btn2: function (index, layero) {
                        //按钮【按钮二】的回调
                        $this.html("编辑");
                        $desc_title.attr("readonly", '');
                        $desc_title.attr("contenteditable", 'false');
                        $desc_con.attr("readonly", '');
                        $desc_type.css("display", "none");
                        $desc_title.html(sessionStorage.getItem("editor.thisTitle"));
                        $desc_type.val(sessionStorage.getItem("editor.thisType"));
                        $desc_con.val(sessionStorage.getItem("editor.thisDesc"));
                        obj.css({
                            'left': sessionStorage.getItem("editor.thisX") + 'vmin',
                            'top': sessionStorage.getItem("editor.thisY") + 'vmin'
                        });
                        $desc_type.change();
                        drag(obj, false);
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
            var $this = $(e.target), $desc_item = $this.parents(".content__item");
            var $obj = $(".pin.pin--active");
            var floor_index = $(".level--current").index(), point_index = $obj.index();

            //todo 删除操作

            layer.alert('删除成功', {icon: 1, closeBtn: 0}, function (index) {
                location.reload();
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
            var trans = bIndex == 1 ? 'translateZ(15vmin) rotateX(-69.75deg) rotateY(-45deg) rotateZ(14deg)' : 'translateZ(38vmin) rotateX(-69.75deg) rotateY(-32deg) rotateZ(9deg)';
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
        var trans = bIndex == 1 ? 'translateZ(15vmin) rotateX(-69.75deg) rotateY(-45deg) rotateZ(14deg)' : 'translateZ(38vmin) rotateX(-69.75deg) rotateY(-32deg) rotateZ(9deg)';
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
    if ($e.hasClass('disable'))return;
    $e.addClass('disable');
    $("#addNew .inputGroup").slideDown();
    $("#addNew .close_add").slideDown();
    $("#addNew .btnG .btn2").slideDown();
    $(".mallnav").addClass("mallnav--hidden");
    $(".inputGroup input[name='name']").val('New');
    $(".inputGroup input[name='desc']").val('');
    $(".inputGroup input[name='x']").val(101);
    $(".inputGroup input[name='y']").val(36);
    var name = $(".inputGroup input[name='name']").val();
    var x = $(".inputGroup input[name='x']").val();
    var y = $(".inputGroup input[name='y']").val();
    var ht = '<a title="可拖拽来移动位置" class="pin" style="left:' + x + 'vmin;top:' + y + 'vmin;" data-category="0" href="javascript:void(0)"aria-label="">' +
        '</a>';
    $('.level__pins--active').append(ht);
    var obj = $(".level__pins.level__pins--active .pin:last-child"), oParent = obj.parent();
    drag(obj, true, oParent, function (x, y) {
        $(".inputGroup input[name='x']").val(x);
        $(".inputGroup input[name='y']").val(y);
    });
}

//确定添加
function addSubmit() {
    var obj = $(".level__pins.level__pins--active .pin:last-child");
    var floor_index = $(".level--current").index();
    var name = $(".inputGroup input[name='name']").val();
    var category = $(".inputGroup select[name='type']").val();
    var desc = $(".inputGroup input[name='desc']").val();
    var x = $(".inputGroup input[name='x']").val();
    var y = $(".inputGroup input[name='y']").val();
    if (!name) {
        layer.msg('未填写名称', {icon: 0});
        return;
    }
    if (!category) {
        layer.msg('未选择类型', {icon: 0});
        return;
    }
    if (!desc) {
        layer.msg('未填写详细信息', {icon: 0});
        return;
    }
    if (!x || !y) {
        layer.msg('坐标不完整', {icon: 0});
        return;
    }

    //todo:记录数据

    layer.alert('添加成功', {icon: 1, closeBtn: 0}, function (index) {
        drag(obj, false);
        close_addView();
        location.reload();
    });
}

//    取消添加
function addCancel() {
    close_addView();
    $(".level__pins.level__pins--active .pin:last-child").remove();
}

//关闭添加视图
function close_addView() {
    $("#addNew .inputGroup").slideUp();
    $("#addNew .close_add").slideUp();
    $("#addNew .btnG .btn2").slideUp();
    $("#addNew .btnG .btn1").removeClass('disable');
    $(".mallnav").removeClass("mallnav--hidden");
}

//根据输入改变传感器位置和内容
function changeByInput() {
    var name = $(".inputGroup input[name='name']").val();
    var x = $(".inputGroup input[name='x']").val();
    var y = $(".inputGroup input[name='y']").val();
    $(".level__pins.level__pins--active .pin:last-child").css({
        'left': x + 'vmin',
        'top': y + 'vmin'
    });
}

//内容区域选择框值的变化
function byContentType(e) {
    var $e = $(e), v = $e.val(), $c = $e.parents(".content__item"), $p = $(".level__pins.level__pins--active .pin.pin--active");
    if (v) {
        $c.data("category", v);
        $c.attr("data-category", v);
        $p.data("category", v);
        $p.attr("data-category", v);
    }
}