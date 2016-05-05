/*
$FHNW
 */
package Model;

import java.io.InputStream;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class FileBackendTest {
    
    public FileBackendTest() {
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
     * Test of getData method, of class FileBackend.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        FileBackend instance = new FileBackend();
        List<Film> expResult = null;
        List<Film> result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class FileBackend.
     */
    @Test
    public void testGetData_String() {
        System.out.println("getData");
        String path = "";
        FileBackend instance = new FileBackend();
        List<Film> expResult = null;
        List<Film> result = instance.getData(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class FileBackend.
     */
    @Test
    public void testGetData_InputStream() {
        System.out.println("getData");
        InputStream inputSream = null;
        FileBackend instance = new FileBackend();
        List<Film> expResult = null;
        List<Film> result = instance.getData(inputSream);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
