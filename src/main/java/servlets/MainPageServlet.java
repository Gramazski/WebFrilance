package servlets;

import DAO.UserInfoDAO;
import DAO.forum.ForumThemeDAO;
import DAO.project.custom.CustomInfoDAO;
import DAO.project.info.ProjectInfoDAO;
import entity.jsp.main.advertising.AdvertisingFrilancerClass;
import entity.jsp.main.frilancer.FrilancerTopClass;
import entity.jsp.main.news.NewsClass;
import entity.jsp.main.stats.ServiceStatsClass;
import entity.jsp.main.title.PageTitleClass;
import entity.jsp.main.title.PageTitleList;
import entity.project.custom.CustomInfo;
import entity.project.info.ProjectInfo;
import entity.user.info.UserInfo;
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
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAO();
        ArrayList<ProjectInfo> projectInfos = projectInfoDAO.getAllProjects();
        request.setAttribute("frilancerWorks", projectInfos);
    }

    private void createJobPanel(HttpServletRequest request){
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        ArrayList<CustomInfo> customInfos = customInfoDAO.getAllCustoms();

        request.setAttribute("jobsForFrilancer", customInfos);
    }

    private void createForumThemesPanel(HttpServletRequest request){
        ForumThemeDAO forumThemeDAO = new ForumThemeDAO();
        ArrayList<entity.jsp.forum.theme.ForumThemeClass> forumThemeClasses = forumThemeDAO.getAllThemes();

        request.setAttribute("forumThemes", forumThemeClasses);
    }

    private void createFrilancerAdvertising(HttpServletRequest request){
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        UserInfo userInfo = userInfoDAO.getAllUsers().get(0);
        AdvertisingFrilancerClass advertisingFrilancerClass = new AdvertisingFrilancerClass(userInfo.getImgLink(),
                "/personaluser?login=" + userInfo.getLogin(), userInfo.getLogin(), userInfo.getDescription());

        request.setAttribute("advertising", advertisingFrilancerClass);
    }

    private void createFrilancerTop(HttpServletRequest request){
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        ArrayList<UserInfo> userInfos = userInfoDAO.getAllUsers();
        ArrayList<FrilancerTopClass> frilancerTopClasses = new ArrayList<FrilancerTopClass>();

        for (UserInfo userinfo : userInfos) {
            frilancerTopClasses.add(new FrilancerTopClass("/personaluser?login=" + userinfo.getLogin(), userinfo.getLogin(), userinfo.getPoints()));
        }

        request.setAttribute("frilancerList", frilancerTopClasses);
    }

    private void createServiceStats(HttpServletRequest request){
        ServiceStatsClass serviceStats = new ServiceStatsClass("10", "10", "20");

        request.setAttribute("stats", serviceStats);
    }
}
