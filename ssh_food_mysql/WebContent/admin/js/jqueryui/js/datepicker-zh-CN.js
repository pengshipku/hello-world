/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
jQuery(function($){
        $.datepicker.regional['zh-CN'] = {
                closeText: 'Close',
                prevText: '&#x3c;Last month',
                nextText: 'Next month&#x3e;',
                currentText: '今天',
                monthNames: ['January','February','March','April','May','June',
                'July','August','September','October','November','December'],
                monthNamesShort: ['Jan','Feb','Mar','Apr','May','June',
                'July','Aug','Sept','Oct','Nov','Dec'],
                dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
                dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
                dayNamesMin: ['日','一','二','三','四','五','六'],
                weekHeader: '周',
                dateFormat: 'yy-mm-dd',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: true,
                yearSuffix: '年'};
        $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});