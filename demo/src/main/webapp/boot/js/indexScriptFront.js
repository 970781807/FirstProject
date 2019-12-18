function apps(a) {
    $.ajax({
        url: a,
        type: "post",
        datatype: "json",
        success: function (data) {
            var list = $(".AppList");
            list.empty();
            $.each(data.data, function (index, value) {
                var a = $("<a href='" + value.href + "' class='thumbnail imglist'>");
                var img = $("<img src='" + value.img + "' alt='" + value.appName + "' class='img-rounded'>")
                var p = $("<p class='img-test'>").append(value.appName);
                var div = $("<div class='col-xs-6 col-sm-4 col-md-3 col-lg-2'>");
                a.append(img);
                a.append(p);
                if (value.type === 1) {
                    a.prop("target", "_blank");
                }
                if (value.type === 2) {
                    console.log(value.type);
                    a.prop("data-toggle", "modal");
                    a.prop("data-target", "#myModal");
                }
                div.append(a);

                list.append(div);
            });
            buttonsHbox();
        }
    });
}

function app_load(x) {
    var modal = $("#myModal");
    modal.modal('toggle');
    $("#myModal .modal-body").load(x);
}