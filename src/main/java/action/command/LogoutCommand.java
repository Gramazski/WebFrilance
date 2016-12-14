package action.command;

import action.ActionCommand;
import manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 14.12.2016.
 */
public class LogoutCommand implements ActionCommand {

    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
// уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}
