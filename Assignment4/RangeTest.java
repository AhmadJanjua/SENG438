package org.jfree.data;

import static org.junit.Assert.*;
import org.jmock.Mockery;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.jmock.lib.JavaReflectionImposteriser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.*;
import java.security.InvalidParameterException;
import org.jmock.Expectations;

public class RangeTest {
	// fields
    private Range exampleRange[];
	private Mockery mockingContext;
    
	// Setup for each test
    @Before
    public void setUp() throws Exception {
    	mockingContext = new Mockery();
    	mockingContext.setImposteriser(ClassImposteriser.INSTANCE);
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
		mockingContext = null;
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
        		"Range[-2.0,2.0]",
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
    
//ASSIGNMENT 3 STARTS
    @Test
    public void testRangeConstructorLowerIsLarger() {
    	try {
    		Range range = new Range(10,5);
    		range.getLowerBound();
    		fail("The IllegalArgumentException is not thrown." );
    	}catch(IllegalArgumentException e){
    		return;	
    	}
    	catch(Exception e) {	
    	}
    }
    
    //Not sure how to do three of these 
    @Test
    public void normalGetCentralValue() {
    	double expectedValue = -1.5;
    	double actualValue =  exampleRange[0].getCentralValue();
    	assertTrue("getCentralValue is not returning the correct number inbetween range -2 and -1.", expectedValue == actualValue);
    }
    
    @Test
    public void containsWhereValueIsLessThanLower() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[1].contains(-2);
    	assertTrue("Contains is not returning false when checking if -2 is inbetweeen range -1 and -1.", expectedValue == actualValue);
    }
    
