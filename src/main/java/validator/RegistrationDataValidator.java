package validator;

import entity.info.storage.BaseUsersInfoStorage;
import entity.user.info.RegistrationUserInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gs on 10.12.2016.
 */
public class RegistrationDataValidator {
    private String errorMessageKey;
    private static BaseUsersInfoStorage usersInfoStorage = new BaseUsersInfoStorage();

    public boolean isValid(RegistrationUserInfo registrationUserInfo){
        if (usersInfoStorage.getUserInfoByLogin(registrationUserInfo.getLogin()) != null){
            errorMessageKey = "errorLogin";
            return false;
        }

        if (usersInfoStorage.getUserInfoByMail(registrationUserInfo.getEmail()) != null){
            errorMessageKey = "errorEmail";
            return false;
        }

        if (!registrationUserInfo.getClonePassword().equals(registrationUserInfo.getPassword())){
            errorMessageKey = "errorSecondPassword";
            return false;
        }

        if (!checkUserName(registrationUserInfo.getName())){
            errorMessageKey = "errorName";
            return false;
        }

        if (!checkUserName(registrationUserInfo.getSurname())){
            errorMessageKey = "errorSurname";
            return false;
        }

        return true;
    }

    private boolean checkUserName(String userName){
        String regexp = "[A-Za-z]+";

        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(userName);

        return matcher.matches();
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }
}
