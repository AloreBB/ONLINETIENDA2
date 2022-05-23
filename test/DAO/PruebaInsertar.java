/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.RegistroBeans;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Alore
 */
public class PruebaInsertar {
    public PruebaInsertar() {
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
     * Test of validar method, of class RegistroDAO.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        String usr = "Kevin";
        String pass = "789";
        RegistroDAO instance = new RegistroDAO();
        RegistroBeans expResult = new RegistroBeans("Kevin", "3135053799", "kevincastrillon4206@gmail.com", "789", 1);
        
        expResult.setId(11);
        expResult.setNombres("Kevin");
        expResult.setContacto("3135053799");
        expResult.setEmail("kevincastrillon4206@gmail.com");
        expResult.setPass("789");
        expResult.setRol("usuario");
        expResult.setEstado(1);
        
        RegistroBeans result = instance.validar(usr, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
