package model.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handler {
    
    DBConnection conn;

    public Handler(DBConnection conn) {
        this.conn = conn;
    }  
}

