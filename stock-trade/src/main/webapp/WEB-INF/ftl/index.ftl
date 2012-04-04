<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Stock Borkers Unlimited</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="/css/screen.css" rel="stylesheet">
    <link rel="shortcut icon" href="images/favicon.ico">
</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/">Stock Borkers Unlimited</a>
        </div>
    </div>
</div>

<div class="container">

    <div class="content-big">
        <table border="0">
            <thead>
            <tr><th>Stock</th><th>Price</th><th>Change</th><th>Chg %</th><th>History</th></tr>
            </thead>
            <tbody>
            <#list stocks as stock>
                <tr>
                    <td><a href="/stock/${stock.id}">${stock.name}</a></td>
                    <td>${helper.getLastPrice(stock)}</td>
                    <td>${helper.getChange(stock)}</td>
                    <td>${helper.getChangePercent(stock)}</td>
                    <td><div class="plot" data-stock-id="${stock.id}" style="height:20px;width:120px;"></div></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <hr>

    <footer>
        <p>&copy; 2012</p>
    </footer>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="/js/jquery.flot.min.js"></script>
<script src="/js/plots.js"></script>
</body>
</html>
