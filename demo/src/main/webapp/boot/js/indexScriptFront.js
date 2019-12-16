function apps(a) {
    $.ajax({
        url: a,
        type: "post",
        datatype: "json",
        success: function (data) {
            var list = $(".AppList");
            list.empty();
            $.each(data.data, function (index, value) {
                var div = $("<div class='col-xs-6 col-sm-4 col-md-3 col-lg-2'><a href='" + value.href + "' class='thumbnail imglist'><img src='" + value.img + "' alt='" + value.appName + "' class='img-rounded'><p class='img-test'>" + value.appName + " </p></a></div>");
                list.append(div);
            });
            buttonsHbox();
        }
    });
}