package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionHelper {
    private static String dbURL = "jdbc:postgresql://localhost:5432/bullsAndCowsDB";
    private static String user = "postgres";
    private static String password = "postgres";
    private static String dbDriver = "org.postgresql.Driver";

    private static DBConnectionManager instance = new DBConnectionManager(dbURL,user,password,dbDriver);
    public static DBConnectionManager getDBConnectionManager(){
        return instance;
    }



    public static class DBConnectionManager{
        private String dbURL;
        private String user;
        private String password;
        private String dbDriver;

        public DBConnectionManager(String dbURL, String user, String password, String dbDriver) {
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

        /*public Connection getConnection(){
            if (this.connection==null)
                this.connection = createConnection();
            return this.connection;
        }
        public void closeConnection() throws SQLException {
            if (connection != null)
                connection.close();
        }*/
    }








}
