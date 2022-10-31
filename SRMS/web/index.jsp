<%--
  Created by IntelliJ IDEA.
  User: LuoTianYang
  Date: 2022/8/11
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title> 静态资源后台管理系统主页</title>
  <link rel="stylesheet" href="css/public.css"/>
  <link rel="stylesheet" href="css/style.css"/>
  <script src="js/jquery.js"></script>
  <script src="js/js.js"></script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
  <h1> 静态资源后台管理系统</h1>

  <div class="publicHeaderR">
    <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;margin-left: -100px;float: left">
      <img style="width: 100%" src="img/head_img.jpeg" alt="头像">
    </div>
    <span style="float: left" ><a href="password.jsp" style="width:90px">修改密码</a></span>
    <span style="float: left" ><a href="login.html">退出</a></span>
  </div>
</header>
<!--时间-->
<section class="publicTime">
  <span id="time">2019年1月1日 11:11  星期一</span>

</section>
<!--主体内容-->
<section class="publicMian">
  <div class="left">

  </div>
  <div class="right">
    <img class="wColck" src="img/clock.jpg" alt=""/>
    <div class="wFont">
      <h2>${userInfo.uname}</h2>
      <p>欢迎来到 静态资源后台管理系统!</p>
      <span id="hours"></span>
    </div>
  </div>
</section>
<script src="js/time.js"></script>
<footer class="footer">
</footer>

<script>
  $(function () {
    $(".left").load("common_pri.jsp");
  }) ;
</script>
</body>
</html>
