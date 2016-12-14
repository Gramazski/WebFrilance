package action.command;

import DAO.project.custom.CustomInfoDAO;
import action.ActionCommand;
import entity.project.custom.CustomInfo;
import entity.user.info.AuthorizationUserInfo;
import manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 14.12.2016.
 */
public class UpdateCustomCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String customName = request.getParameter("custom");
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        CustomInfo customInfo = customInfoDAO.getUserInfoByTitle(customName);
        customInfo.setType(request.getParameter("type"));
        customInfo.setPrice(request.getParameter("price"));
        customInfo.setBody(request.getParameter("description"));
        customInfoDAO.updateCustomInfo(customInfo);
        page = "/usercabinet";
        return page;
    }

    private AuthorizationUserInfo getAuthUserInfo(HttpServletRequest request){
        String login = request.getParameter(ConfigurationManager.getProperty("auth.login"));
        String pass = request.getParameter(ConfigurationManager.getProperty("auth.password"));

        return new AuthorizationUserInfo(login, pass, "");
    }
}
