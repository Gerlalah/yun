<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
            <span>图片管理页面</span>
        </div>
        <div class="search">
            <span>搜索条件：</span>
            <input type="text" placeholder="请输入关键字"/>
            <input type="button" value="搜索"/>
            <a href="pictureAdd.jsp">添加图片</a>
        </div>
        <!--图片操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">图片编号</th>
                <th width="15%">图片名称</th>
                <th width="10%">图片分类</th>
                <th width="10%">审核状态</th>
                <th width="10%">上传时间</th>
                <th width="10%">作者</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${picList}" var="pic">
                <tr>
                    <td>${pic.getPcode()}</td>
                    <td>${pic.getPname()}</td>
                    <td>${pic.getPclass()}</td>
                    <td>${pic.getPstatus()}</td>
                    <td>${pic.getPtime()}</td>
                    <td>${pic.getPauthor()}</td>
                    <td>
                        <a href="./pictureView?pcode=${pic.getPcode()}" ><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="./picturUpdateView?pcode=${pic.getPcode()}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="./picDelete?pcode=${pic.getPcode()}" class="deleteVideo"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该图片资源吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>


<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script>
    $(function () {
        $(".left").load("common_pri.jsp");
    }) ;
</script>
</body>
</html>