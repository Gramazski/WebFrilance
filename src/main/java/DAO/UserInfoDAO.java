package DAO;

import entity.Mind.CustomerMind;
import entity.jsp.project.info.user.SimpleUserClass;
import entity.project.custom.CustomInfo;
import entity.project.info.ProjectInfo;
import entity.project.order.OrderInfo;
import entity.user.info.UserInfo;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by gs on 12.12.2016.
 */
public class UserInfoDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO userinfo(`id`, `name`, `imgLink`, `years`, `timeCreation`," +
                    " `cost`, `costFrom`, `description`, `minds`, `works`, `surname`," +
                    " `birthday`, `sex`, `role`, `login`, `email`, `password`, `country`," +
                    " `points`, `orders`, `messages` ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT `id`, `name`, `imgLink`, `years`, `timeCreation`," +
                    " `cost`, `costFrom`, `description`, `minds`, `works`, `surname`," +
                    " `birthday`, `sex`, `role`, `login`, `email`, `password`, `country`," +
                    " `points`, `orders`, `messages` FROM userinfo";
    private final static String SET_NAMES = "SET NAMES utf8";
    private final static String SQL_UPDATE =
            "UPDATE userinfo SET `id` = ?, `name` = ?, `imgLink` = ?, `years` = ?, `timeCreation` = ?," +
                    " `cost` = ?, `costFrom` = ?, `description` = ?, `minds` = ?, `works` = ?, `surname` = ?," +
                    " `birthday` = ?, `sex` = ?, `role` = ?, `email` = ?," +
                    " `password` = ?, `country` = ?," +
                    " `points` = ?, `orders` = ?, `messages` = ? WHERE login = ?";

    public UserInfoDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdb", "testuser", "123456");
            Statement statement = connection.createStatement();
            statement.executeQuery(SET_NAMES);
        }catch (SQLException ex){

        }
        catch (ClassNotFoundException ex){}

    }

    public UserInfo getUserInfoById(String id){
        UserInfo userInfo = new UserInfo();
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String  name  = rs.getString("name");
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }

        return new UserInfo();
    }

    public void addUserInfo(UserInfo userInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, userInfo.getName());
            preparedStatement.setString(3, userInfo.getImgLink());
            preparedStatement.setString(4, userInfo.getYears());
            preparedStatement.setString(5, userInfo.getDateCreation());
            preparedStatement.setString(6, userInfo.getCost());
            preparedStatement.setString(7, userInfo.getCostFrom());
            preparedStatement.setString(8, userInfo.getDescription());
            String result = "";
            for(CustomerMind mind : userInfo.getMinds()){
                result.endsWith("!" + mind.getTitle());
            }
            preparedStatement.setString(9, result);
            result = "";
            for(ProjectInfo projectInfo : userInfo.getProjectInfos()){
                result.endsWith("!" + projectInfo.getTitle());
            }
            preparedStatement.setString(10, result);
            preparedStatement.setString(11, userInfo.getSurname());
            preparedStatement.setString(12, userInfo.getBirthday());
            preparedStatement.setString(13, userInfo.getSex());
            preparedStatement.setString(14, userInfo.getRole());
            preparedStatement.setString(15, userInfo.getLogin());
            preparedStatement.setString(16, userInfo.getEmail());
            preparedStatement.setString(17, userInfo.getPassword());
            preparedStatement.setString(18, userInfo.getCountry());
            preparedStatement.setString(19, userInfo.getPoints());
            result = "";
            for(String orderInfo : userInfo.getOrders()){
                result.endsWith("!" + orderInfo);
            }
            preparedStatement.setString(20, result);
            result = "";
            for(String orderInfo : userInfo.getMessages()){
                result.endsWith("!" + orderInfo);
            }
            preparedStatement.setString(21, result);
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public void updateUserInfo(UserInfo userInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, userInfo.getName());
            preparedStatement.setString(3, userInfo.getImgLink());
            preparedStatement.setString(4, userInfo.getYears());
            preparedStatement.setString(5, userInfo.getDateCreation());
            preparedStatement.setString(6, userInfo.getCost());
            preparedStatement.setString(7, userInfo.getCostFrom());
            preparedStatement.setString(8, userInfo.getDescription());
            String result = "";
            for(CustomerMind mind : userInfo.getMinds()){
                result.endsWith("!" + mind.getTitle());
            }
            preparedStatement.setString(9, result);
            result = "";
            for(ProjectInfo projectInfo : userInfo.getProjectInfos()){
                result.endsWith("!" + projectInfo.getTitle());
            }
            preparedStatement.setString(10, result);
            preparedStatement.setString(11, userInfo.getSurname());
            preparedStatement.setString(12, userInfo.getBirthday());
            preparedStatement.setString(13, userInfo.getSex());
            preparedStatement.setString(14, userInfo.getRole());
            preparedStatement.setString(21, userInfo.getLogin());
            preparedStatement.setString(15, userInfo.getEmail());
            preparedStatement.setString(16, userInfo.getPassword());
            preparedStatement.setString(17, userInfo.getCountry());
            preparedStatement.setString(18, userInfo.getPoints());
            result = "";
            for(String orderInfo : userInfo.getOrders()){
                result.endsWith("!" + orderInfo);
            }
            preparedStatement.setString(19, result);
            result = "";
            for(String orderInfo : userInfo.getMessages()){
                result.endsWith("!" + orderInfo);
            }
            preparedStatement.setString(20, result);
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public ArrayList<UserInfo> getAllUsers(){
        ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo();

        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            statement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                userInfo.setDateCreation(rs.getString("timeCreation"));
                userInfo.setSurname(rs.getString("surname"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setName(rs.getString("name"));
                userInfo.setLogin(rs.getString("login"));
                userInfo.setBirthday(rs.getString("birthday"));
                userInfo.setCost(rs.getString("cost"));
                userInfo.setCostFrom(rs.getString("costFrom"));
                userInfo.setCountry(rs.getString("country"));
                userInfo.setDescription(rs.getString("description"));
                userInfo.setEmail(rs.getString("email"));
                userInfo.setImgLink(rs.getString("imgLink"));
                userInfo.setPoints(rs.getString("points"));
                userInfo.setRole(rs.getString("role"));
                userInfo.setSex(rs.getString("sex"));
                userInfo.setYears(rs.getString("years"));
                ArrayList<CustomerMind> customerMinds = new ArrayList<CustomerMind>();
                String[] stringArray = rs.getString("minds").split("!");
                for (String someString : stringArray){
                    customerMinds.add(new CustomerMind(new UserInfo(), new UserInfo(), "", "", "", someString));
                }
                userInfo.setMinds(customerMinds);
                ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
                stringArray = rs.getString("works").split("!");
                for (String someString : stringArray){
                    projectInfos.add(new ProjectInfo(new UserInfo(), new CustomInfo("", "", "",
                            new SimpleUserClass("", ""), new ArrayList<OrderInfo>()), "", ""));
                }
                userInfo.setProjectInfos(projectInfos);
                ArrayList<String> orders = new ArrayList<String>();
                stringArray = rs.getString("works").split("!");
                for (String someString : stringArray){
                    orders.add(someString);
                }
                userInfo.setOrders(orders);
                ArrayList<String> messages = new ArrayList<String>();
                stringArray = rs.getString("works").split("!");
                for (String someString : stringArray){
                    messages.add(someString);
                }
                userInfo.setMessages(messages);
                userInfo.setBirthday(rs.getString("birthday"));

                userInfos.add(userInfo);
            }
            rs.close();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }

        return userInfos;
    }
}
