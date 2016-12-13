<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Authorization</title>
    <c:import url="../static/header.jsp" />
</head>
<body>
<c:import url="../static/menu.jsp" />
<div class="container">
    <h2 style="text-align: center">Quick Enter</h2>
    <div class="row">
        <div class="col-sm-4">
            <a href="#" style="width: 100%" class="btn btn-large btn-primary"><img src="/img/social/vkontakte.png" width="30" height="30" style="padding-bottom: 5px"> VKontakte</a>
        </div>
        <div class="col-sm-4">
            <a href="#" style="width: 100%" class="btn btn-large btn-primary"><img src="/img/social/facebook.png" width="30" height="30" style="padding-bottom: 5px"> Facebook</a>
        </div>
        <div class="col-sm-4">
            <a href="#" style="width: 100%" class="btn btn-large btn-primary"><img src="/img/social/twitter.jpg" width="30" height="30" style="padding-bottom: 5px"> Twitter</a>
        </div>
    </div>

    <h2 style="text-align: center; margin-top: 10%">Enter</h2>
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <form role="form" action="/controller" method="post">
                <input type="hidden" name="command" value="LOGIN" />
                <div class="form-group">
                    <label for="username"><span class="glyphicon glyphicon-user"></span> Username</label>
                    <input type="text" class="form-control input-lg" id="username" name="login" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                    <input type="text" class="form-control input-lg" id="psw" name="password" placeholder="Enter password">
                </div>
                <div class="checkbox">
                    <label><input type="checkbox" value="" checked>Remember me</label>
                </div>
                <button type="submit" class="btn btn-large btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
            </form>
        </div>
    </div>
    <hr style="margin-top: 2%; margin-bottom: 2%">
    <h3 style="text-align: center; margin-top: 2%"><p>Not a member? <a href="/jsp/registration/">Sign Up</a></p>
        <p>Forgot <a href="#">Password?</a></p></h3>
</div>
<c:import url="../static/footer.jsp" />
</body>
</html>
