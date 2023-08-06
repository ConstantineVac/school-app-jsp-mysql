package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.ISpecialtyDAO;
import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.SpecialtyDAOImpl;
import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.CityDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.SpecialtyDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.model.City;
import gr.aueb.cf.schoolapp.model.Specialty;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.ISpecialtyService;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import gr.aueb.cf.schoolapp.service.SpecialtyServiceImpl;
import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
import gr.aueb.cf.schoolapp.service.exceptions.CityNotFoundException;
import gr.aueb.cf.schoolapp.service.exceptions.SpecialtyNotFoundException;
import gr.aueb.cf.schoolapp.validator.TeacherValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/schoolapp/teacherInsert")
public class InsertTeacherController extends HttpServlet {
    private final ITeacherDAO teacherDAO = new TeacherDAOImpl();
    private final ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
    private final ISpecialtyDAO specialtyDAO = new SpecialtyDAOImpl();
    private final ISpecialtyService specialtyService = new SpecialtyServiceImpl(specialtyDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet method is called");
        try {
            List<Specialty> specialties = specialtyService.getAllSpecialties();
            request.setAttribute("specialties", specialties);
            request.getRequestDispatcher("/school/static/templates/teachersmenu.jsp")
                    .forward(request, response);
        } catch (SpecialtyDAOException e) {
            request.setAttribute("error1", "Error while retrieving the list for cities");
            request.getRequestDispatcher("/school/static/templates/teachersmenu.jsp")
                    .forward(request, response);

        } catch (SpecialtyNotFoundException e) {
            request.setAttribute("error1", "No cities found in the database");
            request.getRequestDispatcher("/school/static/templates/teachersmenu.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // Set character encoding to properly handle non-ASCII characters in the request
        System.out.println("doPost method is called");

        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();
        String specialtyIdParam = request.getParameter("specialtyId").trim();

        // Perform server-side validation
        if (firstname.isEmpty() || lastname.isEmpty() || specialtyIdParam.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            reloadSpecialtiesAndForward(request, response);
            return;
        }

        int specialtyId;

        try {
            specialtyId = Integer.parseInt(specialtyIdParam);
        } catch (NumberFormatException e) {
            // Handle invalid integer input for specialtyId here
            request.setAttribute("error", "Specialty ID must be a valid integer");
            reloadSpecialtiesAndForward(request, response);
            return;
        }

        TeacherInsertDTO teacherInsertDTO = new TeacherInsertDTO();
        teacherInsertDTO.setFirstname(firstname);
        teacherInsertDTO.setLastname(lastname);
        teacherInsertDTO.setSpecialtyId(specialtyId);

        try {
            Map<String, String> errors = TeacherValidator.validate(teacherInsertDTO);
            if (!errors.isEmpty()) {
                StringBuilder errorMessage = new StringBuilder();
                for (String field : errors.keySet()) {
                    errorMessage.append(field).append(": ").append(errors.get(field)).append(" ");
                }
                request.setAttribute("error", errorMessage.toString());
                reloadSpecialtiesAndForward(request, response);
                return;
            }

            Teacher teacher = teacherService.insertTeacher(teacherInsertDTO);
            request.setAttribute("insertedTeacher", teacher);
            request.getRequestDispatcher("/school/static/templates/teacherInserted.jsp")
                    .forward(request, response);
        } catch (TeacherDAOException e) {
            request.setAttribute("sqlError", true);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
        }
    }

    private void reloadSpecialtiesAndForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Specialty> specialties = specialtyService.getAllSpecialties();
            request.setAttribute("specialties", specialties);
            request.getRequestDispatcher("/school/static/templates/teachersmenu.jsp")
                    .forward(request, response);
        } catch (SpecialtyDAOException e1) {
            request.setAttribute("error1", "Error while retrieving the list for specialties");
            request.getRequestDispatcher("/school/static/templates/teachersmenu.jsp")
                    .forward(request, response);

        } catch (SpecialtyNotFoundException e1) {
            request.setAttribute("error1", "No Specialties found in the database");
            request.getRequestDispatcher("/school/static/templates/teachersmenu.jsp")
                    .forward(request, response);
        }
    }

}
