package servlets;

import DAO.forum.ForumThemeDAO;
import entity.jsp.forum.theme.ForumThemeClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gs on 14.12.2016.
 */
@WebServlet("/theme")
public class ThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String themeName = req.getParameter("theme");
        ForumThemeDAO forumThemeDAO = new ForumThemeDAO();
        ForumThemeClass forumThemeClass = forumThemeDAO.getForumThemeByName(themeName);
        req.setAttribute("pageCreation", 1);
        req.setAttribute("theme", forumThemeClass);
        req.getRequestDispatcher("/jsp/forum/theme/theme_template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        //super.doPost(req, resp);
    }
}
