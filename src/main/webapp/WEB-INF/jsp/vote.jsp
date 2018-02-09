<%--
  Created by IntelliJ IDEA.
  User: Nozomi
  Date: 2/7/2018
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="_base" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>鱼丸部队简称投票</title>
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
<input type="hidden" name="isLogin" id="isLogin" value="${isLogin}"/>
<input type="hidden" name="userName" id="userName" value="${userName}"/>
<input type="hidden" name="userId" id="userId" value="${userId}"/>
<!-- Page Wrapper -->
<div id="page-wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="javascript:goToUrl('/home/home')">鱼丸大爆炸</a></h1>
        <nav id="nav">
            <ul>
                <li class="special">
                    <a href="#menu" class="menuToggle"><span id="user">Menu</span></a>
                    <div id="menu">
                        <ul>
                            <li><a href="javascript:goToUrl('/home/home')">Home</a></li>
                            <li><a href="javascript:loginOrLogout()" id="aLogin">登录&注册</a></li>
                            <li><a href="javascript:goToUrl('/vote/vote')">部队简称投票</a></li>
                            <li><a href="javascript:goToUrl('/nomination/nomination')">部队简称提名</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </header>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>部队简称投票</h2>
            <p>yuwan - vote</p>
        </header>
        <section class="wrapper style5">
            <div class="inner">
                <section>
                    <h4>提名列表</h4>
                    <h5>March</h5>
                    <div class="table-wrapper">
                        <table>
                            <thead>
                            <tr>
                                <th>简称</th>
                                <th>提名人</th>
                                <th>票数</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="nominationList">
                            <%--<tr>--%>
                                <%--<td>Item One</td>--%>
                                <%--<td>Ante turpis integer aliquet porttitor.</td>--%>
                                <%--<td>29.99</td>--%>
                                <%--<td>29.99</td>--%>
                            <%--</tr>--%>
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
        </section>
    </article>

    <!-- Footer -->
    <footer id="footer">
        <ul class="icons">
            <li><a href="javascript:alert('这链接是假的，做个样子')" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="javascript:alert('这链接是假的，做个样子')" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
            <li><a href="javascript:alert('这链接是假的，做个样子')" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="javascript:alert('这链接是假的，做个样子')" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="javascript:alert('这链接是假的，做个样子')" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
        </ul>
        <ul class="copyright">
            <li>Copyright &copy; 2018.YuWan All rights reserved.</li>
        </ul>
    </footer>
</div>
</body>
<script type="text/javascript">
    var _base = "${_base}";

    $(document).ready(function () {
        initUser();
        onQuery();
    });

    function goToUrl(url) {
        window.location.href = _base + url;
    }

    function loginOrLogout() {
        if ($("#isLogin").val() === "1") {
            logOut();
        } else {
            goToUrl("/user/user");
        }
    }

    function logOut() {
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {},
            url: _base + "/user/logOut",
            success: function (data) {
                goToUrl("/home/home");
            },
            error: function (data) {
            },
            beforeSend: function () {
            },
            complete: function () {
            }
        });
    }

    function initUser() {
        if ($("#isLogin").val() === "1") {
            $("#user").html($("#userName").val());
            $("#aLogin").html("退出登录");
        } else {
            $("#user").html("未登录");
            $("#aLogin").html("登录&注册");
        }
    }

    function onQuery() {
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {},
            url: _base + "/nomination/queryNomination",
            success: function (data) {
                var template = $.templates("#nominationTableTemplate");
                var htmlOutput = template.render(data.nominationList);
                $("#nominationList").append(htmlOutput);
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
        if (confirm("要投票给[" + $(item).attr("shortName") + "]？")) {
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
<script id="nominationTableTemplate" type="text/x-jsrender">
<%--nominationTableTemplate--%>
<tr>
    <td>{{:shortName}}</td>
    <td>{{:userName}}</td>
    <td>{{:voteCount}}</td>
    <td onclick="onNominationClick(this)" nominationId={{:nominationId}} shortName={{:shortName}}>投TA一票</td>
</tr>
</script>
</html>