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
                <c:set var="role" value="${user.role}" scope="page"></c:set>
                <c:if test="${role == 'customer'}">
                    <c:import url="../../dynamic/customer_cabinet.jsp"></c:import>
                </c:if>
                <c:if test="${role != 'customer'}">
                    <c:import url="../../dynamic/frilancer_cabinet.jsp"></c:import>
                </c:if>
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

    <div id="editCustom" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit custom</h4>
                </div>
                <div class="modal-body">
                    <c:set var="customsSize" value="${customs.size()}" scope="page"></c:set>
                    <c:if test="${customsSize != 0}">
                        <form class="form-horizontal" method="POST" action="/controller?command=UPDATE_CUSTOM&custom=${customs.get(0).name}">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Price:</label>
                                <div class="col-sm-10">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span><input class="form-control" id="appendedPrependedInput" name="price" size="16" type="number">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Type:</label>
                                <div class="col-sm-10">
                                    <select class="form-control" name="type" id="sel1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Description:</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" id="comment1" name="description"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default pull-right">Submit</button>
                                </div>
                            </div>
                        </form>
                    </c:if>

                </div>
            </div>
        </div>
    </div>

    <div id="deleteCustom" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit custom</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="/controller?command=DELETE_CUSTOM">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="comment">Custom:</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="custom" name="custom" size="16" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default pull-right">Delete</button>
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
