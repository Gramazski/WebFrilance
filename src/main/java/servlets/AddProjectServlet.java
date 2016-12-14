package servlets;

import DAO.UserInfoDAO;
import DAO.project.info.ProjectInfoDAO;
import entity.Mind.CustomerMind;
import entity.jsp.project.info.user.SimpleUserClass;
import entity.project.custom.CustomInfo;
import entity.project.info.ProjectInfo;
import entity.project.order.OrderInfo;
import entity.user.info.UserInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by gs on 14.12.2016.
 */
@WebServlet("/addproject")
public class AddProjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    processMultipartRequest(request);
                } catch (Exception exception) {
                }
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/portfolio/");

        dispatcher.forward(request, response);
    }


    private void saveImage(FileItem fileItem, String title, String description, String fileName, HttpServletRequest request)
            throws Exception {
        File uploadedFile = new File(getServletContext().getRealPath("/img/avatars/"), fileName);
        fileItem.write(uploadedFile);
        HttpSession session = request.getSession();
        UserInfo userInfo =  (UserInfo)session.getAttribute("user");
        ProjectInfo projectInfo = new ProjectInfo(userInfo, new CustomInfo("", "", "",
                new SimpleUserClass(userInfo.getLogin(), userInfo.getYears()), new ArrayList<OrderInfo>()),
                "/img/avatars/" + fileName, title);
        projectInfo.setDescription(description);
        projectInfo.setMinds(new ArrayList<CustomerMind>());
        ProjectInfoDAO projectInfoDAO = new ProjectInfoDAO();
        projectInfoDAO.addProjectInfo(projectInfo);
        userInfo.setImgLink("/img/avatars/" + fileName);
        userInfo.getProjectInfos().add(projectInfo);
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.updateUserInfo(userInfo);
        session.setAttribute("user", userInfo);
    }

    private String processMultipartRequest(HttpServletRequest request)
            throws Exception {
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        Iterator<FileItem> iterator = servletFileUpload.parseRequest(request).iterator();

        FileItem fileToUpload = null;
        String fileName = null;
        String title = null;
        String description = null;
        while (iterator.hasNext()) {
            FileItem item = iterator.next();
            if (!item.isFormField()) {
                if ("file_to_upload".equals(item.getFieldName())) {
                    if ("".equals(item.getName())) {

                    }
                    fileToUpload = item;
                    fileName = item.getName();
                }
            }
            else {
                if ("file_name".equals(item.getFieldName())) {
                    if (item.getString() == null || "".equals(item.getString())) {
                    }
                    fileName = item.getString();
                }
                if ("title".equals(item.getFieldName())) {
                    if (item.getString() == null || "".equals(item.getString())) {

                    }
                    title = item.getString();
                }
                if ("description".equals(item.getFieldName())) {
                    if (item.getString() == null || "".equals(item.getString())) {

                    }
                    description = item.getString();
                }
            }
        }
        if (fileToUpload != null && description != null) {
            saveImage(fileToUpload, title, description, fileName, request);
        }

        return title;
    }
}
