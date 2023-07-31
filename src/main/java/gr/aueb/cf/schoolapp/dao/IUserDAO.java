package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.model.User;



import gr.aueb.cf.schoolapp.model.User;

public interface IUserDAO {
    User createUser(User user) throws UserDAOException;
    boolean isUserValid(String username, String password);
    boolean isUserRegistered(String username);
}
