package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;
import static gr.aueb.cf.schoolapp.security.SecUtil.hashPassword;

public class UserServiceImpl implements IUserService {

    private IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean registerUser(UserInsertDTO userDTO) throws UserNotFoundException, UserDAOException {
        // Validate input
        if (!isInputValid(userDTO)) {
            throw new IllegalArgumentException("Invalid user input.");
        }

        // Check if username already exists
        if (userDAO.isUserExists(userDTO.getUsername())) {
            throw new IllegalArgumentException("Username already exists. Please choose a different username.");
        }

        // Hash the user's password for secure storage
        String hashedPassword = hashPassword(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);

        // Register the user using the DAO
        try {
            return userDAO.registerUser(userDTO);
        } catch (UserDAOException e) {
            throw new UserNotFoundException("Error while registering user.", e);
        }
    }

    @Override
    public boolean isUserValid(String username, String password) throws UserNotFoundException {
        // Validate input
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid username or password.");
        }

        // Hash the provided password for secure validation
        String hashedPassword = hashPassword(password);

        // Validate the user using the DAO
        try {
            return userDAO.isUserValid(username, hashedPassword);
        } catch (UserDAOException e) {
            throw new UserNotFoundException("Error while validating user.", e);
        }
    }

    private boolean isInputValid(UserInsertDTO userDTO) {
        // Add your validation logic here
        // Check that the username and password are not null or empty
        return userDTO.getUsername() != null && !userDTO.getUsername().trim().isEmpty()
                && userDTO.getPassword() != null && !userDTO.getPassword().trim().isEmpty();
    }
}
