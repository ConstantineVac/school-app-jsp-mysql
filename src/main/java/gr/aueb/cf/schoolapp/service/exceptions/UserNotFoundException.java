package gr.aueb.cf.schoolapp.service.exceptions;

import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.model.User;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
