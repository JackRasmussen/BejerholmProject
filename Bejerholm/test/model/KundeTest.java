/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
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
public class KundeTest {

    public KundeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        Kunde before = new Kunde(21212121);
        before.sletKundeFraDatabase();
        before = new Kunde(22222222);
        before.sletKundeFraDatabase();
        before = new Kunde(23232323);
        before.sletKundeFraDatabase();
        before.indsaetKundeIDatabase("Mand", "Mandmand", "Candyvej 11", 1313, "Byby");
        before = new Kunde(24242424);
        before.sletKundeFraDatabase();
        before.indsaetKundeIDatabase("Skal", "Slettes", "Så det kan", 0000, "Være ligemeget");
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        Kunde after = new Kunde(21212121);
        after.sletKundeFraDatabase();
        after = new Kunde(22222222);
        after.sletKundeFraDatabase();
        after = new Kunde(23232323);
        after.sletKundeFraDatabase();
        after = new Kunde(24242424);
        after.sletKundeFraDatabase();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of hentMuligeKunderFraDatabase method, of class Kunde.
     */
    @Test
    public void testHentMuligeKunderFraDatabase() throws Exception {
        System.out.println("hentMuligeKunderFraDatabase");
        Kunde instance = new Kunde(20202020);
        instance.hentMuligeKunderFraDatabase();
        String expResult = "Hans";
        String result = instance.getfNavn();

        assertEquals(expResult, result);
    }

    /**
     * Test of hentMuligeKunderFraDatabase method, of class Kunde.
     */
    @Test
    public void testHentMuligeKunderFraDatabaseFejlet() throws Exception {
        System.out.println("hentMuligeKunderFraDatabaseFejlet");
        Kunde instance = new Kunde(21212121);
        instance.hentMuligeKunderFraDatabase();
        String expResult = "Kunde findes ikke";
        String result = instance.getfNavn();

        assertEquals(expResult, result);
    }

    /**
     * Test of indsaetKundeIDatabase method, of class Kunde.
     */
    @Test
    public void testIndsaetKundeIDatabase() throws Exception {
        System.out.println("indsaetKundeIDatabase");
        String fNavn = "Lotte";
        String eNavn = "Larsen";
        String adresse = "Kendevej 15";
        int postNr = 2323;
        String by = "Lotteved";
        Kunde instance = new Kunde(22222222);
        instance.indsaetKundeIDatabase(fNavn, eNavn, adresse, postNr, by);
        String expResult = "Kendevej 15";
        String result = instance.getAdresse();
        assertEquals(expResult, result);
    }

    /**
     * Test of redigerKundeIDatabase method, of class Kunde.
     */
    @Test
    public void testRedigerKundeIDatabase() throws Exception {
        System.out.println("redigerKundeIDatabase");
        String fNavn = "Mand";
        String eNavn = "Mandmand";
        String adresse = "Candyvej 12";
        int postNr = 1313;
        String by = "Byby";
        Kunde instance = new Kunde(23232323);
        instance.redigerKundeIDatabase(fNavn, eNavn, adresse, postNr, by);
        instance.hentMuligeKunderFraDatabase();
        String expResult = "Candyvej 12";
        String result = instance.getAdresse();
        assertEquals(expResult, result);
    }

    /**
     * Test of sletKundeFraDatabase method, of class Kunde.
     */
    @Test
    public void testSletKundeFraDatabase() throws Exception {
        System.out.println("sletKundeFraDatabase");
        Kunde instance = new Kunde(24242424);
        instance.sletKundeFraDatabase();
        String expResult = "Kunde findes ikke";
        instance.hentMuligeKunderFraDatabase();
        String result = instance.geteNavn();
        assertEquals(expResult, result);
    }
}
