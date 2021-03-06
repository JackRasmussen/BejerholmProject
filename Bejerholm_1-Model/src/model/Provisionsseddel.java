package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.database.Handler;

/**
 * @author Dan-Philip Christensen
 */
public class Provisionsseddel {

    private int provisionsID;
    private Date provisionsDato;
    private final String vedroerende = "Bejerholm";
    private int provisionsProcent;
    private String beskrivelse;
    private int ordreID;
    private Handler handler;

    public Provisionsseddel(int provisionsID) throws SQLException {
        this.provisionsID = provisionsID;
        handler = new Handler();
        hentProvisionsseddelFraDatabase();
    }

    private void hentProvisionsseddelFraDatabase() throws SQLException {
        ResultSet rs = handler.hentProvisionsseddelFraDatabase(provisionsID);
        if (rs.next()) {
            this.provisionsDato = rs.getDate("provisionsDato");
            this.provisionsProcent = rs.getInt("provisionsProcent");
            this.beskrivelse = rs.getString("beskrivelse");
            this.ordreID = rs.getInt("ordreID");
        } else {
            this.provisionsDato = null;
            this.provisionsProcent = 0;
            this.beskrivelse = "Provisionsseddel findes ikke";
            this.ordreID = 0;
        }
        rs.close();
    }

    public void indsaetProvisionsSeddelIDatabase(Date provisionsDato, int provisionsProcent, String beskrivelse, int ordreID) throws SQLException {
        this.provisionsDato = provisionsDato;
        this.provisionsProcent = provisionsProcent;
        this.beskrivelse = beskrivelse;
        this.ordreID = ordreID;
        handler.indsaetProvisionsseddelIDatabase(provisionsID, provisionsDato, vedroerende, provisionsProcent, beskrivelse, ordreID);
    }

    public void sletProvisionsSeddelFraDatabase() throws SQLException {
        handler.sletProvisionsseddelFraDatabase(provisionsID);
    }

    public int getProvisionsID() {
        return provisionsID;
    }

    public Date getProvisionsDato() {
        return provisionsDato;
    }

    public String getVedroerende() {
        return vedroerende;
    }

    public int getProvisionsProcent() {
        return provisionsProcent;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getOrdreID() {
        return ordreID;
    }
}
