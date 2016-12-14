package DAO.forum;

import DAO.forum.message.ForumMessageDAO;
import entity.jsp.forum.message.ForumMessage;
import entity.jsp.forum.theme.ForumThemeClass;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class ForumThemeDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO forumtheme(`id`, `timeCreation`, `title`, `imgLink`, `messages`) VALUES(?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT `id`, `timeCreation`, `title`, `imgLink`, `messages` FROM forumtheme";
    private final static String SET_NAMES = "SET NAMES utf8";
    private final static String SQL_UPDATE =
            "UPDATE forumtheme SET `id` = ?, `timeCreation` = ?," +
                    " `imgLink` = ?, `messages` = ? WHERE title = ?";

    public ForumThemeDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdb", "testuser", "123456");
            Statement statement = connection.createStatement();
            statement.executeQuery(SET_NAMES);
        }catch (SQLException ex){

        }
        catch (ClassNotFoundException ex){}

    }

    public ForumThemeClass getForumThemeByName(String name){
        ArrayList<ForumThemeClass> forumThemes = getAllThemes();

        for (ForumThemeClass forumTheme : forumThemes){
            if (forumTheme.getTitle().equals(name)){
                return forumTheme;
            }
        }

        return null;
    }

    public void addForumTheme(ForumThemeClass forumTheme){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, forumTheme.getTimeAgo());
            preparedStatement.setString(3, forumTheme.getTitle());
            preparedStatement.setString(4, forumTheme.getImgLink());
            String result = "";
            for(ForumMessage forumMessage : forumTheme.getMessages()){
                if (forumMessage != null){
                    result += "!" + forumMessage.getTitle();
                }
            }
            preparedStatement.setString(5, result);
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public void updateForumTheme(ForumThemeClass forumTheme){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, forumTheme.getTimeAgo());
            preparedStatement.setString(3, forumTheme.getImgLink());
            String result = "";
            for(ForumMessage forumMessage : forumTheme.getMessages()){
                result += "!" + forumMessage.getTitle();
            }
            preparedStatement.setString(4, result);
            preparedStatement.setString(5, forumTheme.getTitle());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public ArrayList<ForumThemeClass> getAllThemes(){
        ArrayList<ForumThemeClass> forumThemes = new ArrayList<ForumThemeClass>();

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
                ArrayList<ForumMessage> forumMessages = new ArrayList<ForumMessage>();
                ForumMessageDAO forumMessageDAO = new ForumMessageDAO();
                String[] stringArray = rs.getString("messages").split("!");
                for (String someString : stringArray){
                    if (!someString.equals("")){
                        ForumMessage forumMessage = forumMessageDAO.getForumThemeByName(someString);
                        forumMessages.add(forumMessage);
                    }

                }
                ForumThemeClass forumTheme = new ForumThemeClass(timeCreation, title, imgLink, "",
                        forumMessages);

                forumThemes.add(forumTheme);
            }
            rs.close();

            preparedStatement.close();
            //connection.close();
        }
        catch (SQLException ex){

        }

        return forumThemes;
    }
}
