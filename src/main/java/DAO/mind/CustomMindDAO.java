package DAO.mind;

import entity.Mind.CustomerMind;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class CustomMindDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO customminds(`id`, `author`, `frilancer`, `body`," +
                    " `mark`, `time`, `title`) VALUES(?,?,?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT `id`, `author`, `frilancer`, `body`, `mark`, `time`, `title` FROM customminds";
    private final static String SET_NAMES = "SET NAMES utf8";
    private final static String SQL_UPDATE =
            "UPDATE customminds SET `id` = ?, `author` = ?, `frilancer` = ?, `body` = ?," +
                    " `mark` = ?, `time` = ? WHERE title = ?";

    public CustomMindDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdb", "testuser", "123456");
            Statement statement = connection.createStatement();
            statement.executeQuery(SET_NAMES);
        }catch (SQLException ex){

        }
        catch (ClassNotFoundException ex){}

    }

    public CustomerMind getMindByName(String name){
        ArrayList<CustomerMind> customerMinds = getAllMinds();

        for (CustomerMind customerMind : customerMinds){
            if (customerMind.getTitle().equals(name)){
                return customerMind;
            }
        }

        return null;
    }

    public void addCustomMind(CustomerMind customerMind){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, customerMind.getAuthor());
            preparedStatement.setString(3, "-");
            preparedStatement.setString(4, customerMind.getBody());
            preparedStatement.setString(5, customerMind.getMark());
            preparedStatement.setString(6, customerMind.getTime());
            preparedStatement.setString(7, customerMind.getTitle());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public void updateCustomerMind(CustomerMind customerMind){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(2, customerMind.getAuthor());
            preparedStatement.setString(3, "-");
            preparedStatement.setString(4, customerMind.getBody());
            preparedStatement.setString(5, customerMind.getMark());
            preparedStatement.setString(6, customerMind.getTime());
            preparedStatement.setString(7, customerMind.getTitle());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public ArrayList<CustomerMind> getAllMinds(){
        ArrayList<CustomerMind> customerMinds = new ArrayList<CustomerMind>();

        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            statement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String author = rs.getString("author");
                String body = rs.getString("body");
                String mark = rs.getString("mark");
                String time = rs.getString("time");
                String title = rs.getString("title");

                customerMinds.add(new CustomerMind(author, body, mark, time, title));
            }
            rs.close();

            preparedStatement.close();
            //connection.close();
        }
        catch (SQLException ex){

        }

        return customerMinds;
    }
}
