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
        <div>
            <span class="pr">${helper.getLastPrice(stock)}</span>
            <div class="price-change">
                <span class="${helper.getChangeCss(stock)}">${helper.getChange(stock)}</span>
                <span class="${helper.getChangeCss(stock)}">${helper.getChangePercent(stock)}</span>
            </div>
            <div class="statistics">
                <table class="statistics-table">
                    <tbody>
                    <tr><th>Year high:</th><td>${helper.getYearHigh(stock)}</td></tr>
                    <tr><th>Year low:</th><td>${helper.getYearLow(stock)}</td></tr>
                    <tr><th>Week high:</th><td>${helper.getWeekHigh(stock)}</td></tr>
                    <tr><th>Week low:</th><td>${helper.getWeekLow(stock)}</td></tr>
                    <tr><th>Days high:</th><td>${helper.getDayHigh(stock)}</td></tr>
                    <tr><th>Days low:</th><td>${helper.getDayLow(stock)}</td></tr>
                    </tbody>
                </table>                
            </div>
        </div>
        <div>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; 2012</p>
    </footer>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

</body>
</html>
