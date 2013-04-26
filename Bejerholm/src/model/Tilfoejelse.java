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

    public Tilfoejelse(int tilfoejelsesID) throws SQLException {
        handler = new Handler();
        this.tilfoejelsesID = tilfoejelsesID;
        hentTilfoejelsesInfo();
    }

    private void hentTilfoejelsesInfo() throws SQLException {
        ResultSet rs = handler.hentTilfoejelseFraDatabase(tilfoejelsesID);
        if (rs.next()) {
            this.tilfoejelsesType = rs.getString("tilfoejelsesType");
            this.tilfoejelsesPris = rs.getDouble("pris");
        } else {
            this.tilfoejelsesType = "Tilfoejelse findes ikke";
            this.tilfoejelsesPris = 0;
        }
    }

    public void indsaetTilfoejelseIDatabase(String tilfoejelsesType, double pris) throws SQLException {
        this.tilfoejelsesType = tilfoejelsesType;
        this.tilfoejelsesPris = pris;
        handler.indsaetTilfoejelseIDatabase(tilfoejelsesID, tilfoejelsesType, pris);
    }

    public void redigerTilfoejelse(String type, double pris) throws SQLException {
        handler.redigerTilfoejelseIDatabase(tilfoejelsesID, type, pris);
    }

    public void sletTilfoejelse() throws SQLException {
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
