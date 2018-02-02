<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nozomi
  Date: 2/2/2018
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>鱼丸太太</title>
    <script src="../js/lib/jquery-1.7.2.min.js"></script>
</head>

<body>
<p>${yw}</p>
<p>Your IP: ${address}</p>
<a href="javascript:ajaxTest()">AJAX TEST</a>
<p>$END$</p>
</body>

<script type="text/javascript">
    function ajaxTest() {
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            data: {
                info: "ajaxTest"
            },
            url: "../index/responseTest",
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
