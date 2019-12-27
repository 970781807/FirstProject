var DATA = null;
var Xhref = null;
function apps(a, b) {//a为href b为方式 ：0-显示 1-remove 2-reseton
    Xhref = a;
    if (DATA === null) {
        upDATA(a, b);
    } else {
        setApp(a, b);
    }


}

function logout() {
    $.ajax({
        url: Xhref + "/user/logout",
        type: "post",
        dataType: "json",
        success: function (data) {
            if (data.code == 200) {
                alert("已退出登录!!!");
                //刷新页面
                window.location.reload();
            }
        }
    })
}
function upDATA(a, b) {
    $.ajax({
        url: a + "/app/showAll",
        type: "post",
        datatype: "json",
        success: function (data) {
            var list = $(".AppList");
            list.empty();
            DATA = data.data;
            setApp(a, b);
        }
    });
}

function setApp(href, setw) {
    var list = $(".AppList");
    list.empty();
    $.each(DATA, function (index, value) {
        if (isshowwhitch(setw, value)) {
            var a = $("<a>");
            var img = $("<img src='" + value.img + "' alt='" + value.appName + "' class='img-rounded'>")
            var p = $("<p class='img-test'>").append(value.appName);
            var div = $("<div class='col-xs-6 col-sm-4 col-md-3 col-lg-2'>");
            a.addClass("thumbnail").addClass("imglist");
            a.prop("href", value.href);
            //展示
            if (setw === 0) {
                if (value.type === 1) {//外部链接
                    a.prop("target", "_blank");
                    a.prop("href", "https://" + value.href);
                } else if (value.type === 0) {//内部应用
                    a.prop("data-toggle", "modal");
                    a.prop("data-target", "#myModal");
                    a.prop("href", "javascript:app_load('" + value.href + "')");
                } else if (value.type === 2) {//文档类
                    a.prop("data-toggle", "modal");
                    a.prop("data-target", "#myModal");
                    a.prop("href", "javascript:document_load('" + value.href + "','" + value.appName + "',true)");
                } else {
                }
            }
            //remove
            else if (setw === 1) {
                a.prop("href", "javascript:remove('" + value.id + "','" + href + "')");
                img.css("border", "2px solid #ea7063");
            }
            //reseton
            else if (setw === 2) {
                a.prop("href", "javascript:reseton('" + value.id + "','" + href + "')");
                img.css("border", "2px solid #000000");
            }
            a.append(img);
            a.append(p);

            div.append(a);

            list.append(div);
        }

    });
    buttonsHbox();
}

function isshowwhitch(c, value) {
    if (c === 0) {
        if (value.status === 1 || value.status === 5) return true
    } else if (c === 1) {
        if (value.status >= 0 && value.status <= 3) return true;
    } else if (c === 2) {
        if (value.status === 4) return true;
    } else return null;
    return false;
}


function remove(id, href) {
    $.ajax({
        url: href + "/app/remove",
        data: {"id": id},
        dataType: "json",
        type: "post",
        success: function (data) {
            if (data.code === 500) return;
            upDATA(href, 1);
        }
    })
}

function reseton(id, href) {
    $.ajax({
        url: href + "/app/reseton",
        data: {"id": id},
        dataType: "json",
        type: "post",
        success: function (data) {
            if (data.code === 500) return;
            upDATA(href, 2);
        }
    })
}

function app_load(href) {
    var modal = $("#appModal");
    modal.modal('toggle');
    modal.load(href);
}

function document_load(href, title, size) {
    var modal = $("#myModal");
    modal.modal('toggle');
    $("#myModalLabel").html(title);
    $("#myModal .modal-body").load(href);
    modal_size(size);
}

function modal_size(size) {
    var modal = $("#myModal");
    var myModal_dialog = $("#myModal-dialog");
    if (size == null) {
        if (modal.hasClass("bs-example-modal-lg")) {
            myModal_dialog.removeClass("modal-lg");
            modal.removeClass("bs-example-modal-lg");
        } else if (modal.hasClass("bs-example-modal-sm")) {
            modal.removeClass("bs-example-modal-sm");
            myModal_dialog.removeClass("modal-sm");
        }
    } else if (size) {//大
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