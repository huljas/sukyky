$(function () {
    $(".plot").each(function () {
        var stockId = $(this).data("stock-id");
        var jqxhr = $.get('/trends/' + stockId + '/monthly');
        jqxhr.success(function (data) {
            console.log("success", data);
            var d = [];
            for (var i = 0; i < data.rates.length; i++) {
                d.push([i, data.rates[i] / 100]);
            }
            var options = {
                series : {lines:{show:true}, points:{show:false}},
                xaxis : {show: false},
                yaxis : {show: false},
                grid : {show: false}
            };
            var series = {data: d, color: '#c31'}
            $.plot($(".plot[data-stock-id=" + stockId + "]"), [series], options);
        });
    });

    $(".plot-large").each(function () {
        var stockId = $(this).data("stock-id");
        var jqxhr = $.get('/trends/' + stockId + '/yearly');
        jqxhr.success(function (data) {
            console.log("success", data);
            var d = [];
            for (var i = 0; i < data.rates.length; i++) {
                d.push([i, data.rates[i] / 100]);
            }
            var options = {
                series : {lines:{show:true}, points:{show:false}},
                xaxis : {ticks: [[0, "12m"],[360-9*30, "9m"], [360-6*30, "6m"], [360-3*30, "3m"], [365, "0m"]]},
                yaxis : {show: true},
                grid : {show: true}
            };
            var series = {data: d, color: '#c31'}
            $.plot($(".plot-large[data-stock-id=" + stockId + "]"), [series], options);
        });
    });
});