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
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="userAdd" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="ok">
                    <label for="userId">用户编码：</label>
                    <input type="text" name="ucode" id="userId"/>
                    <span>*请输入用户编码，且不能重复</span>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="uname" id="userName"/>
                    <span >*请输入用户名称</span>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="text" name="upwd" id="userPassword"/>
                    <span>*密码长度必须小于20位</span>

                </div>
                <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="text" name="userRemi" id="userRemi"/>
                    <span>*请输入确认密码</span>
                </div>
                <div>
                    <label >用户性别：</label>

                    <select name="usex">
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="ubirthday" id="data"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userPhone">用户电话：</label>
                    <input type="text" name="uphone" id="userPhone"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="uaddress" id="userAddress"/>
                </div>
                <div>
                    <label >用户类别：</label>
<!--                    <input type="radio" name="userlei"/>管理员-->
                    <input type="radio" name="rid" id="super"  value="1"/>超级管理员
                    <input type="radio" name="rid" id="lowSuper"  value="2"/>系统管理员
                    <input type="radio" name="rid" id="VIP"  value="3"/>VIP玩家
                    <input type="radio" name="rid" id="normal"  value="4"/>普通玩家

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存" onclick="history.back(-1)"/>
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
        $(".left").load("common_pri.html");
    }) ;
</script>
</body>
</html>