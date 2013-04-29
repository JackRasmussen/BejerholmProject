package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.database.Handler;

/**
 * @author Dan-Philip Christensen
 */
public class KirkegaardsOrdre {

    private int kirkegaardsID;
    private boolean urne_Kiste;
    private int raekke;
    private int nummer;
    private int ordreID;
    private String afdeling;
    private Handler handler;

    public KirkegaardsOrdre(int kirkegaardsID) throws SQLException {
        this.kirkegaardsID = kirkegaardsID;
        this.handler = new Handler();
        hentKirkegaardsOrdre();
    }

    private void hentKirkegaardsOrdre() throws SQLException {
        ResultSet rs = handler.hentKirkegaardsOrdreFraDatabase(kirkegaardsID);
        if (rs.next()) {
            this.urne_Kiste = rs.getBoolean("urne_Kiste");
            this.raekke = rs.getInt("raekke");
            this.nummer = rs.getInt("afdeling");
            this.afdeling = rs.getString("afdeling");
            this.ordreID = rs.getInt("ordreID");
        } else {
            this.urne_Kiste = false;
            this.raekke = 0;
            this.nummer = 0;
            this.afdeling = "Kirkegårds ordre findes ikke";
            this.ordreID = 0;
        }
        rs.close();
    }

    public void indsaetKirkegaardsOrdreTilDatabase(boolean urne_Kiste, int raekke, int nummer, String afdeling, int ordreID) throws SQLException {
        this.urne_Kiste = urne_Kiste;
        this.raekke = raekke;
        this.nummer = nummer;
        this.afdeling = afdeling;
        this.ordreID = ordreID;
        handler.indsaetKirkegaardsOrdreIDatabase(kirkegaardsID, urne_Kiste, raekke, nummer, afdeling, ordreID);
    }

    public void redigerKirkegaardsOrdre(boolean urne_Kiste, int raekke, int nummer, String afdeling) throws SQLException {
        this.urne_Kiste = urne_Kiste;
        this.raekke = raekke;
        this.nummer = nummer;
        this.afdeling = afdeling;
        handler.redigerKirkegaardsOrdreIDatabase(kirkegaardsID, urne_Kiste, raekke, nummer, afdeling);
    }

    public void sletKirkegaardsOrdreFraDatabase() throws SQLException {
        handler.sletKirkegaardsOrdreFraDatabase(kirkegaardsID);
    }

    public int getKirkegaardsID() {
        return kirkegaardsID;
    }

    public boolean isUrne_Kiste() {
        return urne_Kiste;
    }

    public int getRaekke() {
        return raekke;
    }

    public int getNummer() {
        return nummer;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public int getOrdreID() {
        return ordreID;
    }
}
