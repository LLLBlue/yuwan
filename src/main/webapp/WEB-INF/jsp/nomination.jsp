<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nozomi
  Date: 2/2/2018
  Time: 2:49 PM
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

<!-- Page Wrapper -->
<div id="page-wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="javascript:goToUrl('/home/home')">鱼丸大爆炸</a></h1>
        <nav id="nav">
            <ul>
                <li class="special">
                    <a href="#menu" class="menuToggle"><span>Menu</span></a>
                    <div id="menu">
                        <ul>
                            <li><a href="javascript:goToUrl('/home/home')">Home</a></li>
                            <li><a href="javascript:alert('敬请期待')">注册</a></li>
                            <li><a href="javascript:alert('敬请期待')">登录</a></li>
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
            <h2>部队简称提名</h2>
            <p>yuwan - nomination</p>
        </header>
        <section class="wrapper style5">
            <div class="inner">
                <section>
                    <h4>部队简称提名</h4>
                    <form method="post" action="javascript:onSubmit()">
                        <div class="row uniform">
                            <div class="6u 12u$(xsmall)">
                                <input type="text" name="shortName" id="shortName" value="" placeholder="部队简称"/>
                            </div>
                            <div class="6u$ 12u$(xsmall)">
                                <input type="text" name="userName" id="userName" value="" placeholder="你的名字"/>
                            </div>
                            <div class="12u$">
                                <ul class="actions">
                                    <li><input type="submit" value="提交" class="special"/></li>
                                </ul>
                            </div>
                        </div>
                    </form>
                </section>
                <section>
                    <h4>当前提名列表</h4>
                    <div class="table-wrapper">
                        <table>
                            <thead>
                            <tr>
                                <th>简称</th>
                                <th>提名人</th>
                            </tr>
                            </thead>
                            <tbody id="nominationList">
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

    function goToUrl(url) {
        window.location.href = _base + url;
    }

    $(document).ready(function () {
        onQuery();
    });

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
            url: _base + "/nomination/nominateSubmit",
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
</tr>
</script>
</html>