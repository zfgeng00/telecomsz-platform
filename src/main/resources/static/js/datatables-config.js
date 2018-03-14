"use strict";
$(function () {
    $.extend($.fn.dataTable.defaults, {
        processing: true,
        searching: false,
        sorting: false,
        ordering: false,
        serverSide: true,
        autoWidth: !1,
        responsive: !0,
        lengthMenu: [10, 25, 50, 75, 100],
        language: {
            processing: '正在处理中。。。'
        }
    });
});