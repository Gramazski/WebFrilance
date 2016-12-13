package action.factory;

import action.ActionCommand;
import action.command.EmptyCommand;
import action.list.CommandEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 10.12.2016.
 */
public class ActionCommandFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
// извлечение имени команды из запроса
        String action = request.getParameter("command");
        if (action == null) {
// если команда не задана в текущем запросе
            return current;
        }
// получение объекта, соответствующего команде
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            /*request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));*/
        }
        return current;
    }
}
