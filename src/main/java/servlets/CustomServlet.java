package servlets;

import DAO.UserInfoDAO;
import DAO.project.custom.CustomInfoDAO;
import entity.jsp.main.advertising.AdvertisingFrilancerClass;
import entity.jsp.main.frilancer.FrilancerTopClass;
import entity.jsp.main.stats.ServiceStatsClass;
import entity.project.custom.CustomInfo;
import entity.user.info.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        createFrilancerAdvertising(req);
        createFrilancerTop(req);
        createServiceStats(req);
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        String projectInfo = req.getParameter("projectInfo");
        CustomInfo customInfo = customInfoDAO.getUserInfoByTitle(projectInfo);
        req.setAttribute("projectInfo", customInfo);
        req.setAttribute("pageCreation", 1);
        req.getRequestDispatcher("/jsp/job/tmpl/project_template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/job/").forward(req, resp);
        //super.doPost(req, resp);
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

    private void createServiceStats(HttpServletRequest request){
        ServiceStatsClass serviceStats = new ServiceStatsClass("10", "10", "20");

        request.setAttribute("stats", serviceStats);
    }
}
