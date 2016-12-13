package DAO.project.custom;

import DAO.project.order.OrderInfoDAO;
import entity.jsp.project.info.user.SimpleUserClass;
import entity.project.custom.CustomInfo;
import entity.project.order.OrderInfo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class CustomInfoDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO custominfo(`id`, `timeCreation`, `name`, `body`," +
                    " `price`, `type`, `customCondition`, `author`, `orders`) VALUES(?,?,?,?,?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT `id`, `timeCreation`, `name`, `body`," +
                    " `price`, `type`, `customCondition`, `author`, `orders` FROM custominfo";
    private final static String SET_NAMES = "SET NAMES utf8";
    private final static String SQL_UPDATE =
            "UPDATE custominfo SET `id` = ?, `timeCreation` = ?, `body` = ?," +
                    " `price` = ?, `type` = ?, `customCondition` = ?, `author` = ?, `orders` = ? WHERE name = ?";

    public CustomInfoDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdb", "testuser", "123456");
            Statement statement = connection.createStatement();
            statement.executeQuery(SET_NAMES);
        }catch (SQLException ex){

        }
        catch (ClassNotFoundException ex){}

    }

    public CustomInfo getUserInfoByTitle(String name){
        ArrayList<CustomInfo> customInfos = getAllCustoms();

        for (CustomInfo customInfo : customInfos){
            if (customInfo.getName().equals(name)){
                return customInfo;
            }
        }

        return null;
    }

    public void addCustomInfo(CustomInfo customInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, customInfo.getTimeAgo());
            preparedStatement.setString(3, customInfo.getName());
            preparedStatement.setString(4, customInfo.getBody());
            preparedStatement.setString(5, customInfo.getPrice());
            preparedStatement.setString(6, customInfo.getType());
            preparedStatement.setString(7, customInfo.getCondition());
            preparedStatement.setString(8, customInfo.getAuthor().getName());
            String result = "";
            for(OrderInfo orderInfo : customInfo.getFrilancersOrders()){
                if (orderInfo != null){
                    result.endsWith("!" + orderInfo.getCustomName());
                }
            }
            preparedStatement.setString(9, result);
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public void updateCustomInfo(CustomInfo customInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, customInfo.getTimeAgo());
            preparedStatement.setString(9, customInfo.getName());
            preparedStatement.setString(3, customInfo.getBody());
            preparedStatement.setString(4, customInfo.getPrice());
            preparedStatement.setString(5, customInfo.getType());
            preparedStatement.setString(6, customInfo.getCondition());
            preparedStatement.setString(7, customInfo.getAuthor().getName());
            String result = "";
            for(OrderInfo orderInfo : customInfo.getFrilancersOrders()){
                if (orderInfo != null){
                    result += "!" + orderInfo.getCustomName();
                }
            }
            preparedStatement.setString(8, result);
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public ArrayList<CustomInfo> getAllCustoms(){
        ArrayList<CustomInfo> customInfos = new ArrayList<CustomInfo>();

        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            statement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String timeCreation = rs.getString("timeCreation");
                String name = rs.getString("name");
                String body = rs.getString("body");
                String price = rs.getString("price");
                String type = rs.getString("type");
                String condition = rs.getString("customCondition");
                SimpleUserClass author = new SimpleUserClass(rs.getString("author"), "");
                ArrayList<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
                OrderInfoDAO orderInfoDAO = new OrderInfoDAO();
                String[] stringArray = rs.getString("orders").split("!");
                for (String someString : stringArray){
                    if (!someString.equals("")){
                        OrderInfo orderInfo = orderInfoDAO.getUserInfoByName(someString);
                        orderInfos.add(orderInfo);
                    }
                }

                CustomInfo customInfo = new CustomInfo(timeCreation, body, name, author, orderInfos);
                customInfo.setCondition(condition);
                customInfo.setPrice(price);
                customInfo.setType(type);
                customInfos.add(customInfo);
            }
            rs.close();

            preparedStatement.close();
            //connection.close();
        }
        catch (SQLException ex){

        }

        return customInfos;
    }
}
