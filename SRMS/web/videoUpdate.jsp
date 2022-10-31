<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <span>视频管理页面 >> 视频编辑页</span>
        </div>
        <div class="providerAdd">
            <form action="videoUpdate" method="post">
                <div class="">
                    <label for="videoId">视频编号：</label>
                    <input type="text" name="vcode" id="videoId" readonly="true" value="${video.getVcode()}" />
                    <span>*这里不可修改</span>
                </div>
                <div>
                    <label for="fileId">文件名称：</label>
                    <input type="text" name="vname" id="fileId"  value="${video.getVname()}"/>
                    <span >*请输入文件名称</span>
                </div>
                <div>
                    <label for="people">文件大小：</label>
                    <input type="text" name="vsize" id="people" readonly="true"  value="${video.getVsize()}"/>
                    <span>*这里不可修改</span>

                </div>
                <div>
                    <label for="fileType">视频分类：</label>
                    <select name="vclass" id="fileType">
                        <option value="">--请选择相应的视频分类--</option>
                        <option value="国产">国产</option>
                        <option value="欧美">欧美</option>
                        <option value="日韩">日韩</option>
                    </select>
                    <span>*请选择视频分类</span>
                </div>
                <div>
                    <label >审核状态：</label>
                    审核通过: <input align="middle" type="radio" name="vstatus"   value="审核通过" />
                    审核未通过: <input align="middle" type="radio" name="vstatus"   value="审核未通过"/>
                    <span>*请输入状态</span>
                </div>
                <div>
                    <label for="uploadTime">上传时间：</label>
                    <input type="date" name="vtime" id="uploadTime"  value="${video.getVtime()}"/>
                    <span>*请输入上传时间</span>
                </div>
                <div>
                    <label for="countId" >浏览数量：</label>
                    <input type="text" name="vview" id="countId"  value="${video.getVview()}"/>
                    <span>*请输入浏览数量</span>
                </div>
                <div class="providerAddBtn">
                    <input id="html_form" type="submit" value="保存"/>
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