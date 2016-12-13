package action.command;

import DAO.UserInfoDAO;
import action.ActionCommand;
import entity.user.info.UserInfo;
import manager.ConfigurationManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Iterator;

/**
 * Created by gs on 13.12.2016.
 */
public class ChangeDataCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
// извлечение из запроса логина и пароля
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        String fileName = "";

        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    fileName = processMultipartRequest(request);
                } catch (Exception exception) {

                }
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }

        if ((fileName != null) && (fileName != "")){
            userInfo.setImgLink(fileName);
        }

        if ((request.getParameter("name") != null) && (request.getParameter("name") != "")){
            userInfo.setName(request.getParameter("name"));
        }
        if ((request.getParameter("surname") != null) && (request.getParameter("surname") != "")){
            userInfo.setSurname(request.getParameter("surname"));
        }
        if ((request.getParameter("country") != null) && (request.getParameter("country") != "")){
            userInfo.setCountry(request.getParameter("country"));
        }
        if ((request.getParameter("birthday") != null) && (request.getParameter("birthday") != "")){
            userInfo.setBirthday(request.getParameter("birthday"));
        }
        if ((request.getParameter("sex") != null) && (request.getParameter("sex") != "")){
            userInfo.setSex(request.getParameter("sex"));
        }
        if ((request.getParameter("description") != null) && (request.getParameter("description") != "")){
            userInfo.setDescription(request.getParameter("description"));
        }
        if ((request.getParameter("cost") != null) && (request.getParameter("cost") != "")){
            userInfo.setCost(request.getParameter("cost"));
        }
        if ((request.getParameter("costFrom") != null) && (request.getParameter("costFrom") != "")){
            userInfo.setCostFrom(request.getParameter("costFrom"));
        }
// проверка логина и пароля
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.updateUserInfo(userInfo);
        session.setAttribute("user", userInfo);
        page = ConfigurationManager.getProperty("path.page.user_cabinet");
        return page;
    }


    private String processMultipartRequest(HttpServletRequest request)
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
            saveImage(fileToUpload, fileName);
        }

        return fileName;
    }


    private void saveImage(FileItem fileItem, String fileName)
            throws Exception {
        File uploadedFile = new File(System.getenv("CATALINA_HOME") + File.separator + "webapps"
                + File.separator + "ROOT" + File.separator + "img", fileName);
        fileItem.write(uploadedFile);
    }
}
