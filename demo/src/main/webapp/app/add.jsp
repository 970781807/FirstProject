<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<script src="${pageContext.request.contextPath}/boot/js/addScript.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/addStyle.css">
<%--<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
            aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title" id="myModalLabel">Add App</h4>
</div>--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/base.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/frozenui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/register.css">

<style>
    #app_add_content {

    }
</style>
<div class="c-title">
    <div class="logo">
    </div>
    <p class="name">add</p>
</div>
<div class="add-body c-login add-some-body">
    <form id="add_app" class="loginForm" method="post" enctype="multipart/form-data">
        <div class="container-fluid" id="app_add_content" style="width: 250px;">
            <img src="${pageContext.request.contextPath}/images/add_black.png" id="imgShow" class="img-rounded"
                 alt="添加图标" rel="添加图标">
            <input type="file" placeholder="img" id="imgFile" name="img">
            <input type="text" class=" userLogo" placeholder="AppName" id="appName" name="appName"
                   lay-verify="required">
            <input type="text" class=" userLogo" placeholder="APP简介" name="about" id="about" lay-verify="required">
            <input type="text" class=" userLogo" placeholder="APP作者" name="author" id="author" lay-verify="required">
            <div class="row">
                <div class="col-lg-6 col-sm-6 col-xs-6">
                    <select class="form-control" name="status" id="status">
                        <option value="1">启用</option>
                        <option value="0">开发中</option>
                        <option value="2">停用</option>
                        <option value="3">维护</option>
                    </select>
                </div><!-- /.col-lg-6 -->
                <div class="col-lg-6 col-sm-6 col-xs-6">
                    <select class="form-control" name="type" id="type"
                            onchange="if ($(this).val()==2){$('#href_file_div').show();$('#href_div').hide()}else if($(this).val()==0){$('#status').val(5);}else{$('#href_file_div').hide();$('#href_div').show()} ">
                        <option value="0">内部应用</option>
                        <option value="1">外部链接</option>
                        <option value="2">内部文档</option>
                    </select>
                </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->
            <div id="href_div">
                <input type="text" class="userLogo" placeholder="APP链接" name="href" id="href">
            </div>
            <div id="href_file_div" style="display: none">
                <input type="file" placeholder="APP链接" name="href" id="href_file">
                <br>
            </div>

            <button type="button" class="btn btn-primary "
                    onclick="" id="app_add_btn">提交
            </button>
        </div>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/boot/js/base.js"></script>
<script>
    $('#app_add_btn').click(function () {
        if (!checkInputFunction($('#app_add_btn'))) {
            return false;
        }
        //下面书写验证成功后执行的内容
        uploadfile('${pageContext.request.contextPath}' + '');
    });
    var width = $(document).width();
    var height = $(document).height();
    var title_logo = $(".c-title .logo")
    if (width <= 768) {
        title_logo.hide();
    } else {
        title_logo.show();
    }

</script>