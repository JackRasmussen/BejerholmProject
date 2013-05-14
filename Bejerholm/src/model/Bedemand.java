package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.database.Handler;

/**
 * @author Dan-Philip Christensen
 */
public class Bedemand {

    private Handler handler;
    private String firmaNavn;
    private int cvr;
    private int tlfNr;

    public Bedemand(int tlfNr) throws SQLException {
        this.handler = new Handler();
        this.tlfNr = tlfNr;
        findBedemandViaTlf(tlfNr);
    }

    public Bedemand(String firmaNavn) throws SQLException {
        this.handler = new Handler();
        this.firmaNavn = firmaNavn;
        findBedemandViaNavn(firmaNavn);
    }

    private void findBedemandViaTlf(int tlfNr) throws SQLException {
        ResultSet rs = handler.soegBedemandViaTlf(tlfNr);
        if (rs.next()) {
            cvr = rs.getInt("cvr");
            firmaNavn = rs.getString("firmaNavn");
        } else {
            cvr = 0;
            firmaNavn = "Bedemand findes ikke";
        }
        rs.close();
    }

    private void findBedemandViaNavn(String firmaNavn) throws SQLException {
        ResultSet rs = handler.soegBedemandViaNavn(firmaNavn);
        if (rs.next()) {
            cvr = rs.getInt("cvr");
            tlfNr = rs.getInt("tlfNr");
        } else {
            cvr = 0;
            tlfNr = 0;
        }
        rs.close();
    }

    public void tilfoejBedemandTilDatabase(int cvr, int tlfNr, String firmaNavn) throws SQLException {
        this.cvr = cvr;
        this.tlfNr = tlfNr;
        this.firmaNavn = firmaNavn;
        handler.tilfoejBedemand(cvr, firmaNavn, tlfNr);
    }

    public void sletBedemandFraDatabase() throws SQLException {
        handler.sletBedemand(cvr);
    }

    public void redigerBedemandIDatabase(String firmaNavn, int tlfNr) throws SQLException {
        handler.redigerBedemand(cvr, firmaNavn, tlfNr);
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
