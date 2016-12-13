package DAO.forum.message;

import DAO.UserInfoDAO;
import entity.jsp.forum.message.ForumMessage;
import entity.user.info.UserInfo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class ForumMessageDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO forummessage(`id`, `timeCreation`, `title`, `imgLink`, `author`) VALUES(?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT id, `timeCreation`, `title`, `imgLink`, `author` FROM forummessage";
    private final static String SET_NAMES = "SET NAMES utf8";
    private final static String SQL_UPDATE =
            "UPDATE forummessage SET `id` = ?, `timeCreation` = ?," +
                    " `imgLink` = ?, `author` = ? WHERE title = ?";

    public ForumMessageDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdb", "testuser", "123456");
            Statement statement = connection.createStatement();
            statement.executeQuery(SET_NAMES);
        }catch (SQLException ex){

        }
        catch (ClassNotFoundException ex){}

    }

    public ForumMessage getForumThemeByName(String name){
       ArrayList<ForumMessage> forumMessages = getAllMessages();

        for (ForumMessage forumMessage : forumMessages){
            if (forumMessage.getTitle().equals(name)){
                return forumMessage;
            }
        }

        return null;
    }

    public void addForumMessage(ForumMessage forumMessage){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, forumMessage.getTimeAgo());
            preparedStatement.setString(3, forumMessage.getTitle());
            preparedStatement.setString(4, forumMessage.getImgLink());
            preparedStatement.setString(5, forumMessage.getAuthor().getLogin());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public void updateForumMessage(ForumMessage forumMessage){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, forumMessage.getTimeAgo());
            preparedStatement.setString(3, forumMessage.getImgLink());
            preparedStatement.setString(4, forumMessage.getAuthor().getLogin());
            preparedStatement.setString(5, forumMessage.getTitle());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public ArrayList<ForumMessage> getAllMessages(){
        ArrayList<ForumMessage> forumMessages = new ArrayList<ForumMessage>();

        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            statement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String timeCreation = rs.getString("timeCreation");
                String title = rs.getString("title");
                String imgLink = rs.getString("imgLink");
                UserInfoDAO userInfoDAO = new UserInfoDAO();
                UserInfo author = userInfoDAO.getUserInfoById(rs.getString("author"));
                ForumMessage forumMessage = new ForumMessage(timeCreation, title, imgLink, author);

                forumMessages.add(forumMessage);
            }
            rs.close();

            preparedStatement.close();
            //connection.close();
        }
        catch (SQLException ex){

        }

        return forumMessages;
    }
}
