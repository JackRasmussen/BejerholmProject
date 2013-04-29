package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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

    public Faktura(int fakturaNr) throws SQLException {
        this.fakturaNr = fakturaNr;
        handler = new Handler();
        hentFaktura();
    }

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

    public void indsaetFakturaIDatabase(Date fakturaDato, String bankOplysninger, int ordreID) throws SQLException {
        this.fakturaDato = fakturaDato;
        this.bankOplysninger = bankOplysninger;
        this.ordreID = ordreID;
        handler.indsaetFakturaIDatabase(fakturaNr, fakturaDato, vedroerende, bankOplysninger, ordreID);
    }

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