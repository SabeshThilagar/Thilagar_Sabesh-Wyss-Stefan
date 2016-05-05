/*
$FHNW
 */
package Model;

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
public class MainModelTest {
    
    public MainModelTest() {
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
     * Test of getData method, of class MainModel.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        MainModel instance = new MainModelImpl();
        List<Film> expResult = null;
        List<Film> result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MainModelImpl implements MainModel {

        public List<Film> getData() {
            return null;
        }
    }
    
}
