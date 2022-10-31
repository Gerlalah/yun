﻿<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> 静态资源后台管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1> 静态资源后台管理系统</h1>

    <div class="publicHeaderR">
        <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;margin-left: -100px;float: left">
            <img style="width: 100%" src="img/head_img.jpeg" alt="头像">
        </div>
        <span style="float: left" ><a href="login.html">退出</a></span>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2019年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">

    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>视频管理页面 >> 视频添加页面</span>
        </div>
        <div class="providerAdd">
            <button>点击跳转页面</button>
           <h2></h2>

        </div>

    </div>

</section>
<footer class="footer">
</footer>

<script src="js/time.js"></script>
<script src="js/jquery.js"></script>
<script>
    $(function () {
        $(".left").load("common_pri.jsp");
    }) ;
</script>
<script>
    var btn = document.querySelector('button');
    var div = document.querySelector('h2');
    btn.addEventListener('click', function () {
        location.href = 'videoList';
    })
    var timer = 5;
    timee();
    setInterval(function () {
        if (timer == 0) {
            location.href = 'videoList';
        }
        else {
            div.innerHTML = '您将在' + timer + '秒钟之后跳转首页';
            timer--;
        }
    }, 1000)
    function timee() {
        if (timer == 0) {
            location.href = 'videoList';
        }
        else {
            div.innerHTML = '您将在' + timer + '秒钟之后跳转首页';
            timer--;
        }
    }
</script>

</body>
</html>