$(function () {
    $(".tiny-plot").each(function () {
        var stockId = $(this).data("stock-id");
        var jqxhr = $.get('/trends/' + stockId + '/small');
        jqxhr.success(function (data) {
            console.log("success", data);
            var d = [];
            for (var i = 0; i < data.rates.length; i++) {
                d.push([i, data.rates[i] / 100]);
            }
            console.log("data", d);
            var options = {
                series : {lines:{show:true}, points:{show:false}},
                xaxis : {show: false},
                yaxis : {show: false},
                grid : {show: false}
            };
            var series = {data: d, color: '#000'}
            $.plot($(".tiny-plot[data-stock-id=" + stockId + "]"), [series], options);
        });
    });
});