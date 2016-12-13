package handlers.request;

import entity.user.info.AuthorizationUserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 10.11.2016.
 */
public class AuthDataHandler {
    public AuthorizationUserInfo getAuthData(HttpServletRequest request){
        return  new AuthorizationUserInfo(request.getParameter("login"),
                request.getParameter("password"), request.getParameter("email"));
    }

}
