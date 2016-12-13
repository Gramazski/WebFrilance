package entity.info.controlers;

import entity.user.info.RegistrationUserInfo;

/**
 * Created by gs on 11.11.2016.
 */
public class RegInfoController extends UserInfoController {
    public boolean checkUserRegData(RegistrationUserInfo userInfo) {
        return ((userInfo.getPassword() == userInfo.getClonePassword()) && !checkUserAuthData(userInfo));
    }
}
