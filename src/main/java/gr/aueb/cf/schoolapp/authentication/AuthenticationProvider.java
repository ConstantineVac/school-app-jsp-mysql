package gr.aueb.cf.schoolapp.authentication;

import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.UserDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserLoginDTO;
import gr.aueb.cf.schoolapp.model.User;

public class AuthenticationProvider {

    private static final IUserDAO userDAO = new UserDAOImpl();

    private AuthenticationProvider() {}

    public static boolean authenticate(UserLoginDTO userLoginDTO) {
        //System.out.println("authenticate" + userLoginDTO.getUsername());
        if (userLoginDTO.getUsername().equals("test@aueb.gr")) {
            return false;
        }
        return userDAO.isUserValid(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }
}