    @Test
    public void containsWhereValueIsGreaterThanUpper() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[1].contains(5);
    	assertTrue("Contains is not returning false when checking if 5 is inbetweeen range -1 and -1.", expectedValue == actualValue);

    }
    
    @Test
    public void containsWhereValueIsInbetween() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[1].contains(-1.5);
    	assertTrue("Contains is not returning false when checking if -1.5 is inbetweeen range -1 and -1.", expectedValue == actualValue);

    }
    
    @Test
    public void normalIntersects() {
    	boolean expectedValue = true;
    	boolean actualValue = exampleRange[0].intersects(-3, -1);
    	assertTrue("Intersects is not returning true when checking if -3 and -1 is inbetween the range of -2 and -1", expectedValue == actualValue);
    }
    
    @Test
    public void lowerisTrueUpperIsFalseIntersects() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[0].intersects(-4,-3);
    	assertTrue("Intersects is not returning false when checking if -4 and -3 is inbetween the range of -2 and -1", expectedValue == actualValue);
    }
        
    @Test
    public void lowerisFalseUpperIsFalseIntersects() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[0].intersects(-5, -7);
    	assertTrue("Intersects is not returning false when checking if -5 and -7 is inbetween the range of -2 and -1", expectedValue == actualValue);
    }
    
    @Test
    public void intersectsWithInputParameterAsRange() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[0].intersects(exampleRange[6]);
    	assertTrue("Intersects is not returning false when throwing range index 6 is inbetween the range of -2 and -1", expectedValue == actualValue);
    }
    
    @Test
    public void constrainUpper() {
    	double expectedValue = -1;
    	double actualValue = exampleRange[0].constrain(5.0);
    	assertTrue("Constrain is not returning -1 when the value we are checking that is closest to the range is 5", expectedValue == actualValue);
    }
    
    @Test
    public void constrainLower() {
    	double expectedValue = -2;
    	double actualValue = exampleRange[0].constrain(-3);
    	assertTrue("Constrain is not returning -2 when the value we are checking that is closest to the range is -3", expectedValue == actualValue);
    }
    
    @Test
    public void constrainInbetween() {
    	double expectedValue = -1.5;
    	double actualValue = exampleRange[0].constrain(-1.5);
    	assertTrue("Constrain is not returning -1.5 when the value we are checking that is closest to the range is -1.5", expectedValue == actualValue);
    }
    
    @Test
    public void constrainLowerIsEqualToValue() {
    	double expectedValue = -2.0;
    	double actualValue = exampleRange[0].constrain(-2.0);
    	assertTrue("Constrain is not returning -2.0 when the value we are checking that is closest to the range is -2.0", expectedValue == actualValue);
    }
    
    @Test
    public void combineFirstIsNullLastIsRange() {
    	Range firstInput = null;
    	Range secondInput = exampleRange[6];
    	Range expectedValue = exampleRange[6];
    	Range actualValue = Range.combine(firstInput,secondInput);
    	assertTrue("Combine is not returning the correct range when one range is null",actualValue == expectedValue);
    }
    
    @Test
    public void combineFirstIsRangeLastIsNull() {
    	Range firstInput = exampleRange[6];
    	Range secondInput = null;
    	Range expectedValue = exampleRange[6];
    	Range actualValue = Range.combine(firstInput, secondInput);
    	assertTrue("Combine is not returning the correct range when one range is null", actualValue == expectedValue);
    }
    
    
    @Test
    public void combineNaNFirstNullRange() {
    	Range firstInput = null;
    	Range secondInput = exampleRange[3];
    	Range expectedValue = exampleRange[3];
    	Range actualValue = Range.combineIgnoringNaN(firstInput, secondInput);
    	assertTrue("CombineNaN is not returning the correct number.", actualValue == expectedValue);
    }
    
    @Test
    public void combineNaNSecondNullRange() {
    	Range firstInput = exampleRange[3];
    	Range secondInput = null;
    	Range expectedValue = exampleRange[3];
    	Range actualValue = Range.combineIgnoringNaN(firstInput, secondInput);
    	assertTrue("CombineNaN is not returning the correct number.", actualValue == expectedValue);
    }
    
    @Test
    public void combineBothNaNRange() {
    	Range firstInput = new Range(Math.sqrt(-1.0),Math.sqrt(-1.0));
    	Range secondInput = new Range(Math.sqrt(-1.0),Math.sqrt(-1.0));
    	Range expectedValue = null;
    	Range actualValue = Range.combineIgnoringNaN(firstInput, secondInput);
    	assertTrue("CombineNaN is not returning the correct number.", actualValue == expectedValue);
    }
    
    @Test
    public void combineFirstNaNRange() {
    	Range firstInput = null;
    	Range secondInput = new Range(Math.sqrt(-1.0),Math.sqrt(-1.0));
    	Range expectedValue = null;
    	Range actualValue = Range.combineIgnoringNaN(firstInput, secondInput);
    	assertTrue("CombineNaN is not returning the correct number.", actualValue == expectedValue);
    }
    
    @Test
    public void combineSecondNaNRange() {
    	Range firstInput = new Range(Math.sqrt(-1.0),Math.sqrt(-1.0));
    	Range secondInput = null;
    	Range expectedValue = null;
    	Range actualValue = Range.combineIgnoringNaN(firstInput, secondInput);
    	assertTrue("CombineNaN is not returning the correct number.", actualValue == expectedValue);
    }
    
    @Test
    public void combineNaNBothNullRange() {
    	Range firstInput = null;
    	Range secondInput = null;
    	Range expectedValue = null;
    	Range actualValue = Range.combineIgnoringNaN(firstInput, secondInput);
    	assertTrue("CombineNaN is not returning the correct number.", actualValue == expectedValue);
    }
    
    @Test
    public void combineNaNBothNaNLowerRange() {
    	Range firstInput = new Range(0,2);
    	Range secondInput = new Range(-1,3);
    	Range expectedValue = new Range(-1.0,3.0);
    	Range actualValue = Range.combineIgnoringNaN(firstInput, secondInput);
    	assertTrue("CombineNaN is not returning the lower bound.", actualValue.getLowerBound() == expectedValue.getLowerBound());
    	assertTrue("CombineNaN is not returning the upper bound.", actualValue.getUpperBound() == expectedValue.getUpperBound());
    	
    }
    
    @Test
    public void expandNormal() {
    	Range firstInput = exampleRange[2];
    	Range expectedValue = new Range(2.0,2.0);
    	Range actualValue = Range.expand(firstInput, -3, 2);
    	assertTrue("Expand is not returning the correct lower bound.", actualValue.getLowerBound() == expectedValue.getLowerBound());
    	assertTrue("Expand is not returning the correct upper bound", actualValue.getUpperBound() == expectedValue.getUpperBound());
    }
    
    //May have to mock
    @Test
    public void expandLowerLargerThanUpper() {
    	Range firstInput = new Range(0,1);
    	Range expectedValue = new Range(11.5,11.5);
    	Range actualValue = Range.expand(firstInput, -20, 2);
    	assertTrue("Expand is not returning the correct lower bound.", actualValue.getLowerBound() == expectedValue.getLowerBound());
    	assertTrue("Expand is not returning the correct upper bound.", actualValue.getUpperBound() == expectedValue.getUpperBound());
    }
    
    @Test
    public void shiftNormalFalse() {
    	Range firstInput = exampleRange[2];
    	Range expectedValue = new Range(9.0,10.0);
    	Range actualValue = Range.shift(firstInput, 10, true);
    	assertTrue("Shift is not returning the correct lower bound.", actualValue.getLowerBound() == expectedValue.getLowerBound());
    	assertTrue("Shift is not returning the correct upper bound.", actualValue.getUpperBound() == expectedValue.getUpperBound());
    }
    
    @Test
    public void normalScaling() {
    	Range firstInput = exampleRange[2];
    	Range expectedValue = new Range(-10.0,0);
    	Range actualValue = Range.scale(firstInput, 10);

    	assertTrue("Scaling is not returning the correct lower bound.", actualValue.getLowerBound() == expectedValue.getLowerBound());
    	assertTrue("Scaling is not returning the correct upper bound.", actualValue.getUpperBound() == expectedValue.getUpperBound());
    }
    
    @Test
    public void argumentScaling() {
    	try {
    		Range firstInput = exampleRange[2];
    		Range.scale(firstInput, -5.0);
    		fail("The IllegalArgumentException is not thrown." );
    	}catch(IllegalArgumentException e){
    		return;	
    	}
    	catch(Exception e) {	
    	}
    }
        
    @Test
    public void ObjInstanceOfRange() {
    	Double input_one = null;
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[2].equals(input_one);
    	assertTrue("Equals function is not equating the object correctly.", expectedValue == actualValue);
    }
    
    @Test
    public void rangeEqualsToRangeUpperFailure() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[0].equals(exampleRange[1]);
    	assertTrue("Equals function is not equating the object correctly", expectedValue == actualValue);
    }
    
    @Test
    public void rangeEqualsToRangeLowerFailure() {
    	boolean expectedValue = false;
    	boolean actualValue = exampleRange[7].equals(new Range(-2,0));
    	assertTrue("Equals function is not equating the object correctly", expectedValue == actualValue);
    }
    
    @Test
    public void rangeEqualsToRangeNormal() {
    	Range range = new Range(-2, -1);
    	boolean expectedValue = true;
    	boolean actualValue = exampleRange[0].equals(range);
    	assertTrue("Equals function is not equating the object correctly", expectedValue == actualValue);
    }
    
    @Test
    public void HashCodeComparator() {
    	int actualValue = exampleRange[4].hashCode();
    	int expectedValue = 1072693248;
    	assertTrue("The hash code is not being outputted correctly by the machine.", expectedValue == actualValue);
    }
    
    @Test
    public void expandToInclude_null() {
    	Range expected = new Range(0,0);
    	Range actual = Range.expandToInclude(null, 0);
    	assertEquals("Checks expandToInclude with a null range value", expected, actual);
    }
    
    @Test
    public void expandToInclude_LessLower() {
    	double value = 0;
    	Range range = new Range(value+1,value+2);
    	Range expected = new Range(value,value+2);
    	Range actual = Range.expandToInclude(range, value);
    	assertEquals("Checks expandToInclude for a range with greater lowerbound than the input value",
    			expected, actual);
    }
    
    @Test
    public void expandToInclude_GreaterUpper() {
    	double value = 0;
    	Range range = new Range(value-2,value-1);
    	Range expected = new Range(value-2,value);
    	Range actual = Range.expandToInclude(range, value);
    	assertEquals("Checks expandToInclude for a range with lower upperbound than the input value",
    			expected, actual);
    }
    
    @Test
    public void expandToInclude_equivalent() {
    	double value = 0;
    	Range range = new Range(value,value);
    	Range expected = new Range(value,value);
    	Range actual = Range.expandToInclude(range, value);
    	assertEquals("Checks expandToInclude for a range with same upper and lower bounds as value",
    			expected, actual);
    }
    
    @Test
    public void min_d1NaN() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	double expected = -1;
    	
		Method min = Range.class.getDeclaredMethod("min", double.class, double.class);
		min.setAccessible(true);
		double actual = (double) min.invoke(null, Double.NaN, -1);
    	assertTrue("Checks for min of one real value", expected==actual);
    }
    
    @Test
    public void min_d2NaN() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	double expected = -1;
    	
		Method min = Range.class.getDeclaredMethod("min", double.class, double.class);
		min.setAccessible(true);
		double actual = (double) min.invoke(null, -1, Double.NaN);
    	assertTrue("Checks for min of one real value", expected==actual);
    }
	
    @Test
    public void min_normal() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	double expected = -1;
    	
		Method min = Range.class.getDeclaredMethod("min", double.class, double.class);
		min.setAccessible(true);
		double actual = (double) min.invoke(null, expected, 100);
    	assertTrue("Checks for min of one real value", expected==actual);
    }
    
    @Test
    public void max_d1NaN() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	double expected = 1;
    	
		Method max = Range.class.getDeclaredMethod("max", double.class, double.class);
		max.setAccessible(true);
		double actual = (double) max.invoke(null, Double.NaN, 1);
    	assertTrue("Checks for max of one real value", expected==actual);
    }
    
    @Test
    public void max_d2NaN() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	double expected = 1;
    	
		Method max = Range.class.getDeclaredMethod("max", double.class, double.class);
		max.setAccessible(true);
		double actual = (double) max.invoke(null, 1, Double.NaN);
    	assertTrue("Checks for max of one real value", expected==actual);
    }
	
    @Test
    public void max_normal() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	double expected = 100;
    	
		Method max = Range.class.getDeclaredMethod("max", double.class, double.class);
		max.setAccessible(true);
		double actual = (double) max.invoke(null, -1, 100);
    	assertTrue("Checks for max of one real value", expected==actual);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void illegalGetLowerBoundTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Range myRange = new Range(0,0);
    	Field lower = myRange.getClass().getDeclaredField("lower");
    	Field upper = myRange.getClass().getDeclaredField("upper");
    	lower.setAccessible(true);
    	upper.setAccessible(true);
    	
    	lower.setDouble(myRange, 10);
    	upper.setDouble(myRange, 0);
    	
    	myRange.getLowerBound();
    	fail();
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void illegalGetUpperBoundTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Range myRange = new Range(0,0);
    	Field lower = myRange.getClass().getDeclaredField("lower");
    	Field upper = myRange.getClass().getDeclaredField("upper");
    	lower.setAccessible(true);
    	upper.setAccessible(true);
    	
    	lower.setDouble(myRange, 10);
    	upper.setDouble(myRange, 0);
    	
    	myRange.getUpperBound();
    	fail();
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void illegalGetLengthTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Range myRange = new Range(0,0);
    	Field lower = myRange.getClass().getDeclaredField("lower");
    	Field upper = myRange.getClass().getDeclaredField("upper");
    	lower.setAccessible(true);
    	upper.setAccessible(true);
    	
    	lower.setDouble(myRange, 10);
    	upper.setDouble(myRange, 0);
    	
    	myRange.getLength();
    	fail();
    }
    
    @Test
    public void b0GreaterThanLowerTest() {
    	Range myRange = new Range(0, 10);
    	boolean expected = true;
    	boolean actual = myRange.intersects(1, 10);
    	assertTrue("Checks if the supplied range intersects with original range", expected==actual );
    }
    
    @Test
    public void shiftWithNoZeroCrossingValueZeroTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Method shift = Range.class.getDeclaredMethod("shiftWithNoZeroCrossing", double.class, double.class);
		shift.setAccessible(true);
		
		double expected = 100;
		double actual = (double) shift.invoke(null, 0, 100);
		assertTrue(expected==actual);
    }
    
    @Test
    public void shiftWithNoZeroCrossingValuePosTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Method shift = Range.class.getDeclaredMethod("shiftWithNoZeroCrossing", double.class, double.class);
		shift.setAccessible(true);
		
		double expected = 0;
		double actual = (double) shift.invoke(null, 1, -2);
		assertTrue(expected==actual);
    }
    
    @Test
    public void shiftWithNoZeroCrossingValueNegTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Method shift = Range.class.getDeclaredMethod("shiftWithNoZeroCrossing", double.class, double.class);
		shift.setAccessible(true);
		
		double expected = 0;
		double actual = (double) shift.invoke(null, -1, 2);
		assertTrue(expected==actual);
    }
    
    @Test
    public void shiftDontAllowCrossing() {
    	Range myRange = new Range(0,0);
    	Range expected = new Range(0,0);
    	Range actual = Range.shift(myRange, 0);
    	assertEquals(expected, actual);
    }
    
    //Testing contains return value 
    @Test
    public void testContainsWithin() {
        Range range = new Range(-6, 5);
        double value = 2;
        assertTrue("Contains does not work.", range.contains(value)==true);
    }
    
    @Test
    public void testContainsLower() {
        Range range = new Range(-6,5);
        double value = -6;
        assertTrue("Contains does not work.", range.contains(value) == true);
    }
    
    @Test
    public void testContainsUpper() {
        Range range = new Range(-6, 5);
        double value = 5;
        assertTrue("Contains does not work.", range.contains(value)== true);
    }

    //Test cases for combine
    @Test
    public void testCombineRange2NULL() {
        Range range1 = new Range(-6, 5);
        Range range2 = null;
        assertTrue("Combine did not execute correctly", range1 == Range.combine(range1, range2));
    }
    
    @Test
    public void testCombineRangeMin() {
        Range range1 = new Range(-6, 5);
        Range range2 = new Range(-7, 4);
        Range expectedRange = new Range(-7, 5);
        Range actualRange = Range.combine(range1, range2);
        assertTrue("Combine did not execute lower bound correctly", expectedRange.getLowerBound() == actualRange.getLowerBound());
        assertTrue("Combine did not execute lower bound correctly", expectedRange.getUpperBound() == actualRange.getUpperBound());
    }
    
    
}