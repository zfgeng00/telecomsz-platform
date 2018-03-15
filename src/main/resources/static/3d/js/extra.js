/**
 * 传感器被点击事件回调
 * @param ele 元素
 * @param ev 事件
 */
function pinClick(ele, ev) {
    var $ele = $(ele);
    if ($ele.hasClass("pin--active"))return;

    console.log($ele)
}