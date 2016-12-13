package entity.info.storage;

import DAO.UserInfoDAO;
import DAO.auth.AuthUserDAO;
import entity.user.info.AuthorizationUserInfo;
import entity.user.info.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gs on 09.11.2016.
 */
//Static singleton??
public class BaseUsersInfoStorage {
    private List<AuthorizationUserInfo> simpleUserInfos;

    public BaseUsersInfoStorage(){
        simpleUserInfos = getUserInfoList();
    }

    private List<AuthorizationUserInfo> getUserInfoList(){
        List<AuthorizationUserInfo> simpleUserInfoList = new ArrayList<AuthorizationUserInfo>();
        //For tests
        AuthUserDAO authUserDAO = new AuthUserDAO();
        simpleUserInfoList = authUserDAO.getAllUsers();
        //Get simple user info from DB by DAO
        return simpleUserInfoList;
    }

    public AuthorizationUserInfo getUserInfoByLogin(String login){
        for (AuthorizationUserInfo userInfo : simpleUserInfos) {
            if(userInfo.getLogin().equals(login)){
                return userInfo;
            }
        }
        //throw new UserIsNotFoundExeption();
        return null;
    }

    public AuthorizationUserInfo getUserInfoByMail(String email){
        for (AuthorizationUserInfo userInfo : simpleUserInfos) {
            if(userInfo.getEmail().equals(email)){
                return userInfo;
            }
        }
        //throw new UserIsNotFoundExeption();
        return null;
    }

    public UserInfo getUserInfo(String login){
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        ArrayList<UserInfo> userInfos = userInfoDAO.getAllUsers();
        for (UserInfo userInfo : userInfos){
            if (userInfo.getLogin().equals(login)){
                return userInfo;
            }
        }

        return null;
    }
}
