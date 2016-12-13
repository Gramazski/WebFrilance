package servlets;

import entity.jsp.job.ServiceProjectClass;
import entity.jsp.main.job.JobForFrilancerClass;
import entity.jsp.user.category.CategoryClass;

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
        ArrayList<JobForFrilancerClass> jobForFrilancerClasses = new ArrayList<JobForFrilancerClass>();
        jobForFrilancerClasses.add(new JobForFrilancerClass("#", "Программист в Игровой проект на постоянную удаленную работу", "$1500", "5 заявок",
                "В команду из 6 программистов нужен сотрудник на постоянную основу для разработки и улучшения имеющихся игровых проектов связанных со Steam, WoT и E-commerce. 2+ млн посещаемости ежемесячно насчитывает...",
                "Веб-программирование", "#", "12.11.2016 в 22:44", "16 дней назад", "вакансия"));
        jobForFrilancerClasses.add(new JobForFrilancerClass("#", "Статьи про самостоятельное оформление тур. и миграционных документов", "", "18 заявок",
                "На сайт для самостоятельных путешественников и мигрантов нужны статьи про: визы, загранпаспорта, миграционные карты, ВНЖ, гражданство и так далее. Всего около 500 статей. Особое внимание уделяется дос...",
                "Копирайтинг", "#", "12.11.2016 в 22:44", "16 дней назад", ""));

        request.setAttribute("jobsForFrilancer", jobForFrilancerClasses);
    }

    private void createCategoryList(HttpServletRequest request){
        ArrayList<CategoryClass> categoryClasses = new ArrayList<CategoryClass>();

        categoryClasses.add(new CategoryClass("#", "200", "Администрирование сайтов"));
        categoryClasses.add(new CategoryClass("#", "200", "Аудио, Видео и Мультимедиа"));
        categoryClasses.add(new CategoryClass("#", "200", "Графика и Фотография"));

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
