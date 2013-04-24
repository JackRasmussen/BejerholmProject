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

    //denne constructor skal checke om der er nogle kunder med det
    //tlf nr, og returnere infoer på matches
    public Kunde(int tlfNr) {
        handler = new Handler();
        this.tlfNr = tlfNr;
    }

    public void hentMuligeKunderFraDatabase() throws SQLException {
        ResultSet rs = handler.soegKunder(tlfNr);
        if (rs.next()) {
            fNavn = rs.getString("fNavn");
            eNavn = rs.getString("eNavn");
            adresse = rs.getString("adresse");
            postNr = rs.getInt("postNr");
            by = rs.getString("byNavn");
        } else {
            fNavn = "Kunde findes ikke";
            eNavn = "Kunde findes ikke";
            adresse = "Kunde findes ikke";
            postNr = 0;
            by = "Kunde findes ikke";
        }
        rs.close();
    }

    public void indsaetKundeIDatabase(String fNavn, String eNavn, String adresse, int postNr, String by) throws SQLException {
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.by = by;
        handler.indsaetKunde(tlfNr, this.fNavn, this.eNavn, this.adresse, this.postNr, this.eNavn);
    }

    public void sletKundeFraDatabase() throws SQLException {
        handler.sletKunde(tlfNr);
    }

    public void redigerKundeIDatabase(String fNavn, String eNavn, String adresse, int postNr, String by) throws SQLException {
        ResultSet rs = handler.soegKunder(tlfNr);
        if (rs.next()) {
            if (!rs.getString("fNavn").equals(fNavn)
                    || !rs.getString("eNavn").equals(eNavn)
                    || !rs.getString("adresse").equals(adresse)
                    || rs.getInt("postNr") != postNr
                    || !rs.getString("byNavn").equals(by)) {

                handler.redigerKunde(tlfNr, fNavn, eNavn, adresse, postNr, by);
            }
        }

        rs.close();
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
