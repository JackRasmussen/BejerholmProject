package model.database;

import java.sql.*;

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

    private static void connection() {
        boolean result = true;
        String conString = "jdbc:mysql://" + host + ":" + port + "/" + database;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(conString, user, pass);
            state = conn.createStatement();
        } catch (SQLException ex) {
            result = false;
            System.out.println("Could not connect: " + conString + " , " + user + " , " + pass);
            System.out.println(ex.getLocalizedMessage());
        } catch (ClassNotFoundException ex) {
            result = false;
            System.out.println("No driver found");
            System.out.println(ex.getLocalizedMessage());
        } catch (Exception ex) {
            result = false;
            System.out.println("exception: " + ex.getClass().getName() + " = " + ex.getLocalizedMessage());
        }
        connected = result;
    }

    public static Connection getConn() {
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

    public static ResultSet getResultSetWithCommand(String sql) throws SQLException {
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }

    public static void closeConnection() throws SQLException {
        state.close();
        conn.close();
    }
}