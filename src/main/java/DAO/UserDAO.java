package DAO;

import Entities.User;

public interface UserDAO {
    void create(String login,String psw,String name);
    User get(String login, String psw);
}
