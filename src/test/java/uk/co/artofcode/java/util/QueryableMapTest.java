package uk.co.artofcode.java.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;

/**
 *
 * @author owen
 */
public class QueryableMapTest {
    
    public QueryableMapTest() {
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

    @Test
    public void testQuery() {
        QueryableMap<String, String> testMap = new QueryableMap(Arrays.asList(
            new SimpleEntry<>("A", "A"),
            new SimpleEntry<>("C", "D"),
            new SimpleEntry<>("E", "F")
        ));
        QueryableMap<String, String> results = testMap.query((String k, String v) -> k.equals(v));
        
        assertEquals(1, results.size());
        assertTrue(results.containsKey("A"));
        assertTrue(results.get("A").equals("A"));
    }

    @Test
    public void testFilter() {
        QueryableMap<String, String> testMap = new QueryableMap(Arrays.asList(
            new SimpleEntry<>("A", "A"),
            new SimpleEntry<>("C", "D"),
            new SimpleEntry<>("E", "F")
        ));
        
        assertEquals(3, testMap.size());
        assertTrue(testMap.containsKey("A"));

        
        testMap.filter((String k, String v) -> !k.equals(v));
        
        assertEquals(2, testMap.size());
        assertFalse(testMap.containsKey("A"));
        assertTrue(testMap.containsKey("C"));
        assertTrue(testMap.containsKey("E"));
    }
    
}
