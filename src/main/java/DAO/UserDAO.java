package DAO;

import Entities.User;

/**
 * Data Access Object Interface for {@link User} entity
 */
public interface UserDAO {
    /**
     * Method for create of user
     * @param login String with user login
     * @param psw String with user password
     * @param name String with user name
     */
    void create(String login,String psw,String name);

    /**
     * Method for getting {@link User} entity
     * @param login String with user login
     * @param psw String with user password
     * @return {@link User} entity
     */
    User get(String login, String psw);
}
