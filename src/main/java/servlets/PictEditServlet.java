package servlets;
import DAO.UserInfoDAO;
import entity.user.info.UserInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class PictEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    processMultipartRequest(request, response);
                } catch (Exception exception) {
                }
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/user/cabinet/cabinet_template.jsp");

        dispatcher.forward(request, response);
    }

    private void processMultipartRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        Iterator<FileItem> iterator = servletFileUpload.parseRequest(request).iterator();

        FileItem fileToUpload = null;
        String fileName = null;
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
            }
        }
        if (fileToUpload != null && fileName != null) {
            saveImage(fileToUpload, fileName, request);
        }
    }


    private void saveImage(FileItem fileItem, String fileName, HttpServletRequest request)
            throws Exception {
        File uploadedFile = new File(getServletContext().getRealPath("/img/avatars/"), fileName);
        fileItem.write(uploadedFile);
        HttpSession session = request.getSession();
        UserInfo userInfo =  (UserInfo)session.getAttribute("user");
        userInfo.setImgLink("/img/avatars/" + fileName);
        session.setAttribute("user", userInfo);

        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.updateUserInfo(userInfo);
    }
}
