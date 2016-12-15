<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
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
        <c:set var="project" value="${projectInfo}" scope="page"></c:set>
        <div class="row">
            <div class="col-sm-8">
                <div class="media" style="margin-left: 2%; margin-top: 5px; margin-bottom: 2%">
                    <div class="media-left">
                        <img src="${project.frilancer.imgLink}" class="media-object" style="width:70px">
                    </div>
                    <div class="media-body">
                        <a href="#"><h4 class="media-heading">${project.frilancer.name}</h4></a>
                        <p class="text-muted">${project.frilancer.years}
                            <br>
                            ${project.frilancer.dateCreation}
                            <br>
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
                    <b class="h3">${project.title}</b>
                </div>
                <div class="panel-body">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <c:forEach var="image" items="${project.imgLink}" varStatus="status">
                                <li data-target="#myCarousel" data-slide-to="${status.count}" class="active"></li>
                            </c:forEach>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <c:forEach var="image" items="${project.imgLink}">
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

        </div>
        <div class="col-sm-4 right-sidebar">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Information</b>
                </div>
                <div class="panel-body">
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">2</p>
                    </div>
                    <p><a href="#">Customs</a></p>

                    <div class="pull-right hidden-xs">
                        <p class="text-muted">1</p>
                    </div>
                    <p><a href="#">Portfolio</a></p>
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">4</p>
                    </div>
                    <p><a href="#">Prices</a></p>
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">2</p>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">View contact data</b>
                </div>
                <div class="panel-body">
                    <a href="/jsp/registration/" style="width: 100%" class="btn btn-large btn-success"> Advise custom</a>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="../static/footer.jsp" />
</body>
</html>
