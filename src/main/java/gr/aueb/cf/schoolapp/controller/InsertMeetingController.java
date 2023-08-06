package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.IMeetingDAO;
import gr.aueb.cf.schoolapp.dao.MeetingDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.MeetingDAOException;
import gr.aueb.cf.schoolapp.dto.MeetingInsertDTO;
import gr.aueb.cf.schoolapp.model.Meeting;
import gr.aueb.cf.schoolapp.service.IMeetingService;
import gr.aueb.cf.schoolapp.service.MeetingServiceImpl;
import gr.aueb.cf.schoolapp.validator.MeetingValidator;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

@WebServlet("/schoolapp/insertMeeting")
public class InsertMeetingController extends HttpServlet {
    private final IMeetingDAO meetingDAO = new MeetingDAOImpl();
    private final IMeetingService meetingService = new MeetingServiceImpl(meetingDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", "");
        String teacherIdParam = request.getParameter("teacherId").trim();
        String studentIdParam = request.getParameter("studentId").trim();
        String room = request.getParameter("room");
        String meetingDate = request.getParameter("meetingDate");

        // Check if teacherId and studentId are provided
        if (teacherIdParam.isEmpty() || studentIdParam.isEmpty()) {
            request.setAttribute("error", "Teacher's ID and Student's ID are required fields");
            request.getRequestDispatcher("/school/static/templates/meetingsmenu.jsp").forward(request, response);
            return;
        }

        int teacherId = 0;
        int studentId = 0;

        try {
            teacherId = Integer.parseInt(teacherIdParam);
            studentId = Integer.parseInt(studentIdParam);

            MeetingInsertDTO meetingInsertDTO = new MeetingInsertDTO();
            meetingInsertDTO.setTeacherId(teacherId);
            meetingInsertDTO.setStudentId(studentId);
            meetingInsertDTO.setRoom(room);

            // Validate the format of the meetingDate parameter
            if (meetingDate == null || !meetingDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                request.setAttribute("error", "Invalid format for Meeting Date. Please use yyyy-mm-dd format.");
                request.getRequestDispatcher("/school/static/templates/meetingsmenu.jsp").forward(request, response);
                return;
            }

            meetingInsertDTO.setMeetingDate(Date.valueOf(meetingDate));

            Map<String, String> errors = MeetingValidator.validate(meetingInsertDTO);

            // If there are validation errors, concatenate them into one string and set in the request
            if (!errors.isEmpty()) {
                StringBuilder errorMessage = new StringBuilder();
                for (String error : errors.values()) {
                    errorMessage.append(error).append(" ");
                }
                request.setAttribute("error", errorMessage.toString());
                request.getRequestDispatcher("/school/static/templates/meetingsmenu.jsp").forward(request, response);
            } else {
                // If no errors, proceed with the insert operation and display success message
                try {
                    Meeting meeting = meetingService.insertMeeting(meetingInsertDTO);
                    request.setAttribute("insertedMeeting", meeting);
                    request.getRequestDispatcher("/school/static/templates/meetingInserted.jsp").forward(request, response);
                } catch (MeetingDAOException e) {
                    request.setAttribute("sqlError", true);
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
                }
            }
        } catch (NumberFormatException e) {
            // Handle invalid integer inputs here
            request.setAttribute("error", "Teacher's ID and Student's ID must be valid integers");
            request.getRequestDispatcher("/school/static/templates/meetingsmenu.jsp").forward(request, response);
        }
    }
}
