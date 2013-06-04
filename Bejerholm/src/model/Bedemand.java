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
    private int tlfNr;
    private String adresse;
    private int postNr;
    private String byNavn;

    public Bedemand(int tlfNr) throws SQLException, ClassNotFoundException, 
            Exception {
        this.handler = new Handler();
        this.tlfNr = tlfNr;
        findBedemandViaTlf(tlfNr);
    }

    public Bedemand(String firmaNavn) throws SQLException, 
            ClassNotFoundException, Exception {
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
            this.adresse = rs.getString("adresse");
            this.byNavn = rs.getString("byNavn");
            this.postNr = rs.getInt("postNr");
            this.firmaNavn = rs.getString("firmaNavn");
        } else {
            this.adresse = "Bedemand findes ikke";
            this.byNavn = "Bedemand findes ikke";
            this.postNr = 0;
            this.firmaNavn = "Bedemand findes ikke";
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
            this.adresse = rs.getString("adresse");
            this.byNavn = rs.getString("byNavn");
            this.postNr = rs.getInt("postNr");
            this.tlfNr = rs.getInt("tlfNr");
        } else {
            this.adresse = "Bedemand findes ikke";
            this.byNavn = "Bedemand findes ikke";
            this.postNr = 0;
            this.tlfNr = 0;
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
    public void tilfoejBedemandTilDatabase(int tlfNr, String firmaNavn, 
            String adresse, String byNavn, int postNr) throws SQLException {
        this.adresse = adresse;
        this.byNavn = byNavn;
        this.postNr = postNr;
        this.tlfNr = tlfNr;
        this.firmaNavn = firmaNavn;
        handler.tilfoejBedemand(tlfNr, firmaNavn, adresse, postNr, byNavn);
    }

    /**
     * Denne metode sletter en bedemands record i databasen ud fra det aktive
     * objekt af denne klasse.
     *
     * @throws SQLException
     */
    public void sletBedemandFraDatabase() throws SQLException {
        handler.sletBedemand(tlfNr);
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
    public void redigerBedemandIDatabase(int tlfNr, String firmaNavn, 
            String adresse, String byNavn, int postNr) throws SQLException {
        handler.redigerBedemand(tlfNr, firmaNavn, adresse, postNr, byNavn);
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getPostNr() {
        return postNr;
    }

    public String getByNavn() {
        return byNavn;
    }

    public int getTlfNr() {
        return tlfNr;
    }
}
