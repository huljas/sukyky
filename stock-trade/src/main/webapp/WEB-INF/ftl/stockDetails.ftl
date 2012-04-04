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
        <h1>${stock.name}</h1>

        <div class="stock-details">
            <span class="pr">${helper.getLastPrice(stock)}</span>

            <div class="${helper.getChangeCss(stock)}">
                <span>${helper.getChange(stock)}</span>
                <span>(${helper.getChangePercent(stock)} %)</span>
            </div>
        </div>
        <div class="statistics">
            <table>
                <tbody>
                <tr>
                    <th>Range:</th>
                    <td>${helper.getRange(stock)}</td>
                </tr>
                <tr>
                    <th>52 week:</th>
                    <td>${helper.getYearRange(stock)}</td>
                </tr>
                <tr>
                    <th>Open:</th>
                    <td>${helper.getOpeningPrice(stock)}</td>
                </tr>
                <tr>
                    <th>Close:</th>
                    <td>${helper.getClosingPrice(stock)}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="plot" data-stock-id="${stock.id}" style="width:400px;height:225px;">
        </div>
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
