package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import model.database.Handler;
import model.pdfWriter.PDFWriter;

/**
 * @author Dan-Philip Christensen
 */
public class Faktura {

    private int fakturaNr;
    private Date fakturaDato;
    private String vedroerende;
    private String bankOplysninger;
    private int ordreID;
    private Handler handler;

    public Faktura(int fakturaNr) throws SQLException, ClassNotFoundException, 
            Exception {
        this.fakturaNr = fakturaNr;
        handler = new Handler();
        hentFaktura();
    }

    public Faktura(Date fakturaDato, String bankOplysninger, int ordreID, 
            String vedroerende) throws SQLException, ClassNotFoundException, 
            Exception {
        this.fakturaDato = fakturaDato;
        this.bankOplysninger = bankOplysninger;
        this.ordreID = ordreID;
        this.vedroerende = vedroerende;
        this.handler = new Handler();
    }

    /**
     * Denne metode bliver kaldt fra constructoren, og forsøger at lede efter en
     * ordre med dette objekts egenskaber
     *
     * @throws SQLException
     */
    private void hentFaktura() throws SQLException {
        ResultSet rs = handler.hentFakturaFraDatabase(fakturaNr);
        if (rs.next()) {
            this.fakturaDato = rs.getDate("fakturaDato");
            this.bankOplysninger = rs.getString("bankOplysninger");
            this.ordreID = rs.getInt("ordreID");
            this.vedroerende = rs.getString("vedroerende");
        } else {
            this.fakturaDato = null;
            this.bankOplysninger = "Faktura findes ikke";
            this.ordreID = 0;
            this.vedroerende = "Faktura findes ikke";
        }
        rs.close();
    }

    /**
     * Denne metode indsætter data i databasen ud fra metodens input, samt
     * sætter dette objekts egenskaber.
     *
     * @param fakturaDato
     * @param bankOplysninger
     * @param ordreID
     * @throws SQLException
     */
    public void indsaetFakturaIDatabase() throws SQLException {
        this.fakturaNr = handler.indsaetFakturaIDatabase(fakturaDato, 
                vedroerende, bankOplysninger, ordreID);
    }
    
    public void indsaetKundeFakturaData(int kundeTlfNr, boolean faerdigFaktura) 
            throws SQLException{
        handler.indsaetKundeFakturaData(kundeTlfNr, fakturaNr, faerdigFaktura);
    }
    
    public void lavFakturaPdf(JPanel panelAtPrinte, File destination) 
            throws FileNotFoundException{
        PDFWriter pdfw = new PDFWriter(panelAtPrinte, destination);
    }
    
    /**
     * Denne metode sletter en record fra databasen ud fra det nuværende objekt
     * af denne klasse.
     *
     * @throws SQLException
     */
    public void sletFakturaFraDatabase() throws SQLException {
        handler.sletFakturaFraDatabase(fakturaNr);
    }

    public int getFakturaNr() {
        return fakturaNr;
    }

    public Date getFakturaDato() {
        return fakturaDato;
    }

    public String getVedroerende() {
        return vedroerende;
    }

    public String getBankOplysninger() {
        return bankOplysninger;
    }

    public int getOrdreID() {
        return ordreID;
    }
}