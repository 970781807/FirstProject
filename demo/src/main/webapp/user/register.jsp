﻿<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
    <title>jQuery橙色注册表单验证代码 - 站长素材</title>
    <link rel="stylesheet" href="../boot/css/frozenui.css">
    <link rel="stylesheet" href="../boot/css/register.css">
    <link rel="stylesheet" href="../boot/css/base.css"/>

</head>
<body>

<div class="c-title">
    <div class="logo">
        <img src="img/login-alipay.png" width="42" height="32" alt="">
    </div>
    <p class="name">某某某某</p>
</div>

<div class="c-login">
    <h1>注册</h1>
    <form class="loginForm">
        <input type="text" class="userLogo" placeholder="请输入用户名" lay-verify="required|userName" name="username"/>
        <input type="text" placeholder="请输入手机号码" lay-verify="phone" name="phone"/>
        <input type="text" class="codeText" placeholder="请输入验证密码" lay-verify="required" name="code"/>
        <input type="button" class="codeBtn" value="获取验证码" id="code_btn"/>
        <!--<input type="text" class="userLogo" placeholder="请输入邮箱" lay-verify="email" />-->
        <input type="password" placeholder="请输入密码" lay-verify="required"/>
        <input type="password" placeholder="请输入确认密码" lay-verify="required"/>
        <input type="button" value="注册" id="reg_btn"/>
    </form>
</div>

<script type="text/javascript" src="../boot/js/jquery.min.js"></script>
<script type="text/javascript" src="../boot/js/base.js"></script>
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

    $('#reg_btn').click(function () {
        if (!checkInputFunction($('#reg_btn'))) {
            return false;
        }
        $.ajax({})
        //下面书写验证成功后执行的内容
    });
</script>

</body>
</html>

