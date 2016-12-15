<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Registration</title>
    <c:import url="../static/header.jsp" />
</head>
<body>
<c:import url="../static/menu.jsp" />

<div class="container">
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="panel panel-primary">
                <div class="panel-heading"><h2>Registration on site</h2></div>
                <div class="panel-body">
                    <div class="alert alert-info alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                        <strong>Info!</strong> You can't change your email and login after registration.
                    </div>
                    <form name="loginForm" method="POST" action="<c:url value="/controller"/>">
                        <input type="hidden" name="command" value="REGISTR" />
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
                                <span id="error_first_name" class="help-block">${errorName}</span>
                                <!--<label class="control-label">Incorrect email</label>-->
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="surname">Surname:</label>
                                <input type="text" class="form-control" id="surname" name="surname" placeholder="Enter surname">
                                <span id="error_last_name" class="help-block">${errorSurname}</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-3">
                                <label for="calendar">Birthday:</label>
                                <input type="date" class="form-control" id="calendar" name="birthday" value="1997-06-01"
                                       min="1940-01-01" max="1998-01-01">
                                <span id="error_birthday" class="help-block">${errorBirthday}</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label class="required">Sex</label>
                                <div>
                                    <label class="radio-inline"><input type="radio" name="sex" value="male" checked="">Мужской</label>
                                    <label class="radio-inline"><input type="radio" name="sex" value="female">Женский</label>
                                </div>
                            </div>
                            <div class="form-group col-sm-6">
                                <label class="required">Position</label>
                                <div>
                                    <label class="radio-inline"><input type="radio" name="role" value="customer" checked="">Customer</label>
                                    <label class="radio-inline"><input type="radio" name="role" value="frilancer">Frilancer</label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="login">Login:</label>
                            <input type="text" class="form-control" id="login" name="login" placeholder="Enter login">
                            <span id="error_login" class="help-block" style="color: red">${errorLogin}</span>
                            <!--<label class="control-label">Incorrect email</label>-->
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                            <!--<label class="control-label">Incorrect email</label>-->
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter password">
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="repeatPassword">Repeat:</label>
                                <input type="password" class="form-control" id="repeatPassword" name="repeatPassword" placeholder="Repeat password">
                                <span id="error_second_password" class="help-block">${errorSecondPassword}</span>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary btn-block-xs submit">Submit</button>
                        <hr style="margin-top: 2%; margin-bottom: 2%">
                        <div class="footnote">
                            Регистрируясь в сервисе, Вы принимаете <a href="#">Пользовательское соглашение</a>.
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="../static/footer.jsp" />

</body>
</html>
