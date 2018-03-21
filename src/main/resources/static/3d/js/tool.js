/**
 * 封装一些工具方法
 */

/**
 * 封装jquery的ajax，公用错误提示信息，加载loading
 * @param options
 */
function iAjax(options) {
    console.log(options);
    var layerLoading;
    $.ajax({
        url: options.url,
        type: options.type,
        data: options.data,
        contentType: options.contentType || 'application/x-www-form-urlencoded',
        dataType: options.dataType || 'json',
        success: function (ret) {
            console.log(ret);
            options.success(ret);
        },
        error: function (err) {
            console.log(err);
            if (options.error) {
                options.error(err);
            } else {
                layer.alert("未知的错误发生了", {icon: 5, closeBtn: 0, btnAlign: 'c'}, function (index) {
                    layer.close(index);
                });
            }
        },
        beforeSend: function (xhr) {
            layerLoading = layer.load(0, {shade: 0.1});
        },
        complete: function (xhr) {
            layer.close(layerLoading);
        }
    });
}