package DAO;

/**
 * Data access object Factory for DAOs
 */
public class DAOFactory {
    private static UserDAO userDAO = null;
    private static HistoryDAO historyDAO = null;

    private static DAOFactory instance = null;

    public static synchronized DAOFactory getInstance(){
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
    public UserDAO getUserDAO(){
        if (userDAO ==null){
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }
    public HistoryDAO getHistoryDAO(){
        if (historyDAO ==null){
            historyDAO = new HistoryDAOImpl();
        }
        return historyDAO;
    }
}
