package action.command;

import action.ActionCommand;
import manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 10.12.2016.
 */
public class EmptyCommand implements ActionCommand {

    public String execute(HttpServletRequest request) {
/* в случае ошибки или прямого обращения к контроллеру
* переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
