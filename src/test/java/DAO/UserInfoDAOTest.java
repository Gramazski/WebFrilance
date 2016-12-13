package DAO;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gs on 12.12.2016.
 */
public class UserInfoDAOTest {
    @Test
    public void addUserInfo() throws Exception {
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.getUserInfoById("1");

        //userInfoDAO.addUserInfo();

        Assert.assertTrue(true);
    }

}