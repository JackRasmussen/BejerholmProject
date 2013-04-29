package model.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Handler {
    
    Connection conn;

    public Handler(Connection conn) {
        this.conn = conn;
    }  
    
    public ResultSet soegKunder(int tlfNr) throws SQLException{
        Statement stmt = conn.createStatement();
        
        String command = ("select * from Kunde where tlfNr = " + tlfNr + ";");
        stmt.execute(command);
        
        ResultSet rs = stmt.getResultSet();
        
        stmt.close();
        return rs;
    }
}


