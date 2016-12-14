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
                        <img src="${message.author.imgLink}" class="media-object" style="width:100px">
                        <a href="#">${message.author.login}</a>
                        <p>${message.author.dateCreation}</p>
                        <p class="text-muted">3</p>
                    </div>

                    <div class="col-sm-6" style="margin-top: 2%">
                        <p>${message.imgLink}</p>
                    </div>

                    <div class="col-sm-2" style="margin-top: 2%">
                        <div class="pull-right">
                            <p class="text-muted">${message.timeAgo}</p>
                        </div>
                    </div>
                </div>
                <hr style="margin-top: 2%; margin-bottom: 2%">
            </c:forEach>
            <c:if test="${sessionFlag != false}">
                <hr style="margin-top: 2%; margin-bottom: 2%">
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-8">
                        <form class="form-horizontal" method="POST" action="/message?theme=${theme.title}">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Message:</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" id="comment" name="description"></textarea>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-default pull-right">Submit</button>
                        </form>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

</div>
<c:import url="../../static/footer.jsp" />
</body>
</html>
