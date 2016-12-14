package servlets;

import DAO.UserInfoDAO;
import DAO.project.custom.CustomInfoDAO;
import entity.jsp.main.advertising.AdvertisingFrilancerClass;
import entity.project.custom.CustomInfo;
import entity.user.info.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by gs on 14.12.2016.
 */
@WebServlet("/usercabinet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        createFrilancerAdvertising(req);
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        HttpSession session = req.getSession(false);
        UserInfo userInfo = (UserInfo)session.getAttribute("user");
        ArrayList<String> customs = userInfo.getOrders();
        ArrayList<CustomInfo> customInfos = customInfoDAO.getAllCustoms();
        ArrayList<CustomInfo> userCustoms = new ArrayList<CustomInfo>();
        for (CustomInfo custom : customInfos) {
            if (custom.getAuthor().getName().equals(userInfo.getLogin())){
                userCustoms.add(custom);
            }
        }
        req.setAttribute("customs", userCustoms);
        req.setAttribute("pageCreation", 1);
        req.getRequestDispatcher("/jsp/user/cabinet/cabinet_template.jsp").forward(req, resp);
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
}
