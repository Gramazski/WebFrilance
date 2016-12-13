package action.command;

import DAO.UserInfoDAO;
import DAO.auth.AuthUserDAO;
import DAO.registr.RegistrUserDAO;
import action.ActionCommand;
import entity.user.info.AuthorizationUserInfo;
import entity.user.info.RegistrationUserInfo;
import entity.user.info.UserInfo;
import manager.ConfigurationManager;
import manager.MessageManager;
import validator.RegistrationDataValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

/**
 * Created by gs on 10.12.2016.
 */
public class RegisterCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        RegistrationUserInfo registrationUserInfo = getRegistrationUserInfo(request);
        RegistrationDataValidator registrationDataValidator = new RegistrationDataValidator();
// проверка логина и пароля
        if (registrationDataValidator.isValid(registrationUserInfo)) {
            RegistrUserDAO registrUserDAO = new RegistrUserDAO();

            registrUserDAO.addUserInfo(registrationUserInfo);
            AuthUserDAO authUserDAO = new AuthUserDAO();
            authUserDAO.addUserInfo(new AuthorizationUserInfo(registrationUserInfo.getLogin(),
                    registrationUserInfo.getPassword(), registrationUserInfo.getEmail()));
            UserInfo userInfo = createUserInfo(registrationUserInfo);
            UserInfoDAO userInfoDAO = new UserInfoDAO();
            userInfoDAO.addUserInfo(userInfo);
            HttpSession session = request.getSession();
            session.setAttribute("user", userInfo);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute(registrationDataValidator.getErrorMessageKey(),
                    MessageManager.getProperty("message." + registrationDataValidator.getErrorMessageKey()));
            page = ConfigurationManager.getProperty("path.page.registration");
        }
        return page;
    }

    private RegistrationUserInfo getRegistrationUserInfo(HttpServletRequest request){
        String login = request.getParameter(ConfigurationManager.getProperty("registration.login"));
        String pass = request.getParameter(ConfigurationManager.getProperty("registration.password"));
        String secondPass = request.getParameter(ConfigurationManager.getProperty("registration.secondPassword"));
        String name = request.getParameter(ConfigurationManager.getProperty("registration.name"));
        String surname = request.getParameter(ConfigurationManager.getProperty("registration.surname"));
        String email = request.getParameter(ConfigurationManager.getProperty("registration.email"));
        String birthday = request.getParameter(ConfigurationManager.getProperty("registration.birthday"));
        String sex = request.getParameter(ConfigurationManager.getProperty("registration.sex"));
        String role = request.getParameter(ConfigurationManager.getProperty("registration.role"));

        return new RegistrationUserInfo(login, pass, secondPass, name, surname, birthday, sex, role, email);
    }

    private UserInfo createUserInfo(RegistrationUserInfo registrationUserInfo){
        UserInfo userInfo = new UserInfo();

        userInfo.setBirthday(registrationUserInfo.getBirthday());
        userInfo.setEmail(registrationUserInfo.getEmail());
        userInfo.setLogin(registrationUserInfo.getLogin());
        userInfo.setName(registrationUserInfo.getName());
        userInfo.setPassword(registrationUserInfo.getPassword());
        userInfo.setSurname(registrationUserInfo.getSurname());
        userInfo.setRole(registrationUserInfo.getRole());
        long curTime = System.currentTimeMillis();
        String curStringDate = new SimpleDateFormat("dd.MM.yyyy").format(curTime);
        userInfo.setDateCreation(curStringDate);

        return userInfo;
    }
}
