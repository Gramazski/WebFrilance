package action.command;

import DAO.UserInfoDAO;
import DAO.project.custom.CustomInfoDAO;
import DAO.project.order.OrderInfoDAO;
import action.ActionCommand;
import entity.project.custom.CustomInfo;
import entity.project.order.OrderInfo;
import entity.user.info.AuthorizationUserInfo;
import entity.user.info.UserInfo;
import manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

/**
 * Created by gs on 13.12.2016.
 */
public class AddOrderCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        HttpSession session = request.getSession(false);
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        UserInfo userInfo = (UserInfo)session.getAttribute("user");
        String custom = request.getParameter("custom");
        CustomInfo customInfo = customInfoDAO.getUserInfoByTitle(custom);
        OrderInfo orderInfo = new OrderInfo(new SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis()), "2", userInfo);
        orderInfo.setCustomName(custom + "-" + userInfo.getLogin());
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        UserInfo customer = userInfoDAO.getUserInfoById(customInfo.getAuthor().getName());
        orderInfo.setCustomer(customer);
        customInfo.getFrilancersOrders().add(orderInfo);
        userInfo.getOrders().add(orderInfo.getCustomName());
        userInfoDAO = new UserInfoDAO();
        userInfoDAO.updateUserInfo(userInfo);
        customInfoDAO = new CustomInfoDAO();
        customInfoDAO.updateCustomInfo(customInfo);
        OrderInfoDAO orderInfoDAO = new OrderInfoDAO();
        orderInfoDAO.addOrderInfo(orderInfo);
        page = "/jsp/job/";
        return page;
    }

    private AuthorizationUserInfo getAuthUserInfo(HttpServletRequest request){
        String login = request.getParameter(ConfigurationManager.getProperty("auth.login"));
        String pass = request.getParameter(ConfigurationManager.getProperty("auth.password"));

        return new AuthorizationUserInfo(login, pass, "");
    }
}
