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
    <c:set var="projectInfo" value="${projectInfo}" scope="page"></c:set>
    <div class="jumbotron">
        <c:set var="pageCreationFlag" value="${pageCreation}" scope="page"/>
        <c:if test="${pageCreationFlag != 1}">
            <c:redirect url="/projectcontrol"></c:redirect>
        </c:if>
        <c:remove var="pageCreationFlag"></c:remove>
        <div class="row">
            <div class="col-sm-8">
                <h2 style="margin-top: -5px">${projectInfo.name}</h2>
            </div>
            <div class="col-sm-4">
                <a href="/jsp/registration" style="width: 100%" class="btn btn-large btn-success"> Set the same custom!</a>
            </div>
        </div>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <div class="text-muted" style="margin-bottom: 2%">
            <a href="#">Веб-программирование</a>
            <span class="divider"> • </span>
            <span>
                                <span data-toggle="tooltip" title="" data-timestamp="1478983442" class="time_ago" data-original-title="12.11.2016 в 22:44">${projectInfo.timeAgo}</span>
                            </span>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-8">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">${projectInfo.timeAgo}</p>
                    </div>
                    <b class="h3">${projectInfo.author.name}, ${projectInfo.author.yearsInService}</b>
                </div>
                <div class="panel-body">
                    ${projectInfo.body}
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Ваша заявка к этому проекту</b>
                </div>
                <div class="panel-body">
                    <a href="/jsp/registration">Войдите в аккаунт</a>, чтобы добавить заявку и открыть данные заказчика.
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Заявки фрилансеров</b>
                </div>
                <div class="panel-body">
                    <c:forEach var="frilancerOrder" items="${projectInfo.frilancersOrders}">
                        <div class="row">
                            <div class="pull-right hidden-xs" style="margin-right: 2%">
                                <p class="text-muted">${frilancerOrder.timeAgo}</p>
                            </div>
                            <div class="media" style="margin-left: 2%; margin-top: 5px; margin-bottom: 2%">
                                <div class="media-left">
                                    <img src="${frilancerOrder.frilancer.imgLink}" class="media-object" style="width:70px">
                                </div>
                                <div class="media-body">
                                    <a href="${frilancerOrder.frilancer.link}"><h4 class="media-heading">${frilancerOrder.frilancer.data}</h4></a>
                                    <p>${frilancerOrder.frilancer.years}</p>
                                    <p>${frilancerOrder.frilancer.yearsInService}</p>
                                    <a href="${frilancerOrder.frilancer.mindsLink}">Minds</a>
                                </div>
                            </div>
                            <span class="text-nowrap top_label_box" style="margin-left: 2%">
                            <span class="label top_label label-default" data-toggle="tooltip" title="" data-original-title="Count of done projects in this">${frilancerOrder.customes}</span>
                            — Веб-программирование
                        </span>

                        </div>
                        <hr style="margin-top: 2%; margin-bottom: 2%">
                    </c:forEach>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Похожие заказы</b>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <h4 class="title">
                                <a href="#">Xml парсер и ресайз картинок</a>
                            </h4>
                            <div class="small text-muted">
                                Есть скрипт каталога ссылок(http://www.full-soft.com), к нему нужно дописать две вещи, 1. xml парсер (для пад-файлов) как на xttp://www.getsomesoft.net/submit.html......т.е. чтобы при указании урла к xml файлу данные из него загонялись в mysql базу+ ...
                            </div>
                        </div>
                    </div>
                    <hr style="margin-top: 2%; margin-bottom: 2%">
                    <div class="row" style="background-color: #F7FAFA">
                        <div class="col-sm-12">
                            <h4 class="title">
                                <a href="#">Xml парсер и ресайз картинок</a>
                            </h4>
                            <div class="small text-muted">
                                Есть скрипт каталога ссылок(http://www.full-soft.com), к нему нужно дописать две вещи, 1. xml парсер (для пад-файлов) как на xttp://www.getsomesoft.net/submit.html......т.е. чтобы при указании урла к xml файлу данные из него загонялись в mysql базу+ ...
                            </div>
                        </div>
                    </div>
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
                    <b class="h3">ТОП-10 фрилансеров</b>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:forEach var="frilancer" items="${frilancerList}" varStatus="status">
                            <li class="list-group-item">${status.count}
                                <a href="${frilancer.link}">${frilancer.name} </a><span class="badge">${frilancer.points}</span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="panel-footer">
                    <a href="/jsp/user">All frilancers</a>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Статистика заказа</b>
                </div>
                <div class="panel-body">
                    <c:set var="stats" value="${stats}" scope="page"></c:set>
                    <p>${stats.orderCount} заявки</p>
                    <p>${stats.viewCount} watches</p>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="../../static/footer.jsp" />
</body>
</html>
