(function ($) {
    function pagerFilter(data) {
        data = dataListLoadFilter(data);
        console.log(data);
        return data;
    }

    $.extend($.fn.datagrid.methods, {
        clientPaging: function (jq) {
            return jq.each(function () {
                var dg = $(this);
                console.log(dg);
                var state = dg.data('datagrid');
                var opts = state.options;
                console.log(opts);
                opts.loadFilter = pagerFilter;
            });
        }
    })
})(jQuery);

function datagrid_clientPaging(dgName, btnName) {
    var dg = $(dgName);
    console.log(dg);
    console.log(dg.datagrid("clientPaging"));
    var pager = dg.datagrid('getPager');
    console.log(pager);
//.datagrid('getPager');
    var buttons = $(btnName);
    if (buttons) {
        pager.pagination({
            showRefresh: false,
            buttons: buttons
        });
    }
}