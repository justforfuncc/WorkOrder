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
    <script src="../../js/bootstrap.js"></script>
    <script src="../../js/jquery.min.js"></script>

    <script>
        $(document).ready(function () {
            var workorderId = window.location.pathname.split("/").reverse()[0];
            renderPage(workorderId);
        })

        function renderPage(workorderId) {
            $.ajax({
                type : "get",
                dataType : "json",
                url : "/workorder/detail/" + workorderId,
                success : function (data) {
                    console.log(data)
                    $("#name").val(data.data.id);
                    $("#priority").val(data.data.priority);
                    $("#detail").val(data.data.detail);
                }
            })
        }
    </script>
</head>

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
            <a class="navbar-brand" href="#">WorkOrder</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li class="active"><a href="/workorder/list">workOrderList</a></li>
                <li class="active"><a href="/workorder/create">create</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <div class="starter-template">
        <form class="form-horizontal" action="/workorder/create" method="post">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" disabled>
                </div>
            </div>
            <div class="form-group">
                <label for="priority" class="col-sm-2 control-label">Priority</label>
                <div class="col-sm-10">
                    <select class="form-control" id="priority" name="priority" disabled>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="detail" class="col-sm-2 control-label">Detail</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="5" id="detail" name="detail" value="${workOrderVo.detail}" disabled></textarea>
                </div>
            </div>
        </form>
    </div>

</div><!-- /.container -->


</body>
</html>