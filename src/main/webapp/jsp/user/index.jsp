<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users</title>
    <c:import url="../static/header.jsp" />
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
        <c:set var="pageCreationFlag" value="${pageCreation}" scope="page"/>
        <c:if test="${pageCreationFlag != 1}">
            <c:redirect url="/usercontrol"></c:redirect>
        </c:if>
        <c:remove var="pageCreationFlag"></c:remove>
        <h2 style="margin-top: -5px">Все фрилансеры</h2>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <ul class="breadcrumb">
            <li><a href="../">Frilancer.com</a></li>
            <li class="active">Frilancers</li>
        </ul>
    </div>

    <div class="row">
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-body">
                    <c:forEach var="user" items="${users}" varStatus="status">
                        <div class="row">

                            <div class="col-sm-2">
                                <img src="${user.imgLink}" class="media-object" style="width: 120px; height: 150px">
                                <c:if test="${sessionFlag != true}">
                                    <a href="#" style="width: 120px; margin-top: 2%" class="btn btn-large btn-success">Recruit</a>
                                </c:if>
                            </div>

                            <div class="col-sm-10">
                                <div class="row">
                                    <div class="col-sm-9">
                                        <div class="row">
                                            <div class="col-sm-9">
                                                <a href="/personaluser?login=${user.login}"><h4 class="media-heading">${user.name}</h4></a>
                                                <p class="text-muted">${user.years}
                                                    <br>
                                                    ${user.dateCreation}
                                                    <br>
                                                    <a href="#"><span class="badge">2</span> Minds</a>
                                                </p>
                                            </div>
                                            <div class="col-sm-3">
                                                <p style="color: red">${user.cost}$/hour</p>
                                                <p class="text-muted">from ${user.costFrom}$</p>
                                            </div>
                                        </div>
                                        <h3 style="border-left: 3px solid green">${user.description}</h3>
                                    </div>

                                    <div class="col-sm-3">
                                        <div class="pull-right">
                                            <p class="text-muted">${status.count} place</p>
                                        </div>
                                    </div>

                                    <div class="row" style="margin-top: 5%">
                                    <c:forEach var="userWork" items="${user.projectInfos}">

                                        <div class="col-md-4">
                                            <div class="thumbnail">
                                                <a href="#" target="_blank">
                                                    <img src="${userWork.imgLink}" alt="1" style="width:100%; height: 100px">
                                                </a>
                                            </div>
                                        </div>

                                    </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr style="margin-top: 2%; margin-bottom: 2%">
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-sm-3 right-sidebar">
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
            <div class="panel panel-default">
                <form>
                    <div class="input-group" style="width: 100%">
                        <input type="text" class="form-control" placeholder="Search frilancer">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<c:import url="../static/footer.jsp" />
</body>
</html>
