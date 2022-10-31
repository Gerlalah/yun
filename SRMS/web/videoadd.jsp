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
    <div class="left">

    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>视频管理页面 >> 视频添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="videoadd" method="post" enctype="multipart/form-data">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label >视频编码：</label>

                        <input type="file" name="myfile" value="选择文件"/>


                </div>
                <div>
                    <label >视频：</label>
                    <select name="vclass" >
                        <option value="">--请选择相应的视频分类--</option>
                        <option value="国产">国产</option>
                        <option value="欧美">欧美</option>
                        <option value="日韩">日韩</option>
                    </select>
                    <span>*请选择视频</span>
                </div>

                <div class="providerAddBtn">
                    <input type="submit" value="提交" />
                    <input type="button" value="返回" onclick="window.open('picList')"/>
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