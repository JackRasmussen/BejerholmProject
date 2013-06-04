package model.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static Connection conn;
    private static Statement state;
    private static String user;
    private static String pass;
    private static String host;
    private static String port;
    private static String database;
    private static boolean connected;

    private DBConnection() {
        //test
        connected = false;
        user = "root";
        pass = "root";
        host = "localhost";
        port = "3306";
        database = "Bejerholm";
    }

    private static void connection() throws SQLException, 
            ClassNotFoundException, Exception{
        boolean result = true;
        String conString = "jdbc:mysql://" + host + ":" + port + "/" + database;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(conString, user, pass);
            state = conn.createStatement();
        } catch (SQLException ex) {
            result = false;
            System.out.println("Could not connect: " + conString + " , " + 
                    user + " , " + pass);
            System.out.println(ex.getLocalizedMessage());
        } catch (ClassNotFoundException ex) {
            result = false;
            System.out.println("No driver found");
            System.out.println(ex.getLocalizedMessage());
        } catch (Exception ex) {
            result = false;
            System.out.println("exception: " + ex.getClass().getName() + " = " +
                    ex.getLocalizedMessage());
        }
        connected = result;
    }
    
    public static void setConnectionParameters(String user, String pass, 
            String host, String port, String database) throws SQLException, 
            ClassNotFoundException, Exception{
        DBConnection.user = user;
        DBConnection.pass = pass;
        DBConnection.host = host;
        DBConnection.port = port;
        DBConnection.database = database;
        connection();
    }

    public static Connection getConn() throws SQLException, 
            ClassNotFoundException, Exception{
        if (connected) {
            return conn;
        } else {
            connection();
            return conn;
        }
    }

    public static void execute(String sql) throws SQLException {
        state.execute(sql);
    }

    public static ResultSet getResultSetWithCommand(String sql) 
            throws SQLException {
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }

    public static void closeConnection() {
        boolean result = false;
        try {
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, 
                    null, ex);
            result = true;
        }
        connected = result;
    }

    public static boolean isConnected() {
        return connected;
    }
}