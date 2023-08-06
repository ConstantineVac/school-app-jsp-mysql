package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.security.SecUtil;

import java.sql.*;

import static gr.aueb.cf.schoolapp.service.util.DBUtil.getConnection;

public class UserDAOImpl implements IUserDAO {

    @Override
    public boolean isUserValid(String username, String password) throws UserDAOException {
        String sql = "SELECT password FROM users WHERE username = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String storedHashedPassword = resultSet.getString("password");
                    return SecUtil.checkPassword(password, storedHashedPassword);
                }
            }

        } catch (SQLException e) {
            throw new UserDAOException("Error while checking user validity.", e);
        }

        // If the user does not exist, return false
        return false;
    }

    @Override
    public boolean registerUser(User user) throws UserDAOException {
        if (isUserExists(user.getUsername())) {
            throw new UserDAOException("Username already exists. Please choose a different username.");
        }

        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            throw new UserDAOException("Error while registering user.", e);
        }
    }

    @Override
    public boolean isUserExists(String username) throws UserDAOException {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, username);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            throw new UserDAOException("Error while checking user existence.", e);
        }

        // If we reach this point, an error occurred or the user does not exist
        return false;
    }
}
