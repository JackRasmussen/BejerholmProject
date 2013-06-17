/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
import model.pdfWriter.PDFWriter;
import view.BejerholmGUI;
import view.LagerGUI;
import view.OrdreRedigering;
import view.faktura.FakturaForm;
import view.faktura.OrdreForm;
import view.ordre.BedemandGUI;
import view.ordre.BestillingsOrdreGUI;
import view.ordre.KirkegaardGUI;
import view.ordre.KundeGUI;
import view.ordre.ProduktGUI;
import view.ordre.ProduktTilListe;
import view.ordre.TilfoejelseGUI;
import view.ordre.TilfojelseTilListe;

/**
 *
 * @author nicolai
 */
public class Controller {

    public Controller() {
    }

    public void connectDB(String user, String pass, String host, String port,
            String database, BejerholmGUI beg) throws SQLException {
        try {
            DBConnection.setConnectionParameters(user, pass, host, port,
                    database);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        if (DBConnection.isConnected()) {
            beg.skiftPanel("OrdreGUI");
            beg.getAdmin().setVisible(true);
            beg.getOrdre().setVisible(true);
            beg.getLager().setVisible(true);
            beg.getLogaf().setVisible(true);
            beg.getFaktura().setVisible(true);
        } else {
            throw new SQLException("Kunne ikke logge paa db", "Bad password or "
                    + "settings");
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
            beg.getFaktura().setVisible(false);
        }
    }

    public void hentBedemandViaNavn(String firmaNavn) {
        try {
            Bedemand bedemand = new Bedemand(firmaNavn);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
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
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

    }

    public void gemBedemandTilDatabase(int tlfNr, String firmaNavn,
            String adresse, String byNavn, int postNr) {
        try {
            Bedemand bedemand = new Bedemand(tlfNr);
            bedemand.tilfoejBedemandTilDatabase(tlfNr, firmaNavn, adresse,
                    byNavn, postNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void fjernBedemandFraDatabase(int TlfNr) {
        try {
            Bedemand bedemand = new Bedemand(TlfNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void redigerBedemand(int tlfNr, String firmaNavn, String adresse,
            String byNavn, int postNr) {
        try {
            Bedemand bedemand = new Bedemand(tlfNr);
            bedemand.redigerBedemandIDatabase(tlfNr, firmaNavn, adresse, byNavn,
                    postNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    // Begynder connect til Produkt
    public void connFindProduktViaNavn(String produktNavn) {
        try {
            Produkt produkt = new Produkt(produktNavn);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connTilfoejMaengdeTilProdukt(String produktNavn, int antal) {
        Produkt produkt;
        try {
            produkt = new Produkt(produktNavn);
            produkt.tilfoejMaengdeTilProdukt(antal);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connFjernMaengdeFraDatabase(String produktNavn, int antal) {
        try {
            Produkt produkt = new Produkt(produktNavn);
            produkt.fjernMaengdeFraDatabase(antal);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connIndsaetProduktIDatabase(String produktNavn, int produktID,
            String produktType, int produktAntal, double salgsPris,
            double indkoebsPris, double maalX, double maalY)
            throws SQLException {
        try {
            Produkt produkt = new Produkt(produktNavn);
            produkt.indsaetProduktIDatabase(produktID, produktType,
                    produktAntal, salgsPris, indkoebsPris, maalX, maalY);
        } catch (SQLException ex) {
            throw new SQLException();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSletProduktFraDatabase(int produktID) {
        try {
            Produkt produkt = new Produkt(produktID);
            produkt.sletProduktFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connRedigerProduktIDatabase(String produktType,
            String produktNavn, int antal,
            double salgsPris, double indkoebsPris, double maalX, double maalY) {
        try {
            Produkt produkt = new Produkt(produktNavn);
            produkt.redigerProduktIDatabase(produktType, produktNavn, antal,
                    salgsPris, indkoebsPris, maalX, maalY);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
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
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSoegEfterProdukt(String produktSoegeString, ProduktGUI pdg) {
        try {
            Produkt produkt = new Produkt();
            for (Produkt produktIListe
                    : produkt.soegEfterProdukt(produktSoegeString)) {
                pdg.foejTilListeAfProdukter(produktIListe.getProduktID(),
                        produktIListe.getProduktNavn(),
                        produktIListe.getProduktType(),
                        produktIListe.getProduktAntal(),
                        produktIListe.getMaalX(),
                        produktIListe.getMaalY(), produktIListe.getSalgsPris());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

        public void connSoegEfterProdukt(String produktSoegeString, LagerGUI lag) {
        try {
            Produkt produkt = new Produkt();
            for (Produkt produktIListe :
                    produkt.soegEfterProdukt(produktSoegeString)) {
                lag.foejTilListeAfProdukter(produktIListe.getProduktID(),
                        produktIListe.getProduktNavn(),
                        produktIListe.getProduktType(),
                        produktIListe.getProduktAntal(),
                        produktIListe.getMaalX(),
                        produktIListe.getMaalY(), produktIListe.getSalgsPris());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }
    // Begynder connect til Ordre
    public void connHentOrdreFraDatabase(OrdreRedigering org, int ordreID) {
        try {
            Ordre ordre = new Ordre(ordreID);
            org.setFelter(ordre.getTlfNr(), ordre.getStatus());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connGemOrdreIDatabase(Date bestillingsDatoUdenSQL,
            Date leveringsDatoUdenSQL,
            String skrifttype, int skriftStoerrelse, int skriftStil,
            String inskriptionsLinje, String bemaerkninger,
            double totalPris, double rabat, int tlfNr,
            ArrayList<ProduktTilListe> listeAfProdukterIOrdre,
            ArrayList<TilfojelseTilListe> listeAfTilfoejelserTilOrdre,
            BestillingsOrdreGUI beg, File destinationFile) {
        int status = 0;
        try {
            java.sql.Date bestillingsDato =
                    new java.sql.Date(bestillingsDatoUdenSQL.getTime());
            java.sql.Date leveringsDato =
                    new java.sql.Date(leveringsDatoUdenSQL.getTime());
            Ordre ordre =
                    new Ordre(status, bestillingsDato, leveringsDato,
                    skrifttype, skriftStoerrelse, skriftStil, inskriptionsLinje,
                    bemaerkninger, totalPris, rabat, tlfNr);
            ordre.gemOrdreIDatabase();
            for (ProduktTilListe produktTilListe : listeAfProdukterIOrdre) {
                connIndsaetProduktTilOrdre(ordre.getOrdreID(),
                        produktTilListe.getProduktID(), 1);
            }
            for (TilfojelseTilListe tilfojelseTilListe
                    : listeAfTilfoejelserTilOrdre) {
                connIndsaetTilfoejelseTilOrdre(ordre.getOrdreID(),
                        tilfojelseTilListe.getTilfoejelsesID(), 1);
            }
            connLavPDFAfOrdre(bestillingsDatoUdenSQL, leveringsDatoUdenSQL,
                    skrifttype, skriftStoerrelse, skriftStil, inskriptionsLinje,
                    bemaerkninger, totalPris, rabat, tlfNr, listeAfProdukterIOrdre,
                    listeAfTilfoejelserTilOrdre, beg, ordre, destinationFile);
            beg.fortaelBrugerAtOrdreOprettet(ordre.getOrdreID());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    private void connLavPDFAfOrdre(Date bestillingsDatoUdenSQL,
            Date leveringsDatoUdenSQL,
            String skrifttype, int skriftStoerrelse, int skriftStil,
            String inskriptionsLinje, String bemaerkninger,
            double totalPris, double rabat, int tlfNr,
            ArrayList<ProduktTilListe> listeAfProdukterIOrdre,
            ArrayList<TilfojelseTilListe> listeAfTilfoejelserTilOrdre,
            BestillingsOrdreGUI beg, Ordre ordre, File destinationFile) {
        try {
            Kunde kunde = new Kunde(tlfNr);

            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String leveringsDato = sdf.format(leveringsDatoUdenSQL);
            String bestillingsDato = sdf.format(bestillingsDatoUdenSQL);
            int[] arrayAfAntal = new int[6];
            String[] arrayAfNavne = new String[6];
            String[] arrayAfPriser = new String[6];
            for (int i = 5; i >= 0; i--) {
                try {
                    listeAfProdukterIOrdre.get(i);
                    arrayAfAntal[i] = 1;
                } catch (IndexOutOfBoundsException ex) {
                    arrayAfAntal[i] = 0;
                }
            }
            for (int i = 5; i >= 0; i--) {
                try {
                    listeAfProdukterIOrdre.get(i);
                    arrayAfNavne[i] = listeAfProdukterIOrdre.get(i).getProduktNavn();
                } catch (IndexOutOfBoundsException ex) {
                    arrayAfNavne[i] = "";
                }
            }
            for (int i = 5; i >= 0; i--) {
                try {
                    listeAfProdukterIOrdre.get(i);
                    arrayAfPriser[i] = listeAfProdukterIOrdre.get(i).getSalgsPris() + "";
                } catch (IndexOutOfBoundsException ex) {
                    arrayAfPriser[i] = "";
                }
            }
            OrdreForm ordreForm = new OrdreForm();
            ordreForm.setVariables(kunde.getfNavn() + " " + kunde.geteNavn(),
                    kunde.getAdresse(), kunde.getPostNr() + " " + kunde.getBy(),
                    bestillingsDato, tlfNr + "", ordre.getOrdreID(), 0, "", "",
                    null, leveringsDato, "", "", "", inskriptionsLinje, 0,
                    skrifttype, arrayAfAntal[0], arrayAfAntal[1], arrayAfAntal[2],
                    arrayAfAntal[3], arrayAfAntal[4], arrayAfAntal[5], beg.getAntalBogstaver(),
                    arrayAfNavne[0], arrayAfNavne[1], arrayAfNavne[2], arrayAfNavne[3],
                    arrayAfNavne[4], arrayAfNavne[5], "Indhugget bogstaver a' 65 kr.", arrayAfPriser[0], arrayAfPriser[1], arrayAfPriser[2],
                    arrayAfPriser[3], arrayAfPriser[4], arrayAfPriser[5], beg.getBogstavsPris() + "", totalPris * 0.025 + "", bemaerkninger,
                    totalPris + "", (totalPris * 0.25) + "",
                    totalPris * 1.275 + "");
            JFrame frame = new JFrame();
            frame.setSize(595, 842);
            frame.add(ordreForm);
            frame.setVisible(true);
            PDFWriter pdfw = new PDFWriter(ordreForm, destinationFile);
            pdfw.writePDF();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connIndsaetProduktTilOrdre(int ordreID, int produktID,
            int antal) {
        try {
            Ordre ordre = new Ordre(ordreID);
            Produkt produktAtIndsaette = new Produkt(produktID);
            ordre.indsaetProduktTilOrdre(produktAtIndsaette, antal);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    private void connIndsaetTilfoejelseTilOrdre(int ordreID, int tilfoejelsesID,
            int antal) {
        try {
            Ordre ordre = new Ordre(ordreID);
            Tilfoejelse tilfoejelseAtIndsaette =
                    new Tilfoejelse(tilfoejelsesID);
            ordre.indsaetTilfoejelseTilOrdre(tilfoejelseAtIndsaette, antal);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connRedigerOrdreIDatabase(int ordreID, int status,
            Date bestillingsDatoUdenSQL, Date leveringsDatoUdenSQL,
            String skrifttype, int skriftstørrelse, int skriftStil,
            String inskriptionsLinje, String bemærkninger,
            double totalPris, double rabat) {
        try {
            Ordre ordre = new Ordre(ordreID);
            java.sql.Date bestillingsDato =
                    new java.sql.Date(bestillingsDatoUdenSQL.getTime());
            java.sql.Date leveringsDato =
                    new java.sql.Date(leveringsDatoUdenSQL.getTime());
            ordre.redigerOrdreIDatabase(status, bestillingsDato,
                    leveringsDato, skrifttype, skriftstørrelse,
                    skriftStil, inskriptionsLinje, bemærkninger, totalPris,
                    rabat);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSletOrdreFraDatabase(int ordreID) {
        try {
            Ordre ordre = new Ordre(ordreID);
            ordre.sletOrdreFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSaetOrdreStatus(int ordreID, int status) {
        try {
            Ordre ordre = new Ordre(ordreID);
            ordre.saetOrdreStatus(status);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
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
            kgui.setFelter(kundeFNavn, kundeENavn, kundeAdresse, kundePostNr,
                    kundeBy, kundeMobil);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connIndsaetKundeIDatabase(int tlfNr, String fNavn, String eNavn,
            String adresse, int postNr, String by, int mobilNr) {
        try {
            Kunde kunde = new Kunde(tlfNr);
            kunde.indsaetKundeIDatabase(fNavn, eNavn, adresse, postNr, by,
                    mobilNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connRedigerKundeIDatabase(int tlfNr, String fNavn, String eNavn,
            String adresse, int postNr, String by, int mobilNr) {
        try {
            Kunde kunde = new Kunde(tlfNr);
            kunde.redigerKundeIDatabase(fNavn, eNavn, adresse, postNr, by,
                    mobilNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    // Begynder connect til KirkegaardsOrdre
    public void connHentKirkegaardsOrdre(int kirkegaardsID) {
        try {
            KirkegaardsOrdre ordre = new KirkegaardsOrdre(kirkegaardsID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connIndsaetKirkegaardsOrdreTilDatabase(boolean urne_Kiste,
            int raekke, int nummer, String afdeling, int bedemandTlf,
            Date bestillingsDatoUdenSQL, Date leveringsDatoUdenSQL,
            String skrifttype, int skriftStoerrelse, int skriftStil,
            String inskriptionsLinje, String bemaerkninger, double totalPris,
            double rabat, int tlfNr,
            ArrayList<ProduktTilListe> listeAfProdukterIOrdre,
            ArrayList<TilfojelseTilListe> listeAfTilfoejelserTilOrdre,
            KirkegaardGUI kirkegaardGUI) {

        int status = 0;
        try {
            java.sql.Date bestillingsDato =
                    new java.sql.Date(bestillingsDatoUdenSQL.getTime());
            java.sql.Date leveringsDato =
                    new java.sql.Date(leveringsDatoUdenSQL.getTime());
            Ordre ordre = new Ordre(status, bestillingsDato, leveringsDato,
                    skrifttype, skriftStoerrelse, skriftStil, inskriptionsLinje,
                    bemaerkninger, totalPris, rabat, tlfNr);
            ordre.gemOrdreIDatabase();
            for (ProduktTilListe produktTilListe : listeAfProdukterIOrdre) {
                connIndsaetProduktTilOrdre(ordre.getOrdreID(),
                        produktTilListe.getProduktID(), 1);
            }
            for (TilfojelseTilListe tilfojelseTilListe
                    : listeAfTilfoejelserTilOrdre) {
                connIndsaetTilfoejelseTilOrdre(ordre.getOrdreID(),
                        tilfojelseTilListe.getTilfoejelsesID(), 1);
            }
            KirkegaardsOrdre kOrdre = new KirkegaardsOrdre();
            kOrdre.indsaetKirkegaardsOrdreTilDatabase(urne_Kiste, raekke,
                    nummer, afdeling, ordre.getOrdreID(), bedemandTlf);
            kirkegaardGUI.fortaelBrugerAtOrdreOprettet(ordre.getOrdreID());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connRedigerKirkegaardsOrdre(int kirkegaardsID,
            boolean urne_Kiste, int raekke, int nummer, String afdeling) {
        try {
            KirkegaardsOrdre ordre = new KirkegaardsOrdre(kirkegaardsID);
            ordre.redigerKirkegaardsOrdre(urne_Kiste, raekke, nummer, afdeling);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSletKirkegaardsOrdreFraDatabase(int kirkegaardsID) {
        try {
            KirkegaardsOrdre ordre = new KirkegaardsOrdre(kirkegaardsID);
            ordre.sletKirkegaardsOrdreFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    // Begynder connect til Tilfoejelse
    public void connHentTilfoejelsesInfo(int tilfoejelsesID) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connIndsaetTilfoejelseIDatabase(int tilfoejelsesID,
            String tilfoejelsesType, double pris) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
            tilfoejelse.indsaetTilfoejelseIDatabase(tilfoejelsesType, pris);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connRedigerTilfoejelse(int tilfoejelsesID, String type,
            double pris) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
            tilfoejelse.redigerTilfoejelse(type, pris);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSletTilfoejelse(int tilfoejelsesID) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse(tilfoejelsesID);
            tilfoejelse.sletTilfoejelse();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSoegEfterTilfoejelse(String soegeString,
            TilfoejelseGUI tfg) {
        try {
            Tilfoejelse tilfoejelse = new Tilfoejelse();
            for (Tilfoejelse tilfoejelseIListe
                    : tilfoejelse.soegEfterTilfoejelse(soegeString)) {
                tfg.foejTilListeAfTilfoejelser(tilfoejelseIListe.getTilfoejelsesID(),
                        tilfoejelseIListe.getTilfoejelsesType(),
                        tilfoejelseIListe.getTilfoejelsesPris());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    // Begynder connect til Provisionsseddel
    public void connHentProvisionsseddelFraDatabase(int provisionsID) {
        try {
            Provisionsseddel seddel = new Provisionsseddel(provisionsID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connIndsaetProvisionsSeddelIDatabase(int provisionsID,
            Date provisionsDatoUdenSQL, int provisionsProcent,
            String beskrivelse, int ordreID) {
        try {
            Provisionsseddel seddel = new Provisionsseddel(provisionsID);
            java.sql.Date provisionsDato =
                    new java.sql.Date(provisionsDatoUdenSQL.getTime());
            seddel.indsaetProvisionsSeddelIDatabase(provisionsDato,
                    provisionsProcent, beskrivelse, ordreID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSletProvisionsSeddelFraDatabase(int provisionsID) {
        try {
            Provisionsseddel seddel = new Provisionsseddel(provisionsID);
            seddel.sletProvisionsSeddelFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    // Begynder connect til Kontoudtog
    public void connHentKontoUdtog(int kontoudtogsID) {
        try {
            Kontoudtog konto = new Kontoudtog(kontoudtogsID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connIndsaetKontoUdtogIDatabase(int kontoudtogsID,
            Date kontoudtogsDatoUdenSQL, String ordreLinjePris,
            String ordreLinjeProv, int ordreID) {
        try {
            Kontoudtog konto = new Kontoudtog(kontoudtogsID);
            java.sql.Date kontoudtogsDato =
                    new java.sql.Date(kontoudtogsDatoUdenSQL.getTime());
            konto.indsaetKontoUdtogIDatabase(kontoudtogsDato, ordreLinjePris,
                    ordreLinjeProv, ordreID);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSletKontoUdtogFraDatabase(int kontoudtogsID) {
        try {
            Kontoudtog konto = new Kontoudtog(kontoudtogsID);
            konto.sletKontoUdtogFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    // Begynder connect til Faktura
    public void connHentFaktura(int fakturaNr) {
        try {
            Faktura faktura = new Faktura(fakturaNr);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connIndsaetFakturaIDatabase(OrdreRedigering org,
            Date fakturaDatoUdenSQL, String bankOplysninger, int ordreID,
            String vedroerende) {
        try {
            java.sql.Date fakturaDato =
                    new java.sql.Date(fakturaDatoUdenSQL.getTime());
            Faktura faktura =
                    new Faktura(fakturaDato, bankOplysninger, ordreID,
                    vedroerende);
            faktura.indsaetFakturaIDatabase();
            org.fortaelBrugerFakturaNr(faktura.getFakturaNr());
            faktura.indsaetKundeFakturaData(org.getKundeTlfNr(), true);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    public void connSletFakturaFraDatabase(int fakturaNr) {
        try {
            Faktura faktura = new Faktura(fakturaNr);
            faktura.sletFakturaFraDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }
}
