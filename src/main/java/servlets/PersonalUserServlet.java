package servlets;

import DAO.UserInfoDAO;
import entity.user.info.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PersonalUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String login = req.getParameter("login");
        UserInfo userInfo = findUserByLogin(login);
        req.setAttribute("pageCreation", 1);
        req.setAttribute("curUser", userInfo);
        req.getRequestDispatcher("/jsp/user/info/").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        //super.doPost(req, resp);
    }

    private UserInfo findUserByLogin(String login){
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        ArrayList<UserInfo> userInfos = userInfoDAO.getAllUsers();

        for (UserInfo currentUserInfo : userInfos){
            if (currentUserInfo.getLogin().equals(login)){
                return currentUserInfo;
            }
        }

        return null;
    }
}
