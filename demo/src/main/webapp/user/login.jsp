<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/frozenui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/base.css"/>

</head>
<body>

<div class="c-title ">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/images/tip.png" width="42" height="32" alt="">
    </div>
    <p class="name">登录
    </p>
</div>

<div class="c-login add-some-body">
    <br>
    <form class="loginForm " id="loginFrom">
        <input type="text" class="userLogo" placeholder="请输入用户名或手机" lay-verify="required" name="str"/>
        <input type="password" placeholder="请输入密码" lay-verify="required" name="password"/>
        <input type="button" value="登录" id="log_btn"/>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/boot/js/base.js"></script>
<script type="text/javascript">
    /**
     * 配置验证须知
     * 1、要引入jquery.js、base.js、base.css
     * 2、提交按钮应在<form></form>内部
     * 3、在要验证的input中写上lay-verify="验证方法名|验证方法名" 可写多个但要用|分隔开
     * 4、要添加验证方法可在base.js中添加
     * 5、诺只想引用提示弹出：showTip.success("弹出提示内容");、showTip.fall("弹出提示内容")
     * 6、base.css中可以自行修改弹窗样式
     */
    $('#log_btn').click(function () {
        if (!checkInputFunction($('#log_btn'))) {
            return false;
        }
        var fromData = $("#loginFrom").serialize();
        $.ajax({
            url: "${pageContext.request.contextPath}/user/login",
            type: "post",
            dataType: "json",
            data: fromData,
            success: function (data) {
                if (data.code == 500)
                    alert("error");
                else {
                    var modal = $("#appModal");
                    modal.modal('toggle');
                    showTip.success("success");
                    window.location.reload();
                }


            }
        })
        //下面书写验证成功后执行的内容
    });
</script>

</body>
</html>

