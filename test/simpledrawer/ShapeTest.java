/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledrawer;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rajbir-dhillon
 */
public class ShapeTest {
    
    public ShapeTest() {
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
     * Test of getVertices method, of class Shape.
     */
    @Test
    public void testGetVertices() {
        System.out.println("getVertices");
        Shape instance = null;
        List<Point> expResult = null;
        List<Point> result = instance.getVertices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVertices method, of class Shape.
     */
    @Test
    public void testSetVertices() {
        System.out.println("setVertices");
        List<Point> vertices = null;
        Shape instance = null;
        instance.setVertices(vertices);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColour method, of class Shape.
     */
    @Test
    public void testGetColour() {
        System.out.println("getColour");
        Shape instance = null;
        Color expResult = null;
        Color result = instance.getColour();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColour method, of class Shape.
     */
    @Test
    public void testSetColour() {
        System.out.println("setColour");
        Color colour = null;
        Shape instance = null;
        instance.setColour(colour);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThickness method, of class Shape.
     */
    @Test
    public void testGetThickness() {
        System.out.println("getThickness");
        Shape instance = null;
        int expResult = 0;
        int result = instance.getThickness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setThickness method, of class Shape.
     */
    @Test
    public void testSetThickness() {
        System.out.println("setThickness");
        int thickness = 0;
        Shape instance = null;
        instance.setThickness(thickness);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShapeType method, of class Shape.
     */
    @Test
    public void testGetShapeType() {
        System.out.println("getShapeType");
        Shape instance = null;
        ShapeType expResult = null;
        ShapeType result = instance.getShapeType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShapeType method, of class Shape.
     */
    @Test
    public void testSetShapeType() {
        System.out.println("setShapeType");
        ShapeType shapeType = null;
        Shape instance = null;
        instance.setShapeType(shapeType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
