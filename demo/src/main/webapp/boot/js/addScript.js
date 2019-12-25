function uploadfile(x) {
    var imgdata = document.getElementById("imgFile").files[0];
    var hrefdata = document.getElementById("href_file").files[0];
    if (imgdata == null) {
        showTip.fall("请选择上传图片");
        //alert("请选择上传文件!!!!");

        return;
    }
    var formData = new FormData(); // FormData 对象
    var href = $("#href").val();
    if (href == null || href === undefined || href == "") {
        if (hrefdata == null || hrefdata === undefined) {
            showTip.fall("请添加文件路径");
            return;
        }
    } else {
        formData.append("href", href);
    }
    formData.append("hreffile", hrefdata); // 文件对象
    formData.append("imgfile", imgdata); // 文件对象
    formData.append("appName", $("#appName").val());
    formData.append("about", $("#about").val());
    formData.append("author", $("#author").val());
    formData.append("status", $("#status").val());
    formData.append("type", $("#type").val());
    $.ajax({
        url: x + "/app/add",
        type: "post",
        datatype: "json",
        data: formData,
        processData: false, //formdata已将数据序列化，无需在处理
        contentType: false, //formdata无需设置请求头
        success: function (data) {
            var modal = $("#appModal");
            modal.modal('toggle');
            alert("上传成功!!!");
        }
    })
}

$(function () {
    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        } else {
            window.createObjectURL = undefined;
            window.URL = undefined;
            window.webkitURL = undefined;
            url = getObjectURL(file);
        }
        return url;
    }

    $("#imgShow").click(function () {
        $('#imgFile').click();
    });
    $('#imgFile').change(function () {
        var file = getObjectURL(this.files[0]);
        console.log(file);
        $("#imgShow").prop("src", file);
    })
});