package DAO;

import Entities.User;

import java.sql.ResultSet;

public interface HistoryDAO {
    void add(User user,int counter);
    ResultSet getRating();
}
