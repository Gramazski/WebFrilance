package handlers;

import entity.user.info.AuthorizationUserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gs on 11.11.2016.
 */
public abstract class AbstarctDataHandler {
    public abstract AuthorizationUserInfo getInputData(HttpServletRequest request);
}
