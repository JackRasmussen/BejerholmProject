package model;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Handler handler;

    public Produkt(String produktNavn) throws SQLException {
        this.handler = new Handler();
        this.produktNavn = produktNavn;
        findProduktViaNavn();
    }
    
    private void findProduktViaNavn() throws SQLException{
        ResultSet rs = handler.findProduktViaNavn(produktNavn);
        
        if (rs.next()) {
            this.produktID = rs.getInt("produktID");
            this.produktType = rs.getString("type");
            this.produktAntal = rs.getInt("antal");
            this.salgsPris = rs.getDouble("salgsPris");
            this.indkoebsPris = rs.getDouble("indkoebsPris");
        } else {
            this.produktID = 0;
            this.produktType = "Produkt findes ikke";
            this.produktAntal = 0;
            this.salgsPris = 0;
            this.indkoebsPris = 0;
        }
    }

    public void tilfoejMaengdeTilProdukt(int antal) throws SQLException {
        handler.tilfoejProduktMaengdeTilDatabase(produktID, antal);
    }

    public void fjernMaengdeFraDatabase(int antal) throws SQLException {
        handler.fjernProduktMaengdeFraDatabase(produktID, antal);
    }

    public void indsaetProduktIDatabase(int produktID, String produktType, int produktAntal, double salgsPris, double indkoebsPris) throws SQLException {
        handler.tilfoejProdukt(produktID, produktType, produktNavn, produktAntal, salgsPris, indkoebsPris);
    }

    public void sletProduktFraDatabase() throws SQLException {
        handler.sletProduktFraDatabase(produktID);
    }

    public void redigerProduktIDatabase(String produktType, String produktNavn, int antal, 
            double salgsPris, double indkoebsPris) throws SQLException {
        handler.redigerProduktIDatabase(produktID, produktType, produktNavn, antal, salgsPris, indkoebsPris);
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
}
