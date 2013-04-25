package model.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Handler {

    DBConnection dBConnection;

    public Handler() {
        dBConnection = new DBConnection();
    }

    public ResultSet soegKunder(int tlfNr) throws SQLException {
        String command = ("select * from Kunde where tlfNr = " + tlfNr + ";");

        ResultSet rs = dBConnection.getResultSetWithCommand(command);

        return rs;
    }

    public void indsaetKunde(int tlfNr, String fNavn, String eNavn, String adresse, int postNr, String byNavn) throws SQLException {
        String command = ("insert into Kunde(tlfNr, fNavn, eNavn, adresse, postNr, byNavn) "
                + "values (" + tlfNr + ", '" + fNavn + "', '" + eNavn + "', '" + adresse + "', " + postNr + ", '" + "');");
        dBConnection.execute(command);
    }

    public void sletKunde(int tlfNr) throws SQLException {
        String command = ("delete from Kunde where tlfNr = " + tlfNr + ";");
        dBConnection.execute(command);
    }

    public void redigerKunde(int tlfNr, String nyFNavn, String nyENavn, String nyAdresse, int nyPostNr, String nyByNavn) throws SQLException {
        String command = ("update Kunde set fNavn = '" + nyFNavn + "', eNavn = '"
                + nyENavn + "', adresse = '" + nyAdresse + "', postNr = " + nyPostNr
                + ", byNavn = '" + nyByNavn + "' where tlfNr = " + tlfNr + ";");
        dBConnection.execute(command);
    }

    public void tilfoejBedemand(int cvr, String firmaNavn, int tlfNr) throws SQLException {
        String command = ("insert into Bedemand(cvr, firmaNavn, tlfNr) "
                + "values (" + cvr + ", '" + firmaNavn + "', " + tlfNr + ");");
        dBConnection.execute(command);
    }

    public void sletBedemand(int cvr) throws SQLException {
        String command = ("delete from Bedemand where cvr = " + cvr + ";");
        dBConnection.execute(command);
    }

    public ResultSet soegBedemandViaTlf(int tlfNr) throws SQLException {
        String command = ("select * from Bedemand where tlfNr = " + tlfNr + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public ResultSet soegBedemandViaNavn(String firmaNavn) throws SQLException {
        String command = ("select * from Bedemand where firmaNavn = '" + firmaNavn + "';");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public ResultSet hentListeOverBedemaend() throws SQLException {
        String command = ("select * from Bedemand;");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public ResultSet hentListeOverProdukter() throws SQLException {
        String command = ("select * from Produkt");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);

        return rs;
    }

    public ResultSet findMaengdeAfProdukt(int produktID) throws SQLException {
        String command = ("select * from Produkt where produktID = " + produktID + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);

        return rs;
    }

    public void tilfoejProdukt(int produktID, String produktType,
            String produktNavn, int antal, double salgsPris, double indkoebsPris) throws SQLException {
        String command = ("insert into Produkt(produktID, produktType, produktNavn, antal, salgsPris, indkoebsPris)"
                + "values (" + produktID + ", '" + produktType + "', '"
                + produktNavn + "', " + antal + ", " + salgsPris + ", " + indkoebsPris + ");");
        dBConnection.execute(command);
    }

    public ResultSet findProduktIDViaNavn(String produktNavn) throws SQLException {
        String command = ("select * from Produkt where produktNavn like '%" + produktNavn + "%';");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public void redigerProduktIDatabase(int produktID, String produktType,
            String produktNavn, int antal, double salgsPris, double indkoebsPris) throws SQLException {
        String command = ("update Produkt set produktType  = '" + produktType + "', produktNavn = '"
                + produktNavn + "', antal = " + antal + ", salgsPris = " + salgsPris + ", indkoebsPris = "
                + indkoebsPris + " where produktID = " + produktID + ";");

        dBConnection.execute(command);
    }

    public void tilfoejProduktMaengdeTilDatabase(int produktID, int antal) throws SQLException {
        String command = ("update Produkt set antal = antal + " + antal + " where produktID = " + produktID + ";");
        dBConnection.execute(command);
    }

    public void fjernProduktMaengdeFraDatabase(int produktID, int antal) throws SQLException {
        String command = ("update Produkt set antal = antal - " + antal + " where produktID = " + produktID + ";");
        dBConnection.execute(command);
    }

    public void sletProduktFraDatabase(int produktID) throws SQLException {
        String command = ("delete from Produkt where produktID = " + produktID + ";");
        dBConnection.execute(command);
    }

    public void indsaetTilfoejelseIDatabase(int tilfoejelsesID, String type, double pris) throws SQLException {
        String command = ("insert into Tilfoejelse (tilfoejelsesID, opgaveType, pris)"
                + "values (" + tilfoejelsesID + ", '" + type + "', " + pris + ");");
        dBConnection.execute(command);
    }

    public void sletTilfoejelseFraDatabase(int tilfoejelsesID) throws SQLException {
        String command = ("delete from Tilfoejelse where tilfoejelsesID = " + tilfoejelsesID + ";");
        dBConnection.execute(command);
    }

    public void redigerTilfoejelseIDatabase(int tilfoejelsesID, String type, double pris) throws SQLException {
        String command = ("update Tilfoejelse set opgaveType = '"
                + type + "', pris = " + pris + "where tilfoejelsesID = " + tilfoejelsesID + ";");
        dBConnection.execute(command);
    }

    public int hentTilfoejelsesPrisFraDatabase(int tilfoejelsesID) throws SQLException {
        String command = ("select *  from Tilfoejelse where tilfoejelsesID = " + tilfoejelsesID + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        int pris = 0;
        if (rs.next()) {
        pris = rs.getInt("pris");
        }
        
        return pris;
    }

    public String hentTilfoejelsesTypeFraDatabase(int tilfoejelsesID) throws SQLException {
        String command = ("select * from Tilfoejelse where tilfoejelsesID = " + tilfoejelsesID + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        String opgaveType = null;
        if (rs.next()) {
            opgaveType = rs.getString("opgaveType");
        }
        return opgaveType;
    }

    public ResultSet hentListeOverTilfoejelserFraDatabase() throws SQLException {
        String command = ("select * from Tilfoejelse;");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);

        return rs;
    }

    public void finalizeThisHandler() {
        dBConnection.closeConnection();
    }
}
