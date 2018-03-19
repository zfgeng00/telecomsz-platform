/**
 * 传感器对应的详情被打开之前的回调
 * @param ele 元素
 * @param ev 事件
 */
function beforeOpenContent(space, category) {
    var $thisCon = $(".content__item[data-space='" + space + "'] ");
    if ($thisCon.hasClass("content__item--current"))return; //如果已经打开了，不做操作，直接结束

    // console.log(space, category)
}