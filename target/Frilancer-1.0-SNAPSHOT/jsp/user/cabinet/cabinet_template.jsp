<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
    <c:import url="../../static/header.jsp" />
</head>
<body>
<c:import url="../../static/auth_menu.jsp" />
<div class="container">
    <div class="row">
        <div class="col-sm-9">
            <div class="panel panel-primary">
                <div class="panel-heading"><h2>Your own cabinet</h2></div>
                <c:set var="user" value="${user}" scope="page"></c:set>
                <div class="panel-body">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#menu1">Data</a></li>
                        <li><a data-toggle="tab" href="#menu2">Portfolio && Minds</a></li>
                        <li><a data-toggle="tab" href="#menu3">Orders && messages</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="menu1" class="tab-pane fade in active">
                            <div class="panel-group" style="margin-top: 2%">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" href="#collapse1">Contact data</a>
                                        </h4>
                                    </div>
                                    <div id="collapse1" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-9">
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Email:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${user.email}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Name:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${user.name}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Surname:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${user.surname}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Status:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${user.role}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Средняя цена:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${user.cost}$/h</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Цена от:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${user.costFrom}$</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="col-md-3">
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <div class="thumbnails">
                                                                <img src="${user.imgLink}" style="align-content: center; width: 100px">
                                                                <div class="caption">
                                                                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#pictData">Edit pict</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                            <button type="button" class="btn btn-info btn-lg pull-right" data-toggle="modal" data-target="#contactData">Edit</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" href="#collapse2">More data</a>
                                        </h4>
                                    </div>
                                    <div id="collapse2" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <form class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-2" for="email">Birthday:</label>
                                                    <div class="col-sm-10">
                                                        <p class="form-control-static">${user.birthday}</p>
                                                    </div>
                                                </div>
                                            </form>
                                            <form class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-2" for="email">Country:</label>
                                                    <div class="col-sm-10">
                                                        <p class="form-control-static">${user.country}</p>
                                                    </div>
                                                </div>
                                            </form>
                                            <form class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-2" for="email">Sex:</label>
                                                    <div class="col-sm-10">
                                                        <p class="form-control-static">${user.sex}</p>
                                                    </div>
                                                </div>
                                            </form>
                                            <form class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="control-label col-sm-2" for="email">Description:</label>
                                                    <div class="col-sm-10">
                                                        <p class="form-control-static">${user.description}</p>
                                                    </div>
                                                </div>
                                            </form>
                                            <button type="button" class="btn btn-info btn-lg pull-right" data-toggle="modal" data-target="#moreData">Open Modal</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="menu2" class="tab-pane fade" style="margin-top: 2%">
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" href="#collapse3">Your portfolio</a>
                                        </h4>
                                    </div>
                                    <div id="collapse3" class="panel-collapse collapse">
                                        <div id="myCarousel" class="carousel slide" data-ride="carousel">
                                            <!-- Indicators -->

                                            <ol class="carousel-indicators">
                                                <c:forEach var="project" items="${user.projectInfos}" varStatus="status">
                                                    <li data-target="#myCarousel" data-slide-to="${status.count}" class="active"></li>
                                                </c:forEach>
                                            </ol>


                                            <!-- Wrapper for slides -->
                                            <div class="carousel-inner" role="listbox">
                                                <c:forEach var="project" items="${user.projectInfos}">
                                                    <div class="item active">
                                                        <img src="${project.imgLink}" alt="Chania" style="width: 120px">
                                                        <div class="carousel-caption">
                                                            <h3><a href="#">${project.title}</a></h3>
                                                        </div>
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
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" href="#collapse4">YOur minds</a>
                                        </h4>
                                    </div>
                                    <div id="collapse4" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <c:forEach var="mind" items="${user.minds}">
                                                <div class="row">
                                                    <div class="pull-right hidden-xs" style="margin-right: 2%">
                                                        <p class="text-muted">${mind.time}</p>
                                                    </div>
                                                    <div class="media" style="margin-left: 2%; margin-top: 5px; margin-bottom: 2%">
                                                        <div class="media-left">
                                                            <img src="${mind.author.imgLink}" class="media-object" style="width:70px">
                                                        </div>
                                                        <div class="media-body">
                                                            <a href="#"><h4 class="media-heading">${mind.author.name}</h4></a>
                                                            <p>${mind.author.years}</p>
                                                            <p>${mind.author.dateCreation}</p>
                                                            <a href="#">Minds</a>
                                                        </div>
                                                        <hr style="margin-top: 2%; margin-bottom: 2%">
                                                    </div>

                                                    <h4 class="text-muted" style="margin-left: 2%"><a href="#" >Last work</a> - customer mind</h4>
                                                    <blockquote class="success" style="margin-left: 2%">
                                                        <div class="spoiler">
                                                            ${mind.body}
                                                        </div>
                                                    </blockquote>

                                                </div>
                                                <hr style="margin-top: 2%; margin-bottom: 2%">
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="menu3" class="tab-pane fade" style="margin-top: 2%">
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" href="#collapse5">Orders</a>
                                        </h4>
                                    </div>
                                    <div id="collapse5" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <c:forEach var="order" items="${user.orders}">
                                                <form class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-2" for="email">Order</label>
                                                        <div class="col-sm-10">
                                                            <p class="form-control-static"><a href="#">${order}</a> </p>
                                                        </div>
                                                    </div>
                                                </form>
                                            </c:forEach>
                                            <button type="submit" class="btn btn-primary btn-block-xs submit pull-right">Edit</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" href="#collapse6">Forum themes</a>
                                        </h4>
                                    </div>
                                    <div id="collapse6" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <c:forEach var="message" items="${user.messages}">
                                                <form class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-2" for="email">Order</label>
                                                        <div class="col-sm-10">
                                                            <p class="form-control-static"><a href="#">${message}</a> </p>
                                                        </div>
                                                    </div>
                                                </form>
                                            </c:forEach>
                                            <button type="submit" class="btn btn-primary btn-block-xs submit pull-right">Edit</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

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
        </div>
    </div>

    <!-- Modal -->
    <div id="contactData" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">

                    <form class="form-horizontal" method="POST" action="<c:url value="/controller"/>">
                        <input type="hidden" name="command" value="CHANGE_DATA" />
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Cost:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="cost" name="cost" placeholder="Enter email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">CostF from:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="costFrom" name="costFrom" placeholder="Enter email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="pwd">Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="pwd">Surname:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="surName" name="surname" placeholder="Enter name">
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

    <div id="pictData" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">

                    <form class="form-horizontal" method="POST" action="<c:url value="/pictediting"/>" enctype="multipart/form-data">
                        <input type="hidden" name="command" value="CHANGE_DATA" />
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Picture:</label>
                            <div class="col-sm-10">
                                <input type="file" name="file_to_upload" />

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

    <div id="moreData" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="<c:url value="/controller"/>">
                        <input type="hidden" name="command" value="CHANGE_DATA" />
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Country:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="country" name="country" placeholder="Enter country">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="calendar">Birthday:</label>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" id="calendar" name="birthday" value="1997-06-01"
                                       min="1940-01-01" max="1998-01-01">
                                <span id="error_birthday" class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Пол</label>
                            <div class="col-sm-10">
                                <label class="radio-inline"><input type="radio" name="sex" value="male" checked="">Мужской</label>
                                <label class="radio-inline"><input type="radio" name="sex" value="female">Женский</label>
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

</div>
<c:import url="../../static/footer.jsp" />
</body>
</html>
