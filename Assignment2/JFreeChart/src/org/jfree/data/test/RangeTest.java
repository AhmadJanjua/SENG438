package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range range;
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {}


  
/////TEST CASES FOR toString
    @Test
    public void toStringBothNegative() {
    	range = new Range(-2.0, -1.0);
    	String expected = "Range[-2.0,-1.0]";
    	String actual = range.toString();
    	assertEquals(expected, actual);
    }
    
    @Test
    public void toStringBothPositive() {
    	range = new Range(1.0, 5.0);
    	String expected = "Range[1.0,5.0]";
    	String actual = range.toString();
    	assertEquals(expected, actual);
    }
    
    @Test
    public void toStringNegativePositive() {
    	range = new Range(-5, 3);
    	String expected = "Range[-5.0,3.0]";
    	String actual = range.toString();
    	assertEquals(expected, actual);
    }
    
    @Test
    public void toStringSameValue() {
    	range = new Range(0,0);
    	String expected = "Range[0.0,0.0]";
    	String actual = range.toString();
    	assertEquals(expected, actual);
    }
    
    
   
    @After
    public void tearDown() throws Exception {
    	range = null;
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
