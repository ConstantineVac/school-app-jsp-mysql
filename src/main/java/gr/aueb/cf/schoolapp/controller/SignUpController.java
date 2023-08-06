package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.UserDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.service.IUserService;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;
import gr.aueb.cf.schoolapp.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    private final IUserService userService;
    private final IUserDAO userDAO = new UserDAOImpl();

    public SignUpController() {
        this.userService = new UserServiceImpl(userDAO);
    }

    public SignUpController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/school/static/templates/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInsertDTO userDTO = new UserInsertDTO(username, password);

        boolean registrationResult = false;
        try {
            registrationResult = userService.registerUser(userDTO);
        } catch (UserNotFoundException | UserDAOException e) {
            // Handle the exception gracefully
            request.setAttribute("errorMessage", "Error registering user: " + e.getMessage());
            request.getRequestDispatcher("/school/static/templates/signup.jsp").forward(request, response);
            return;
        }

        if (registrationResult) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            response.sendRedirect(request.getContextPath() + "/signup?isError=true");
        }
    }
}
