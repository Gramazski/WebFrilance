package servlets;

import DAO.UserInfoDAO;
import DAO.project.info.ProjectInfoDAO;
import entity.jsp.main.advertising.AdvertisingFrilancerClass;
import entity.jsp.user.category.CategoryClass;
import entity.project.info.ProjectInfo;
import entity.user.info.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by gs on 14.12.2016.
 */
@WebServlet("/projects")
public class PortfolioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //createUsersList(req);
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAO();
        ArrayList<ProjectInfo> projectInfos = projectInfoDAO.getAllProjects();
        req.setAttribute("frilancerWorks", projectInfos);
        createFrilancerAdvertising(req);
        createCategoryList(req);
        req.setAttribute("pageCreation", 1);
        req.getRequestDispatcher("/jsp/portfolio/").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        //super.doPost(req, resp);
    }

    private void createUsersList(HttpServletRequest request){
        UserInfoDAO userInfoDAO = new UserInfoDAO();

        request.setAttribute("users", userInfoDAO.getAllUsers());
    }

    private void createFrilancerAdvertising(HttpServletRequest request){
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        UserInfo userInfo = userInfoDAO.getAllUsers().get(0);
        AdvertisingFrilancerClass advertisingFrilancerClass = new AdvertisingFrilancerClass(userInfo.getImgLink(),
                "#", userInfo.getLogin(), userInfo.getDescription());

        request.setAttribute("advertising", advertisingFrilancerClass);
    }

    private void createCategoryList(HttpServletRequest request){
        ArrayList<CategoryClass> categoryClasses = new ArrayList<CategoryClass>();

        categoryClasses.add(new CategoryClass("#", "200", "Администрирование сайтов"));
        categoryClasses.add(new CategoryClass("#", "200", "Аудио, Видео и Мультимедиа"));
        categoryClasses.add(new CategoryClass("#", "200", "Графика и Фотография"));

        request.setAttribute("categories", categoryClasses);
    }
}
