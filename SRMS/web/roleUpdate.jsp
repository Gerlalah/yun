<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="cn.wolfcode.entity.T_User" %>
<%@ page import="cn.wolfcode.entity.T_Role" %>
<%@ page import="cn.wolfcode.entity.T_priviage" %>
<%@ page import="java.util.List" %>
<%
    //获取session中的用户
    T_User userInfo = (T_User)session.getAttribute("userInfo");
    //获取用户的权限
    List<T_priviage> priList = userInfo.getPriList();
    //判定用户权限中是否包含用户管理模块权限

    request.setCharacterEncoding("UTF-8");
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
            <span>角色管理页面 >> 角色修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="updaterole" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userName">角色名称：</label>
                    <input type="text" name="rid" value="${roleView.rid}" style="display:none;"/>
                    <input type="text" name="rname" placeholder="${roleView.rname}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">角色描述：</label>
                    <input type="text" name="rdesc" id="userAddress" placeholder="${roleView.rdesc}"/>
                </div>
                <div>
                    <label >用户状态：</label>
                    <input type="radio" />停用
                    <input type="radio" checked/>启用
                </div>

                <div class="providerAddBtn">
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
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