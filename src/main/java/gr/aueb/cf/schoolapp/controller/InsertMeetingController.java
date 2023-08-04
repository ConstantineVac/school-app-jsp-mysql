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

        int teacherId = Integer.parseInt(request.getParameter("teacherId").trim());
        int studentId = Integer.parseInt(request.getParameter("studentId").trim());
        String room = request.getParameter("room");
        String meetingDate = (request.getParameter("meetingDate"));


        MeetingInsertDTO meetingInsertDTO = new MeetingInsertDTO();

        meetingInsertDTO.setTeacherId(teacherId);
        meetingInsertDTO.setStudentId(studentId);
        meetingInsertDTO.setRoom(room);
        meetingInsertDTO.setMeetingDate(Date.valueOf(meetingDate));

        try {
            Map<String, String> errors = MeetingValidator.validate(meetingInsertDTO);
            if (!errors.isEmpty()) {
                String teacherIdMessage = (errors.get("teacherId") != null) ? "Teacher's ID: " + errors.get("teacherId") : "";
                String studentIdMessage = (errors.get("studentId") != null) ? "Student's ID: " + errors.get("studentId") : "";
                String roomMessage = (errors.get("room") != null) ? "Room: " + errors.get("room") : "";
                String meetingDateMessage = (errors.get("meetingDate") != null) ? "Meeting Date: " + errors.get("meetingDate") : "";
                request.setAttribute("error", teacherIdMessage + " " + studentIdMessage + " ");
                request.getRequestDispatcher("/school/static/templates/meetingsmenu.jsp").forward(request, response);
                return;
            }

            Meeting meeting = meetingService.insertMeeting(meetingInsertDTO);
            request.setAttribute("insertedMeeting", meeting);
            request.getRequestDispatcher("/school/static/templates/meetingInserted.jsp").forward(request, response);
        } catch (MeetingDAOException e) {
            request.setAttribute("sqlError", true);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
        }
    }
}
