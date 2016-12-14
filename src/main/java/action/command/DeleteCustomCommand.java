package action.command;

import DAO.project.custom.CustomInfoDAO;
import action.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 14.12.2016.
 */
public class DeleteCustomCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String customName = request.getParameter("custom");
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        customInfoDAO.deleteCustom(customName);
        page = "/usercabinet";
        return page;
    }
}
