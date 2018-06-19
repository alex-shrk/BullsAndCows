package DAO;

import Entities.Rating;
import Entities.User;
import Helpers.DBConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Helpers.DBConnectionHelper.getDBConnection;


public class HistoryDAOImpl implements HistoryDAO{
    public void add(User user,int counter) {
        DBConnectionHelper.DBConnection db = getDBConnection();
        try (Connection connection = db.getConnection()) {
            String sqlInsertUser = "INSERT INTO \"History\"(id_user,result) VALUES(?,?)";
            PreparedStatement insertUser = connection.prepareStatement(sqlInsertUser);
            insertUser.setLong(1, user.getId());
            insertUser.setInt(2, counter);
            insertUser.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Rating> getRating(){
        List<Rating> ratingList = new ArrayList<>();
        DBConnectionHelper.DBConnection db = getDBConnection();
        try (Connection connection = db.getConnection()) {
            String sqlGetRatingView = "SELECT * FROM \"RatingView\"";
            PreparedStatement getRatingView = connection.prepareStatement(sqlGetRatingView);
            try(ResultSet resultSet = getRatingView.executeQuery()){
                while (resultSet.next()){
                    Rating rating = new Rating();
                    rating.setUser(resultSet.getString("User"));
                    rating.setResult(resultSet.getString("Result"));
                    ratingList.add(rating);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratingList;
    }
}
