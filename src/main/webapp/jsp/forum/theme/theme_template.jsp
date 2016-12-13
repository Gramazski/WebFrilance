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
        <c:set var="theme" value="${theme}" scope="page"></c:set>
        <h2 style="margin-top: -5px">${theme.title}</h2>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <ul class="breadcrumb">
            <li><a href="/index.jsp">Frilancer.com</a></li>
            <li><a href="#">Forum</a></li>
            <li><a href="#"> Forum news</a></li>
        </ul>
    </div>

    <div class="panel panel-default">
        <div class="panel-body">
            <c:forEach var="message" items="${theme.messages}">
                <div class="row">
                    <div class="col-sm-3" style="margin-left: 2%; margin-top: 2%">
                        <img src="${message.author}" class="media-object" style="width:100px">
                        <a href="#">${message.author.name}</a>
                        <p>${message.author.dateCreation}</p>
                        <p class="text-muted">3</p>
                    </div>

                    <div class="col-sm-6" style="margin-top: 2%">
                        <p>${message.body}</p>
                    </div>

                    <div class="col-sm-2" style="margin-top: 2%">
                        <div class="pull-right">
                            <p class="text-muted">${message.dateCreation}</p>
                        </div>
                    </div>
                </div>
                <hr style="margin-top: 2%; margin-bottom: 2%">
            </c:forEach>
        </div>
    </div>

</div>
<c:import url="../../static/footer.jsp" />
</body>
</html>
