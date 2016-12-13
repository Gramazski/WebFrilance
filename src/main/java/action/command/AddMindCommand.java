package action.command;

import DAO.UserInfoDAO;
import DAO.mind.CustomMindDAO;
import DAO.project.custom.CustomInfoDAO;
import action.ActionCommand;
import entity.Mind.CustomerMind;
import entity.user.info.AuthorizationUserInfo;
import entity.user.info.UserInfo;
import manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

/**
 * Created by gs on 14.12.2016.
 */
public class AddMindCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        HttpSession session = request.getSession(false);
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        UserInfo userInfo = (UserInfo)session.getAttribute("user");
        String mark = request.getParameter("mark");
        String body = request.getParameter("body");
        String frilancerName = request.getParameter("frilancer");
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        UserInfo frilancer = userInfoDAO.getUserInfoById(frilancerName);
        CustomerMind customerMind = new CustomerMind(userInfo.getLogin(), body, mark,
                new SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis()),
                userInfo.getImgLink());
        frilancer.getMinds().add(customerMind);
        CustomMindDAO customMindDAO = new CustomMindDAO();
        customMindDAO.addCustomMind(customerMind);
        userInfoDAO.updateUserInfo(frilancer);
        page = "/jsp/user/info/";
        return page;
    }

    private AuthorizationUserInfo getAuthUserInfo(HttpServletRequest request){
        String login = request.getParameter(ConfigurationManager.getProperty("auth.login"));
        String pass = request.getParameter(ConfigurationManager.getProperty("auth.password"));

        return new AuthorizationUserInfo(login, pass, "");
    }
}
