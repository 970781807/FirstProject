function uploadfile(x) {
    var mydata = document.getElementById("imgFile").files[0];
    if (mydata == null) {
        alert("请选择上传文件!!!!");
        return;
    }
    var formData = new FormData(); // FormData 对象
    formData.append("file", mydata); // 文件对象
    formData.append("appName", $("#appName").val());
    formData.append("href", $("#href").val());
    formData.append("about", $("#about").val());
    formData.append("author", $("#author").val());
    formData.append("status", $("#status").val());
    formData.append("type", $("#type").val());
    alert(formData);
    $.ajax({
        url: x + "/app/add",
        type: "post",
        datatype: "json",
        data: formData,
        processData: false, //formdata已将数据序列化，无需在处理
        contentType: false, //formdata无需设置请求头
        success: function (data) {
            var modal = $("#myModal");
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