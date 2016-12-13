package servlets;

import entity.jsp.main.advertising.AdvertisingFrilancerClass;
import entity.jsp.main.frilancer.FrilancerTopClass;
import entity.jsp.main.work.FrilancerWorkClass;
import entity.jsp.project.info.ProjectInfoClass;
import entity.jsp.project.info.user.SimpleUserClass;
import entity.jsp.project.stats.ProjectStatsClass;
import entity.project.order.OrderInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        createFrilancerAdvertising(req);
        createFrilancerTop(req);
        createProjectStats(req);
        createProjectDescription(req);
        req.setAttribute("pageCreation", 1);
        req.getRequestDispatcher("/jsp/project/project_template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        //super.doPost(req, resp);
    }

    private void createProjectDescription(HttpServletRequest request){
        ArrayList<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
        ArrayList<FrilancerWorkClass> frilancerWorkClasses = new ArrayList<FrilancerWorkClass>();
        frilancerWorkClasses.add(new FrilancerWorkClass("#", "/img/works/music_site.jpg", "Pulpit Rock", "Good site on Node.js about music!"));
        frilancerWorkClasses.add(new FrilancerWorkClass("#", "/img/works/java_site.jpg", "Pulpit Rock", "Lorem ipsum donec id elit non."));
        frilancerWorkClasses.add(new FrilancerWorkClass("#", "/img/works/js_scripts.jpg", "Pulpit Rock", "Good site on Node.js about music!"));
        /*orderInfos.add(new OrderInfo("3 days ago", "5", new UserInfo("#", "/img/avatars/my_own.jpg", "#", "Frilancer_Name Surname(prof)", "Frilancers years",
                "Years in service", "#", "10", "30$/hour", "from 100$", "Frilancer long description", frilancerWorkClasses)));
        orderInfos.add(new OrderInfo("3 days ago", "10", new UserClass("#", "/img/avatars/my_own.jpg", "#", "Frilancer_Name Surname(prof)", "Frilancers years",
                "Years in service", "#", "10", "30$/hour", "from 100$", "Frilancer long description", frilancerWorkClasses)));*/
        ProjectInfoClass projectInfoClass = new ProjectInfoClass("3 days ago", "Нужен парсер БК онлайн матчей в\n" +
                "                    реальном времени. Переменные (значения) для Парсинга выдам (около 5).\n" +
                "                    Адрес для Парсинга\n" +
                "                    <a href=\"http://sports.williamhill.com/betting/en-gb/football/in-play\">http://sports.williamhill.com/betting/en-gb/football/in-playhttp://sports.williamhill.com/betting/en-gb/football/in-play</a> здесь матчи, именно уже внутри каждого мачта и нужно Парсить заданные переменные, например такие как: время матча, коэффициенты и т.д. Выполнить нужно до пятницы (48часов), не позже. Требование: опыт обязателен, часто быть на рабочем месте - нужна будет поддержка. Оплата своевременная и адекватная.",
                "Парсер БК", new SimpleUserClass("Roman", "5 month in service"), orderInfos);


        request.setAttribute("projectInfo", projectInfoClass);
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

    private void createProjectStats(HttpServletRequest request){
        ProjectStatsClass projectStats = new ProjectStatsClass("10", "10");

        request.setAttribute("stats", projectStats);
    }
}
