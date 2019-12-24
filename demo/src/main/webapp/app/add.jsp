<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<script src="${pageContext.request.contextPath}/boot/js/addScript.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/addStyle.css">
<%--<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
            aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title" id="myModalLabel">Add App</h4>
</div>--%>
<div class="modal-body">
    <form id="add_app" method="post" enctype="multipart/form-data">
        <div class="input-group input-group-lg container-fluid" id="img_div">
            <input type="file" placeholder="img" id="imgFile" name="img">
            <img src="${pageContext.request.contextPath}/images/add_black.png" id="imgShow" class="img-rounded"
                 alt="添加图标">
        </div>
        <br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
            <input type="text" class="form-control" placeholder="AppName" id="appName" name="appName">
        </div>

        <br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" placeholder="APP简介" name="about" id="about">
        </div>
        <br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" placeholder="APP作者" name="author" id="author">
        </div>
        <br>
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">status</span>
                    <select class="form-control" name="status" id="status">
                        <option value="0">开发中</option>
                        <option value="1">启用</option>
                        <option value="2">停用</option>
                        <option value="3">维护</option>
                    </select>
                </div>
                <br>
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">type</span>
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
        <div class="input-group input-group-lg" id="href_div">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" placeholder="APP链接" name="href" id="href">
        </div>
        <div id="href_file_div" style="display: none">
            选择上传文档：
            <input type="file" placeholder="APP链接" name="href" id="href_file">
        </div>
        <br>

        <button type="button" class="btn btn-primary btn-lg btn-block"
                onclick="uploadfile('${pageContext.request.contextPath}'+'')">提交
        </button>
    </form>
</div>

