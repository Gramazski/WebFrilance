<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
    <c:import url="../static/header.jsp" />
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
        <c:set var="pageCreationFlag" value="${pageCreation}" scope="page"/>
        <c:if test="${pageCreationFlag != 1}">
            <c:redirect url="/jobcontrol"></c:redirect>
        </c:if>
        <c:remove var="pageCreationFlag"></c:remove>
        <div class="row">
            <div class="col-sm-8">
                <h2 style="margin-top: -5px">Удаленная работа для фрилансеров</h2>
            </div>
            <div class="col-sm-4">
                <c:if test="${sessionFlag == true}">
                    <a href="/jsp/job/creation/" style="width: 100%" class="btn btn-large btn-success"> Set custom!</a>
                </c:if>
                <c:if test="${sessionFlag != true}">
                    <a href="/jsp/registration/" style="width: 100%" class="btn btn-large btn-success"> Set custom!</a>
                </c:if>

            </div>
        </div>

        <hr style="margin-top: 2%; margin-bottom: 2%">
        <ul class="breadcrumb">
            <li><a href="/index.jsp">Main</a></li>
            <li class="active">Удаленная работа</li>
        </ul>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-body">
                    <c:forEach var="jobForFrilancer" items="${jobsForFrilancer}" varStatus="status">
                        <div class="row">
                            <div class="col-sm-7" style="margin-top: -10px; padding-bottom: 20px">
                                <h4>
                                    <a href="/custom?projectInfo=${jobForFrilancer.name}">${jobForFrilancer.name}</a>
                                </h4>
                            </div>
                            <div class="col-sm-2" style="color: red">
                                    ${jobForFrilancer.price}$
                            </div>
                            <div class="col-sm-3 text-right text-nowrap hidden-xs">
                                    0 заявок
                            </div>
                            <div class="col-xs-12" style="margin-top: -10px; margin-bottom: -10px">
                                    ${jobForFrilancer.body}
                            </div>
                            <div class="col-xs-12 text-muted" style="margin-top: 2%">
                                <a class="text-muted" href="#">${jobForFrilancer.type}</a>
                                <span class="divider">•</span>
                                <span>
                                <span data-toggle="tooltip" title="" data-timestamp="1478983442" class="time_ago" data-original-title="">${jobForFrilancer.timeAgo}</span>
                            </span>
                                <span class="divider">•</span>
                                    ${jobForFrilancer.type}
                            </div>
                        </div>
                        <hr style="margin-top: 2%; margin-bottom: 2%">
                    </c:forEach>
                </div>
                <div class="panel-footer">
                    <ul class="pagination pagination-lg">
                        <li><a href="#">Previous</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-4 right-sidebar">
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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">117</p>
                    </div>
                    <b class="h3">Все заказы</b>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:forEach var="project" items="${projectsList}" varStatus="status">
                            <li class="list-group-item">
                                <a href="${project.link}">${project.name} </a><span class="badge">${project.points}</span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <p class="text-muted">500</p>
                    </div>
                    <b class="h3">Открытые</b>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:forEach var="project" items="${projectsGeneralList}" varStatus="status">
                            <li class="list-group-item">
                                <a href="${project.link}">${project.name} </a><span class="badge">${project.points}</span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="panel panel-default">
                <form>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search customs">
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

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 style="text-align: center">Frilancer.com — лучший русскоязычный сайт для удаленной работы</h3>
                </div>
                <div class="panel-body">
                    <p>В последние годы удаленная работа через интернет стала одинаково выгодна и фрилансерам, и заказчикам, а в виртуальном пространстве появилось множество сервисов и бирж для поиска вакансий в других городах и странах. В нашем сервисе собраны свежие вакансии в сфере айдентики, администрирования, бухгалтерии, программирования и других популярных направлений фриланса.</p>
                    <p style="margin-top: 2%">Работа фрилансером в интернете часто оказывается выгодной и для сотрудников, и для работодателя, и лучшее доказательство этому — огромное количество вакансий.</p>
                    <p style="margin-top: 2%">Фрилансеры могут рассчитывать на получение высокооплачиваемой удаленной работы, находясь в России, Беларуси, Украине, Казахстане и других странах мира. Удаленная работа через интернет позволяет самостоятельно планировать график выполнения заданий, регулировать уровень занятости, а сервисы и биржи предоставляют множество привлекательных вакансий.</p>
                    <p style="margin-top: 2%">В нашем сервисе собраны свежие вакансии, которые позволят удаленно участвовать в работе над высокооплачиваемыми проектами. Выбор в пользу фриланса позволит вам в полной мере проявить талант переводчика, дизайнера, администратора сайта или специалиста по продвижению сайтов. Регулярное обновление базы заказов для фрилансеров дает возможность найти работу через интернет без утомительного отслеживания предложений на сайтах и биржах.</p>
                    <p style="margin-top: 2%">Заказчики, которые пользуются услугами нашего сервиса, уже успели оценить простоту и удобство поиска удаленных сотрудников. В каталоге фрилансеров зарегистрировано более 100 000 квалифицированных специалистов из Украины, России и других стран СНГ, которые готовы выполнять большие объемы работ через интернет. Если вам необходимо воспользоваться услугами профессионалов в области SEO, веб-программирования, инжиниринга, анимации и других, достаточно подать заявку и выбрать лучшего исполнителя.</p>
                </div>
            </div>
        </div>

    </div>
</div>
<c:import url="../static/footer.jsp" />
</body>
</html>
