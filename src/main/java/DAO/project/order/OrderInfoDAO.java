package DAO.project.order;

import DAO.UserInfoDAO;
import entity.project.order.OrderInfo;
import entity.user.info.UserInfo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class OrderInfoDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO orderinfo(`id`, `time`, `customes`," +
                    " `name`, `customer`, `frilancer`) VALUES(?,?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT id, `time`, `customes`, `name`, `customer`, `frilancer` FROM orderinfo";
    private final static String SET_NAMES = "SET NAMES utf8";
    private final static String SQL_UPDATE =
            "UPDATE orderinfo SET `id` = ?, `time` = ?, `customes` = ?, " +
                    "`customer` = ?, `frilancer` = ? WHERE name = ?";

    public OrderInfoDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdb", "testuser", "123456");
            Statement statement = connection.createStatement();
            statement.executeQuery(SET_NAMES);
        }catch (SQLException ex){

        }
        catch (ClassNotFoundException ex){}

    }

    public OrderInfo getUserInfoByName(String name){
        ArrayList<OrderInfo> customInfos = getAllOrders();

        for (OrderInfo orderInfo : customInfos){
            if (orderInfo.getCustomName().equals(name)){
                return orderInfo;
            }
        }

        return null;
    }

    public void addOrderInfo(OrderInfo orderInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, orderInfo.getTimeAgo());
            preparedStatement.setString(3, orderInfo.getCustomes());
            preparedStatement.setString(4, orderInfo.getCustomName());
            preparedStatement.setString(5, orderInfo.getCustomer().getLogin());
            preparedStatement.setString(6, orderInfo.getFrilancer().getLogin());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public void updateOrderInfo(OrderInfo orderInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, orderInfo.getTimeAgo());
            preparedStatement.setString(3, orderInfo.getCustomes());
            preparedStatement.setString(6, orderInfo.getCustomName());
            preparedStatement.setString(4, orderInfo.getCustomer().getLogin());
            preparedStatement.setString(5, orderInfo.getFrilancer().getLogin());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public ArrayList<OrderInfo> getAllOrders(){
       ArrayList<OrderInfo> orderInfos = new ArrayList<OrderInfo>();

        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            statement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String timeCreation = rs.getString("time");
                String name = rs.getString("name");
                String customes = rs.getString("customes");
                UserInfoDAO userInfoDAO = new UserInfoDAO();
                UserInfo customer = userInfoDAO.getUserInfoById(rs.getString("customer"));
                UserInfo frilancer = userInfoDAO.getUserInfoById(rs.getString("frilancer"));
                OrderInfo orderInfo = new OrderInfo(timeCreation, customes, frilancer);
                orderInfo.setCustomer(customer);
                orderInfo.setCustomName(name);

                orderInfos.add(orderInfo);
            }
            rs.close();

            preparedStatement.close();
            //connection.close();
        }
        catch (SQLException ex){

        }

        return orderInfos;
    }
}
