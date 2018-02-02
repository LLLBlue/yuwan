<%--
  Created by IntelliJ IDEA.
  User: Nozomi
  Date: 2/2/2018
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>鱼丸部队简称提名</title>
    <script src="../js/lib/jquery-1.7.2.min.js"></script>
    <!-- Custom Theme files -->
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div class="login">
    <div class="login-top">
        <h1>部队简称提名</h1>
        <form>
            <input type="text" id="shortName" placeholder="部队简称">
            <input type="text" id="userName" placeholder="你的名字">
        </form>
        <div class="forgot" id="submitButton">
            <input type="submit" value="提名！">
        </div>
    </div>
    <div class="login-bottom">
        <h3>查看提名列表  <a href="javascript:onQuery()">点我</a></h3>
    </div>
</div>
<div class="copyright">
    <p>Copyright &copy; 2018.YuWan All rights reserved.</p>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#submitButton").click(function () {
            onSubmit();
        });
    });

    function onSubmit() {
        var shortName = $("#shortName").val();
        var userName = $("#userName").val();
        if (shortName === "" || shortName === null) {
            alert("请输入部队简称");
            return;
        }
        if (userName === "" || userName === null) {
            alert("请输入你的名字");
            return;
        }

        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {
                shortName: shortName,
                userName: userName
            },
            url: "../article/nominateSubmit",
            success: function (data) {
                alert(data);
            },
            error: function (data) {
            },
            beforeSend: function () {
            },
            complete: function () {
            }
        });
    }

    function onQuery() {
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {
            },
            url: "../article/queryNomination",
            success: function (data) {
                alert(data);
            },
            error: function (data) {
            },
            beforeSend: function () {
            },
            complete: function () {
            }
        });
    }

</script>
</html>
