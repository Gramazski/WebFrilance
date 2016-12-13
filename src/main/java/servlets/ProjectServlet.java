package servlets;

import DAO.UserInfoDAO;
import DAO.project.info.ProjectInfoDAO;
import entity.jsp.main.advertising.AdvertisingFrilancerClass;
import entity.jsp.main.frilancer.FrilancerTopClass;
import entity.jsp.project.stats.ProjectStatsClass;
import entity.project.info.ProjectInfo;
import entity.user.info.UserInfo;

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
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAO();
        String projectTitle = (String) request.getAttribute("title");
        ProjectInfo projectInfo = projectInfoDAO.getUserInfoByTitle(projectTitle);

        request.setAttribute("projectInfo", projectInfo);
    }

    private void createFrilancerAdvertising(HttpServletRequest request){
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        UserInfo userInfo = userInfoDAO.getAllUsers().get(0);
        AdvertisingFrilancerClass advertisingFrilancerClass = new AdvertisingFrilancerClass(userInfo.getImgLink(),
                "#", userInfo.getLogin(), userInfo.getDescription());

        request.setAttribute("advertising", advertisingFrilancerClass);
    }

    private void createFrilancerTop(HttpServletRequest request){
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        ArrayList<UserInfo> userInfos = userInfoDAO.getAllUsers();
        ArrayList<FrilancerTopClass> frilancerTopClasses = new ArrayList<FrilancerTopClass>();

        for (UserInfo userinfo : userInfos) {
            frilancerTopClasses.add(new FrilancerTopClass("#", userinfo.getLogin(), userinfo.getPoints()));
        }

        request.setAttribute("frilancerList", frilancerTopClasses);
    }

    private void createProjectStats(HttpServletRequest request){
        ProjectStatsClass projectStats = new ProjectStatsClass("10", "10");

        request.setAttribute("stats", projectStats);
    }
}
