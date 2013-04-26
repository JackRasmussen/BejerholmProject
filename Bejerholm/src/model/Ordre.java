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
    private String bemaerkninger;
    private double totalPris;
    private double rabat;
    private Handler handler;
    private final double MOMS = 25;
    private final double MILJOE_AFGIFT = 2.5;

    public Ordre(int ordreID) throws SQLException {
        this.ordreID = ordreID;
        handler = new Handler();
        hentOrdreFraDatabase();
    }

    private void hentOrdreFraDatabase() throws SQLException {
        ResultSet rs = handler.hentOrdreFraDatabase(ordreID);
        if (rs.next()) {
            this.status = rs.getInt("status");
            this.bestillingsDato = rs.getDate("bestillingsDato");
            this.leveringsDato = rs.getDate("leveringsDato");
            this.skrifttype = rs.getString("skriftType");
            this.skriftStoerrelse = rs.getInt("skriftStoerrelse");
            this.skriftStil = rs.getInt("skriftStil");
            this.bemaerkninger = rs.getString("bemaerkninger");
            this.totalPris = rs.getDouble("totalPris");
            this.rabat = rs.getDouble("rabat");
        }
    }

    public void gemOrdreIDatabase(int status, Date bestillingsDato, Date leveringsDato,
            String skrifttype, int skriftstørrelse, int skriftStil, String bemærkninger,
            double totalPris, double rabat) throws SQLException {
        this.status = status;
        this.bestillingsDato = bestillingsDato;
        this.leveringsDato = leveringsDato;
        this.skrifttype = skrifttype;
        this.skriftStoerrelse = skriftstørrelse;
        this.skriftStil = skriftStil;
        this.bemaerkninger = bemærkninger;
        this.totalPris = totalPris;
        this.rabat = rabat;
        handler.indsaetOrdreIDatabase(ordreID, status, bestillingsDato, leveringsDato,
                skrifttype, skriftStoerrelse, skriftStil, bemaerkninger, totalPris, MOMS, rabat, MILJOE_AFGIFT);
    }

    public void redigerOrdreIDatabase(int status, Date bestillingsDato, Date leveringsDato,
            String skrifttype, int skriftstørrelse, int skriftStil, String bemærkninger,
            double totalPris, double rabat) throws SQLException {
        handler.redigerOrdreIDatabase(ordreID, status, bestillingsDato, leveringsDato,
                skrifttype, skriftstørrelse, skriftStil, bemaerkninger, totalPris, MOMS, rabat, MILJOE_AFGIFT);
    }

    public void sletOrdreFraDatabase() throws SQLException {
        handler.sletOrdreFraDatabase(ordreID);
    }

    public void saetOrdreStatus(int status) throws SQLException {
        this.status = status;
        handler.redigerOrdreIDatabase(ordreID, status, bestillingsDato, leveringsDato, 
                skrifttype, skriftStoerrelse, skriftStil, bemaerkninger, totalPris, MOMS, rabat, totalPris);
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

    public String getBemaerkninger() {
        return bemaerkninger;
    }

    public double getTotalPris() {
        return totalPris;
    }

    public double getRabat() {
        return rabat;
    }
}
