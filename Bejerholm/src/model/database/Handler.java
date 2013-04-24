package model.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Handler {
    
    Connection conn;
    DBConnection dbConnection;

    public Handler() {
         dbConnection = new DBConnection();
    }  
    
    public ResultSet soegKunder(int tlfNr) throws SQLException{
        Statement stmt = conn.createStatement();
        
        String command = ("select * from Kunde where tlfNr = " + tlfNr + ";");
        stmt.execute(command);
        
        ResultSet rs = stmt.getResultSet();
        
        stmt.close();
        return rs;
    }
    
    public void indsaetKunde(){
        
    }
}


