package validator;

import entity.info.storage.BaseUsersInfoStorage;
import entity.user.info.AuthorizationUserInfo;

/**
 * Created by gs on 10.12.2016.
 */
public class AuthorizationDataValidator {
    private String errorMessageKey;
    private static BaseUsersInfoStorage usersInfoStorage = new BaseUsersInfoStorage();

    public boolean isValid(AuthorizationUserInfo userInfo){
        AuthorizationUserInfo simpleUserInfo = usersInfoStorage.getUserInfoByLogin(userInfo.getLogin());

        if (simpleUserInfo != null){
            if (userInfo.getPassword().equals(simpleUserInfo.getPassword())){
                return true;
            }
                errorMessageKey = "errorPassword";
        }
        else {
            errorMessageKey = "errorLogin";
        }

        return false;
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }
}
