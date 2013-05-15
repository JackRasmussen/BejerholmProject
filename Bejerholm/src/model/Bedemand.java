package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.database.Handler;

/**
 * @author Dan-Philip Christensen
 */
public class Bedemand {

    private Handler handler;
    private String firmaNavn;
    private int cvr;
    private int tlfNr;

    public Bedemand(int tlfNr) throws SQLException {
        this.handler = new Handler();
        this.tlfNr = tlfNr;
        findBedemandViaTlf(tlfNr);
    }

    public Bedemand(String firmaNavn) throws SQLException {
        this.handler = new Handler();
        this.firmaNavn = firmaNavn;
        findBedemandViaNavn(firmaNavn);
    }

    /**
     * Denne metode kaldes fra constructoren, og søger i databasen efter en
     * bedemand med det givne telefon nummer. Hvis der ikke findes en bedemand
     * med det givne telefonnummer sætter den tomme værdier ind.
     *
     * @param tlfNr
     * @throws SQLException
     */
    private void findBedemandViaTlf(int tlfNr) throws SQLException {
        ResultSet rs = handler.soegBedemandViaTlf(tlfNr);
        if (rs.next()) {
            cvr = rs.getInt("cvr");
            firmaNavn = rs.getString("firmaNavn");
        } else {
            cvr = 0;
            firmaNavn = "Bedemand findes ikke";
        }
        rs.close();
    }

    /**
     * Denne metode kaldes fra constructoren, og søger i databasen efter en
     * bedemand med det givne telefon nummer. Hvis der ikke findes en bedemand
     * med det givne telefonnummer sætter den tomme værdier ind.
     *
     * @param firmaNavn
     * @throws SQLException
     */
    private void findBedemandViaNavn(String firmaNavn) throws SQLException {
        ResultSet rs = handler.soegBedemandViaNavn(firmaNavn);
        if (rs.next()) {
            cvr = rs.getInt("cvr");
            tlfNr = rs.getInt("tlfNr");
        } else {
            cvr = 0;
            tlfNr = 0;
        }
        rs.close();
    }

    /**
     * Denne metode indsætter en bedemand i databasen hvis muligt, med de givne
     * input som informationer.
     *
     * @param cvr
     * @param tlfNr
     * @param firmaNavn
     * @throws SQLException
     */
    public void tilfoejBedemandTilDatabase(int cvr, int tlfNr, String firmaNavn) throws SQLException {
        this.cvr = cvr;
        this.tlfNr = tlfNr;
        this.firmaNavn = firmaNavn;
        handler.tilfoejBedemand(cvr, firmaNavn, tlfNr);
    }

    /**
     * Denne metode sletter en bedemands record i databasen ud fra det aktive
     * objekt af denne klasse.
     *
     * @throws SQLException
     */
    public void sletBedemandFraDatabase() throws SQLException {
        handler.sletBedemand(cvr);
    }

    /**
     * Denne metode redigerer i en bedemand i databasen ud fra de givne input og
     * det aktive objekt af denne klasse.
     *
     * @param cvr 
     * @param firmaNavn
     * @param tlfNr
     * @throws SQLException
     */
    public void redigerBedemandIDatabase(int cvr, String firmaNavn, int tlfNr) throws SQLException {
        handler.redigerBedemand(cvr, firmaNavn, tlfNr);
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public int getCvr() {
        return cvr;
    }

    public int getTlfNr() {
        return tlfNr;
    }
}
