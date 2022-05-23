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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alore
 */
public class RegistroDAOTest {
    
    public RegistroDAOTest() {
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
     * Test of modificar method, of class RegistroDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        RegistroBeans r = new RegistroBeans();
        r.setId(14);
        r.setNombres("Jovy");
        r.setContacto("3135053799");
        r.setCorreo("kevincastrillon843@gmail.com");
        //r.setPass("789");
        //r.setRol("admin");
        RegistroDAO instance = new RegistroDAO();
        int expResult = 0;
        int result = instance.modificar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cargar method, of class RegistroDAO.
     */
    @Test
    public void testCargar() {
        System.out.println("cargar");
        int id = 14;
        RegistroDAO instance = new RegistroDAO();
        RegistroBeans expResult = new RegistroBeans("Jovy", "3135053799", "kevincastrillon843@gmail.com", "", 0);
        expResult.setId(id);
        expResult.setRol("usuario");
        
        RegistroBeans result = instance.cargar(id);
        assertEquals(expResult, result);
        if (result != expResult){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of insertar method, of class RegistroDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        RegistroBeans r = new RegistroBeans();
        r.setId(78);
        r.setNombres("Jovyendo");
        r.setContacto("3135053799");
        r.setCorreo("kevincastrillon4206@gmail.com");
        r.setPass("789");
        r.setRol("admin");
        RegistroDAO instance = new RegistroDAO();
        int expResult = 0;
        int result = instance.insertar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of validar method, of class RegistroDAO.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        String usr = "";
        String pass = "";
        RegistroDAO instance = new RegistroDAO();
        RegistroBeans expResult = null;
        RegistroBeans result = instance.validar(usr, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class RegistroDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        RegistroDAO instance = new RegistroDAO();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsu method, of class RegistroDAO.
     */
    @Test
    public void testGetUsu() {
        System.out.println("getUsu");
        int id = 0;
        RegistroDAO instance = new RegistroDAO();
        List expResult = null;
        List result = instance.getUsu(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class RegistroDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 13;
        RegistroBeans r = new RegistroBeans();
        
        RegistroDAO instance = new RegistroDAO();
        boolean expResult = false;
        boolean result = instance.eliminar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    
}
