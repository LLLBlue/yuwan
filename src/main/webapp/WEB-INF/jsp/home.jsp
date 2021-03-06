<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nozomi
  Date: 2018/2/6
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="_base" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>鱼丸大爆炸</title>
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
            <h2>鱼丸太太大爆炸</h2>
            <p>yuwan - stormblood</p>
        </header>
        <section class="wrapper style5">
            <div class="inner" id="noticeWrapper">
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
        initNotice();
    });

    function initNotice() {
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {},
            url: _base + "/home/queryNotice",
            success: function (data) {
                var template = $.templates("#noticeTemplate");
                var htmlOutput = template.render(data.sysConfigEntityList);
                $("#noticeWrapper").append(htmlOutput);
            },
            error: function (data) {
            },
            beforeSend: function () {
            },
            complete: function () {
            }
        });
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

    function goToUrl(url) {
        window.location.href = _base + url;
    }
</script>
<script id="noticeTemplate" type="text/x-jsrender">
<%--noticeTemplate--%>
<h3>{{:paramValue}}</h3>
<p>{{:description}}</p>
<p>{{:detail}}</p>
<hr/>
</script>
</html>