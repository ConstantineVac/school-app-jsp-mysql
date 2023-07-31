package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.security.SecUtil;

import static gr.aueb.cf.schoolapp.security.SecUtil.hashPassword;

public class UserServiceImpl implements IUserService{
    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {this.userDAO = userDAO;}

    @Override
    public User registerUser(UserInsertDTO dto) throws UserDAOException {
        if (dto == null) return null;
        User user;

        try {
            user = map(dto);

            // Hash the password before creating the user
            String hashedPassword = SecUtil.hashPassword(dto.getPassword());
            user.setPassword(hashedPassword);

            System.out.println("Service returned user: " + user.getUsername());
            return userDAO.createUser(user);
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }



    private User map(UserInsertDTO dto) {
        return new User(dto.getUsername(), dto.getPassword());
    }

}
