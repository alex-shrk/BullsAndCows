package DAO;

import Entities.User;
import Helpers.DBConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Helpers.DBConnectionHelper.getDBConnectionManager;

public class HistoryDAOImpl implements HistoryDAO{
    public void add(User user,int counter) {
        DBConnectionHelper.DBConnectionManager db = getDBConnectionManager();
        try (Connection connection = db.getConnection()) {
            String sqlInsertUser = "INSERT INTO \"History\"(id_user,result) VALUES(?,?)";
            PreparedStatement insertUser = connection.prepareStatement(sqlInsertUser);
            insertUser.setLong(1, user.getId());
            insertUser.setInt(2, counter);
            insertUser.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public ResultSet getRating(){
        ResultSet resultSet = null;
        DBConnectionHelper.DBConnectionManager db = getDBConnectionManager();
        try (Connection connection = db.getConnection()) {
            String sqlGetRatingView = "SELECT * FROM \"RatingView\"";
            PreparedStatement getRatingView = connection.prepareStatement(sqlGetRatingView);
            resultSet =  getRatingView.executeQuery();
           /* Rating rating = new Rating();
            rating.se
            session.setAttribute("ratingSet", ratingSet);*/


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return resultSet;
    }
}
