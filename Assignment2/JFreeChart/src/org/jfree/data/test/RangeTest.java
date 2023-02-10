package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
	// fields
    private Range exampleRange[];

    // Setup and cleanup for each test
    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range[8];
    	
    	// Negative with combinations
    	exampleRange[0] = new Range(-2,-1);
    	exampleRange[1] = new Range(-1,-1);
    	
    	// Zero Combinations
    	exampleRange[2] = new Range(-1, 0);
    	exampleRange[3] = new Range(0,0);
    	exampleRange[4] = new Range(0,1);
    	
    	// Positive combinations
    	exampleRange[5] = new Range(1,1);
    	exampleRange[6] = new Range(1,2);
    	exampleRange[7] = new Range(-2, 2);    	
    }
    @After
    public void tearDown() {
    	exampleRange = null;
    }

    
// TEST CASES FOR: toString()
    @Test
    public void stringWithTwoDiffNeg() {
    	assertEquals(
        		"Make sure the range for two different negative numbers is represented correctly.",
        		"Range[-2.0,-1.0]",
        		exampleRange[0].toString());
    }
    @Test
    public void stringWithTwoSameNeg() {
    	assertEquals(
        		"Make sure the range for two same negative numbers is represented correctly",
        		"Range[-1.0,-1.0]",
        		exampleRange[1].toString());
    }
    @Test
    public void stringWithZeroAndNeg() {
    	assertEquals(
        		"Make sure the range for zero and negative is represented correctly",
        		"Range[-1.0,0.0]",
        		exampleRange[2].toString());
    }
    @Test
    public void stringWithTwoZeros() {
    	assertEquals(
        		"Make sure the range for two zeros is represented correctly",
        		"Range[0.0,0.0]",
        		exampleRange[3].toString());
    }

    @Test
    public void stringWithZeroAndPos() {
    	assertEquals(
        		"Make sure the range for zero and a positive number is represented correctly",
        		"Range[0.0,1.0]",
        		exampleRange[4].toString());
    }
    @Test
    public void stringWithTwoSamePos() {
    	assertEquals(
        		"Make sure the range for two same positive numbers is represented correctly",
        		"Range[1.0,1.0]",
        		exampleRange[5].toString());
    }
    @Test
    public void stringWithTwoDiffPos() {
    	assertEquals(
        		"Make sure the range for two different positive numbers is represented correctly",
        		"Range[1.0,2.0]",
        		exampleRange[6].toString());
    }
    @Test
    public void stringWithNegAndPos() {
    	assertEquals(
        		"Make sure the range for a negative and positive number is represented correctly",
        		"Range[1.0,2.0]",
        		exampleRange[6].toString());
    }  
}