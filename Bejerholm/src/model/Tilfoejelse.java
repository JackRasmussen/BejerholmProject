package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.database.Handler;

/**
 *
 * @author Dan-Philip-N
 */
public class Tilfoejelse {
    
    private Handler handler;
    
    public Tilfoejelse(){
        handler = new Handler();
    }
    
    public ArrayList<Integer> hentListeOverTilfoejelser() throws SQLException{
        ResultSet rs = handler.hentListeOverTilfoejelserFraDatabase();
        ArrayList<Integer> listeAfTilfoejelser = new ArrayList<>();
        
        while (rs.next()){
            listeAfTilfoejelser.add(rs.getInt("tilfoejelsesID"));
        }
        
        return listeAfTilfoejelser;
    }
    
    public String hentTilfoejelsesType(int tilfoejelsesID) throws SQLException{
        return handler.hentTilfoejelsesTypeFraDatabase(tilfoejelsesID);
    }
    
    public int hentTilfoejelsesPris(int tilfoejelsesID) throws SQLException{
        return handler.hentTilfoejelsesPrisFraDatabase(tilfoejelsesID);
    }
    
    public void indsaetNyTilfoejelse(int tilfoejelsesID, String type, double pris) throws SQLException{
        handler.indsaetTilfoejelseIDatabase(tilfoejelsesID, type, pris);
    }
    
    public void redigerTilfoejelse(int tilfoejelsesID, String type, double pris) throws SQLException{
        handler.redigerTilfoejelseIDatabase(tilfoejelsesID, type, pris);
    }
    
    public void sletTilfoejelse(int tilfoejelsesID) throws SQLException{
        handler.sletTilfoejelseFraDatabase(tilfoejelsesID);
    }
    
}
