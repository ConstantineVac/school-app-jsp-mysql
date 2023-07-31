package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.UserDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    private IUserDAO userDAO; // Declare the IUserDAO reference

    // Override the init method to perform dependency injection
    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAOImpl(); // Instantiate the DAO implementation here
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Display the signup form (signup.jsp)
        request.getRequestDispatcher("/school/static/templates/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the form data (you can add more validation if needed)

        // Assuming you have a method to register the user in the database, similar to UserDAO.createUser()
        User newUser = new User(username, password); // You can set the email to null or get it from the request

        try {
            // Register the user in the database
            userDAO.createUser(newUser);

            // Redirect to the menu page after successful registration
            response.sendRedirect(request.getContextPath() + "/schoolapp/menu");
        } catch (UserDAOException e) {
            // Handle registration errors
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/signup?error=true");
        }
    }
}
