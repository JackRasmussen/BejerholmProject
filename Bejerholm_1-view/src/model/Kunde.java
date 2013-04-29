package model;

/**
 *
 * @author Dan-Philip Christensen
 */
public class Kunde {

    private String fNavn;
    private String eNavn;
    private String adresse;
    private int postNr;
    private String by;
    private int tlfNr;
    private int mobil;

    //denne constructor skal checke om der er nogle kunder med det
    //tlf nr, og returnere infoer på matches
    public Kunde(int tlfNr){
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
