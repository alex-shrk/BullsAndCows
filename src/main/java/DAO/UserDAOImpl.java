package DAO;

import Entities.User;
import Helpers.DBConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Helpers.DBConnectionHelper.getDBConnectionManager;

public class UserDAOImpl implements UserDAO {

    @Override
    public void create(String login, String psw, String name) {
        DBConnectionHelper.DBConnectionManager db = getDBConnectionManager();
        try(Connection connection = db.getConnection()) {
            String sqlInsertUser = "INSERT INTO \"User\"(login,psw,name) VALUES(?,?,?)";
            PreparedStatement insertUser = connection.prepareStatement(sqlInsertUser);
            insertUser.setString(1,login);
            insertUser.setString(2,psw);
            insertUser.setString(3,name);
            insertUser.execute();


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public User get(String login, String psw) {
        DBConnectionHelper.DBConnectionManager db = getDBConnectionManager();
        User user = new User();
        try (Connection connection = db.getConnection()) {
            String sqlGetUserId = "SELECT * FROM \"User\" WHERE login=? AND psw=?";
            PreparedStatement getUserId = connection.prepareStatement(sqlGetUserId);
            getUserId.setString(1, login);
            getUserId.setString(2, psw);
            ResultSet resultSet = getUserId.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setLogin(login);
                user.setPassword(psw);//todo fix pasw store
                user.setName(resultSet.getString("name"));
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return user;
    }
}
