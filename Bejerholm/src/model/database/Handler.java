package model.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Handler {
    
    DBConnection dBConnection;

    public Handler() {
        dBConnection = new DBConnection();
    }

    public ResultSet soegKunder(int tlfNr) throws SQLException {
        //DBConnection dbConnection = new DBConnection();
        String command = ("select * from Kunde where tlfNr = " + tlfNr + ";");

        ResultSet rs = dBConnection.getResultSetWithCommand(command);

        //dbConnection.closeConnection(); 
        return rs;
    }

    public void indsaetKunde(int tlfNr, String fNavn, String eNavn, String adresse, int postNr, String byNavn) throws SQLException {
        //DBConnection dbConnection = new DBConnection();
        String command = ("insert into Kunde(tlfNr, fNavn, eNavn, adresse, postNr, byNavn) "
                + "values (" + tlfNr + ", '" + fNavn + "', '" + eNavn + "', '" + adresse + "', " + postNr + ", '" + "');");
        dBConnection.execute(command);
        //dBConnection.closeConnection();
    }

    public void sletKunde(int tlfNr) throws SQLException {
        //DBConnection dbConnection = new DBConnection();
        String command = ("delete from Kunde where tlfNr = " + tlfNr + ";");
        dBConnection.execute(command);
        //dBConnection.closeConnection();
    }
    
    public void redigerKunde(int tlfNr, String nyFNavn, String nyENavn, String nyAdresse, int nyPostNr, String nyByNavn) throws SQLException{
        //DBConnection dbConnection = new DBConnection();
        String command = ("update Kunde set fNavn = '" + nyFNavn + "', eNavn = '" 
                + nyENavn + "', adresse = '" + nyAdresse + "', postNr = " + nyPostNr 
                + ", byNavn = '" + nyByNavn + "' where tlfNr = " + tlfNr + ";");
        dBConnection.execute(command);
        //dBConnection.closeConnection();
    }
}
