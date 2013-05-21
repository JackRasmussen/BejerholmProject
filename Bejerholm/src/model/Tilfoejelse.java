package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.database.Handler;

/**
 *
 * @author Dan-Philip-N
 */
public class Tilfoejelse {

    private Handler handler;
    private int tilfoejelsesID;
    private String tilfoejelsesType;
    private double tilfoejelsesPris;

    public Tilfoejelse(int tilfoejelsesID) throws SQLException, ClassNotFoundException, Exception {
        handler = new Handler();
        this.tilfoejelsesID = tilfoejelsesID;
        hentTilfoejelsesInfo();
    }

    /**
     * Denne metode kaldes fra constructoren og forsøger at sætte egenskaberne
     * for det nuværende objekt af denne klasse ud fra informationerne der
     * ligger i databasen. Hvis ikke der findes en gyldig record i databasen
     * sættes egenskaberne til tomme værdier.
     *
     * @throws SQLException
     */
    private void hentTilfoejelsesInfo() throws SQLException {
        ResultSet rs = handler.hentTilfoejelseFraDatabase(tilfoejelsesID);
        if (rs.next()) {
            this.tilfoejelsesType = rs.getString("tilfoejelsesType");
            this.tilfoejelsesPris = rs.getDouble("pris");
        } else {
            this.tilfoejelsesType = "Tilfoejelse findes ikke";
            this.tilfoejelsesPris = 0;
        }
    }

    /**
     * Denne metode indsætter en ny record i databasen ud fra de givne input
     * metoden modtager, samt egenskaberne for det nuværende objekt af denne
     * klasse.
     *
     * @param tilfoejelsesType
     * @param pris
     * @throws SQLException
     */
    public void indsaetTilfoejelseIDatabase(String tilfoejelsesType, double pris) throws SQLException {
        this.tilfoejelsesType = tilfoejelsesType;
        this.tilfoejelsesPris = pris;
        handler.indsaetTilfoejelseIDatabase(tilfoejelsesID, tilfoejelsesType, pris);
    }

    /**
     * Denne metode redigerer en record i databasen ud fra de input metoden
     * modtager, samt egenskaberne for det nuværende objekt af denne klasse.
     *
     * @param type
     * @param pris
     * @throws SQLException
     */
    public void redigerTilfoejelse(String type, double pris) throws SQLException {
        handler.redigerTilfoejelseIDatabase(tilfoejelsesID, type, pris);
    }

    /**
     * Denne metode sletter en record i databasen ud fra de egenskaber det
     * nuværende objekt af denne klasse har.
     *
     * @throws SQLException
     */
    public void sletTilfoejelse() throws SQLException {
        handler.sletTilfoejelseFraDatabase(tilfoejelsesID);
    }

    public int getTilfoejelsesID() {
        return tilfoejelsesID;
    }

    public String getTilfoejelsesType() {
        return tilfoejelsesType;
    }

    public double getTilfoejelsesPris() {
        return tilfoejelsesPris;
    }
}
