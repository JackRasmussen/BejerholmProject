/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.database.Handler;

/**
 *
 * @author jack
 */
public class Ordre {

    private int ordreID;
    private int status;
    private Date bestillingsDato;
    private Date leveringsDato;
    private String skrifttype;
    private int skriftStoerrelse;
    private int skriftStil;
    private String inskriptionsLinje;
    private String bemaerkninger;
    private double totalPris;
    private double rabat;
    private int tlfNr;
    private int bedemandCvr;
    private Handler handler;
    private final double MOMS = 25;
    private final double MILJOE_AFGIFT = 2.5;

    public Ordre(int ordreID) throws SQLException, ClassNotFoundException, Exception {
        this.ordreID = ordreID;
        handler = new Handler();
        hentOrdreFraDatabase();
    }

    /**
     * Denne metode kaldes fra constructoren og sætter hvis muligt egenskaberne
     * for det nuværende objekt af denne klasse ud fra informationerne i
     * databasen. Hvis ikke der findes en record i databasen vil metoden i
     * stedet sætte egenskaberne til tomme værdier.
     *
     * @throws SQLException
     */
    private void hentOrdreFraDatabase() throws SQLException {
        ResultSet rs = handler.hentOrdreFraDatabase(ordreID);
        if (rs.next()) {
            this.status = rs.getInt("status");
            this.bestillingsDato = rs.getDate("bestillingsDato");
            this.leveringsDato = rs.getDate("leveringsDato");
            this.skrifttype = rs.getString("skriftType");
            this.skriftStoerrelse = rs.getInt("skriftStoerrelse");
            this.skriftStil = rs.getInt("skriftStil");
            this.inskriptionsLinje = rs.getString("inskriptionsLinje");
            this.bemaerkninger = rs.getString("bemaerkninger");
            this.totalPris = rs.getDouble("totalPris");
            this.rabat = rs.getDouble("rabat");
            this.tlfNr = rs.getInt("tlfNr");
            this.bedemandCvr = rs.getInt("bedemandCvr");
        } else {
            this.status = 0;
            this.bestillingsDato = null;
            this.leveringsDato = null;
            this.skrifttype = "Ordre findes ikke";
            this.skriftStoerrelse = 0;
            this.skriftStil = 0;
            this.inskriptionsLinje = "Ordre findes ikke";
            this.bemaerkninger = "Ordre findes ikke";
            this.totalPris = 0;
            this.rabat = 0;
            this.tlfNr = 0;
            this.bedemandCvr = 0;
        }
    }

    /**
     * Denne metode indsætter en ny record i databasen ud fra de givne input
     * metoden modtager og sætter samtidig egenskaberne for det nuværende objekt
     * af denne klasse.
     *
     * @param status
     * @param bestillingsDato
     * @param leveringsDato
     * @param skrifttype
     * @param skriftstørrelse
     * @param skriftStil
     * @param bemærkninger
     * @param totalPris
     * @param rabat
     * @param tlfNr
     * @param bedemandCvr
     * @throws SQLException
     */
    public void gemOrdreIDatabase(int status, Date bestillingsDato, Date leveringsDato,
            String skrifttype, int skriftstørrelse, int skriftStil, String inskriptionsLinje, String bemærkninger,
            double totalPris, double rabat, int tlfNr, int bedemandCvr) throws SQLException {
        this.status = status;
        this.bestillingsDato = bestillingsDato;
        this.leveringsDato = leveringsDato;
        this.skrifttype = skrifttype;
        this.skriftStoerrelse = skriftstørrelse;
        this.skriftStil = skriftStil;
        this.inskriptionsLinje = inskriptionsLinje;
        this.bemaerkninger = bemærkninger;
        this.totalPris = totalPris;
        this.rabat = rabat;
        this.tlfNr = tlfNr;
        this.bedemandCvr = bedemandCvr;
        handler.indsaetOrdreIDatabase(ordreID, status, bestillingsDato, leveringsDato,
                skrifttype, skriftStoerrelse, skriftStil, inskriptionsLinje, bemaerkninger, totalPris, MOMS, rabat, MILJOE_AFGIFT, tlfNr, bedemandCvr);
    }

    /**
     * Denne metode indsætter et produkt til ProduktOrdre tabellen i databasen
     * ud fra det givne input. Den modtager i samme omgang et objekt af Produkt
     * til at indsætte produktID fra.
     *
     * @param produktNr
     * @param antal
     * @throws SQLException
     */
    public void indsaetProduktTilOrdre(Produkt produktAtIndsaette, int antal) throws SQLException {
        if (ordreID != 0) {
            handler.indsaetProduktOrdreData(ordreID, produktAtIndsaette.getProduktID(), antal);
        }
    }

    /**
     * Denne metode redigerer en record i databasen ud fra dette objekts
     * nuværende egenskaber samt det input metoden modtager.
     *
     * @param status
     * @param bestillingsDato
     * @param leveringsDato
     * @param skrifttype
     * @param skriftstørrelse
     * @param skriftStil
     * @param bemærkninger
     * @param totalPris
     * @param rabat
     * @throws SQLException
     */
    public void redigerOrdreIDatabase(int status, Date bestillingsDato, Date leveringsDato,
            String skrifttype, int skriftstørrelse, int skriftStil, String inskriptionsLinje, String bemaerkninger,
            double totalPris, double rabat) throws SQLException {
        handler.redigerOrdreIDatabase(ordreID, status, bestillingsDato, leveringsDato,
                skrifttype, skriftstørrelse, skriftStil, inskriptionsLinje, bemaerkninger, totalPris, MOMS, rabat, MILJOE_AFGIFT);
    }

    /**
     * Denne metode sletter en record fra databasen ud fra de egenskaber det
     * nuværende objekt af denne klasse har.
     *
     * @throws SQLException
     */
    public void sletOrdreFraDatabase() throws SQLException {
        handler.sletOrdreFraDatabase(ordreID);
    }

    /**
     * Denne metode ændrer status variablen til det input metoden modtager, og
     * ændrer det også i databasen.
     *
     * @param status
     * @throws SQLException
     */
    public void saetOrdreStatus(int status) throws SQLException {
        this.status = status;
        handler.redigerOrdreIDatabase(ordreID, status, bestillingsDato, leveringsDato,
                skrifttype, skriftStoerrelse, skriftStil, inskriptionsLinje, bemaerkninger, totalPris, MOMS, rabat, totalPris);
    }

    public int getOrdreID() {
        return ordreID;
    }

    public int getStatus() {
        return status;
    }

    public Date getBestillingsDato() {
        return bestillingsDato;
    }

    public Date getLeveringsDato() {
        return leveringsDato;
    }

    public String getSkrifttype() {
        return skrifttype;
    }

    public int getSkriftStoerrelse() {
        return skriftStoerrelse;
    }

    public int getSkriftStil() {
        return skriftStil;
    }

    public String getInskriptionsLinje() {
        return inskriptionsLinje;
    }
    
    public String getBemaerkninger() {
        return bemaerkninger;
    }

    public double getTotalPris() {
        return totalPris;
    }

    public double getRabat() {
        return rabat;
    }

    public int getTlfNr() {
        return tlfNr;
    }

    public int getBedemandCvr() {
        return bedemandCvr;
    }
}
