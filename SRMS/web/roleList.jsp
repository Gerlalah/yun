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



    for(T_priviage pri:priList){
        if(pri.getPname().equals("角色管理")){
            //获取这个模块权限对应的按钮级的权限
            List<T_priviage> son = pri.getPriList();
            //有了这个按钮级别的权限-做个标志
            //遍历
            for(T_priviage sonPri:son){
                //判定是否存在该按钮级别权限
                if(sonPri.getPname().equals("角色管理_查询")){
                    //设置
                    pageContext.setAttribute("role_select",true);
                    pageContext.setAttribute("role_select_url",sonPri.getPurl());
                }
                if(sonPri.getPname().equals("角色管理_编辑")){
                    //设置
                    pageContext.setAttribute("role_edit",true);
                }
                if(sonPri.getPname().equals("角色管理_新增")){
                    //设置
                    pageContext.setAttribute("role_add",true);
                }
                if(sonPri.getPname().equals("角色管理_详情")){
                    //设置
                    pageContext.setAttribute("role_details",true);
                }
                if(sonPri.getPname().equals("角色管理_删除")){
                    //设置
                    pageContext.setAttribute("role_delete",true);
                }
            }
            //结束
            continue ;
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
                <span>角色管理页面</span>
            </div>
            <div class="search">
                <span>查询条件：</span>
                <c:if test="${role_select}">
                    <form method="post" action="${role_select_url}">
                        <input type="text" name="rname" placeholder="请输入关键字"/>
                        <input type="submit" data-ajax="post" data-callback="success" value="查询"/>
                    </form>
                </c:if>

                <c:if test="${role_add}">
                    <a href="roleAdd.jsp">新增角色</a>
                </c:if>
            </div>
            <!--角色-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">角色编号</th>
                    <th width="15%">角色名称</th>
                    <th width="15%">权限</th>
                    <th width="15%">操作</th>
                </tr>
                 <c:forEach items="${roles}" var="role">
                    <tr >
                        <td>${role.rid}</td>
                        <td>${role.rname}</td>
                        <td>权限</td>
                        <td>
                            <c:if test="${role_details}">
                            <a href="#" onclick="detailsRole(${role.rid})"><img src="img/read.png" alt="查看" title="查看"/></a>
                            </c:if>
                            <c:if test="${role_edit}">
                            <a href="#" onclick="updatebeforeRole(${role.rid})"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                            </c:if>
                            <c:if test="${role_delete}">
                            <a href="#" class="removeRole" onclick="deleteRole(${role.rid})"><img src="img/schu.png" alt="删除" title="删除"/></a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeRe">
    <div class="removerChid">
        <form action="deleterole" method="post">
            <h2>提示</h2>
            <div class="removeMain">
                <p>你确定要删除该角色吗？</p>
                <a href="#" id="no" onclick="deleteRoleSubmit()">确定</a>
                <a href="#" id="no">取消</a>
            </div>
        </form>
    </div>
</div>

<form action="deleterole" method="post" id="deleterole">
</form>

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