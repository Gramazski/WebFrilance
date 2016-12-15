<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel-body">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#menu1">Data</a></li>
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
                            <button type="button" class="btn btn-info btn-lg pull-right" data-toggle="modal" data-target="#moreData">Edit</button>
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
                            <a data-toggle="collapse" href="#collapse5">Customs</a>
                        </h4>
                    </div>
                    <div id="collapse5" class="panel-collapse collapse">
                        <div class="panel-body">
                            <c:forEach var="custom" items="${customs}" varStatus="status">
                                    <div class="panel panel-default">
                                        <div class="panel panel-heading">
                                            <h4 class="panel-title">
                                                <c:set var="collapseVar" value="${status.count}"></c:set>
                                                <a data-toggle="collapse" href="#order${collapseVar}">Customs</a>
                                            </h4>
                                        </div>
                                        <div id="order${collapseVar}" class="panel-collapse collapse">
                                            <div class="panel panel-body">
                                                <form class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="control-label col-sm-2" for="email">Custom</label>
                                                        <div class="col-sm-10">
                                                            <p class="form-control-static"><a href="#">${custom.name}</a> </p>
                                                        </div>
                                                    </div>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Price:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${custom.price}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Type:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${custom.type}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Status:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${custom.condition}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-2" for="email">Description:</label>
                                                            <div class="col-sm-10">
                                                                <p class="form-control-static">${custom.body}</p>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    <hr style="margin-top: 2%; margin-bottom: 2%">
                                                    <c:forEach var="order" items="${custom.frilancersOrders}">
                                                        <c:set var="customName" value="${custom.name}" scope="session"></c:set>
                                                    <form class="form-horizontal">
                                                        <div class="form-group">
                                                            <label class="control-label col-sm-3" for="email">Frilancer:</label>
                                                            <a class="col-sm-3" href="/personaluser?login=${order.frilancer.login}">${order.frilancer.login}</a>
                                                            <div class="col-sm-6">
                                                                <button type="submit" class="btn btn-primary btn-block-xs submit pull-right"><a href="/controller?command=UPDATE_FRILANCER&custom=${custom.name}&frilancer=${order.frilancer.login}">Accept</a> </button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                    </c:forEach>
                                                    <button type="button" class="btn btn-info btn-lg pull-right" style="margin-top: 2%" data-toggle="modal" data-target="#editCustom">Edit</button>
                                            </div>
                                        </div>
                                    </div>

                                </form>

                                <hr style="margin-top: 2%; margin-bottom: 2%">
                            </c:forEach>
                            <button type="button" class="btn btn-info btn-lg pull-right" style="margin-top: 2%" data-toggle="modal" data-target="#deleteCustom">Delete</button>
                            <a href="/jsp/job/creation" class="btn btn-large btn-success" style="margin-top: 2%"> Advise custom</a>
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
