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
    <script src="../js/lib/jquery-1.9.1.min.js"></script>
    <script src="../js/lib/jsrender.min.js"></script>
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
    <div class="login-bottom" id="bottomList">
        <h5>当前提名列表（点击投票）：</h5>
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
        onQuery();
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
                window.location.reload();
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
            data: {},
            url: "../article/queryNomination",
            success: function (data) {
                var template = $.templates("#nominationListTemplate");
                var htmlOutput = template.render(data.nominationList);
                $("#bottomList").append(htmlOutput);
            },
            error: function (data) {
            },
            beforeSend: function () {
            },
            complete: function () {
            }
        });
    }

    function onNominationClick(item) {
        if (confirm("要投票给" + $(item).html() + "？")) {
            onVote($(item).attr("nominationId"))
        }
    }

    function onVote(nominationId) {
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {
                nominationId: nominationId
            },
            url: "../vote/voteSubmit",
            success: function (data) {
                alert(data);
                window.location.reload();
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

<script id="nominationListTemplate" type="text/x-jsrender">
    <br>
    <h3 onclick="onNominationClick(this)" nominationId={{:nominationId}}>→ {{:shortName}} -- {{:userName}} （{{:state}}票）</h3>
</script>
</html>
