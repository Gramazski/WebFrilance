<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Help</title>
    <c:import url="../static/header.jsp" />
</head>
<body>
<c:import url="../static/menu.jsp" />
<div class="container">
    <div class="jumbotron">
        <h1>Start work!</h1>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">General information</b>
                </div>
                <div class="panel-body">
                    <ul>
                        <li><a href="/untitled/pages/help/how-to-find-worker/">How to find frilancer</a></li>
                        <li><a href="#">How to find work</a></li>
                    </ul>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Start working in service</b>
                </div>
                <div class="panel-body">
                    <ul>
                        <li><a href="#">Register and auth in service</a></li>
                        <li><a href="#">Repair entering</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-4 right-sidebar">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Start work</b>
                </div>
                <div class="panel-body">
                    <p><a href="#">For customer</a></p>
                    <p><a href="#">For frilancer</a></p>
                    <p><a href="#">Safe job</a></p>
                    <p><a href="#">Manage your account</a></p>
                    <p><a href="#">Arbitr</a></p>
                </div>
            </div>
            <div class="panel panel-default">
                <form>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search in help">
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
