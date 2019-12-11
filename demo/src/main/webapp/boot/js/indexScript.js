var title = $("#navbar-title");
$("#nav-1 a").on("click", function () {
    var position = $(this)
        .parent()
        .position();
    var width = $(this)
        .parent()
        .width();
    var height = $(this)
        .parent()
        .height();
    $("a").removeClass("active");
    $(this).addClass("active");
    $("#nav-1 .slide1").css({opacity: 1, left: +position.left, width: width, top: +position.top, height: height});
    title.html($(this).html());
});

$("#nav-1 a").on("mouseover", function () {
    var position = $(this)
        .parent()
        .position();
    /*    var width = $(this)
            .parent()
            .width();*/
    var width = $(this)
        .parent()
        .width();
    var height = $(this)
        .parent()
        .height();
    $("#nav-1 .slide2")
        .css({
            opacity: 1,
            left: +position.left,
            top: +position.top,
            width: width,
            height: height
        })
        .addClass("squeeze");
});

$("#nav-1 a").on("mouseout", function () {
    $("#nav-1 .slide2")
        .css({opacity: 0})
        .removeClass("squeeze");
});


function f() {
    var currentWidth = $("#nav-1 .nav")
        .find(".active")
        .parent("li")
        .width();
    var currentHeight = $("#nav-1 .nav")
        .find(".active")
        .parent("li")
        .height();
    var current = $(".nav .active").parent().position();
    var currentLeft = current.left;
    var currentTop = current.top;
    $("#nav-1 .slide1").css({left: +currentLeft, width: currentWidth});
    $("#nav-1 .slide1").css({top: +currentTop, height: currentHeight});

}

function buttonsHbox() {
    var width = $(document).width();
    $("#bs-example-navbar-collapse-0").css("display", "none");
    if (width <= 768) {
        $("#button-hbox-father").width(width - 10);
        $("#nav-1 .nav").css("border-radius", 0);
        $("#nav-1 .slide1").css("border-radius", 0);
        $("#nav-1 .slide2").css("border-radius", 0);
        title.css("display", "block");
        title.html($("#nav-1 .nav").find(".active").html());
    } else {
        $("#nav-1 .nav").css("border-radius", "10em");
        $("#nav-1 .slide1").css("border-radius", "10em");
        $("#nav-1 .slide2").css("border-radius", "10em");
        title.css("display", "none");
    }
}

$(window).resize(function () {          //当浏览器大小变化时
    f();
    buttonsHbox();

});


$("#buttons-hbox").on("click", function () {
    var box = $("#bs-example-navbar-collapse-0");
    if ($(box).css("display") === "none") {
        box.show();
        f();
    } else {
        box.hide(500);
    }
});
f();
buttonsHbox();
