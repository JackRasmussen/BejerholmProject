package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.database.Handler;

/**
 * @author Dan-Philip Christensen
 */
public class Faktura {

    private int fakturaNr;
    private Date fakturaDato;
    private final String vedroerende = "Bejerholm";
    private String bankOplysninger;
    private int ordreID;
    private Handler handler;

    public Faktura(int fakturaNr) throws SQLException, ClassNotFoundException, Exception {
        this.fakturaNr = fakturaNr;
        handler = new Handler();
        hentFaktura();
    }

    /**
     * Denne metode bliver kaldt fra constructoren, og forsøger at lede efter en
     * ordre med dette objekts egenskaber
     *
     * @throws SQLException
     */
    private void hentFaktura() throws SQLException {
        ResultSet rs = handler.hentFakturaFraDatabase(fakturaNr);
        if (rs.next()) {
            this.fakturaDato = rs.getDate("fakturaDato");
            this.bankOplysninger = rs.getString("bankOplysninger");
            this.ordreID = rs.getInt("ordreID");
        } else {
            this.fakturaDato = null;
            this.bankOplysninger = "Faktura findes ikke";
            this.ordreID = 0;
        }
        rs.close();
    }

    /**
     * Denne metode indsætter data i databasen ud fra metodens input, samt
     * sætter dette objekts egenskaber.
     *
     * @param fakturaDato
     * @param bankOplysninger
     * @param ordreID
     * @throws SQLException
     */
    public void indsaetFakturaIDatabase(Date fakturaDato, String bankOplysninger, int ordreID) throws SQLException {
        this.fakturaDato = fakturaDato;
        this.bankOplysninger = bankOplysninger;
        this.ordreID = ordreID;
        handler.indsaetFakturaIDatabase(fakturaNr, fakturaDato, vedroerende, bankOplysninger, ordreID);
    }

    /**
     * Denne metode sletter en record fra databasen ud fra det nuværende objekt
     * af denne klasse.
     *
     * @throws SQLException
     */
    public void sletFakturaFraDatabase() throws SQLException {
        handler.sletFakturaFraDatabase(fakturaNr);
    }

    public int getFakturaNr() {
        return fakturaNr;
    }

    public Date getFakturaDato() {
        return fakturaDato;
    }

    public String getVedroerende() {
        return vedroerende;
    }

    public String getBankOplysninger() {
        return bankOplysninger;
    }

    public int getOrdreID() {
        return ordreID;
    }
}