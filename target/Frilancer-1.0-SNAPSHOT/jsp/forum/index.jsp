<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Forum</title>
    <c:import url="../static/header.jsp" />
</head>
<body>
<c:import url="../static/menu.jsp" />
<div class="container">
    <div class="jumbotron">
        <c:set var="pageCreationFlag" value="${pageCreation}" scope="page"/>
        <c:if test="${pageCreationFlag != 1}">
            <c:redirect url="/forumcontrol"></c:redirect>
        </c:if>
        <c:remove var="pageCreationFlag"></c:remove>
        <h2 style="margin-top: -5px">Форум фриланс-сообщества</h2>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <ul class="breadcrumb">
            <li><a href="/index.jsp">Frilancer.com</a></li>
            <li><a href="#">Forum</a></li>
            <li class="active">Forum news</li>
        </ul>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-body">
                    <c:forEach var="theme" items="${themes}">
                        <div class="row">
                            <div class="pull-right hidden-xs" style="margin-right: 2%">
                                <p class="text-muted">${theme.timeAgo}</p>
                            </div>
                            <div class="media" style="margin-left: 2%; margin-top: 5px; margin-bottom: 2%">
                                <div class="media-left">
                                    <img src="${theme.imgLink}" class="media-object" style="width:40px">
                                </div>
                                <div class="media-body" style="padding-left: 2%">
                                    <a href="${theme.link}"><h4 class="media-heading">${theme.title}</h4></a>
                                    <p class="text-muted">${theme.messageCount} messages</p>
                                </div>
                            </div>
                        </div>
                        <hr style="margin-top: 2%; margin-bottom: 2%">
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-sm-4 right-sidebar">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3"><a href="#">All themes</a></b>
                </div>
                <div class="panel-body">
                    <c:forEach var="forumTheme" items="${forumStruct}">
                        <p><a href="${forumTheme.link}">${forumTheme.name}</a> </p>
                        <ul>
                            <c:set var="testSubTheme" value="${forumTheme.subThemes}" scope="page"></c:set>
                            <c:if test="${testSubTheme != null}">
                                <c:forEach var="subTheme" items="${forumTheme.subThemes}">
                                    <li>
                                        <a href="${subTheme.link}">${subTheme.name}</a>
                                        <span class="badge pull-right">${subTheme.messageCount}</span>
                                    </li>
                                </c:forEach>
                            </c:if>
                        </ul>
                    </c:forEach>
                </div>
            </div>
            <div class="panel panel-default">
                <form>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search theme">
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
