package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.database.Handler;

/**
 *
 * @author Dan-Philip Christensen
 */
public class Kunde {

    private String fNavn;
    private String eNavn;
    private String adresse;
    private int postNr;
    private String by;
    private int tlfNr;
    private int mobil;
    Handler handler;

    public Kunde(int tlfNr) throws SQLException {
        this.handler = new Handler();
        this.tlfNr = tlfNr;
        hentMuligKundeFraDatabase();
    }

    private void hentMuligKundeFraDatabase() throws SQLException {
        ResultSet rs = handler.soegKunder(tlfNr);
        if (rs.next()) {
            this.fNavn = rs.getString("fNavn");
            this.eNavn = rs.getString("eNavn");
            this.adresse = rs.getString("adresse");
            this.postNr = rs.getInt("postNr");
            this.by = rs.getString("byNavn");
        } else {
            this.fNavn = "Kunde findes ikke";
            this.eNavn = "Kunde findes ikke";
            this.adresse = "Kunde findes ikke";
            this.postNr = 0;
            this.by = "Kunde findes ikke";
        }
        rs.close();
    }

    public void indsaetKundeIDatabase(String fNavn, String eNavn, String adresse, int postNr, String by) throws SQLException {
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.by = by;
        handler.indsaetKunde(tlfNr, fNavn, eNavn, adresse, postNr, eNavn);
    }

    public void sletKundeFraDatabase() throws SQLException {
        handler.sletKunde(tlfNr);
    }

    public void redigerKundeIDatabase(String fNavn, String eNavn, String adresse, int postNr, String by) throws SQLException {
        handler.redigerKunde(tlfNr, fNavn, eNavn, adresse, postNr, by);
    }

    public String getfNavn() {
        return fNavn;
    }

    public String geteNavn() {
        return eNavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getPostNr() {
        return postNr;
    }

    public String getBy() {
        return by;
    }

    public int getTlfNr() {
        return tlfNr;
    }

    public int getMobil() {
        return mobil;
    }
}
