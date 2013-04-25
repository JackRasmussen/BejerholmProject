/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class BedemandTest {
    
    public BedemandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        Bedemand before = new Bedemand();
        before.tilfoejBedemand(2, "To", 22222222);
        before.tilfoejBedemand(3, "Tre", 33333333);
        before.tilfoejBedemand(4, "Fire", 44444444);
        before.tilfoejBedemand(5, "Fem", 55555555);
        before.tilfoejBedemand(6, "Seks", 66666666);
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        Bedemand after = new Bedemand();
        after.findBedemandViaTlf(11111111);
        after.sletBedemand();
        after.findBedemandViaTlf(22222222);
        after.sletBedemand();
        after.findBedemandViaTlf(33333333);
        after.sletBedemand();
        after.findBedemandViaTlf(44444444);
        after.sletBedemand();
        after.findBedemandViaTlf(55555555);
        after.sletBedemand();
        after.findBedemandViaTlf(66666666);
        after.sletBedemand();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of tilfoejBedemand method, of class Bedemand.
     */
    @Test
    public void testTilfoejBedemand() throws Exception {
        System.out.println("tilfoejBedemand");
        int cvr = 1;
        String firmaNavn = "En";
        int tlfNr = 11111111;
        Bedemand instance = new Bedemand();
        instance.tilfoejBedemand(cvr, firmaNavn, tlfNr);
        instance.findBedemandViaTlf(11111111);
        String expResult = "En";
        String result = instance.getFirmaNavn();
        instance.sletBedemand();
        assertEquals(expResult, result);
    }

    /**
     * Test of findBedemandViaTlf method, of class Bedemand.
     */
    @Test
    public void testFindBedemandViaTlf() throws Exception {
        System.out.println("findBedemandViaTlf");
        int tlfNr = 22222222;
        Bedemand instance = new Bedemand();
        instance.findBedemandViaTlf(tlfNr);
        String expResult = "To";
        String result = instance.getFirmaNavn();
        assertEquals(expResult, result);
    }

    /**
     * Test of findBedemandViaNavn method, of class Bedemand.
     */
    @Test
    public void testFindBedemandViaNavn() throws Exception {
        System.out.println("findBedemandViaNavn");
        String firmaNavn = "Tre";
        Bedemand instance = new Bedemand();
        instance.findBedemandViaNavn(firmaNavn);
        int expResult = 33333333;
        int result = instance.getTlfNr();
        assertEquals(expResult, result);
    }

    /**
     * Test of sletBedemand method, of class Bedemand.
     */
    @Test
    public void testSletBedemand() throws Exception {
        System.out.println("sletBedemand");
        Bedemand instance = new Bedemand();
        instance.findBedemandViaNavn("Fire");
        instance.sletBedemand();
        instance.findBedemandViaTlf(44444444);
        String expResult = "Bedemand findes ikke";
        String result = instance.getFirmaNavn();
        instance.tilfoejBedemand(4, "Fire", 44444444);
        assertEquals(expResult, result);
    }

    /**
     * Test of hentListeOverBedemaend method, of class Bedemand.
     */
    @Test
    public void testHentListeOverBedemaend() throws Exception {
        System.out.println("hentListeOverBedemaend");
        Bedemand instance = new Bedemand();
        int expResult = 5;
        int result = instance.hentListeOverBedemaend().size();
        assertEquals(expResult, result);
    }
}
