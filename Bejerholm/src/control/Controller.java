/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bedemand;
import model.Faktura;
import model.KirkegaardsOrdre;
import model.Kontoudtog;
import model.Kunde;
import model.Ordre;
import model.Produkt;
import model.Provisionsseddel;
import model.Tilfoejelse;
import model.database.DBConnection;
import view.BejerholmGUI;
import view.ordre.BedemandGUI;
import view.ordre.KundeGUI;
import view.ordre.ProduktGUI;

/**
 *
 * @author nicolai
 */
public class Controller {

    public Controller() {
    }

    public void connectDB(String user, String pass, String host, String port, String database, BejerholmGUI beg) throws SQLException {
        try {
            DBConnection.setConnectionParameters(user, pass, host, port, database);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (DBConnection.isConnected()) {
            beg.skiftPanel("OrdreGUI");
            beg.getAdmin().setVisible(true);
            beg.getOrdre().setVisible(true);
            beg.getLager().setVisible(true);
            beg.getLogaf().setVisible(true);
        } else {
            throw new SQLException("Kunne ikke logge paa db", "Bad password or settings");
        }
    }

    public void closeDBConnection(BejerholmGUI beg) {
        if (DBConnection.isConnected()) {
            DBConnection.closeConnection();
        }
        if (!DBConnection.isConnected()) {
            System.out.println("Succesfuldt logget af");
            beg.skiftPanel("LogPaaGUI");
            beg.getLager().setVisible(false);
            beg.getAdmin().setVisible(false);
            beg.getOrdre().setVisible(false);
            beg.getLogaf().setVisible(false);
        }
    }

    public void hentBedemandViaNavn(String firmaNavn) {
        try {
            Bedemand bedemand = new Bedemand(firmaNavn);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hentBedemandViaTlfNr(int tlfNr, BedemandGUI bgui) {
        try {
            Bedemand bedemand = new Bedemand(tlfNr);
            String firmaNavn = bedemand.getFirmaNavn();
            String adresse = bedemand.getAdresse();
            int postNr = bedemand.getPostNr();
            String byNavn = bedemand.getByNavn();

            bgui.setFelter(firmaNavn, adresse, postNr, byNavn);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void gemBedemandTilDatabase(int tlfNr, String firmaNavn, String adresse, String byNavn, int postNr) {
        try {
            Bedemand bedemand = new Bedemand(tlfNr);
            bedemand.tilfoejBedemandTilDatabase(tlfNr, firmaNavn, adresse, byNavn, postNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fjernBedemandFraDatabase(int TlfNr) {
        try {
            Bedemand bedemand = new Bedemand(TlfNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redigerBedemand(int tlfNr, String firmaNavn, String adresse, String byNavn, int postNr) {
        try {
            Bedemand bedemand = new Bedemand(tlfNr);
            bedemand.redigerBedemandIDatabase(tlfNr, firmaNavn, adresse, byNavn, postNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til Produkt
    public void connFindProduktViaNavn(String produktNavn) {
        try {
            Produkt produkt = new Produkt(produktNavn);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connTilfoejMaengdeTilProdukt(String produktNavn, int antal) {
        Produkt produkt;
        try {
            produkt = new Produkt(produktNavn);
            produkt.tilfoejMaengdeTilProdukt(antal);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connFjernMaengdeFraDatabase(String produktNavn, int antal) {
        try {
            Produkt produkt = new Produkt(produktNavn);
            produkt.fjernMaengdeFraDatabase(antal);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetProduktIDatabase(String produktNavn, int produktID, String produktType, int produktAntal, double salgsPris, double indkoebsPris, double maalX, double maalY) throws SQLException {
        try {
            Produkt produkt = new Produkt(produktNavn);
            produkt.indsaetProduktIDatabase(produktID, produktType, produktAntal, salgsPris, indkoebsPris, maalX, maalY);
        } catch (SQLException ex) {
            throw new SQLException();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSletProduktFraDatabase(String produktNavn) {
        try {
            Produkt produkt = new Produkt(produktNavn);
            produkt.sletProduktFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connRedigerProduktIDatabase(String produktType, String produktNavn, int antal,
            double salgsPris, double indkoebsPris, double maalX, double maalY) {
        try {
            Produkt produkt = new Produkt(produktNavn);
            produkt.redigerProduktIDatabase(produktType, produktNavn, antal, salgsPris, indkoebsPris, maalX, maalY);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connHentListeAfProdukter(String produktType) {
        try {
            Produkt produkt = new Produkt();
            for (Produkt produktIListe : produkt.hentListeAfProdukter()) {
                if (produktType.equalsIgnoreCase(produktIListe.getProduktType())) {
                    //INDSÆT LOGIK HER EFTER VIEW.LAGER ER RYDDET OP
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSoegEfterProdukt(String produktSoegeString, ProduktGUI pdg) {
        try {
            Produkt produkt = new Produkt();
            for (Produkt produktIListe : produkt.soegEfterProdukt(produktSoegeString)) {
                pdg.foejTilListeAfProdukter(produktIListe.getProduktID(),
                        produktIListe.getProduktNavn(), produktIListe.getProduktType(),
                        produktIListe.getProduktAntal(), produktIListe.getMaalX(),
                        produktIListe.getMaalY(), produktIListe.getSalgsPris());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til Ordre
    public void connHentOrdreFraDatabase(int ordreID) {
        try {
            Ordre ordre = new Ordre(ordreID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connGemOrdreIDatabase(int ordreID, int status, Date bestillingsDato, Date leveringsDato,
            String skrifttype, int skriftstørrelse, int skriftStil, String inskriptionsLinje, String bemærkninger,
            double totalPris, double rabat, int tlfNr, int bedemandCvr) {
        try {
            Ordre ordre = new Ordre(ordreID);
            ordre.gemOrdreIDatabase(status, bestillingsDato, leveringsDato, skrifttype, skriftstørrelse, skriftStil, inskriptionsLinje, bemærkninger, totalPris, rabat, tlfNr, bedemandCvr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetProduktTilOrdre(int ordreID, Produkt produktAtIndsaette, int antal) {
        try {
            Ordre ordre = new Ordre(ordreID);
            ordre.indsaetProduktTilOrdre(produktAtIndsaette, antal);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connRedigerOrdreIDatabase(int ordreID, int status, Date bestillingsDato, Date leveringsDato,
            String skrifttype, int skriftstørrelse, int skriftStil, String inskriptionsLinje, String bemærkninger,
            double totalPris, double rabat) {
        try {
            Ordre ordre = new Ordre(ordreID);
            ordre.redigerOrdreIDatabase(status, bestillingsDato, leveringsDato, skrifttype, skriftstørrelse, skriftStil, inskriptionsLinje, bemærkninger, totalPris, rabat);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSletOrdreFraDatabase(int ordreID) {
        try {
            Ordre ordre = new Ordre(ordreID);
            ordre.sletOrdreFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSaetOrdreStatus(int ordreID, int status) {
        try {
            Ordre ordre = new Ordre(ordreID);
            ordre.sletOrdreFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til Kunde
    public void connHentMuligKundeFraDatabase(int tlfNr, KundeGUI kgui) {
        try {
            Kunde kunde = new Kunde(tlfNr);
            String kundeFNavn = kunde.getfNavn();
            String kundeENavn = kunde.geteNavn();
            String kundeBy = kunde.getBy();
            String kundeAdresse = kunde.getAdresse();
            String kundePostNr = kunde.getPostNr() + "";
            String kundeMobil = kunde.getMobil() + "";
            kgui.setFelter(kundeFNavn, kundeENavn, kundeAdresse, kundePostNr, kundeBy, kundeMobil);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetKundeIDatabase(int tlfNr, String fNavn, String eNavn, String adresse, int postNr, String by, int mobilNr) {
        try {
            Kunde kunde = new Kunde(tlfNr);
            kunde.indsaetKundeIDatabase(fNavn, eNavn, adresse, postNr, by, mobilNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connRedigerKundeIDatabase(int tlfNr, String fNavn, String eNavn, String adresse, int postNr, String by, int mobilNr) {
        try {
            Kunde kunde = new Kunde(tlfNr);
            kunde.redigerKundeIDatabase(fNavn, eNavn, adresse, postNr, by, mobilNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til KirkegaardsOrdre
    public void connHentKirkegaardsOrdre(int kirkegaardsID) {
        try {
            KirkegaardsOrdre ordre = new KirkegaardsOrdre(kirkegaardsID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetKirkegaardsOrdreTilDatabase(int kirkegaardsID, boolean urne_Kiste, int raekke, int nummer, String afdeling, int ordreID) {
        try {
            KirkegaardsOrdre ordre = new KirkegaardsOrdre(kirkegaardsID);
            ordre.indsaetKirkegaardsOrdreTilDatabase(urne_Kiste, raekke, nummer, afdeling, ordreID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connRedigerKirkegaardsOrdre(int kirkegaardsID, boolean urne_Kiste, int raekke, int nummer, String afdeling) {
        try {
            KirkegaardsOrdre ordre = new KirkegaardsOrdre(kirkegaardsID);
            ordre.redigerKirkegaardsOrdre(urne_Kiste, raekke, nummer, afdeling);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSletKirkegaardsOrdreFraDatabase(int kirkegaardsID) {
        try {
            KirkegaardsOrdre ordre = new KirkegaardsOrdre(kirkegaardsID);
            ordre.sletKirkegaardsOrdreFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til Tilfoejelse
    public void connHentTilfoejelsesInfo(int tilfoejelsesID) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetTilfoejelseIDatabase(int tilfoejelsesID, String tilfoejelsesType, double pris) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
            tilfoejelse.indsaetTilfoejelseIDatabase(tilfoejelsesType, pris);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connRedigerTilfoejelse(int tilfoejelsesID, String type, double pris) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
            tilfoejelse.redigerTilfoejelse(type, pris);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSletTilfoejelse(int tilfoejelsesID) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
            tilfoejelse.sletTilfoejelse();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til Provisionsseddel
    public void connHentProvisionsseddelFraDatabase(int provisionsID) {
        try {
            Provisionsseddel seddel = new Provisionsseddel(provisionsID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetProvisionsSeddelIDatabase(int provisionsID, Date provisionsDato, int provisionsProcent, String beskrivelse, int ordreID) {
        try {
            Provisionsseddel seddel = new Provisionsseddel(provisionsID);
            seddel.indsaetProvisionsSeddelIDatabase(provisionsDato, provisionsProcent, beskrivelse, ordreID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSletProvisionsSeddelFraDatabase(int provisionsID) {
        try {
            Provisionsseddel seddel = new Provisionsseddel(provisionsID);
            seddel.sletProvisionsSeddelFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til Kontoudtog
    public void connHentKontoUdtog(int kontoudtogsID) {
        try {
            Kontoudtog konto = new Kontoudtog(kontoudtogsID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetKontoUdtogIDatabase(int kontoudtogsID, Date kontoudtogsDato, String ordreLinjePris, String ordreLinjeProv, int ordreID) {
        try {
            Kontoudtog konto = new Kontoudtog(kontoudtogsID);
            konto.indsaetKontoUdtogIDatabase(kontoudtogsDato, ordreLinjePris, ordreLinjeProv, ordreID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSletKontoUdtogFraDatabase(int kontoudtogsID) {
        try {
            Kontoudtog konto = new Kontoudtog(kontoudtogsID);
            konto.sletKontoUdtogFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Begynder connect til Faktura
    public void connHentFaktura(int fakturaNr) {
        try {
            Faktura faktura = new Faktura(fakturaNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connIndsaetFakturaIDatabase(int fakturaNr, Date fakturaDato, String bankOplysninger, int ordreID) {
        try {
            Faktura faktura = new Faktura(fakturaNr);
            faktura.indsaetFakturaIDatabase(fakturaDato, bankOplysninger, ordreID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connSletFakturaFraDatabase(int fakturaNr) {
        try {
            Faktura faktura = new Faktura(fakturaNr);
            faktura.sletFakturaFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
