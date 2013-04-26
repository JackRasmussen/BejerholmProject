/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author jack
 */
public class Ordre {
    
    private int ordreID;
    private int status;
    private Date bestillingsDato;
    private Date leveringsDato;
    private String skrifttype;
    private int skriftstørrelse;
    private int skriftStil;
    private String bemærkninger;
    private double totalPris;
    private final double MILJØ_AFGIFT = 2.5;
    private double moms;
    private double rabat;

    public Ordre(int ordreID, int status, Date bestillingsDato, Date leveringsDato, String skrifttype, int skriftstørrelse, int skriftStil, String bemærkninger, double totalPris, double moms, double rabat) {
        this.ordreID = ordreID;
        this.status = status;
        this.bestillingsDato = bestillingsDato;
        this.leveringsDato = leveringsDato;
        this.skrifttype = skrifttype;
        this.skriftstørrelse = skriftstørrelse;
        this.skriftStil = skriftStil;
        this.bemærkninger = bemærkninger;
        this.totalPris = totalPris;
        this.moms = moms;
        this.rabat = rabat;
    }
    
    public void gemOrdreIDatabase(){
        
    }
    
    public void hentOrdreFraDatabase(){
        
    }
    
    public void redigerOrdreIDatabase(){
        
    }
    
    public void sletOrdreFraDatabase(int ordreID){
        
    }
}
