package entity.info.controlers;

import entity.info.storage.BaseUsersInfoStorage;
import entity.user.info.AuthorizationUserInfo;
import entity.user.info.UserInfo;

/**
 * Created by gs on 09.11.2016.
 */
public class UserInfoController extends InfoController {
    private BaseUsersInfoStorage usersInfoStorage;
    private UserInfo currrentUserInfo;

    public UserInfoController(){
        usersInfoStorage = new BaseUsersInfoStorage();
    }

    public boolean checkUserAuthData(AuthorizationUserInfo userInfo){
        AuthorizationUserInfo simpleUserInfo = usersInfoStorage.getUserInfoByLogin(userInfo.getLogin());

        if (simpleUserInfo != null){
            //currrentUserInfo = new UserInfo(userInfo.getLogin(), userInfo.getPassword());
            return true;
        }
        else {
            return false;
        }
    }

    public UserInfo getCurrrentUserInfo() {
        return currrentUserInfo;
    }
}
