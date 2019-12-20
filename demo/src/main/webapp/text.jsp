<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%--<script src="//cdn.ckeditor.com/4.13.1/standard/ckeditor.js"></script>--%>
</head>
<body>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
            aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title" id="myModalLabel">Add App</h4>
</div>
<div class="modal-body">
    <form>
        <input type="text" id="content" name="content">
        <input type="button" value="保存" id="save" onclick="save()"/>
    </form>
</div>
<div id="editor">

</div>
<script>
    $(function () {
        CKEDITOR.replace('content', {
            customConfig: "${pageContext.request.contextPath}/ckeditor/config.js"
        });
    });

</script>
</body>
</html>