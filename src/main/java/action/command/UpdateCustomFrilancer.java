package action.command;

import DAO.project.custom.CustomInfoDAO;
import action.ActionCommand;
import entity.project.custom.CustomInfo;
import entity.project.order.OrderInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by gs on 14.12.2016.
 */
public class UpdateCustomFrilancer implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String customName = request.getParameter("custom");
        String frilancerName = request.getParameter("frilancer");
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        CustomInfo customInfo = customInfoDAO.getUserInfoByTitle(customName);
        customInfo.setCondition("Charged to " + frilancerName);
        customInfo.setFrilancersOrders(new ArrayList<OrderInfo>());
        customInfoDAO.updateCustomInfo(customInfo);
        request.setAttribute("login", frilancerName);
        page = "/personaluser";
        return page;
    }
}
