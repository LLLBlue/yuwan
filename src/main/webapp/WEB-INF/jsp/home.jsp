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
            <h2>鱼丸太太大爆炸</h2>
            <p>yuwan - stormblood</p>
        </header>
        <section class="wrapper style5">
            <div class="inner">

                <h3>恋人节活动进行中</h3>
                <p>在森都剧场接任务哦</p>
                <p></p>
                <hr/>

                <h3>部队简称投票进行中</h3>
                <p>右侧菜单或<a href="javascript:goToUrl('/vote/vote')">点我</a>进入投票</p>
                <p></p>
                <hr/>

                <h3>当前项目已开源</h3>
                <p><a href="https://github.com/LLLBlue/yuwan">GitHub</a></p>
                <p></p>

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
</script>
</html>