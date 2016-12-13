package action;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 10.12.2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
