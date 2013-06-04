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

    public Kunde(int tlfNr) throws SQLException, ClassNotFoundException, 
            Exception {
        this.handler = new Handler();
        this.tlfNr = tlfNr;
        hentMuligKundeFraDatabase();
    }

    /**
     * Denne metode kaldes fra constructoren og sætter egenskaberne for det
     * nuværende objekt af denne klasse, ud fra informationerne databasen har.
     * Hvis der ikke findes en record der er gyldig, vil egenskaberne sættes til
     * tomme værdier.
     *
     * @throws SQLException
     */
    private void hentMuligKundeFraDatabase() throws SQLException {
        ResultSet rs = handler.soegKunder(tlfNr);
        if (rs.next()) {
            this.fNavn = rs.getString("fNavn");
            this.eNavn = rs.getString("eNavn");
            this.adresse = rs.getString("adresse");
            this.postNr = rs.getInt("postNr");
            this.by = rs.getString("byNavn");
            this.mobil = rs.getInt("ekstraTlfNr");
        } else {
            this.fNavn = "Kunde findes ikke";
            this.eNavn = "Kunde findes ikke";
            this.adresse = "Kunde findes ikke";
            this.postNr = 0;
            this.by = "Kunde findes ikke";
            this.mobil = 0;
        }
        rs.close();
    }

    /**
     * Denne metode indsætter en ny record i databasen ud fra det givne input
     * metoden modtager, og sætter samtidig også egenskaber for det nuværende
     * objekt af denne klasse.
     *
     * @param fNavn
     * @param eNavn
     * @param adresse
     * @param postNr
     * @param by
     * @throws SQLException
     */
    public void indsaetKundeIDatabase(String fNavn, String eNavn, 
            String adresse, int postNr, String by, int mobil) 
            throws SQLException {
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.by = by;
        handler.indsaetKunde(tlfNr, fNavn, eNavn, adresse, 
                postNr, eNavn, mobil);
    }

    /**
     * Denne metode ændrer en record i databasen ud fra telefonnummeret det
     * nuværende objekt af denne klasse har, samt de input metoden modtager.
     *
     * @param fNavn
     * @param eNavn
     * @param adresse
     * @param postNr
     * @param by
     * @throws SQLException
     */
    public void redigerKundeIDatabase(String fNavn, String eNavn, 
            String adresse, int postNr, String by, int mobil) 
            throws SQLException {
        handler.redigerKunde(tlfNr, fNavn, eNavn, adresse, postNr, by, mobil);
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
