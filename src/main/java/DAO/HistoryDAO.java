package DAO;

import Entities.Rating;
import Entities.User;

import java.util.List;

public interface HistoryDAO {
    void add(User user,int counter);
    List<Rating> getRating();
}
