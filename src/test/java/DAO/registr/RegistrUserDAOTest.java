package DAO.registr;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gs on 12.12.2016.
 */
public class RegistrUserDAOTest {
    @Test
    public void getUserInfoById() throws Exception {
        RegistrUserDAO registrUserDAO = new RegistrUserDAO();

        registrUserDAO.getUserInfoById("1");

        Assert.assertTrue(true);
    }

}