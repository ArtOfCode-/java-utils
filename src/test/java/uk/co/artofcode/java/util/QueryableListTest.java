package uk.co.artofcode.java.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

/**
 *
 * @author owen
 */
public class QueryableListTest {
    
    public QueryableListTest() {
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
    public void testQueryOnStrings() {
        QueryableList<String> testList = new QueryableList<>(Arrays.asList("1", "1 2", "1 2 3", "1 2 3 4"));
        QueryableList<String> results = testList.query((String s) -> s.split(" ").length > 2);
        
        assertEquals(2, results.size());
        assertTrue(results.contains("1 2 3"));
        assertTrue(results.contains("1 2 3 4"));
        assertFalse(results.contains("1"));
        assertFalse(results.contains("1 2"));
    }
    
    @Test
    public void testQueryOnPeople() {
        Person anna = new Person("Anna", 18);
        Person bob = new Person("Bob", 23);
        Person charlie = new Person("Charlie", 28);
        Person dom = new Person("Dom", 33);
        
        QueryableList<Person> testList = new QueryableList<>(Arrays.asList(anna, bob, charlie, dom));
        QueryableList<Person> namesContainingA = testList.query((Person p) -> p.getName().contains("a"));
        QueryableList<Person> youngsters = testList.query((Person p) -> p.getAge() <= 25);
        
        assertEquals(2, namesContainingA.size());
        assertEquals(2, youngsters.size());
        
        assertTrue(namesContainingA.contains(anna));
        assertTrue(namesContainingA.contains(charlie));
        assertFalse(namesContainingA.contains(bob));
        assertFalse(namesContainingA.contains(dom));
        
        assertTrue(youngsters.contains(anna));
        assertTrue(youngsters.contains(bob));
        assertFalse(youngsters.contains(charlie));
        assertFalse(youngsters.contains(dom));
    }
    
}
