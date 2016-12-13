package action.command;

import DAO.project.custom.CustomInfoDAO;
import action.ActionCommand;
import entity.jsp.project.info.user.SimpleUserClass;
import entity.project.custom.CustomInfo;
import entity.project.order.OrderInfo;
import entity.user.info.AuthorizationUserInfo;
import entity.user.info.UserInfo;
import manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class CreateCustomCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        HttpSession session = request.getSession(false);
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        UserInfo userInfo = (UserInfo)session.getAttribute("user");
        SimpleUserClass simpleUserClass = new SimpleUserClass(userInfo.getLogin(), userInfo.getYears());
        CustomInfo customInfo = new CustomInfo(new SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis()),
                request.getParameter("description"), request.getParameter("title"), simpleUserClass,
                new ArrayList<OrderInfo>());
        customInfo.setType(request.getParameter("type"));
        customInfo.setPrice(request.getParameter("price"));
        customInfo.setCondition("Created");
        customInfoDAO.addCustomInfo(customInfo);
        page = "/jsp/job/";
        return page;
    }

    private AuthorizationUserInfo getAuthUserInfo(HttpServletRequest request){
        String login = request.getParameter(ConfigurationManager.getProperty("auth.login"));
        String pass = request.getParameter(ConfigurationManager.getProperty("auth.password"));

        return new AuthorizationUserInfo(login, pass, "");
    }
}
