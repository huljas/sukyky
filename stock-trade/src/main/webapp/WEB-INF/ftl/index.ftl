<#assign _title="Market summary"/>
<#include "_head.ftl"/>

<div class="row">
    <div class="span6">
        <h2>Most up</h2>

        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Stock</th>
                <th>Price</th>
                <th>Change</th>
                <th>Chg %</th>
            </tr>
            </thead>
            <tbody>
            <#list upStocks as stock>
            <tr>
                <td><a href="/stock/${stock.id}">${stock.name}</a></td>
                <td>${stock.formatCurrency(stock.getLastPrice())}</td>
                <td>${stock.formatCurrency(stock.getChange())}</td>
                <td>${stock.formatPercentage(stock.getChangePercentage())}</td>
            </tr>
            </#list>
            </tbody>
        </table>

    </div>

    <div class="span6">
        <h2>Most down</h2>

        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Stock</th>
                <th>Price</th>
                <th>Change</th>
                <th>Chg %</th>
            </tr>
            </thead>
            <tbody>
            <#list downStocks as stock>
            <tr>
                <td><a href="/stock/${stock.id}">${stock.name}</a></td>
                <td>${stock.formatCurrency(stock.getLastPrice())}</td>
                <td>${stock.formatCurrency(stock.getChange())}</td>
                <td>${stock.formatPercentage(stock.getChangePercentage())}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="span12">
        <h2>All stocks</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Stock</th>
                <th>Price</th>
                <th>Change</th>
                <th>Chg %</th>
                <th>Trend 1m</th>
            </tr>
            </thead>
            <tbody>
            <#list allStocks as stock>
            <tr>
                <td><a href="/stock/${stock.id}">${stock.name}</a></td>
                <td>${stock.formatCurrency(stock.getLastPrice())}</td>
                <td>${stock.formatCurrency(stock.getChange())}</td>
                <td>${stock.formatPercentage(stock.getChangePercentage())}</td>
                <td>
                    <div class="plot" data-stock-id="${stock.id}" style="height:20px;width:120px;"></div>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<#include "_footer.ftl"/>

