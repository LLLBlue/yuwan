<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nozomi
  Date: 4/23/2018
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="_base" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>配置</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- Scripts -->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery.scrollex.min.js"></script>
    <script src="../js/jquery.scrolly.min.js"></script>
    <script src="../js/skel.min.js"></script>
    <script src="../js/util.js"></script>
    <script src="../js/lib/jsrender.min.js"></script>

    <script src="../js/main.js"></script>
    <!--[if lte IE 8]>
    <script src="../js/ie/respond.min.js"></script><![endif]-->
    <!--[if lte IE 8]>
    <script src="../js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="../css/main.css"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="../css/ie8.css"/><![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="../css/ie9.css"/><![endif]-->
</head>
<body>
<article id="main">
    <section>
        <br>
        <div class="6u 12u$(small)">
            <input type="checkbox" id="nominationSwitch" name="nominationSwitch">
            <label for="nominationSwitch">提名开关</label>
        </div>

        <div class="6u$ 12u$(small)">
            <input type="checkbox" id="voteSwitch" name="voteSwitch">
            <label for="voteSwitch">投票开关</label>
        </div>

        <h4>提名说明</h4>
        <div class="6u 12u$(xsmall)">
            <input type="text" name="nominationTitle" id="nominationTitle" placeholder="提名说明"/>
        </div>

        <h4>投票说明</h4>
        <div class="6u$ 12u$(xsmall)">
            <input type="text" name="voteTitle" id="voteTitle" placeholder="投票说明"/>
        </div>
    </section>
    <section>
        <br>
        <div class="6u 12u$(medium)">
            <ul class="actions">
                <li><a href="javascript:pageSubmit()" class="button">SUBMIT</a></li>
            </ul>
        </div>
    </section>
</article>
</body>
<script type="text/javascript">
    var _base = "${_base}";

    $(document).ready(function () {
        initPage();
    });

    function initPage() {
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {},
            url: _base + "/config/queryConfig",
            success: function (data) {
                var configList = data.configEntityList;
                for (var k = 0; k < configList.length; k++) {
                    if (configList[k].configId === 1) {
                        if (configList[k].paramValue === "1") {
                            $("#nominationSwitch").attr("checked", true);
                        } else {
                            $("#nominationSwitch").attr("checked", false);
                        }
                    }
                    if (configList[k].configId === 2) {
                        if (configList[k].paramValue === "1") {
                            $("#voteSwitch").attr("checked", true);
                        } else {
                            $("#voteSwitch").attr("checked", false);
                        }
                    }
                    if (configList[k].configId === 4) {
                        $("#nominationTitle").val(configList[k].paramValue);
                    }
                    if (configList[k].configId === 5) {
                        $("#voteTitle").val(configList[k].paramValue);
                    }
                }
            },
            error: function (data) {
            },
            beforeSend: function () {
            },
            complete: function () {
            }
        });
    }

    function pageSubmit() {
        var nominationSwitch = $("#nominationSwitch").prop("checked") === true ? "1" : "0";
        var voteSwitch = $("#voteSwitch").prop("checked") === true ? "1" : "0";
        var nominationTitle = $("#nominationTitle").val();
        var voteTitle = $("#voteTitle").val();
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {
                nominationSwitch: nominationSwitch,
                voteSwitch: voteSwitch,
                nominationTitle: nominationTitle,
                voteTitle: voteTitle
            },
            url: _base + "/config/configSubmit",
            success: function (data) {
                alert(data);
                window.location.reload(true);
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
