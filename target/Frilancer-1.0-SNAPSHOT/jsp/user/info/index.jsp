<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
    <c:import url="../../static/header.jsp" />
</head>
<body>
<c:import url="../../static/menu.jsp" />
<div class="container">
    <div class="jumbotron">
        <c:set var="pageCreationFlag" value="${pageCreation}" scope="page"/>
        <c:if test="${pageCreationFlag != 1}">
            <c:redirect url="/personaluser"></c:redirect>
        </c:if>
        <c:remove var="pageCreationFlag"></c:remove>
        <c:set var="user" value="${curUser}" scope="page"></c:set>
        <div class="row">
            <div class="col-sm-8">
                <div class="media" style="margin-left: 2%; margin-top: 5px; margin-bottom: 2%">
                    <div class="media-left">
                        <img src="${user.imgLink}" class="media-object" style="width:50%">
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">${user.name}</h4></a>
                        <p class="text-muted">${user.years}
                            <br>
                            ${user.dateCreation}
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
            <li class="active">Information</li>
        </ul>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4 col-md-3" style="border-right: 1px solid #F1F1F1; margin-top: -5px">
                            <div class="main_stats" >
                                <div class="h3">${user.points}</div>
                                <div class="text-muted">по оценкам заказчиков</div>
                            </div>
                            <div class="main_stats">
                                <div class="h3">100%</div>
                                <div class="text-muted">заказчиков рекомендуют</div>
                            </div>
                            <div class="main_stats">
                                <div class="h3">29%</div>
                                <div class="text-muted">заявок приняты заказчиками</div>
                            </div>
                        </div>
                        <div class="col-sm-8 col-md-9">
                            <div class="pull-right small text-muted hidden-xs">Статистика фрилансера за год</div>
                            <div class="top_freelancer">
                                <span class="text-nowrap top_label_box">
                                    <span class="label top_label label-default" data-toggle="tooltip" title="" data-original-title="24-й в каталоге фрилансеров">1</span>
                                    — Веб-программирование
                                </span>
                            </div>
                            <div class="top_freelancer">
                                <span class="text-nowrap top_label_box">
                                    <span class="label top_label label-default" data-toggle="tooltip" title="" data-original-title="24-й в каталоге фрилансеров">2</span>
                                    — OS working
                                </span>
                            </div>
                            <div class="top_freelancer">
                                <span class="text-nowrap top_label_box">
                                    <span class="label top_label label-default" data-toggle="tooltip" title="" data-original-title="24-й в каталоге фрилансеров">1</span>
                                    — Web-administrating
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">About Frilancer</b>
                </div>
                <div class="panel-body">
                    <p>${user.description}</p>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <a href="#">All works</a>
                    </div>
                    <b class="h3">Portfolio</b>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <c:forEach var="userWork" items="${user.projectInfos}">

                            <div class="col-md-4">
                                <div class="thumbnail">
                                    <a href="#" target="_blank">
                                        <img src="${userWork.imgLink}" alt="1" style="width:100%; height: 150px">
                                        <p>${userWork.title}</p>
                                    </a>
                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
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
</div>
<c:import url="../../static/footer.jsp" />
</body>
</html>
