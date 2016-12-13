package validator.session;

import entity.user.info.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by gs on 11.12.2016.
 */
public class SessionValidator {

    public static boolean isValidSession(HttpServletRequest request){
        HttpSession session = null;
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");

        if (userInfo == null){
            return false;
        }

        return true;
    }
}
