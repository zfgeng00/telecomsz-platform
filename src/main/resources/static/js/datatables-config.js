"use strict";
$(function () {
    $.extend($.fn.dataTable.defaults, {
        processing: false,
        searching: false,
        sorting: false,
        ordering: false,
        serverSide: true,
        lengthMenu: [10, 25, 50, 75, 100],
        language: {
            processing: '正在处理中。。。',
            infoEmpty: '显示第 0 至 0 项结果，共 0 项',
            info: '显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项'
        },
        ajax: {
            url: 'data',
            type: 'post',
            dataSrc: function (data) {
                return JSOG.decode(data).data;
            }
        }
    });
});