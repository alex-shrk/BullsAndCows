package DAO;

import Entities.User;
import Helpers.DBConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Helpers.DBConnectionHelper.getDBConnection;

public class UserDAOImpl implements UserDAO {

    @Override
    public void create(String login, String psw, String name) {
        DBConnectionHelper.DBConnection db = getDBConnection();
        try (Connection connection = db.getConnection()) {
            String sqlInsertUser = "INSERT INTO \"User\"(login,psw,name) VALUES(?,?,?)";
            PreparedStatement insertUser = connection.prepareStatement(sqlInsertUser);
            insertUser.setString(1, login);
            insertUser.setString(2, psw);
            insertUser.setString(3, name);
            insertUser.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public User get(String login, String psw) {
        DBConnectionHelper.DBConnection db = getDBConnection();
        User user = new User();
        try (Connection connection = db.getConnection()) {
            String sqlGetUserId = "SELECT * FROM \"User\" WHERE login=? AND psw=?";
            PreparedStatement getUserId = connection.prepareStatement(sqlGetUserId);
            getUserId.setString(1, login);
            getUserId.setString(2, psw);
            try (ResultSet resultSet = getUserId.executeQuery()) {
                if (resultSet.next()) {
                    user.setId(resultSet.getLong("id"));
                    user.setLogin(login);
                    user.setPassword(psw);
                    user.setName(resultSet.getString("name"));
                }
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return user;
    }
}
