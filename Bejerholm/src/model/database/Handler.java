package model.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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

    public void redigerBedemand(int cvr, String firmaNavn, int tlfNr) throws SQLException {
        String command = ("update Bedemand set firmaNavn = '" + firmaNavn + "', tlfNr = " + tlfNr + " where cvr = " + cvr + ";");
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

    public ResultSet findProduktViaNavn(String produktNavn) throws SQLException {
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

    public ResultSet hentTilfoejelseFraDatabase(String tilfoejelsesType) throws SQLException {
        String command = ("select * from Tilfoejelse where tilfoejelsesType = '" + tilfoejelsesType + "';");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);

        return rs;
    }

    public ResultSet hentFakturaFraDatabase(int fakturaNr) throws SQLException {
        String command = ("select * from Faktura where fakturaNr = " + fakturaNr + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public void indsaetFakturaIDatabase(int fakturaNr, Date fakturaDato, String vedroerende, String bankOplysninger) throws SQLException {
        String command = ("insert into Faktura (faktureringsNr, faktureringsDato, vedroerende, bankOplysninger) "
                + "values (" + fakturaNr + ", " + fakturaDato + ", '" + vedroerende + "', '" + bankOplysninger + "');");
        dBConnection.execute(command);
    }

    public void sletFakturaFraDatabase(int fakturaNr) throws SQLException {
        String command = ("delete from Faktura where faktureringsNr = " + fakturaNr + ";");
        dBConnection.execute(command);
    }

    public ResultSet hentProvisionsseddelFraDatabase(int provisionsID) throws SQLException {
        String command = ("select * from Provisionsseddel where provisionsID = " + provisionsID + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public void indsaetProvisionsseddelIDatabase(int provisionsID, Date provisionsDato, String vedroerende, int provisionsProcent, String beskrivelse) throws SQLException {
        String command = ("insert into Provisionsseddel (provisionsID, provisionsDato, vedroerende, provisionsProcent, beskrivelse) "
                + "values (" + provisionsDato + ", " + provisionsDato + ", '" + vedroerende + "', " + provisionsProcent + ", '" + beskrivelse + "');");
        dBConnection.execute(command);
    }

    public void sletProvisionsseddelFraDatabase(int provisionsID) throws SQLException {
        String command = ("delete from Provisionsseddel where provisionsID = " + provisionsID + ";");
        dBConnection.execute(command);
    }

    public ResultSet hentKontoudtogFraDatabase(int kontoudtogsID) throws SQLException {
        String command = ("select * from Kontoudtog where kontoudtogsID = " + kontoudtogsID + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public void sletKontoudtogFraDatabase(int kontoudtogsID) throws SQLException {
        String command = ("delete from Kontoudtog where kontoudtogsID = " + kontoudtogsID + ";");
        dBConnection.execute(command);
    }

    public void indsaetKontoudtogIDatabase(int kontoudtogsID, Date kontoudtogsDato, String vedroerende, String ordreLinjePris, String ordreLinjeProv) throws SQLException {
        String command = ("insert into Kontoudtog(kontoudtogsID, kontoudtogsDato, vedroerende, ordreLinjePris, ordreLinjeProv) "
                + "values (" + kontoudtogsID + ", " + kontoudtogsDato + ", '" + vedroerende + "', '" + ordreLinjePris + "', '" + ordreLinjeProv + "');");
        dBConnection.execute(command);
    }

    public ResultSet hentKirkegaardsOrdreFraDatabase(int kirkegaardsID) throws SQLException {
        String command = ("select * from KirkegaardsOrdre where kirkegaardsID = " + kirkegaardsID + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public void indsaetKirkegaardsOrdreIDatabase(int kirkegaardsID, boolean urne_Kiste, int raekke, int nummer, String afdeling) throws SQLException {
        String command = ("insert into KirkegaardsOrdre(kirkegaardsID, urne_Kiste, raekke, nummer, afdeling) "
                + "values (" + kirkegaardsID + ", " + urne_Kiste + ", " + raekke + ", " + nummer + ", '" + afdeling + "');");
        dBConnection.execute(command);
    }

    public void redigerKirkegaardsOrdreIDatabase(int kirkegaardsID, boolean urne_Kiste, int raekke, int nummer, String afdeling) throws SQLException {
        String command = ("update KirkegaardsOrdre set urne_Kiste = " + urne_Kiste + ", raekke = " + raekke + ", nummer = "
                + nummer + ", afdeling = '" + afdeling + "' where kirkegaardsID = " + kirkegaardsID + ";");
        dBConnection.execute(command);
    }
    
    public void sletKirkegaardsOrdreFraDatabase(int kirkegaardsID) throws SQLException{
        String command = ("delete from KirkegaardsOrdre where kirkegaardsID = " + kirkegaardsID + ";");
        dBConnection.execute(command);
    }
    
    public void sletOrdreFraDatabase(int ordreID) throws SQLException{
        String command = ("delete from Ordre where ordreID = " + ordreID + ";");
        dBConnection.execute(command);
    }
    
    public void redigerOrdreIDatabase(int ordreID, int status, Date bestillingsDato, Date leveringsDato, 
            String skrifttype, int skriftstørroelse, int skriftStil, String bemaerkninger, double totalPris, 
            double moms, double rabat, double miljoe_Afgift) throws SQLException{
        String command = ("update Ordre set status = " + status + ", bestillingsDato = " + bestillingsDato +
                ", leveringsDato = " + leveringsDato + ", skriftType = '" + skrifttype + "', skriftStil = '"
                + skriftStil + "', bemaerkninger = '" + bemaerkninger + "', totalPris = " + totalPris +
                ", moms = " + moms + ", rabat = " + rabat + ", miljoeAfgift = " + miljoe_Afgift + " where ordreID = " + ordreID + ";");
        dBConnection.execute(command);
    }
    
    public void indsaetOrdreIDatabase(int ordreID, int status, Date bestillingsDato, Date leveringsDato, 
            String skrifttype, int skriftstoerrelse, int skriftStil, String bemaerkninger, double totalPris, 
            double moms, double rabat, double miljoe_Afgift) throws SQLException{
        String command = ("insert into Ordre (ordreID, status, bestillingsDato, leveringsDato, skriftType,"
                + " skriftStoerrselse, skriftStil, bemaerkninger, totalPris, moms, rabat, miljoeAfgift) " 
                + "values (" + ordreID + ", " + status + ", " + bestillingsDato + ", " + leveringsDato + ", '"
                + skrifttype + "', " + skriftstoerrelse + ", " + skriftStil + ", '" + bemaerkninger + "', "
                + totalPris + ", " + moms + ", " + rabat + ", " + miljoe_Afgift + ");");
        dBConnection.execute(command);
    }
    
    public ResultSet hentOrdreFraDatabase(int ordreID) throws SQLException{
        String command = ("select * from Ordre where ordreID = " + ordreID + ";");
        ResultSet rs = dBConnection.getResultSetWithCommand(command);
        return rs;
    }

    public void finalizeThisHandler() {
        dBConnection.closeConnection();
    }
}
