package model;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan-Philip-N
 */
public class TilfoejelseTest {
    
    public TilfoejelseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        Tilfoejelse before = new Tilfoejelse();
        before.indsaetNyTilfoejelse(1, "En", 10);
        before.indsaetNyTilfoejelse(2, "To", 20);
        before.indsaetNyTilfoejelse(3, "Tre", 30);
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        Tilfoejelse after = new Tilfoejelse();
        after.sletTilfoejelse(1);
        after.sletTilfoejelse(2);
        after.sletTilfoejelse(3);
    }

    /**
     * Test of hentListeOverTilfoejelser method, of class Tilfoejelse.
     */
    @Test
    public void testHentListeOverTilfoejelser() throws Exception {
        System.out.println("hentListeOverTilfoejelser");
        Tilfoejelse instance = new Tilfoejelse();
        int expResult = 3;
        int result = instance.hentListeOverTilfoejelser().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of hentTilfoejelsesType method, of class Tilfoejelse.
     */
    @Test
    public void testHentTilfoejelsesType() throws Exception {
        System.out.println("hentTilfoejelsesType");
        int tilfoejelsesID = 1;
        Tilfoejelse instance = new Tilfoejelse();
        String expResult = "En";
        String result = instance.hentTilfoejelsesType(tilfoejelsesID);
        assertEquals(expResult, result);
    }

    /**
     * Test of hentTilfoejelsesPris method, of class Tilfoejelse.
     */
    @Test
    public void testHentTilfoejelsesPris() throws Exception {
        System.out.println("hentTilfoejelsesPris");
        int tilfoejelsesID = 1;
        Tilfoejelse instance = new Tilfoejelse();
        int expResult = 10;
        int result = instance.hentTilfoejelsesPris(tilfoejelsesID);
        assertEquals(expResult, result);
    }

    /**
     * Test of indsaetNyTilføjelse method, of class Tilfoejelse.
     */
    @Test
    public void testIndsaetNyTilfoejelse() throws Exception {
        System.out.println("indsaetNyTilf\u00f8jelse");
        int tilfoejelsesID = 4;
        String type = "Fire";
        double pris = 40;
        Tilfoejelse instance = new Tilfoejelse();
        instance.indsaetNyTilfoejelse(tilfoejelsesID, type, pris);
        String expResult = "Fire";
        String result = instance.hentTilfoejelsesType(tilfoejelsesID);
        instance.sletTilfoejelse(tilfoejelsesID);
        assertEquals(expResult, result);
    }

    /**
     * Test of redigerTilfoejelse method, of class Tilfoejelse.
     */
    @Test
    public void testRedigerTilfoejelse() throws Exception {
        System.out.println("redigerTilfoejelse");
        int tilfoejelsesID = 2;
        String type = "Too";
        double pris = 20;
        Tilfoejelse instance = new Tilfoejelse();
        instance.redigerTilfoejelse(tilfoejelsesID, type, pris);
        String expResult = "Too";
        String result = instance.hentTilfoejelsesType(tilfoejelsesID);
        instance.redigerTilfoejelse(2, "To", 20);
        assertEquals(expResult, result);
    }
}
