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
    
    private Handler handler;

    public Produkt() {
        handler = new Handler();
    }

    public ArrayList<Integer> hentListeOverProdukter() throws SQLException {
        ResultSet rs = handler.hentListeOverProdukter();
        ArrayList<Integer> idListeOverAlleProdukter = new ArrayList<>();
        while(rs.next()){
            idListeOverAlleProdukter.add(rs.getInt("produktID"));
        }
        
        return idListeOverAlleProdukter;
    }
    
    public ArrayList<Integer> findProduktIDer(String produktNavn) throws SQLException{
        ResultSet rs = handler.findProduktIDViaNavn(produktNavn);
        ArrayList<Integer> idListe = new ArrayList<>();
        while (rs.next()) {
            idListe.add(rs.getInt("produktID"));
        }
        
        return idListe;
    }
    
    public int hentProduktMaengde(int produktID) throws SQLException{
        ResultSet rs = handler.findMaengdeAfProdukt(produktID);
        int resulterendeMaengde = 0;
        if (rs.next()) {
            resulterendeMaengde = rs.getInt("antal");
        }
        
        return resulterendeMaengde;
    }
    
    public void tilfoejMaengdeTilProdukt(int produktID, int antal) throws SQLException{
        handler.tilfoejProduktMaengdeTilDatabase(produktID, antal);
    }
    
    public void fjernMaengdeFraDatabase(int produktID, int antal) throws SQLException{
        handler.fjernProduktMaengdeFraDatabase(produktID, antal);
    }

    public void indsaetProduktIDatabase(int produktID, String produktType,
            String produktNavn, int antal, double salgsPris, double indkoebsPris) throws SQLException {
        handler.tilfoejProdukt(produktID, produktType, produktNavn, antal, salgsPris, indkoebsPris);
    }

    public void sletProduktFraDatabase(int produktID) throws SQLException {
        handler.sletProduktFraDatabase(produktID);
    }

    public void redigerProduktIDatabase(int produktID, String produktType,
            String produktNavn, int antal, double salgsPris, double indkoebsPris) throws SQLException {
        handler.redigerProduktIDatabase(produktID, produktType, produktNavn, antal, salgsPris, indkoebsPris);
    }
    
    public void finalizeThisProdukt(){
        handler.finalizeThisHandler();
    }
}
