<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="boot/css/indexStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script src="boot/js/jquery.min.js"></script>
    <script src="boot/js/bootstrap.min.js"></script>
    <script src="boot/js/indexScriptFront.js"></script>

</head>
<body>
<div class="container-fluid">
    <!--title-->
    <!--导航栏-->
    <nav class="navbar navbar-default" id="window-title">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div id="nav-1" class="nav-1 ">
            <div class="navbar-header " id="button-hbox-father">
                <button type="button" id="buttons-hbox" class="navbar-toggle collapsed"
                        data-target="#bs-example-navbar-collapse-0" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand " href="#" id="navbar-title"></a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-0">
                <ul class="nav navbar-nav">
                    <li class="slide1"></li>
                    <li class="slide2"></li>
                    <li><a class="active" href="javascript:void(0);"
                           onclick="apps('${pageContext.request.contextPath}',0)" id="AppHOME">HOME</a></li>
                    <li><a href="javascript:void(0);" onclick="apps('${pageContext.request.contextPath}',1)"
                           id="AppREMOVE">删除模式</a></li>
                    <li><a href="javascript:void(0);" onclick="apps('${pageContext.request.contextPath}',0)"
                           id="AppCONTROLLER">控制台</a></li>
                    <li><a href="javascript:void(0);" onclick="apps('${pageContext.request.contextPath}',2)"
                           id="AppRECYCLE">回收站</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <hr>

    <!--app-->
    <div class="container-fluid" id="home-body">

        <div class="row">
            <div class="col-md-1 col-lg-1"></div>
            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 AppList">


                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="#" class="thumbnail imglist">
                        <img src="images/logo.png" alt="Website" class="img-rounded">
                        <p class="img-test ">Website</p>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="#" class="thumbnail  imglist">
                        <img src="images/github.png" alt="Github" class="img-rounded">
                        <p class="img-test ">Github</p>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="#" class="thumbnail  imglist">
                        <img src="images/email.png" alt="Contact me" class="img-rounded">
                        <p class="img-test ">Contact me</p>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="#" class="thumbnail  imglist">
                        <img src="images/tip.png" alt="About me" class="img-rounded">
                        <p class="img-test ">About me</p>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="#" class="thumbnail  imglist">
                        <img src="images/javascript.jpg" alt="More" class="img-rounded">
                        <p class="img-test ">More</p>
                    </a>
                </div>


            </div>

            <div class="col-md-1 col-lg-1"></div>


        </div>
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" id="myModal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">

            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="appModal" tabindex="-1" role="dialog" aria-labelledby="appModalLabel">
</div>
<script src="boot/js/indexScript.js"></script>


</body>
</html>