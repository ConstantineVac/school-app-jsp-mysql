package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.CityDAOImpl;
import gr.aueb.cf.schoolapp.dao.ICityDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.CityDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.model.City;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.CityServiceImpl;
import gr.aueb.cf.schoolapp.service.ICityService;
import gr.aueb.cf.schoolapp.service.exceptions.CityNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/schoolapp/citySearch")
public class SearchCityController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ICityDAO cityDAO = new CityDAOImpl();
    ICityService cityService = new CityServiceImpl(cityDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/schoolapp/menu")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();

        String message = "";
        try {
            List<City> cities = cityService.getCitiesByCityName(name);
            if (cities.size() == 0) {
                request.setAttribute("cityNotFound", true);
                request.getRequestDispatcher("/schoolapp/menu")
                        .forward(request, response);
            }
            request.setAttribute("cities", cities);
            request.getRequestDispatcher("/school/static/templates/cities.jsp").forward(request, response);
        } catch (CityDAOException | CityNotFoundException e) {
            message = e.getMessage();
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", message);
            request.getRequestDispatcher("/school/static/templates/citiesmenu.jsp").forward(request, response);
        }
    }
}
