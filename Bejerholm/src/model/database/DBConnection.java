package model.database;

import java.sql.*;

public class DBConnection {

    private Connection conn;
    private Statement state;
    private String user;
    private String pass;
    private String host;
    private String port;
    private String database;
    private boolean connected;

    public DBConnection() {
        //test
        connected = false;
        this.user = "root";
        this.pass = "root";
        this.host = "localhost";
        this.port = "3306";
        this.database = "Bejerholm";
        connection();
    }

    public final boolean connection() {
        boolean result = true;
        String conString = "jdbc:mysql://" + host + ":" + port + "/" + database;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(conString, user, pass);
            state = conn.createStatement();
            System.out.println(this.getClass().getName() + " siger det fungerer!");

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
        return result;
    }
    
    public Connection getConn(){
        return conn;
    }

    public void execute(String sql) throws SQLException {
        state.execute(sql);
    }

    public ResultSet getResultSetWithCommand(String sql) throws SQLException {
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }

    public void closeConnection() {
        try {
            state.close();
            conn.close();
        } catch (SQLException ex) {
        }
    }

    public boolean isConnected() {
        return connected;
    }
}