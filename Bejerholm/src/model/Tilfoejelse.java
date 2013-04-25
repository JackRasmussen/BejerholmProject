package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.database.Handler;

/**
 *
 * @author Dan-Philip-N
 */
public class Tilfoejelse {
    
    private Handler handler;
    private int tilfoejelsesID;
    private String tilfoejelsesType;
    private double tilfoejelsesPris;
    
    public Tilfoejelse(String tilfoejelsesType) throws SQLException{
        handler = new Handler();
        this.tilfoejelsesType = tilfoejelsesType;
        hentTilfoejelsesInfo();
    }
    
    private void hentTilfoejelsesInfo() throws SQLException{
        ResultSet rs = handler.hentTilfoejelseFraDatabase(tilfoejelsesType);
        if (rs.next()) {
            this.tilfoejelsesID = rs.getInt("tilfoejelsesID");
            this.tilfoejelsesPris = rs.getDouble("pris");
        } else {
            this.tilfoejelsesID = 0;
            this.tilfoejelsesPris = 0;
        }
    }
    
    public void indsaetTilfoejelseIDatabase(int tilfoejelsesID, double pris) throws SQLException{
        handler.indsaetTilfoejelseIDatabase(tilfoejelsesID, tilfoejelsesType, pris);
    }
    
    public void redigerTilfoejelse(String type, double pris) throws SQLException{
        handler.redigerTilfoejelseIDatabase(tilfoejelsesID, type, pris);
    }
    
    public void sletTilfoejelse() throws SQLException{
        handler.sletTilfoejelseFraDatabase(tilfoejelsesID);
    }

    public int getTilfoejelsesID() {
        return tilfoejelsesID;
    }

    public String getTilfoejelsesType() {
        return tilfoejelsesType;
    }

    public double getTilfoejelsesPris() {
        return tilfoejelsesPris;
    }
}
