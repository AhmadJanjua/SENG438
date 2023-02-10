package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
	// fields
    private Range exampleRange[];

    // Setup and cleanup for each test
    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range[9];
    	
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
	exampleRange[8] = new Range(-100000000, 100000000);
    }
    @After
    public void tearDown() {
    	exampleRange = null;
    }
    //Test Cases for: getLowerBound()
    @Test
    public void getLowerBoundBothNegative_GreaterNegativeAndLesserNegative() {
        double expected = -2;
        double actual = exampleRange[0].getLowerBound();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getLowerBoundBothNegativeEqualValues() {
        double expected = -1;
        double actual = exampleRange[1].getLowerBound();
        assertEquals(expected, actual,0);
    }

    @Test
    public void getLowerBoundNegativeAndZero() {
        double expected = -1;
        double actual = exampleRange[2].getLowerBound();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getLowerBoundZeroZero() {
        double expected = 0;
        double actual = exampleRange[3].getLowerBound();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getLowerBoundZeroPositive() {
        double expected = 0;
        double actual = exampleRange[4].getLowerBound();
        assertEquals(expected, actual,0);
    }
    
    @Test
    public void getLowerBoundPositiveBothSame() {
        double expected = 1;
        double actual = exampleRange[5].getLowerBound();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getLowerBoundPositive_SmallerValueAndGreaterValue() {
        double expected = 1;
        double actual = exampleRange[6].getLowerBound();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getLowerBoundMixedPositiveNegtaive() {
        double expected = -2;
        double actual = exampleRange[7].getLowerBound();
        assertEquals(expected, actual, 0);
    }
       
    //Test Cases For: getUpperBound()
    @Test
    public void getUpperBoundBothNegative_GreaterNegativeAndLesserNegative() {
        double expected = -1;
        double actual = exampleRange[0].getUpperBound();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getUpperBoundBothNegativeEqualValues() {
        double expected = -1;
        double actual = exampleRange[1].getUpperBound();
        assertEquals(expected, actual,0);
    }

    @Test
    public void getUpperBoundNegativeSmallerPositive() {
        double expected = 0;
        double actual = exampleRange[2].getUpperBound();
        assertEquals(expected, actual,0);
    }

    @Test
    public void getUpperBoundBothZeros() {
        double expected = 0;
        double actual = exampleRange[3].getUpperBound();
        assertEquals(expected, actual,0);
    }

    @Test
    public void getUpperBoundPositiveSmallerPositive() {
        double expected = 1;
        double actual = exampleRange[4].getUpperBound();
        assertEquals(expected, actual,0);
    }

    @Test
    public void getUpperBoundBothPositivesEqualValues() {
        double expected = 1;
        double actual = exampleRange[5].getUpperBound();
        assertEquals(expected, actual,0);
    }

    @Test
    public void getUpperBoundPositive_SmallerValueAndGreaterValue() {
        double expected = 2;
        double actual = exampleRange[6].getUpperBound();
        assertEquals(expected, actual,0);
    }

    @Test
    public void getUpperBoundBothPositivesSmallerGreater() {
        double expected = 2;
        double actual = exampleRange[7].getUpperBound();
        assertEquals(expected, actual,0);
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
        		exampleRange[7].toString());
    }  
    
    
    //Testing length method
    @Test
    public void lengthWithTwoDiffNeg() {
    	double expected = 1;
    	double actual = exampleRange[0].getLength();
    	assertEquals("Checking the length for two different negative numbers.", expected, actual, .000000001d);
    }
    
    @Test
    public void lengthWithTwoSameNeg() {
    	double expected = 0;
    	double actual = exampleRange[1].getLength();
    	assertEquals("Checking the length for the same two negative numbers.", expected, actual, .000000001d);
    }
    
    @Test
    public void lengthWithZeroAndNeg() {
    	double expected = 1;
    	double actual = exampleRange[2].getLength();
    	assertEquals("Checking the length for a negative number and zero.", expected, actual, .000000001d);
    }
    
    @Test
    public void lengthWithTwoZeros() {
    	double expected = 0;
    	double actual = exampleRange[3].getLength();
    	assertEquals("Checking the length for two zeros.", expected, actual, .000000001d);
    }

    @Test
    public void lengthWithZeroAndPos() {
    	double expected = 1;
    	double actual = exampleRange[4].getLength();
    	assertEquals("Checking the length for a positive number and zero.", expected, actual, .000000001d);
    }
    
    @Test
    public void lengthWithTwoSamePos() {
    	double expected = 0;
    	double actual = exampleRange[5].getLength();
    	assertEquals("Checking the length for the same positive number.", expected, actual, .000000001d);
    }
    
    @Test
    public void lengthWithTwoDiffPos() {
    	double expected = 1;
    	double actual = exampleRange[6].getLength();
    	assertEquals("Checking the length for two different positive numbers.", expected, actual, .000000001d);
    }
    
    @Test
    public void lengthWithNegAndPos() {
    	double expected = 4;
    	double actual = exampleRange[7].getLength();
    	assertEquals("Checking the length for a negative and positive numbers.", expected, actual, .000000001d);
    }
	@Test
    public void containsStandardValues() {
    	boolean expectedValue = true;
    	boolean actualValue = exampleRange[7].contains(0);
    	assertTrue("contains is not returning the correct value for a basic functionality", expectedValue == actualValue);
    }
    
    @Test
    public void containsNegativeValues() {
    	boolean expectedValue = true;
    	boolean actualValue = exampleRange[0].contains(0);
    	assertFalse("contains is not returning the correct value for the basic functionality", expectedValue == actualValue);
    }
    
    @Test
    public void containsSmallRange() {
    	//These are same values but they are different in terms of the fact that they are negative numbers instead
    	boolean expectedValue = true;
    	boolean actualValue = exampleRange[3].contains(0);
    	assertTrue("contains is not returning a value where when range is one number", expectedValue == actualValue);
    }
    
    @Test
    public void containsHugeRange() {
    	boolean expectedValue = true;
    	boolean actualValue = exampleRange[8].contains(0);
    	assertTrue("contains is not returning a value where wne range is one number", expectedValue = actualValue);
    }
}
