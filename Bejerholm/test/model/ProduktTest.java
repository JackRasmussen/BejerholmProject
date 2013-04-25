/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan-Philip Christensen
 */
public class ProduktTest {
    
    public ProduktTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        Produkt before = new Produkt();
        before.indsaetProduktIDatabase(1, "Fuglebad", "En", 10, 10, 5);
        before.indsaetProduktIDatabase(2, "Fuglebad", "To", 10, 12, 5);
        before.indsaetProduktIDatabase(3, "Fuglebad", "Tre", 15, 10, 3);
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        Produkt after = new Produkt();
        after.sletProduktFraDatabase(1);
        after.sletProduktFraDatabase(2);
        after.sletProduktFraDatabase(3);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hentListeOverProdukter method, of class Produkt.
     */
    @Test
    public void testHentListeOverProdukter() throws Exception {
        System.out.println("hentListeOverProdukter");
        Produkt instance = new Produkt();
        int expResult = 3;
        int result = instance.hentListeOverProdukter().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of findProduktIDer method, of class Produkt.
     */
    @Test
    public void testFindProduktIDer() throws Exception {
        System.out.println("findProduktIDer");
        String produktNavn = "";
        Produkt instance = new Produkt();
        int expResult = 2;
        int result = instance.findProduktIDer("T").size();
        assertEquals(expResult, result);
    }

    /**
     * Test of tilfoejMaengdeTilProdukt method, of class Produkt.
     */
    @Test
    public void testTilfoejMaengdeTilProdukt() throws Exception {
        System.out.println("tilfoejMaengdeTilProdukt");
        int produktID = 1;
        int antal = 5;
        Produkt instance = new Produkt();
        instance.tilfoejMaengdeTilProdukt(produktID, antal);
        int expResult = 15;
        int result = instance.hentProduktMaengde(produktID);
        instance.fjernMaengdeFraDatabase(produktID, antal);
        assertEquals(expResult, result);
    }

    /**
     * Test of fjernMaengdeFraDatabase method, of class Produkt.
     */
    @Test
    public void testFjernMaengdeFraDatabase() throws Exception {
        System.out.println("fjernMaengdeFraDatabase");
        int produktID = 1;
        int antal = 5;
        Produkt instance = new Produkt();
        instance.fjernMaengdeFraDatabase(produktID, antal);
        int expResult = 5;
        int result = instance.hentProduktMaengde(produktID);
        instance.tilfoejMaengdeTilProdukt(produktID, antal);
        assertEquals(expResult, result);
    }

    /**
     * Test of indsaetProduktIDatabase method, of class Produkt.
     */
    @Test
    public void testIndsaetProduktIDatabase() throws Exception {
        System.out.println("indsaetProduktIDatabase");
        int produktID = 4;
        String produktType = "Fuglebad";
        String produktNavn = "Fire";
        int antal = 40;
        double salgsPris = 444;
        double indkoebsPris = 44;
        Produkt instance = new Produkt();
        instance.indsaetProduktIDatabase(produktID, produktType, produktNavn, antal, salgsPris, indkoebsPris);
        int expResult = 40;
        int result = instance.hentProduktMaengde(4);
        instance.sletProduktFraDatabase(4);
        assertEquals(expResult, result);
    }

    /**
     * Test of sletProduktFraDatabase method, of class Produkt.
     */
    @Test
    public void testSletProduktFraDatabase() throws Exception {
        System.out.println("sletProduktFraDatabase");
        int produktID = 3;
        Produkt instance = new Produkt();
        instance.sletProduktFraDatabase(produktID);
        int expResult = 2;
        int result = instance.hentListeOverProdukter().size();
        instance.indsaetProduktIDatabase(3, "Fuglebad", "Tre", 15, 10, 3);
        assertEquals(expResult, result);
    }

    /**
     * Test of redigerProduktIDatabase method, of class Produkt.
     */
    @Test
    public void testRedigerProduktIDatabase() throws Exception {
        System.out.println("redigerProduktIDatabase");
        int produktID = 1;
        String produktType = "Sten";
        String produktNavn = "En";
        int antal = 85;
        double salgsPris = 1;
        double indkoebsPris = 2;
        Produkt instance = new Produkt();
        instance.redigerProduktIDatabase(produktID, produktType, produktNavn, antal, salgsPris, indkoebsPris);
        int expResult = 85;
        int result = instance.hentProduktMaengde(produktID);
        instance.redigerProduktIDatabase(1, "Fuglebad", "En", 10, 10, 5);
        assertEquals(expResult, result);
    }
}
