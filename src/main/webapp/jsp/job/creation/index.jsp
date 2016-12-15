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
                                        <option>Web-programming</option>
                                        <option>OS programming</option>
                                        <option>Web administrating</option>
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
                    <b class="h3">Frilancer Advertising</b>
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
            </div>
        </div>
    </div>
</div>
<c:import url="../../static/footer.jsp" />
</body>
</html>
