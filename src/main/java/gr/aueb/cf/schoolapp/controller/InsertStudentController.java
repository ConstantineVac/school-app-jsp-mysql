package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.IStudentDAO;
import gr.aueb.cf.schoolapp.dao.StudentDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.IStudentService;
import gr.aueb.cf.schoolapp.service.StudentServiceImpl;
import gr.aueb.cf.schoolapp.validator.StudentValidator;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

@WebServlet("/schoolapp/studentInsert")
public class InsertStudentController extends HttpServlet {
    private final IStudentDAO studentDAO = new StudentDAOImpl();
    private final IStudentService studentService = new StudentServiceImpl(studentDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", "");


        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();
        String gender = request.getParameter("gender").trim();
        String birthdate = (request.getParameter("birthdate"));

        StudentInsertDTO studentInsertDTO = new StudentInsertDTO();

        studentInsertDTO.setFirstname(firstname);
        studentInsertDTO.setLastname(lastname);
        studentInsertDTO.setGender(gender);
        studentInsertDTO.setBirthdate(Date.valueOf(birthdate));

        try {
            Map<String, String> errors = StudentValidator.validate(studentInsertDTO);
            if (!errors.isEmpty()) {
                //String idMessage = (errors.get("id") !=null) ? "ID:" + errors.get("id") : "";
                String firstnameMessage = (errors.get("firstname") != null) ? "Firstname: " + errors.get("firstname") : "";
                String lastnameMessage = (errors.get("lastname") != null) ? "Lastname: " + errors.get("lastname") : "";
                String genderMessage = (errors.get("gender") != null) ? "Gender: " + errors.get("gender") : "";
                String birthdateMessage = (errors.get("birthdate") != null) ? "Birthdate: " + errors.get("birthdate") : "";
                request.setAttribute("error", firstnameMessage + " " + lastnameMessage);
                request.getRequestDispatcher("/school/static/templates/studentsmenu.jsp").forward(request, response);
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
}
