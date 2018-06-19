package DAO;

import Entities.History;
import Entities.Rating;
import Entities.User;

import java.util.List;

/**
 * Data Access Object Interface for {@link History} entity
 * and list with {@link Rating}
 */
public interface HistoryDAO {
    /**
     * Is used for add step of user in game to history
     * @param user {@link User} entity
     * @param counter Count of user steps spent for guessing computer combination
     */
    void add(User user,int counter);

    /**
     * Is used for getting of Players Rating
     * @return list with {@link Rating}
     */
    List<Rating> getRating();
}
