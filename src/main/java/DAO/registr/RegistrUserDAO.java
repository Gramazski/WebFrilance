package DAO.registr;

/**
 * Created by gs on 12.12.2016.
 */
import entity.user.info.RegistrationUserInfo;
import entity.user.info.UserInfo;

import java.sql.*;

/**
 * Created by gs on 12.12.2016.
 */
public class RegistrUserDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO reguser(id, name, surname, birthday, sex, role," +
                    "email, login, password ) VALUES(?,?,?,?,?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT id, name, imgLink, years, timeCreation, cost," +
                    "costFrom, description, minds, works FROM userinfo WHERE id = ?";
    private final static String SET_NAMES = "SET NAMES utf8";

    public RegistrUserDAO(){
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

    public void addUserInfo(RegistrationUserInfo userInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(2, userInfo.getName());
            preparedStatement.setString(3, userInfo.getSurname());
            preparedStatement.setString(5, userInfo.getSex());
            preparedStatement.setString(6, userInfo.getRole());
            preparedStatement.setString(4, userInfo.getBirthday());
            preparedStatement.setString(7, userInfo.getEmail());
            preparedStatement.setString(8, userInfo.getLogin());
            preparedStatement.setString(9, userInfo.getPassword());
            preparedStatement.setString(1, "1");
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }
}
