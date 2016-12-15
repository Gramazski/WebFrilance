package servlets;

import DAO.forum.ForumThemeDAO;
import entity.jsp.forum.message.ForumMessage;
import entity.jsp.forum.theme.ForumThemeClass;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by gs on 14.12.2016.
 */
@WebServlet("/newtheme")
public class CreateNewThemeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                try {
                    String title = request.getParameter("title");
                    processMultipartRequest(request, response);
                } catch (Exception exception) {
                }
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/forum/");

        dispatcher.forward(request, response);
    }

    private void processMultipartRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        Iterator<FileItem> iterator = servletFileUpload.parseRequest(request).iterator();

        FileItem fileToUpload = null;
        String fileName = null;
        String title = null;
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
                if ("title".equals(item.getFieldName())) {
                    if (item.getString() == null || "".equals(item.getString())) {
                    }
                    title = item.getString();
                }
            }
        }
        if (fileToUpload != null && fileName != null) {
            saveImage(fileToUpload, fileName, request, title);
        }
    }


    private void saveImage(FileItem fileItem, String fileName, HttpServletRequest request, String title)
            throws Exception {
        File uploadedFile = new File(getServletContext().getRealPath("/img/forum/themes"), fileName);
        fileItem.write(uploadedFile);
        ForumThemeClass forumThemeClass =
                new ForumThemeClass(new SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis()), title,
                        "/img/forum/themes/" + fileName, "", new ArrayList<ForumMessage>());
        ForumThemeDAO forumThemeDAO = new ForumThemeDAO();
        forumThemeDAO.addForumTheme(forumThemeClass);
    }
}
