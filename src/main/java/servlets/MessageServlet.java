package servlets;

import DAO.UserInfoDAO;
import DAO.forum.ForumThemeDAO;
import DAO.forum.message.ForumMessageDAO;
import entity.jsp.forum.message.ForumMessage;
import entity.jsp.forum.theme.ForumThemeClass;
import entity.user.info.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by gs on 14.12.2016.
 */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String themeName = req.getParameter("theme");
        String body = req.getParameter("description");
        HttpSession session = req.getSession(false);
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        ForumThemeDAO forumThemeDAO = new ForumThemeDAO();
        ForumThemeClass forumThemeClass = forumThemeDAO.getForumThemeByName(themeName);
        userInfo.getMessages().add(themeName);
        ForumMessage forumMessage = new ForumMessage("", themeName, body, userInfo);
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.updateUserInfo(userInfo);
        forumThemeDAO.updateForumTheme(forumThemeClass);
        ForumMessageDAO forumMessageDAO = new ForumMessageDAO();
        forumMessageDAO.addForumMessage(forumMessage);
        req.setAttribute("pageCreation", 1);
        req.setAttribute("theme", forumThemeClass);
        req.getRequestDispatcher("/jsp/forum/theme/theme_template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String themeName = req.getParameter("theme");
        String body = req.getParameter("description");
        HttpSession session = req.getSession(false);
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        ForumThemeDAO forumThemeDAO = new ForumThemeDAO();
        ForumThemeClass forumThemeClass = forumThemeDAO.getForumThemeByName(themeName);
        userInfo.getMessages().add(themeName);
        ForumMessage forumMessage = new ForumMessage(new SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis()),
                themeName, body, userInfo);
        forumThemeClass.getMessages().add(forumMessage);
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.updateUserInfo(userInfo);
        forumThemeDAO.updateForumTheme(forumThemeClass);
        ForumMessageDAO forumMessageDAO = new ForumMessageDAO();
        forumMessageDAO.addForumMessage(forumMessage);
        req.setAttribute("pageCreation", 1);
        req.setAttribute("theme", forumThemeClass);
        req.getRequestDispatcher("/jsp/forum/theme/theme_template.jsp").forward(req, resp);
    }
}
