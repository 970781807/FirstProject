function apps(a) {
    $.ajax({
        url: a,
        type: "post",
        datatype: "json",
        success: function (data) {
            var list = $(".AppList");
            list.empty();
            $.each(data.data, function (index, value) {
                var a = $("<a>");
                var img = $("<img src='" + value.img + "' alt='" + value.appName + "' class='img-rounded'>")
                var p = $("<p class='img-test'>").append(value.appName);
                var div = $("<div class='col-xs-6 col-sm-4 col-md-3 col-lg-2'>");
                a.addClass("thumbnail").addClass("imglist");
                a.prop("href", value.href);
                a.append(img);
                a.append(p);
                if (value.type === 1) {
                    a.prop("target", "_blank");
                    a.prop("href", value.href);
                } else if (value.type === 0) {
                    a.prop("data-toggle", "modal");
                    a.prop("data-target", "#myModal");
                    a.prop("href", "javascript:app_load('" + value.href + "','" + value.appName + "')");
                } else if (value.type === 2) {
                    a.prop("data-toggle", "modal");
                    a.prop("data-target", "#myModal");
                    a.prop("href", "javascript:app_load('" + value.href + "','" + value.appName + "',true)");
                } else {
                }
                div.append(a);

                list.append(div);
            });
            buttonsHbox();
        }
    });
}

function app_load(href, title, z) {
    var modal = $("#myModal");
    modal.modal('toggle');
    $("#myModalLabel").html(title);
    $("#myModal .modal-body").load(href);
    var myModal_dialog = $("#myModal-dialog");
    if (z == null) {
        if (modal.hasClass("bs-example-modal-lg")) {
            myModal_dialog.removeClass("modal-lg");
            modal.removeClass("bs-example-modal-lg");
        } else if (modal.hasClass("bs-example-modal-sm")) {
            modal.removeClass("bs-example-modal-sm");
            myModal_dialog.removeClass("modal-sm");
        }
    } else if (z) {//大
        if (modal.hasClass("bs-example-modal-lg")) return;
        else if (modal.hasClass("bs-example-modal-sm")) {
            modal.removeClass("bs-example-modal-sm");
            myModal_dialog.removeClass("modal-sm");
        }
        modal.addClass("bs-example-modal-lg");
        myModal_dialog.addClass("modal-lg");
    } else {//小
        if (modal.hasClass("bs-example-modal-sm")) return;
        else if (modal.hasClass("bs-example-modal-lg")) {
            myModal_dialog.removeClass("modal-lg");
            modal.removeClass("bs-example-modal-lg");
        }
        myModal_dialog.addClass("modal-sm");
        modal.addClass("bs-example-modal-sm");
    }
}