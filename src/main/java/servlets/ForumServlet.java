package servlets;

import entity.jsp.forum.theme.ForumThemeClass;
import entity.jsp.forum.theme.SimpleForumThemeClass;
import entity.jsp.job.ServiceProjectClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ForumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        createForumThemePanel(req);
        createThemesList(req);
        req.setAttribute("pageCreation", 1);
        req.getRequestDispatcher("/jsp/forum/").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/job/").forward(req, resp);
        //super.doPost(req, resp);
    }

    private void createForumThemePanel(HttpServletRequest request){
        ArrayList<ForumThemeClass> forumThemeClasses = new ArrayList<ForumThemeClass>();
        forumThemeClasses.add(new ForumThemeClass("3 days ago", "Good theme", "/img/avatars/my_own.jpg", "#"));
        forumThemeClasses.add(new ForumThemeClass("3 days ago", "Good theme", "/img/avatars/my_own.jpg", "#"));
        forumThemeClasses.add(new ForumThemeClass("3 days ago", "Good theme", "/img/avatars/my_own.jpg", "#"));
        forumThemeClasses.add(new ForumThemeClass("3 days ago", "Good theme", "/img/avatars/my_own.jpg", "#"));

        request.setAttribute("themes", forumThemeClasses);
    }

    private void createThemesList(HttpServletRequest request){
        ArrayList<SimpleForumThemeClass> themeClasses = new ArrayList<SimpleForumThemeClass>();

        themeClasses.add(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.get(0).addSubTheme(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.get(0).addSubTheme(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.get(0).addSubTheme(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.get(0).addSubTheme(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.add(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.get(1).addSubTheme(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.get(1).addSubTheme(new SimpleForumThemeClass("#", "Theme"));
        themeClasses.add(new SimpleForumThemeClass("#", "Theme"));

        request.setAttribute("forumStruct", themeClasses);
    }

    private void createProjectsList(HttpServletRequest request){
        ArrayList<ServiceProjectClass> serviceProjectClasses = new ArrayList<ServiceProjectClass>();

        serviceProjectClasses.add(new ServiceProjectClass("#", "Проекты", "12"));
        serviceProjectClasses.add(new ServiceProjectClass("#", "Вакансии", "11"));
        serviceProjectClasses.add(new ServiceProjectClass("#", "Конкурсы", "10"));

        request.setAttribute("projectsList", serviceProjectClasses);
    }

    private void createGeneralProjectsList(HttpServletRequest request){
        ArrayList<ServiceProjectClass> serviceProjectClasses = new ArrayList<ServiceProjectClass>();

        serviceProjectClasses.add(new ServiceProjectClass("#", "Завершенные", "12"));
        serviceProjectClasses.add(new ServiceProjectClass("#", "Закрытые", "11"));

        request.setAttribute("projectsGeneralList", serviceProjectClasses);
    }
}
