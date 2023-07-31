package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.authentication.AuthenticationProvider;
import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.UserDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserLoginDTO;
import gr.aueb.cf.schoolapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isError = request.getParameter("isError");

        if (isError != null && isError.equals("true")) {
            request.setAttribute("isError", isError);
        } else {
            request.setAttribute("isError", "false");
        }

        request.getRequestDispatcher("/school/static/templates/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserLoginDTO userLoginDTO = new UserLoginDTO(username, password);

        // First, check if the user is already registered in the database
        IUserDAO userDAO = new UserDAOImpl();
        boolean isUserRegistered = userDAO.isUserRegistered(username);

        if (!isUserRegistered) {
            // If the username is not found in the database, set isRegistered to 'false'
            request.setAttribute("isRegistered", "false");
            request.getRequestDispatcher("/school/static/templates/login.jsp").forward(request, response);
            return;
        }

        // Now authenticate the user
        boolean principleIsAuthenticated = AuthenticationProvider.authenticate(userLoginDTO);

        if (principleIsAuthenticated) {
            HttpSession session = request.getSession(false);
            session.setAttribute("loginName", username);
            response.sendRedirect(request.getContextPath() + "/schoolapp/menu");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?isError=true");
        }
    }
}

