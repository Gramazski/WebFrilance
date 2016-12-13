package servlets;

import entity.jsp.main.advertising.AdvertisingFrilancerClass;
import entity.jsp.main.forum.ForumThemeClass;
import entity.jsp.main.frilancer.FrilancerTopClass;
import entity.jsp.main.job.JobForFrilancerClass;
import entity.jsp.main.news.NewsClass;
import entity.jsp.main.stats.ServiceStatsClass;
import entity.jsp.main.title.PageTitleClass;
import entity.jsp.main.title.PageTitleList;
import entity.jsp.main.work.FrilancerWorkClass;
import validator.session.SessionValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        createJumbotronTitle(req);
        createNewsPanel(req);
        createFrilancerWorkPanel(req);
        createJobPanel(req);
        createForumThemesPanel(req);
        createFrilancerAdvertising(req);
        createFrilancerTop(req);
        createServiceStats(req);
        req.setAttribute("pageCreation", 1);
        req.setAttribute("sessionFlag", SessionValidator.isValidSession(req));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        createJumbotronTitle(req);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        //super.doPost(req, resp);
    }

    private void createJumbotronTitle(HttpServletRequest request){
        ArrayList<PageTitleClass> tabPaneList = new ArrayList<PageTitleClass>();
        PageTitleList pageTitleList = new PageTitleList();
        pageTitleList.add(new PageTitleClass("welcome", "Биржа фриланса для работы онлайн", "tab-pane fade in active",
                "Добро пожаловать на сайт фрилансеров!\n" +
                        "                    Наш сервис — популярная биржа удаленной работы.\n" +
                        "                    Множество заказчиков и фрилансеров уже зарегистрированы здесь.", "active", "Welcome"));
        pageTitleList.add(new PageTitleClass("for_customer", "Лучшие фрилансеры для ваших заказов", "tab-pane fade",
                "Вам нужны исполнители на вакансии или проекты?\n" +
                        "                    Множество специалистов ждут ваших заказов на нашей бирже.\n" +
                        "                    Разместите заказ и найдите фрилансеров для реализации ваших идей прямо сейчас!",
                "", "For customer"));
        pageTitleList.add(new PageTitleClass("for_frilancer", "Работа для фрилансеров", "tab-pane fade",
                "Вам нужна удаленная работа?\n" +
                        "                    Зарегистрируйтесь, разместите портфолио и откликайтесь на заказы.\n" +
                        "                    Получите ваш первый фриланс-заказ уже сегодня!", "", "For customer"));

        request.setAttribute("tabPaneList", pageTitleList);
    }

    private void createNewsPanel(HttpServletRequest request){
        NewsClass newsClass = new NewsClass("Тарифный план на 3-6 месяцев со скидкой",
                "Возвращена возможность активации тарифного плана на период больше месяца.<br>\n" +
                "                    При активации на 3 месяца предоставляется скидка&nbsp;5%, на 6 месяцев —&nbsp;10%.",
                "18 дней назад" , "11.11.2016 в 11:15");

        request.setAttribute("someNews", newsClass);
    }

    private void createFrilancerWorkPanel(HttpServletRequest request){
        ArrayList<FrilancerWorkClass> frilancerWorkClasses = new ArrayList<FrilancerWorkClass>();

        frilancerWorkClasses.add(new FrilancerWorkClass("#", "/img/works/music_site.jpg", "Pulpit Rock", "Good site on Node.js about music!"));
        frilancerWorkClasses.add(new FrilancerWorkClass("#", "/img/works/frontend.jpg", "Pulpit Rock", "Good site on Node.js about music!"));
        frilancerWorkClasses.add(new FrilancerWorkClass("#", "/img/works/java_site.jpg", "Pulpit Rock", "Lorem ipsum donec id elit non."));
        frilancerWorkClasses.add(new FrilancerWorkClass("#", "/img/works/js_scripts.jpg", "Pulpit Rock", "Good site on Node.js about music!"));

        request.setAttribute("frilancerWorks", frilancerWorkClasses);
    }

    private void createJobPanel(HttpServletRequest request){
        ArrayList<JobForFrilancerClass> jobForFrilancerClasses = new ArrayList<JobForFrilancerClass>();
        jobForFrilancerClasses.add(new JobForFrilancerClass("#", "Программист в Игровой проект на постоянную удаленную работу", "$1500", "5 заявок",
                "В команду из 6 программистов нужен сотрудник на постоянную основу для разработки и улучшения имеющихся игровых проектов связанных со Steam, WoT и E-commerce. 2+ млн посещаемости ежемесячно насчитывает...",
                "Веб-программирование", "#", "12.11.2016 в 22:44", "16 дней назад", "вакансия"));
        jobForFrilancerClasses.add(new JobForFrilancerClass("#", "Статьи про самостоятельное оформление тур. и миграционных документов", "", "18 заявок",
                "На сайт для самостоятельных путешественников и мигрантов нужны статьи про: визы, загранпаспорта, миграционные карты, ВНЖ, гражданство и так далее. Всего около 500 статей. Особое внимание уделяется дос...",
                "Копирайтинг", "#", "12.11.2016 в 22:44", "16 дней назад", ""));

        request.setAttribute("jobsForFrilancer", jobForFrilancerClasses);
    }

    private void createForumThemesPanel(HttpServletRequest request){
        ArrayList<ForumThemeClass> forumThemeClasses = new ArrayList<ForumThemeClass>();
        forumThemeClasses.add(new ForumThemeClass("#", "Сколько будет стоить CMS?)", "1 час назад",
                "9 сообщений", "/img/forum/themes/java_vs_sharp.jpg"));
        forumThemeClasses.add(new ForumThemeClass("#", "Раскрутка сайта за 300 гривен - это как?", "4 час назад",
                "12 сообщений", "/img/forum/themes/fun_time.jpg"));

        request.setAttribute("forumThemes", forumThemeClasses);
    }

    private void createFrilancerAdvertising(HttpServletRequest request){
        AdvertisingFrilancerClass advertisingFrilancerClass = new AdvertisingFrilancerClass("/img/avatars/my_own.jpg",
                "#", "Frilancer_Name Surname(prof)", "Современный дизайн достигающий цели! От идеи до результата!");

        request.setAttribute("advertising", advertisingFrilancerClass);
    }

    private void createFrilancerTop(HttpServletRequest request){
        ArrayList<FrilancerTopClass> frilancerTopClasses = new ArrayList<FrilancerTopClass>();

        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "12"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "Second frilancer", "11"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "10"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "10"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "2"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "2"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "2"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "2"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "2"));
        frilancerTopClasses.add(new FrilancerTopClass("#", "First frilancer", "2"));

        request.setAttribute("frilancerList", frilancerTopClasses);
    }

    private void createServiceStats(HttpServletRequest request){
        ServiceStatsClass serviceStats = new ServiceStatsClass("10", "10", "20");

        request.setAttribute("stats", serviceStats);
    }
}
