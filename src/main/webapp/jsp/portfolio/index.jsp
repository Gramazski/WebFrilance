<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
    <c:import url="/jsp/static/header.jsp" />
</head>
<body>
<c:set var="sessionFlag" value="${sessionFlag}" scope="session"></c:set>
<c:if test="${sessionFlag == true}">
    <c:import url="/jsp/static/auth_menu.jsp" />
</c:if>
<c:if test="${sessionFlag != true}">
    <c:import url="/jsp/static/menu.jsp" />
</c:if>
<br/>
<div class="container">
    <div class="jumbotron">
        <h1>Frilancers portfolio</h1>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <c:if test="${sessionFlag == true}">
            <div class="row">
                <div class="col-sm-4">
                    <a href="#pictData" style="width: 100%" class="btn btn-large btn-success" data-toggle="modal" data-target="#pictData"> Add project</a>
                </div>
            </div>
        </c:if>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <a href="#">${frilancerWorks.size()}</a>
                    </div>
                    <b class="h3">All frilancers works</b>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <c:forEach var="frilancerWork" items="${frilancerWorks}" >
                            <div class="col-md-4">
                                <div class="thumbnail">
                                    <a href="/projectcontrol?title=${frilancerWork.title}" target="_blank">
                                        <img src="${frilancerWork.imgLink}" alt="1" style="width:100%; height: 150px">
                                        <div class="caption">
                                            <p>${frilancerWork.title}</p>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
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
                    <a href="/jsp/user/">All frilancers</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="pictData" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add project</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" method="POST" action="/addproject" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Picture:</label>
                        <div class="col-sm-10">
                            <input type="file" name="file_to_upload" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Title:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="country" name="title" placeholder="Enter title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="comment">Description:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="5" id="comment" name="description"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default pull-right">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>

<c:import url="/jsp/static/footer.jsp" />
</body>
</html>