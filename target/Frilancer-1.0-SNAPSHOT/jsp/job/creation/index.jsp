<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
    <c:import url="../../static/header.jsp" />
</head>
<body>
<c:if test="${sessionFlag == true}">
    <c:import url="/jsp/static/auth_menu.jsp" />
</c:if>
<c:if test="${sessionFlag != true}">
    <c:import url="/jsp/static/menu.jsp" />
</c:if>
<div class="container">
    <div class="jumbotron">

        <h2 style="margin-top: -5px">Create custom</h2>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <ul class="breadcrumb">
            <li><a href="/untitled/">Frilancer.com</a></li>
            <li class="active">Forum</li>
        </ul>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Creation</b>
                </div>
                <div class="panel-body">
                    <form action="/controller?command=CREATE_CUSTOM" method="post">
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="name">Title:</label>
                                <input type="text" class="form-control" id="name" name="title" placeholder="Enter title">
                                <span id="error_first_name" class="help-block"></span>
                                <!--<label class="control-label">Incorrect email</label>-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <label for="name">Price:</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span><input class="form-control" id="appendedPrependedInput" name="price" size="16" type="number">
                                </div>
                                <span id="error_price" class="help-block"></span>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="sel1">Type:</label>
                                    <select class="form-control" name="type" id="sel1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
                                </div>
                                <span id="error_login" class="help-block"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-10">
                                <div class="form-group">
                                    <label for="comment">Description:</label>
                                    <textarea class="form-control" rows="5" id="comment" name="description"></textarea>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block-xs submit pull-right">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-4 right-sidebar">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Реклама фрилансеров</b>
                </div>
                <div class="panel-body">
                    <c:set var="advertising" value="${advertising}" scope="page"></c:set>
                    <div class="media" style="margin-bottom: 2%">
                        <div class="media-left">
                            <img src="${advertising.imgLink}" class="media-object" style="width:30px">
                        </div>
                        <div class="media-body">
                            <a href="${advertising.frilancerLink}"><h4 class="media-heading">${advertising.frilancerData}</h4></a>
                        </div>
                    </div>
                    ${advertising.description}
                </div>
                <div class="panel-footer">
                    <a href="#">Как разместить здесь рекламу »</a>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">3.5k</p>
                    </div>
                    <b class="h3">Все категории</b>
                </div>
                <div class="panel-body">
                    <c:forEach var="category" items="${categories}">
                        <div class="pull-right hidden-xs">
                            <p class="text-muted">${category.visitingCount}</p>
                        </div>
                        <p><a href="${category.link}">${category.name}</a></p>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <footer class="page_footer" style="margin-bottom: 3%">
        <div class="container">
            <hr style="margin-top: 2%; margin-bottom: 2%">
            <div class="row">
                <div class="col-xs-6 col-sm-4">
                    <div class="spacer-20">
                    <span class="hidden-xs hidden-sm hidden-md">
                        <a href="/untitled/" rel="nofollow">Главная страница</a>
                        <span class="divider text-muted">•</span>
                    </span>
                        <a href="/terms/">Правила сервиса</a>
                        <span class="hidden-xs">
                        <span class="divider text-muted">•</span>
                        <a href="/tariffs/">Тарифы</a>
                    </span>
                    </div>
                </div>
                <div class="col-sm-4 text-center social_links hidden-xs">
                    <div class="text-muted spacer-10 hidden-xs hidden-sm">Присоединяйтесь к нам!</div>
                </div>
                <div class="col-xs-6 col-sm-4 text-right">
                    <div>
                        <a href="/support/">Служба поддержки</a>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 1%">
                <div class="col-xs-6 col-sm-4">
                    © 2016, ООО «Frilancer»
                </div>
                <div class="col-sm-4 text-center social_links hidden-xs">
                    <a href="/untitled/img/social/facebook.png" target="_blank" rel="nofollow"><img src="/untitled/img/social/facebook.png" width="30" height="30" alt="in Facebook"></a>
                    <a href="#" target="_blank" rel="nofollow"><img src="/untitled/img/social/vkontakte.png" width="30" height="30" alt="in ВКонтакте"></a>
                    <a href="#" target="_blank" rel="nofollow"><img src="/untitled/img/social/twitter.jpg" width="30" height="30" alt="in Twitter"></a>
                    <a href="#" target="_blank" rel="nofollow"><img src="/untitled/img/social/google_plus.png" width="30" height="30" alt="in Google+"></a>
                    <a href="#" target="_blank" rel="nofollow"><img src="/untitled/img/social/youtube.png" width="30" height="30" alt="in Youtube"></a>
                </div>
            </div>
        </div>
    </footer>
</div>
<c:import url="../../static/footer.jsp" />
</body>
</html>
