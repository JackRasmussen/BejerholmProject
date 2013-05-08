/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.database.DBConnection;

/**
 *
 * @author nicolai
 */
public class Controller {
    
    
    public Controller () {
        
    }
    public void connectDB (String user, String pass, String host, String port, String database) {
        DBConnection.setConnectionParameters(user, pass, host, port, database);
    }
}
