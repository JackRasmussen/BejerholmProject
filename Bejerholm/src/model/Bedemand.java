package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.database.Handler;

/**
 * @author Dan-Philip Christensen
 */
public class Bedemand {
    
    private Handler handler;
    private String firmaNavn;
    private int cvr;
    private int tlfNr;
    private boolean cvrFilled;
    
    public Bedemand() {
        handler = new Handler();
        cvrFilled = false;
    }
    
    public void tilfoejBedemand(int cvr, String firmaNavn, int tlfNr) throws SQLException{
        handler.tilfoejBedemand(cvr, firmaNavn, tlfNr);
    }
    
    public void findBedemandViaTlf(int tlfNr) throws SQLException{
        ResultSet rs = handler.soegBedemandViaTlf(tlfNr);
        if (rs.next()) {
            cvr = rs.getInt("cvr");
            firmaNavn = rs.getString("firmaNavn");
            cvrFilled = true;
        } else {
            cvr = 0;
            firmaNavn = "Bedemand findes ikke";
            cvrFilled = false;
        }
    }
    
    public void findBedemandViaNavn(String firmaNavn) throws SQLException{
        ResultSet rs = handler.soegBedemandViaNavn(firmaNavn);
        if (rs.next()) {
            cvr = rs.getInt("cvr");
            tlfNr = rs.getInt("tlfNr");
            cvrFilled = true;
        } else {
            cvr = 0;
            tlfNr = 0;
            cvrFilled = false;
        }
    }
    
    public void sletBedemand() throws SQLException{
        if (cvrFilled) {
        handler.sletBedemand(cvr);            
        }
    }
    
    public ArrayList<Integer> hentListeOverBedemaend() throws SQLException{
        ResultSet rs = handler.hentListeOverBedemaend();
        
        ArrayList<Integer> cvrListe = new ArrayList<>();
        while(rs.next()){
            cvrListe.add(rs.getInt("cvr"));
        }
        return cvrListe;
    }
    
    public void finalizeThisBedemand(){
        handler.finalizeThisHandler();
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public int getCvr() {
        return cvr;
    }

    public int getTlfNr() {
        return tlfNr;
    }
    
    
}
