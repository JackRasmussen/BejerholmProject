package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.database.Handler;

/**
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

    public Produkt(String produktNavn) throws SQLException {
        this.handler = new Handler();
        this.produktNavn = produktNavn;
        findProduktViaNavn();
    }

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

    public void tilfoejMaengdeTilProdukt(int antal) throws SQLException {
        handler.tilfoejProduktMaengdeTilDatabase(produktID, antal);
    }

    public void fjernMaengdeFraDatabase(int antal) throws SQLException {
        handler.fjernProduktMaengdeFraDatabase(produktID, antal);
    }

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

    public void sletProduktFraDatabase() throws SQLException {
        handler.sletProduktFraDatabase(produktID);
    }

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

    public ArrayList<Produkt> hentListeAfProdukter() throws SQLException {
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
