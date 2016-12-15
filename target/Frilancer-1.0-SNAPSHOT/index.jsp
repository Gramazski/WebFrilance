<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Index page</title>
    <c:import url="jsp/static/header.jsp" />
</head>
<body>
<c:set var="sessionFlag" value="${sessionFlag}" scope="session"></c:set>
<c:if test="${sessionFlag == true}">
    <c:import url="jsp/static/auth_menu.jsp" />
</c:if>
<c:if test="${sessionFlag != true}">
    <c:import url="jsp/static/menu.jsp" />
</c:if>
<br/>
<div class="container">
    <div class="jumbotron">
        <h1>Welcome to Frilance.com</h1>
        <div class="tab-content">
            <c:set var="pageCreationFlag" value="${pageCreation}" scope="page"/>
            <c:if test="${pageCreationFlag != 1}">
                <c:redirect url="/main"></c:redirect>
            </c:if>
            <c:remove var="pageCreationFlag"></c:remove>
            <c:forEach var="tabPane" items="${tabPaneList}">
                <div id="<c:out value="${tabPane.id}"></c:out>" class="${tabPane.divClass}">
                    <h3>${tabPane.title}</h3>
                    <p>${tabPane.body}</p>
                </div>
            </c:forEach>
        </div>

        <ul class="nav nav-pills">
            <c:forEach var="tabPane" items="${tabPaneList}">
                <li class="${tabPane.liClass}"><a data-toggle="pill" href="#${tabPane.id}">${tabPane.liName}</a></li>
            </c:forEach>
        </ul>
        <hr style="margin-top: 2%; margin-bottom: 2%">
        <c:if test="${sessionFlag != true}">
            <div class="row">
                <div class="col-sm-4">
                    <a href="/jsp/registration/" style="width: 100%" class="btn btn-large btn-success"> Come on!</a>
                </div>
            </div>
        </c:if>
    </div>

    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <a href="#">All news</a>
                    </div>
                    <c:set var="someNews" value="${someNews}" scope="page"></c:set>
                    <b class="h3">${someNews.title}</b>
                </div>
                <div class="panel-body">
                    <div class="pull-right text-muted top_right_box">
                        <span data-toggle="tooltip" title="" data-timestamp="1478855729" class="time_ago" data-original-title="${someNews.totalTime}">${someNews.timeAgo}</span>
                    </div>
                    ${someNews.body}
                    <a class="text-nowrap" href="#" rel="nofollow">Read more →</a>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <a href="/projects">All frilancers works</a>
                    </div>
                    <b class="h3">New works</b>
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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <a href="/jsp/job/">All orders</a>
                    </div>
                    <b class="h3">Recommended</b>
                </div>
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
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="pull-right hidden-xs">
                        <a href="/jsp/forum/">All forums themes</a>
                    </div>
                    <b class="h3">Themes on forum</b>
                </div>
                <div class="panel-body">
                    <c:forEach var="forumTheme" items="${forumThemes}">
                        <div class="pull-right">
                            <p class="text-muted">${forumTheme.timeAgo}</p>
                        </div>
                        <div class="media">
                            <div class="media-left">
                                <img src="${forumTheme.imgLink}" class="media-object" style="width:40px">
                            </div>
                            <div class="media-body">
                                <a href="/theme?theme=${forumTheme.title}"><h4 class="media-heading">${forumTheme.title}</h4></a>
                                <p class="text-muted">${forumTheme.messageCount}</p>
                            </div>
                        </div>
                        <hr style="margin-top: 2%; margin-bottom: 2%">
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-sm-4 right-sidebar">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Advertising</b>
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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Frilancers TOP</b>
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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b class="h3">Stats</b>
                </div>
                <div class="panel-body">
                    <c:set var="stats" value="${stats}" scope="page"></c:set>
                    <p><kbd>${stats.open}</kbd></p>
                    <p class="text-muted">opened</p>
                    <p><kbd>${stats.complete}</kbd></p>
                    <p class="text-muted">closea</p>
                    <p><kbd>${stats.users}</kbd></p>
                    <p class="text-muted">services</p>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 style="text-align: center">Frilancer.com — the best site for frilance</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-6">
                    <h4 style="text-align: center">Для тех, кому нужен специалист (фрилансер)</h4>
                    <p>У нас вы можете найти лучших фриланс специалистов среди 1 млн исполнителей, зарегистрированных на сайте Frilancer.com. Программисты, юристы, бухгалтеры, инженеры, фотографы - тысячи удаленных сотрудников по любым freelance специализациям.</p>
                    <p style="margin-top: 2%">Вам достаточно опубликовать проект, конкурс или вакансию - и заинтересованные фрилансеры сами предложат свои услуги, помогут вам сформировать задание, определить бюджет и сроки выполнения работы. Останется только выбрать лучшего исполнителя из числа откликнувшихся фриланс специалистов и начать с ним сотрудничество.</p>
                    <p style="margin-top: 2%">Если же совсем нет времени на проекты, вы можете быстро найти и заказать нужную услугу (с фиксированной ценой и сроком выполнения) в нашем каталоге услуг. А также выбрать удаленных специалистов в каталоге, оценив их портфолио с представленными работами - и в 2 клика предложить заказ.</p>
                    <p style="margin-top: 2%">Frilancer.com за безопасность freelance сотрудничества! Используйте наш сервис "Безопасная сделка" с резервированием суммы на сайте для сотрудничества с фрилансерами - и мы гарантируем вам возврат средств, если работа будет выполнена некачественно и/или не в срок.</p>
                    <p style="margin-top: 2%">Хороших вам исполнителей!</p>
                    <c:if test="${sessionFlag != true}">
                        <div class="row">
                            <div class="col-sm-4">
                                <p style="text-align: center"><a class="btn btn-success" role="button" href="/jsp/registration/">Опубликовать проект и найти специалиста</a></p>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="col-sm-6">
                    <h4 style="text-align: center">Тем, кто ищет работу на дому (фрилансерам)</h4>
                    <p>Для вас ежедневно свыше 1500 фриланс проектов, конкурсов и вакансий с поиском исполнителей. Если вы ищете удаленную работу фрилансером и умеете создавать сайты, писать тексты, администрировать, консультировать, оказывать freelance услуги на дому - добро пожаловать на сайт Frilancer.com.</p>
                    <p style="margin-top: 2%">Начиная работу с нашим сайтом, вам прежде всего необходимо заполнить портфолио фрилансера, добавив примеры успешно выполненных вами проектов и заказов. Указать в профиле всю необходимую информацию о своих навыках и опыте, добавить контактные данные.</p>
                    <p style="margin-top: 2%">Фрилансерам для получения работы рекомендуем регулярно просматривать ленту проектов, отвечая на подходящие вам предложения - в случае заинтересованности заказчики обязательно предложат вам сотрудничество по freelance проектам с дальнейшим выполнением работы.</p>
                    <p style="margin-top: 2%">Чтобы повысить шансы получить работу, также рекомендуем фрилансеру оформить и добавить на сайт все свои услуги, описав их и указав стоимость и срок выполнения того или иного объема работ. И не забудьте приобрести аккаунт PRO - сервис, который значительно расширит возможности вашего фриланс профиля и поможет привлечь еще больше выгодных заказов.</p>
                    <p style="margin-top: 2%">Успешного поиска работы!</p>
                    <c:if test="${sessionFlag != true}">
                        <p style="text-align: center"><a class="btn btn-success" role="button" href="/jsp/registration/">Стать фрилансером и найти работу</a></p>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="/jsp/static/footer.jsp" />
</body>
</html>