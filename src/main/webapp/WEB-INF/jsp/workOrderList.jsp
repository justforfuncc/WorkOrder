<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>WorkOrder</title>

    <link href="../../css/bootstrap.css" rel="stylesheet">
    <link href="../../css/bootstrap-theme.css" rel="stylesheet">
    <link href="../../css/template.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../js/bootstrap.js"></script>
</head>

<script>
    $( document ).ready(function() {
        $.ajax({
            type : "get",
            dataType : "json",
            url : "/workorder/list/data",
            success : function(data){
                console.log(data)
                $("tbody").append("<tr><td>" + data.data.id +  "</td><td>" + data.data.name + "</td><td>"
                        + data.data.priority + "</td><td><a href=" + "/workorder/preview/" + data.data.id + ">preview</a></td></tr>")
            },
            error : function () {
                alert("request workorder list data error! please contact system admin")
            }
        });
    });
</script>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">WorkOrder</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/workorder/list">workOrderList</a></li>
                <li class="active"><a href="/workorder/create">Create</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <div class="starter-template">
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <th style="text-align: center">ID</th>
                    <th style="text-align: center">Name</th>
                    <th style="text-align: center">Priority</th>
                    <th style="text-align: center">Prevoew</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

</div><!-- /.container -->

</body>
</html>