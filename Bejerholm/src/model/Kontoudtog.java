package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.database.Handler;

/**
 * @author Dan-Philip Christensen
 */
public class Kontoudtog {
    
    private int kontoudtogsID;
    private Date kontoudtogsDato;
    private final String vedroerende = "Bejerholm";
    private String ordreLinjePris;
    private String ordreLinjeProv;
    private Handler handler;
    
    public Kontoudtog(int kontoudtogsID) throws SQLException {
        this.kontoudtogsID = kontoudtogsID;
        handler = new Handler();
        hentKontoUdtog();
    }
    
    private void hentKontoUdtog() throws SQLException{
        ResultSet rs = handler.hentKontoudtogFraDatabase(kontoudtogsID);
        if (rs.next()) {
            this.kontoudtogsDato = rs.getDate("kontoudtogsDato");
            this.ordreLinjePris = rs.getString("ordreLinjePris");
            this.ordreLinjeProv = rs.getString("ordreLinjeProv");
        } else {
            this.kontoudtogsDato = null;
            this.ordreLinjePris = "Kontoudtog findes ikke";
            this.ordreLinjeProv = "Kontoudtog findes ikke";
        }
        rs.close();
    }
    
    public void indsaetKontoUdtogIDatabase(Date kontoudtogsDato, String ordreLinjePris, String ordreLinjeProv) throws SQLException{
        handler.indsaetKontoudtogIDatabase(kontoudtogsID, kontoudtogsDato, vedroerende, ordreLinjePris, ordreLinjeProv);
    }
    
    public void sletKontoUdtogFraDatabase() throws SQLException{
        handler.sletKontoudtogFraDatabase(kontoudtogsID);
    }

    public int getKontoudtogsID() {
        return kontoudtogsID;
    }

    public Date getKontoudtogsDato() {
        return kontoudtogsDato;
    }

    public String getOrdreLinjePris() {
        return ordreLinjePris;
    }

    public String getOrdreLinjeProv() {
        return ordreLinjeProv;
    }
}
