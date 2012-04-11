<#assign _title="${stock.name}"/>
<#include "_head.ftl"/>

<div class="row" xmlns="http://www.w3.org/1999/html">
    <div class="span4">
        <h1>${stock.name}</h1>
    </div>
    <div class="span4">
        <h1 class="pr">${stock.formatCurrency(stock.getLastPrice())}
            <small class="${stock.getChangeDirection()}">
                <span>${stock.formatCurrency(stock.getChange())}</span>
                <span>(${stock.formatPercentage(stock.getChangePercentage())})</span>
            </small>
        </h1>
        <h6><i class="icon-refresh"></i> ${stock.formatTime(stock.getLastTime())}</h6>
    </div>
    <div class="span4">
        <h4>Statistics</h4>
        <table class="table">
            <tbody>
            <tr>
                <th>Range:</th>
                <td>${stock.formatCurrency(stock.getDailyMin())} - ${stock.formatCurrency(stock.getDailyMax())}</td>
            </tr>
            <tr>
                <th>52 week:</th>
                <td>${stock.formatCurrency(stock.getYearlyMin())} - ${stock.formatCurrency(stock.getYearlyMax())}</td>
            </tr>
            <tr>
                <th>Open:</th>
                <td>${stock.formatCurrency(stock.getOpeningPrice())}</td>
            </tr>
            <tr>
                <th>Close:</th>
                <td>${stock.formatCurrency(stock.getClosingPrice())}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="span12">
        <div class="plot-large" data-stock-id="${stock.id}" style="width:938px;height:480px;">
        </div>
    </div>
</div>

<#include "_footer.ftl"/>
