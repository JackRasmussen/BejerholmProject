package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.database.Handler;

/**
 * Denne klasse har 2 constructorer, en som skal bruges i de fleste tilfælde, og
 * en som KUN bruges i sammenhæng med metoden kaldet hentListeAfProdukter.
 *
 * <p>
 *
 * <strong> WARNING: Brug kun tom constructor input når produktliste skal
 * hentes!<strong>
 *
 * @author jack
 */
public class Produkt {

    private int produktID;
    private String produktType;
    private String produktNavn;
    private int produktAntal;
    private double salgsPris;
    private double indkoebsPris;
    private double maalX;
    private double maalY;
    private Handler handler;

    /**
     * Denne constructor skaber et nyt objekt af denne klasse og parametre fra
     * databasen efter inputtet denne constructor modtager.
     *
     * @param produktNavn
     * @throws SQLException
     */
    public Produkt(String produktNavn) throws SQLException, ClassNotFoundException, Exception {
        this.handler = new Handler();
        this.produktNavn = produktNavn;
        findProduktViaNavn();
    }

    /**
     * <strong> Warning: BRUG KUN DENNE CONSTRUCTOR TIL HENTLISTE!! <strong>
     */
    public Produkt() throws SQLException, ClassNotFoundException, Exception {
        this.handler = new Handler();
    }

    /**
     * Denne metode kaldes fra constructoren og henter data fra databasen til at
     * sætte egenskaberne for det nuværende objekt af denne klasse. Hvis ikke
     * der findes en gyldig record i databasen til egenskaberne sættes til tomme
     * værdier.
     *
     * @throws SQLException
     */
    private void findProduktViaNavn() throws SQLException {
        ResultSet rs = handler.findProduktViaNavn(produktNavn);

        if (rs.next()) {
            this.produktID = rs.getInt("produktID");
            this.produktType = rs.getString("type");
            this.produktAntal = rs.getInt("antal");
            this.salgsPris = rs.getDouble("salgsPris");
            this.indkoebsPris = rs.getDouble("indkoebsPris");
            this.maalX = rs.getDouble("maalX");
            this.maalY = rs.getDouble("maalY");
        } else {
            this.produktID = 0;
            this.produktType = "Produkt findes ikke";
            this.produktAntal = 0;
            this.salgsPris = 0;
            this.indkoebsPris = 0;
            this.maalX = 0;
            this.maalY = 0;
        }
    }

    /**
     * Denne metode ændrer maengde variablen i det nuværende objekt af denne
     * klasse, og ændrer det samtidig i databasen.
     *
     * @param antal
     * @throws SQLException
     */
    public void tilfoejMaengdeTilProdukt(int antal) throws SQLException {
        handler.tilfoejProduktMaengdeTilDatabase(produktID, antal);
    }

    /**
     * Denne metode gør det samme som foregående metode, men fjerner i stedet
     * for at indsætte.
     *
     * @param antal
     * @throws SQLException
     */
    public void fjernMaengdeFraDatabase(int antal) throws SQLException {
        handler.fjernProduktMaengdeFraDatabase(produktID, antal);
    }

    /**
     * Denne metode indsætter en ny record i databasen for det nuværende objekt
     * af denne klasse, og sætter i samme omgang klassens egenskaber til
     * inputtet metoden modtager.
     *
     * @param produktID
     * @param produktType
     * @param produktAntal
     * @param salgsPris
     * @param indkoebsPris
     * @param maalX
     * @param maalY
     * @throws SQLException
     */
    public void indsaetProduktIDatabase(int produktID, String produktType, int produktAntal, double salgsPris, double indkoebsPris, double maalX, double maalY) throws SQLException {
        this.produktID = produktID;
        this.produktType = produktType;
        this.produktAntal = produktAntal;
        this.salgsPris = salgsPris;
        this.indkoebsPris = indkoebsPris;
        this.maalX = maalX;
        this.maalY = maalY;
        handler.tilfoejProdukt(produktID, produktType, produktNavn, produktAntal, salgsPris, indkoebsPris, maalX, maalY);
    }

    /**
     * Denne metode fjerner en record fra databasen ud fra egenskaberne for det
     * nuværende objekt af denne klasse.
     *
     * @throws SQLException
     */
    public void sletProduktFraDatabase() throws SQLException {
        handler.sletProduktFraDatabase(produktID);
    }

    /**
     * Denne metode ændrer en record i databasen ud fra det nuværende objekt af
     * denne klasse samt inputtet metoden modtager, og i samme omgang ændrer den
     * egenskaberne for denne klasse.
     *
     * @param produktType
     * @param produktNavn
     * @param antal
     * @param salgsPris
     * @param indkoebsPris
     * @param maalX
     * @param maalY
     * @throws SQLException
     */
    public void redigerProduktIDatabase(String produktType, String produktNavn, int antal,
            double salgsPris, double indkoebsPris, double maalX, double maalY) throws SQLException {
        this.produktType = produktType;
        this.produktAntal = antal;
        this.salgsPris = salgsPris;
        this.indkoebsPris = indkoebsPris;
        this.maalX = maalX;
        this.maalY = maalY;
        handler.redigerProduktIDatabase(produktID, produktType, produktNavn, antal, salgsPris, indkoebsPris, maalX, maalY);
    }

    /**
     * Denne metode opretter en ArrayList af objekter af denne klasse for alle
     * records i databasen for Produkt tabellen og returnerer listen.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Produkt> hentListeAfProdukter() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Produkt> produktListe = new ArrayList<>();
        ResultSet rs = handler.hentListeAfProdukterFraDatabase();
        while (rs.next()) {
            Produkt produkt = new Produkt(rs.getString("produktNavn"));
            produktListe.add(produkt);
        }
        return produktListe;
    }

    public int getProduktID() {
        return produktID;
    }

    public String getProduktType() {
        return produktType;
    }

    public String getProduktNavn() {
        return produktNavn;
    }

    public int getProduktAntal() {
        return produktAntal;
    }

    public double getSalgsPris() {
        return salgsPris;
    }

    public double getIndkoebsPris() {
        return indkoebsPris;
    }

    public double getMaalX() {
        return maalX;
    }

    public double getMaalY() {
        return maalY;
    }
}
