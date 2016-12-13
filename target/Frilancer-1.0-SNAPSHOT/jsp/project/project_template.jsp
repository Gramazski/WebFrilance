<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
    <c:import url="../static/header.jsp" />
</head>
<body>
<c:import url="../static/menu.jsp" />
<div class="container">
    <div class="jumbotron">
        <c:set var="project" value="${project}" scope="page"></c:set>
        <div class="row">
            <div class="col-sm-8">
                <div class="media" style="margin-left: 2%; margin-top: 5px; margin-bottom: 2%">
                    <div class="media-left">
                        <img src="/untitled/img/avatars/my_own.jpg" class="media-object" style="width:70px">
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">${project.frilancer.name}</h4></a>
                        <p class="text-muted">${project.frilancer.years}
                            <br>
                            ${project.frilancer.dateCreation}
                            <br>
                            <a href="#">Minds</a>
                        </p>

                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <a href="/untitled/pages/registration/" style="width: 100%" class="btn btn-large btn-success"> Advise custom</a>
                <a href="/untitled/pages/registration/" style="width: 100%; margin-top: 3%" class="btn btn-large btn-primary"> Write a message</a>
            </div>
        </div>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <ul class="breadcrumb">
            <li><a href="/untitled/">Frilancer.com</a></li>
            <li><a href="#">Frilancer</a></li>
            <li><a href="#">Portfolio</a></li>
            <li class="active">Project</li>
        </ul>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">${project.name}</b>
                </div>
                <div class="panel-body">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <c:forEach var="image" items="${project.images}" varStatus="status">
                                <li data-target="#myCarousel" data-slide-to="${status.count}" class="active"></li>
                            </c:forEach>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <c:forEach var="image" items="${project.images}">
                                <div class="item active">
                                    <img src="${image}" alt="Chania">
                                </div>
                            </c:forEach>
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="panel-footer">
                    <p>${project.description}</p>
                </div>
            </div>
            <div class="panel panel-default">
                <c:set var="mind" value="${project.frilancer.minds.get(0)}" scope="page"></c:set>
                <div class="panel-heading">
                    <div class="pull-right hidden-xs" style="margin-right: 2%">
                        <a href="#">All minds</a>
                    </div>
                    <b class="h3">Last mind</b>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="pull-right hidden-xs" style="margin-right: 2%">
                            <p class="text-muted">${mind.time}</p>
                        </div>
                        <div class="media" style="margin-left: 2%; margin-top: 5px; margin-bottom: 2%">
                            <div class="media-left">
                                <img src="${mind.author.imgLink}" class="media-object" style="width:70px">
                            </div>
                            <div class="media-body">
                                <a href="#"><h4 class="media-heading">${mind.author.name}</h4></a>
                                <p>${mind.author.years}</p>
                                <p>${mind.author.dateCreation}</p>
                                <a href="#">Minds</a>
                            </div>
                            <hr style="margin-top: 2%; margin-bottom: 2%">
                        </div>

                        <h4 class="text-muted" style="margin-left: 2%"><a href="#" >Last work</a> - customer mind</h4>
                        <blockquote class="success" style="margin-left: 2%">
                            <div class="spoiler">
                                ${mind.author.body}
                            </div>
                        </blockquote>

                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4 right-sidebar">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Information</b>
                </div>
                <div class="panel-body">
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">200</p>
                    </div>
                    <p><a href="#">Customs</a></p>

                    <div class="pull-right hidden-xs">
                        <p class="text-muted">50</p>
                    </div>
                    <p><a href="#">Portfolio</a></p>
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">120</p>
                    </div>
                    <p><a href="#">Prices</a></p>
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">504</p>
                    </div>
                    <p><a href="#">Minds</a></p>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">View contact data</b>
                </div>
                <div class="panel-body">
                    <a href="/untitled/pages/registration/" style="width: 100%" class="btn btn-large btn-success"> Advise custom</a>
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
<c:import url="../static/footer.jsp" />
</body>
</html>
