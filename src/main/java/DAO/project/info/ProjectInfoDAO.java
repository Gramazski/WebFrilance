package DAO.project.info;

import DAO.UserInfoDAO;
import DAO.mind.CustomMindDAO;
import DAO.project.custom.CustomInfoDAO;
import entity.Mind.CustomerMind;
import entity.jsp.project.info.user.SimpleUserClass;
import entity.project.custom.CustomInfo;
import entity.project.info.ProjectInfo;
import entity.project.order.OrderInfo;
import entity.user.info.UserInfo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gs on 13.12.2016.
 */
public class ProjectInfoDAO {
    private Connection connection;
    private final static String SQL_INSERT =
            "INSERT INTO projectinfo(`id`, `frilancer`, `minds`, `custominfo`, `description`," +
                    " `title`, imgLink) VALUES(?,?,?,?,?,?,?)";
    private final static String SQL_GET =
            "SELECT `id`, `frilancer`, `minds`, `custominfo`, `description`," +
                    " `title`, `imgLink` FROM projectinfo";
    private final static String SET_NAMES = "SET NAMES utf8";
    private final static String SQL_UPDATE =
            "UPDATE projectinfo SET `id` = ?, `frilancer` = ?, `minds` = ?, `custominfo` = ?, `description` = ?," +
                    "imgLink = ? WHERE title = ?";

    public ProjectInfoDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverdb", "testuser", "123456");
            Statement statement = connection.createStatement();
            statement.executeQuery(SET_NAMES);
        }catch (SQLException ex){

        }
        catch (ClassNotFoundException ex){}

    }

    public ProjectInfo getUserInfoByTitle(String title){
        ArrayList<ProjectInfo> projectInfos = getAllProjects();

        for (ProjectInfo projectInfo : projectInfos){
            if (projectInfo.getTitle().equals(title)){
                return projectInfo;
            }
        }

        return null;
    }

    public void addProjectInfo(ProjectInfo projectInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, projectInfo.getFrilancer().getLogin());
            String result = "";
            for(CustomerMind mind : projectInfo.getMinds()){
                result += "!" + mind.getTitle();
            }
            preparedStatement.setString(3, result);
            preparedStatement.setString(4, projectInfo.getCustomInfo().getName());
            preparedStatement.setString(5, projectInfo.getDescription());
            preparedStatement.setString(6, projectInfo.getTitle());
            preparedStatement.setString(7, projectInfo.getImgLink());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public void updateProjectInfo(ProjectInfo projectInfo){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, projectInfo.getFrilancer().getLogin());
            String result = "";
            for(CustomerMind mind : projectInfo.getMinds()){
                result += "!" + mind.getTitle();
            }
            preparedStatement.setString(3, result);
            preparedStatement.setString(4, projectInfo.getCustomInfo().getName());
            preparedStatement.setString(5, projectInfo.getDescription());
            preparedStatement.setString(7, projectInfo.getTitle());
            preparedStatement.setString(6, projectInfo.getImgLink());
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException ex){

        }
    }

    public ArrayList<ProjectInfo> getAllProjects(){
        ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();

        PreparedStatement preparedStatement = null;
        Statement statement = null;

        try{
            preparedStatement = connection.prepareStatement(SQL_GET);
            statement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                UserInfoDAO userInfoDAO = new UserInfoDAO();
                UserInfo userInfo = new UserInfo();
                userInfo.setLogin(rs.getString("frilancer"));
                ArrayList<CustomerMind> customerMinds = new ArrayList<CustomerMind>();
                CustomMindDAO customMindDAO = new CustomMindDAO();
                String[] stringArray = rs.getString("minds").split("!");
                for (String someString : stringArray){
                    if (!someString.equals("")){
                        customerMinds.add(customMindDAO.getMindByName(someString));
                    }
                }
                CustomInfoDAO customInfoDAO = new CustomInfoDAO();
                CustomInfo customInfo = new CustomInfo("", "", "", new SimpleUserClass("", ""), new ArrayList<OrderInfo>());
                if (!rs.getString("custominfo").equals("")){
                    customInfo = customInfoDAO.getUserInfoByTitle(rs.getString("custominfo"));
                }

                String description = rs.getString("description");
                String title = rs.getString("title");
                String imgLink = rs.getString("imgLink");

                ProjectInfo projectInfo = new ProjectInfo(userInfo, customInfo, imgLink, title);
                projectInfo.setDescription(description);
                projectInfo.setMinds(customerMinds);

                projectInfos.add(projectInfo);
            }
            rs.close();

            preparedStatement.close();
            //connection.close();
        }
        catch (SQLException ex){

        }

        return projectInfos;
    }
}
