package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.CityDAOImpl;
import gr.aueb.cf.schoolapp.dao.ICityDAO;
import gr.aueb.cf.schoolapp.dao.IStudentDAO;
import gr.aueb.cf.schoolapp.dao.StudentDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.CityDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.model.City;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.CityServiceImpl;
import gr.aueb.cf.schoolapp.service.ICityService;
import gr.aueb.cf.schoolapp.service.IStudentService;
import gr.aueb.cf.schoolapp.service.StudentServiceImpl;
import gr.aueb.cf.schoolapp.service.exceptions.CityNotFoundException;
import gr.aueb.cf.schoolapp.validator.StudentValidator;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/schoolapp/studentInsert")
public class InsertStudentController extends HttpServlet {
    private final IStudentDAO studentDAO = new StudentDAOImpl();
    private final IStudentService studentService = new StudentServiceImpl(studentDAO);
    private final ICityDAO cityDAO = new CityDAOImpl();
    private final ICityService cityService = new CityServiceImpl(cityDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet method is called");

        try {
            List<City> cities = cityService.getAllCities();
            request.setAttribute("cities", cities);
            request.getRequestDispatcher("/school/static/templates/studentsmenu.jsp")
                    .forward(request, response);
        } catch (CityDAOException e) {
            request.setAttribute("error1", "Error while retrieving the list for cities");
            request.getRequestDispatcher("/school/static/templates/studentsmenu.jsp")
                    .forward(request, response);

        } catch (CityNotFoundException e) {
            request.setAttribute("error1", "No cities found in the database");
            request.getRequestDispatcher("/school/static/templates/studentsmenu.jsp")
                    .forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // Set character encoding to properly handle non-ASCII characters in the request
        System.out.println("doPost method is called");

        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();
        String gender = request.getParameter("gender").trim();
        String birthdate = request.getParameter("birthdate").trim();
        String cityIdParam = request.getParameter("cityId").trim();

        // Check if any of the required fields are empty
        if (firstname.isEmpty() || lastname.isEmpty() || gender.isEmpty() || birthdate.isEmpty() || cityIdParam.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            reloadCitiesAndForward(request, response);
            return;
        }

        // Convert the birthdate to a Date object
        Date birthDateValue;
        try {
            birthDateValue = Date.valueOf(birthdate);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Invalid date format for Birthdate.");
            reloadCitiesAndForward(request, response);
            return;
        }

        int cityId;
        try {
            cityId = Integer.parseInt(cityIdParam);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid city ID. Please provide a valid integer value.");
            reloadCitiesAndForward(request, response);
            return;
        }

        StudentInsertDTO studentInsertDTO = new StudentInsertDTO();
        studentInsertDTO.setFirstname(firstname);
        studentInsertDTO.setLastname(lastname);
        studentInsertDTO.setGender(gender);
        studentInsertDTO.setBirthdate(birthDateValue);
        studentInsertDTO.setCityId(cityId);

        try {
            Map<String, String> errors = StudentValidator.validate(studentInsertDTO);
            if (!errors.isEmpty()) {
                StringBuilder errorMessage = new StringBuilder();
                for (String field : errors.keySet()) {
                    errorMessage.append(field).append(": ").append(errors.get(field)).append(" ");
                }
                request.setAttribute("error", errorMessage.toString());
                reloadCitiesAndForward(request, response);
                return;
            }
            Student student = studentService.insertStudent(studentInsertDTO);
            request.setAttribute("insertedStudent", student);
            request.getRequestDispatcher("/school/static/templates/studentInserted.jsp").forward(request, response);
        } catch (StudentDAOException e) {
            request.setAttribute("sqlError", true);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
        }
    }

    private void reloadCitiesAndForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<City> cities = cityService.getAllCities();
            request.setAttribute("cities", cities);
            request.getRequestDispatcher("/school/static/templates/studentsmenu.jsp")
                    .forward(request, response);
        } catch (CityDAOException e1) {
            request.setAttribute("error1", "Error while retrieving the list for cities");
            request.getRequestDispatcher("/school/static/templates/studentsmenu.jsp")
                    .forward(request, response);
        } catch (CityNotFoundException e1) {
            request.setAttribute("error1", "No cities found in the database");
            request.getRequestDispatcher("/school/static/templates/studentsmenu.jsp")
                    .forward(request, response);
        }
    }

}
