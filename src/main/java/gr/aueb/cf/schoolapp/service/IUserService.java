package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;

public interface IUserService {

    boolean registerUser(UserInsertDTO userDTO) throws UserNotFoundException, UserDAOException;

    boolean isUserValid(String username, String password) throws UserNotFoundException;
}