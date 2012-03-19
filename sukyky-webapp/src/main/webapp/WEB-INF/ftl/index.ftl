<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Stock Trade Example</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="css/screen.css" rel="stylesheet">
    <link rel="shortcut icon" href="images/favicon.ico">
</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/">Stock Trade Example</a>
        </div>
    </div>
</div>

<div class="container">

    <div class="content-big">
        <ul class="list">
            <#list stocks as stock>
                <li>${stock.name}: ${stock.lastPrice} ${stock.change} ${stock.changePercentage}</li>
            </#list>
        </ul>
    </div>

    <hr>

    <footer>
        <p>&copy; 2012</p>
    </footer>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

</body>
</html>
