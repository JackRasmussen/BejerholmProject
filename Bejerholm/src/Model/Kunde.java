package Model;

/**
 *
 * @author Dan-Philip Christensen
 */
public class Kunde {

    private int kundeID;
    private String fNavn;
    private String eNavn;
    private String adresse;
    private int postNr;
    private String by;
    private int tlfNr;
    private int mobil;

    //denne constructor skal checke om der er nogle kunder med det navn og
    //tlf nr, og returnere liste med infoer på matches
    public Kunde(String fNavn, String eNavn, int tlfNr){
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.tlfNr = tlfNr;
        hentMuligeKunderFraDatabase();
    }
    
    private void hentMuligeKunderFraDatabase(){
        
    }

    public void indsaetKundeIDatabase() {
        
    }
    
    public void sletKundeFraDatabase(){
        
    }
    
    public void redigerKundeIDatabase(){
        
    }
    
}
