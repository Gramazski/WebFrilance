package servlets;

import DAO.project.custom.CustomInfoDAO;
import entity.jsp.job.ServiceProjectClass;
import entity.jsp.user.category.CategoryClass;
import entity.project.custom.CustomInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        createJobPanel(req);
        createCategoryList(req);
        createProjectsList(req);
        createGeneralProjectsList(req);
        req.setAttribute("pageCreation", 1);
        req.getRequestDispatcher("/jsp/job/").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/job/").forward(req, resp);
        //super.doPost(req, resp);
    }

    private void createJobPanel(HttpServletRequest request){
        CustomInfoDAO customInfoDAO = new CustomInfoDAO();
        ArrayList<CustomInfo> customInfos = customInfoDAO.getAllCustoms();

        request.setAttribute("jobsForFrilancer", customInfos);
    }

    private void createCategoryList(HttpServletRequest request){
        ArrayList<CategoryClass> categoryClasses = new ArrayList<CategoryClass>();

        categoryClasses.add(new CategoryClass("#", "2", "Администрирование сайтов"));
        categoryClasses.add(new CategoryClass("#", "3", "Аудио, Видео и Мультимедиа"));
        categoryClasses.add(new CategoryClass("#", "1", "Графика и Фотография"));

        request.setAttribute("categories", categoryClasses);
    }

    private void createProjectsList(HttpServletRequest request){
        ArrayList<ServiceProjectClass> serviceProjectClasses = new ArrayList<ServiceProjectClass>();

        serviceProjectClasses.add(new ServiceProjectClass("#", "Проекты", "12"));
        serviceProjectClasses.add(new ServiceProjectClass("#", "Вакансии", "11"));
        serviceProjectClasses.add(new ServiceProjectClass("#", "Конкурсы", "10"));

        request.setAttribute("projectsList", serviceProjectClasses);
    }

    private void createGeneralProjectsList(HttpServletRequest request){
        ArrayList<ServiceProjectClass> serviceProjectClasses = new ArrayList<ServiceProjectClass>();

        serviceProjectClasses.add(new ServiceProjectClass("#", "Завершенные", "12"));
        serviceProjectClasses.add(new ServiceProjectClass("#", "Закрытые", "11"));

        request.setAttribute("projectsGeneralList", serviceProjectClasses);
    }
}
