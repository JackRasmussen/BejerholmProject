/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;

/**
 *
 * @author Mathias
 */
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

            System.out.println("Det fungerer");

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

    public Statement getState() {
        return state;
    }

    public void setState(Statement state) {
        this.state = state;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public boolean isConnected() {
        return connected;
    }

    void databaseExecute(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
