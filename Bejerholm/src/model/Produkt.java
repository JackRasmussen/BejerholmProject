package model;

import java.sql.ResultSet;

/**
 *
 * @author jack
 */
public class Produkt {

    private int produktID;
    private String produktType;
    private double salgsPris;
    private String dekoration;
    private String inskriptionsLinje;

    public Produkt() {
    }

    public ResultSet hentListeOverProdukter() {
        return null;
    }

    public void indsaetProduktIDatabase(int produktID, String produktType,
            double salgsPris, String dekoration, String inskriptionsLinje) {
    }

    public void sletProduktFraDatabase() {
    }

    public void redigerProduktIDatabase() {
    }
}
