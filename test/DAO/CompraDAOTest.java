/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Compra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alore
 */
public class CompraDAOTest {
    
    public CompraDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GenerarCompra method, of class CompraDAO.
     */
    @Test
    public void testGenerarCompra() {
        System.out.println("GenerarCompra");
        Compra compra = null;
        CompraDAO instance = new CompraDAO();
        int expResult = 0;
        int result = instance.GenerarCompra(compra);
        assertEquals(expResult, result);
        
    }
    
}
