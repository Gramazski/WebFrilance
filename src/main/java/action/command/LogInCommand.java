package action.command;

import action.ActionCommand;
import entity.info.storage.BaseUsersInfoStorage;
import entity.user.info.AuthorizationUserInfo;
import entity.user.info.UserInfo;
import manager.ConfigurationManager;
import manager.MessageManager;
import validator.AuthorizationDataValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by gs on 11.12.2016.
 */
public class LogInCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        AuthorizationUserInfo authUserInfo = getAuthUserInfo(request);
        AuthorizationDataValidator authDataValidator = new AuthorizationDataValidator();
// проверка логина и пароля
        if (authDataValidator.isValid(authUserInfo)) {
            BaseUsersInfoStorage infoStorage = new BaseUsersInfoStorage();
            UserInfo userInfo = infoStorage.getUserInfo(authUserInfo.getLogin());
            HttpSession session = request.getSession();
            session.setAttribute("user", userInfo);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute(authDataValidator.getErrorMessageKey(),
                    MessageManager.getProperty("message." + authDataValidator.getErrorMessageKey()));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

    private AuthorizationUserInfo getAuthUserInfo(HttpServletRequest request){
        String login = request.getParameter(ConfigurationManager.getProperty("auth.login"));
        String pass = request.getParameter(ConfigurationManager.getProperty("auth.password"));

        return new AuthorizationUserInfo(login, pass, "");
    }
}
