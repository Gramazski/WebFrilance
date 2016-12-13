package entity.info.controlers;

import entity.user.info.AuthorizationUserInfo;

/**
 * Created by gs on 11.11.2016.
 */
public abstract class InfoController {
    public abstract boolean checkUserAuthData(AuthorizationUserInfo userInfo);
}
