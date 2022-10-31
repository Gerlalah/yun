<%@ page import="java.util.List" %>
<%@ page import="cn.wolfcode.entity.T_User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ucode = request.getParameter("ucode");
    T_User user = new T_User();
    List<T_User> users = (List<T_User>) request.getSession().getAttribute("users");
    for (T_User item : users) {
        if (ucode.equals(item.getUcode()))
        {
            user = item;
            /*String ubirthday = user.getUbirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date bir = sdf.parse(ubirthday);
            String now_ =sdf.format(new Date()) ;
            Date now = sdf.parse(now_);
            Integer year = Math.toIntExact((now.getTime() - bir.getTime()) / (24 * 60 * 60 * 1000 * 12));
            pageContext.setAttribute("year",year);*/
            pageContext.setAttribute("user",user);
            break;
        }
    }

%>
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
    <div class="left"></div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${user.ucode}</span></p>
            <p><strong>用户名称：</strong><span>${user.uname}</span></p>
            <p><strong>用户性别：</strong>
                <c:if test="${user.usex==1}">
                    <span>男</span>
                </c:if>
                <c:if test="${user.usex==0}">
                    <span>女</span>
                </c:if>
            </p>
            <p><strong>出生日期：</strong><span>${user.ubirthday}</span></p>
            <p><strong>用户电话：</strong><span>${user.uphone}</span></p>
            <p><strong>用户地址：</strong><span>${user.uaddress}</span></p>
            <p><strong>用户类别：</strong>
                <c:if test="${user.rid==1}">
                    <span>超级管理员</span>
                </c:if>
                <c:if test="${user.rid==2}">
                    <span>系统管理员</span>
                </c:if>
                <c:if test="${user.rid==3}">
                    <span>VIP玩家</span>
                </c:if>
                <c:if test="${user.rid==4}">
                    <span>普通玩家</span>
                </c:if>
            </p>
            <p><strong>用户状态：</strong>
                <c:if test="${user.ustatus}==1">
                    <span>启动</span>
                </c:if>
                <c:if test="${user.ustatus}==0">
                    <span>禁用</span>
                </c:if>
            </p>
            <a href="userList.jsp">返回</a>
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
</body>
</html>