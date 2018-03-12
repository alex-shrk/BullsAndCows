package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionHelper {
    private static final String dbURL = "jdbc:postgresql://localhost:5432/bullsAndCowsDB";
    private static final String user = "postgres";
    private static final String password = "postgres";
    private static final String dbDriver = "org.postgresql.Driver";

    private static final DBConnectionManager instance = new DBConnectionManager(dbURL,user,password,dbDriver);
    public static DBConnectionManager getDBConnectionManager(){
        return instance;
    }



    public static class DBConnectionManager{
        private final String dbURL;
        private final String user;
        private final String password;
        private final String dbDriver;

        DBConnectionManager(String dbURL, String user, String password, String dbDriver) {
            this.dbURL = dbURL;
            this.user = user;
            this.password = password;
            this.dbDriver = dbDriver;
            loadDbDriver();
        }
        private void loadDbDriver(){
            try {
                Class.forName(dbDriver);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection(){
            Connection connection = null;
            try {
                 connection = DriverManager.getConnection(
                        dbURL, user, password);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }








}
