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
                                            <label class="control-label col-sm-2" for="email">Avarage cost:</label>
                                            <div class="col-sm-10">
                                                <p class="form-control-static">${user.cost}$/h</p>
                                            </div>
                                        </div>
                                    </form>
                                    <form class="form-horizontal">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="email">Cost from:</label>
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
                            <button type="button" class="btn btn-info btn-lg pull-right" data-toggle="modal" data-target="#moreData">Edit</button>
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
                                            <img src="${mind.title}" class="media-object" style="width:70px">
                                        </div>
                                        <div class="media-body">
                                            <a href="#"><h4 class="media-heading">${mind.author}</h4></a>
                                            <p>${mind.time}</p>
                                        </div>
                                        <hr style="margin-top: 2%; margin-bottom: 2%">
                                    </div>

                                    <h4 class="text-muted" style="margin-left: 2%"><a href="#" >Last work</a> - ${mind.mark}</h4>
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
                                        <label class="control-label col-sm-2" for="email">Theme</label>
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
