package DAO.auth;

import entity.user.info.AuthorizationUserInfo;
import entity.user.info.UserInfo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gs on 12.12.2016.
 */
public class AuthUserDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO authuser(id, " +
                    "login, password, email ) VALUES(?,?,?,?)";
    private final static String SQL_GET =
            "SELECT email, login, password FROM authuser";
    private final static String SQL_GET_ID = "SELECT count FROM idtable WHERE id = 0";
    private final static String SQL_UPDATE_ID = "INSERT INTO idtable(id, " +
            "count) VALUES(0,?)";
    private final static String SET_NAMES = "SET NAMES utf8";

    public AuthUserDAO(){
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

    public ArrayList<AuthorizationUserInfo> getAllUsers(){
        ArrayList<AuthorizationUserInfo> authorizationUserInfos = new ArrayList<AuthorizationUserInfo>();
        AuthorizationUserInfo authorizationUserInfo;
        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            statement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                authorizationUserInfo = new AuthorizationUserInfo(rs.getString("login"),
                        rs.getString("password"), rs.getString("email"));
                authorizationUserInfos.add(authorizationUserInfo);
            }
            rs.close();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }

        return authorizationUserInfos;
    }

    public void addUserInfo(AuthorizationUserInfo userInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(2, userInfo.getLogin());
            preparedStatement.setString(3, userInfo.getPassword());
            preparedStatement.setString(4, userInfo.getEmail());
            preparedStatement.setInt(1, 1);
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }
}
