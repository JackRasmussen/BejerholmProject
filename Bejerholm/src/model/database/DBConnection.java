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

    public DBConnection(String user, String pass, String host, String port, String database) {
        connected = false;
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.port = port;
        this.database = database;
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

    public void execute(String sql) throws SQLException {
        state.execute(sql);
    }

    public ResultSet getResult(String sql) throws SQLException {
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }

    public boolean isConnected() {
        return connected;
    }
}