package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements IUserDAO {


    @Override
    public User createUser(User user) throws UserDAOException {
        String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            String username = user.getUsername();
            String password = user.getPassword();


            ps.setString(1, username);
            ps.setString(2, password);


            DBUtil.beginTransaction();
            ps.executeUpdate();
            DBUtil.commitTransaction();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int generatedId = 0;
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            }

            // user.setId(generatedId);
            generatedKeys.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            DBUtil.rollbackTransaction();
            throw new UserDAOException("SQL Error in User " + user + " insertion");
        }
        return user;
    }

    @Override
    public boolean isUserRegistered(String username) {
        String sql = "SELECT COUNT(*) FROM USERS WHERE USERNAME = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // If count > 0, the user is registered; otherwise, the user is not registered.
                }
            }
        } catch (SQLException e) {
            // Handle the exception if the query fails
            e.printStackTrace();
        }

        return false; // Return false if an error occurs or the query doesn't return any results.
    }

    @Override
    public boolean isUserValid(String username, String password) {
        return true;
    }
}
