<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<script src="${pageContext.request.contextPath}/boot/js/addScript.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/addStyle.css">
<%--<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
            aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title" id="myModalLabel">Add App</h4>
</div>--%>
<style>
    .title {
        position: relative;
        width: 100%;
        height: 265px;
        background-image: linear-gradient(to left, #feffb7, #8ab9ff);
        text-align: center;
        box-sizing: border-box;
        padding: 70px;
        overflow: hidden;
    }

    .title .name {
        font-size: 36px;
        color: white;
    }

    .title:before {
        content: '';
        display: block;
        width: 150px;
        height: 150px;
        border-radius: 100%;
        position: absolute;
        background-color: rgba(255, 255, 255, 0.2);
        bottom: -55px;
        left: -70px;
    }

    .title .name:after {
        content: '';
        display: block;
        width: 180px;
        height: 180px;
        border-radius: 100%;
        position: absolute;
        background-color: rgba(255, 255, 255, 0.2);
        top: -100px;
        right: -70px;
    }

    .title .name:before {
        content: '';
        display: block;
        width: 260px;
        height: 260px;
        border-radius: 100%;
        position: absolute;
        background-color: rgba(255, 255, 255, 0.2);
        top: -85px;
        right: -85px;
    }

    .add-body {
        margin: -100px auto 0px auto;
        width: 320px;
        height: 480px;
        padding: 15px 0px;
        position: relative;
        box-shadow: 0 0 7px #fdd8ac;
        border-radius: 12px;
        background: white;
    }

    #add_app {
        text-align: center;
    }

    #add_app input {

    }

    #app_add_btn {
        padding: 8px 0px 8px 0px;
        margin-bottom: 10px;
        border-radius: 20px;
        width: 230px;
        color: #000000;
        background-color: #fff463;
        font-size: 14px;
    }

    #app_add_content {
        width: 280px;
    }
</style>
<div class="title">
    <div class="logo">
    </div>
    <p class="name">add</p>
</div>
<div class="add-body">
    <form id="add_app" method="post" enctype="multipart/form-data">
        <div class="container" id="app_add_content">
            <div class="input-group  container-fluid" id="img_div">
            <input type="file" placeholder="img" id="imgFile" name="img">
            <img src="${pageContext.request.contextPath}/images/add_black.png" id="imgShow" class="img-rounded"
                 alt="添加图标">
        </div>
        <br>
            <div class="input-group ">
            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
            <input type="text" class="form-control" placeholder="AppName" id="appName" name="appName">
        </div>

        <br>
            <div class="input-group ">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" placeholder="APP简介" name="about" id="about">
        </div>
        <br>
            <div class="input-group ">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" placeholder="APP作者" name="author" id="author">
        </div>
        <br>
        <div class="row">
            <div class="col-lg-6 col-sm-6 col-xs-6">
                <div class="input-group ">
                    <%--<span class="input-group-addon">status</span>--%>
                    <select class="form-control" name="status" id="status">
                        <option value="0">开发中</option>
                        <option value="1">启用</option>
                        <option value="2">停用</option>
                        <option value="3">维护</option>
                    </select>
                </div>
                <br>
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6 col-sm-6 col-xs-6">
                <div class="input-group ">
                    <%--<span class="input-group-addon">type</span>--%>
                    <select class="form-control" name="type" id="type"
                            onchange="if ($(this).val()==2){$('#href_file_div').show();$('#href_div').hide()}else{$('#href_file_div').hide();$('#href_div').show()} ">
                        <option value="0">内部应用</option>
                        <option value="1">外部链接</option>
                        <option value="2">内部文档</option>
                    </select>
                </div>
                <br>
            </div><!-- /.col-lg-6 -->
        </div><!-- /.row -->
            <div class="input-group " id="href_div">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" placeholder="APP链接" name="href" id="href">
        </div>
        <div id="href_file_div" style="display: none">
            选择上传文档：
            <input type="file" placeholder="APP链接" name="href" id="href_file">
        </div>
        <br>

            <button type="button" class="btn btn-primary "
                    onclick="uploadfile('${pageContext.request.contextPath}'+'')" id="app_add_btn">提交
        </button>
        </div>
    </form>
</div>

