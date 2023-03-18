package org.jfree.data;

import org.jfree.chart.util.ParamChecks;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jfree.data.category.DefaultCategoryDataset;

import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import static org.junit.Assert.*;
import org.junit.*;



public class DataUtilitiesTest extends DataUtilities {
	// Fields
	private Mockery mockingContext;
	private Values2D values;
	private KeyedValues keyValues;

	// Setup for each test
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		keyValues = mockingContext.mock(KeyedValues.class);
	}
	@After
    public void tearDown() throws Exception {
		mockingContext = null;
		values = null;
	}
	
// TEST CASES FOR: getCumulativePercentage()
	
	// Testing for valid Key, value pairs with many entries
	@Test
	public void cummulativePercentValidManyItem() {
		KeyedValues expected = mockingContext.mock(KeyedValues.class, "KeyValue2");
		mockingContext.checking(new Expectations() {
			{
				// Used for setup
				
				// Number of items
				allowing(keyValues).getItemCount();
				will(returnValue(3));
				
				// getKey
				allowing(keyValues).getKey(0);
				will(returnValue(0));
				allowing(keyValues).getKey(1);
				will(returnValue(1));
				allowing(keyValues).getKey(2);
				will(returnValue(2));
				
				// getIndex
				allowing(keyValues).getIndex(0);
				will(returnValue(0));
				allowing(keyValues).getIndex(1);
				will(returnValue(1));
				allowing(keyValues).getIndex(2);
				will(returnValue(2));
				
				// getValue
				allowing(keyValues).getValue(0);
				will(returnValue(5));
				allowing(keyValues).getValue(1);
				will(returnValue(9));
				allowing(keyValues).getValue(2);
				will(returnValue(2));
				
				// EXPECTED VALUES
				// Number of items
				allowing(expected).getItemCount();
				will(returnValue(3));
				
				// getKey
				allowing(expected).getKey(0);
				will(returnValue(0));
				allowing(expected).getKey(1);
				will(returnValue(1));
				allowing(expected).getKey(2);
				will(returnValue(2));
				
				// getIndex
				allowing(expected).getIndex(0);
				will(returnValue(0));
				allowing(expected).getIndex(1);
				will(returnValue(1));
				allowing(expected).getIndex(2);
				will(returnValue(2));
				
				// getValue
				allowing(expected).getValue(0);
				will(returnValue(0.3125));
				allowing(expected).getValue(1);
				will(returnValue(0.875));
				allowing(expected).getValue(2);
				will(returnValue(1.0));	
			}
		});
	    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValues);
	    assertTrue(actual.equals(expected));
	}
	
//	// Testing for valid Key, value pairs with single entries
//	@Test
//	public void cummulativePercentValidOneItem() {
//		KeyedValues expected = mockingContext.mock(KeyedValues.class, "KeyValue2");
//		mockingContext.checking(new Expectations() {
//			{
//				// Setup value
//				// Number of items
//				allowing(keyValues).getItemCount();
//				will(returnValue(1));
//				
//				// getKey
//				allowing(keyValues).getKey(0);
//				will(returnValue(0));
//				
//				// getIndex
//				allowing(keyValues).getIndex(0);
//				will(returnValue(0));
//
//				// getValue
//				allowing(keyValues).getValue(0);
//				will(returnValue(5));	
//				
//				// EXPECTED
//				// Number of items
//				allowing(expected).getItemCount();
//				will(returnValue(1));
//				
//				// getKey
//				allowing(expected).getKey(0);
//				will(returnValue(0));
//				
//				// getIndex
//				allowing(expected).getIndex(0);
//				will(returnValue(0));
//
//				// getValue
//				allowing(expected).getValue(0);
//				will(returnValue(1));	
//			}
//		});
//	    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValues);
//	    assertTrue(actual.equals(expected));
//	}
	
	// Test for key, value pair with no entries.
	@Test
	public void cummulativePercentValidEmpty() {
		mockingContext.checking(new Expectations() {
			{
				// Number of items
				allowing(keyValues).getItemCount();
				will(returnValue(0));
			}
		});
	    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValues);
	    assertTrue(actual.equals(keyValues));
	}
	
//	// Test for key value pair with corrupted entry
//	@Test ( expected = InvalidParameterException.class)
//	public void cummulativePercentInvalid() {
//	    mockingContext.checking(new Expectations() {
//	        {
//				// Number of items
//				allowing(keyValues).getItemCount();
//				will(returnValue(1));
//				
//				// getKey
//				allowing(keyValues).getKey(0);
//				will(returnValue(0));
//				
//				// getIndex
//				allowing(keyValues).getIndex(0);
//				will(returnValue(0));
//				
//				// getValue
//				allowing(keyValues).getValue(0);
//				will(returnValue("1"));
//	        }
//	    });
//	    try {
//	        DataUtilities.getCumulativePercentages(keyValues);
//	        fail("The InvalidParameterException was not thrown.");
//	    } catch (InvalidParameterException e) {
//	        return;
//	    }
//	    catch(Exception e) {}
//	}
	
//	// Test for null input to method
//	@Test ( expected = InvalidParameterException.class)
//	public void cummulativePercentNull() {
//	    try {
//	        DataUtilities.getCumulativePercentages(null);
//	        fail("The InvalidParameterException was not thrown.");
//	    } catch (InvalidParameterException e) {
//	        return;
//	    }
//	    catch(Exception e) {}
//	}
	
// TEST CASES FOR: calculateColumnTotal
	@Test
	public void calculateColumnTotalForTwoValues() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	        	will(returnValue(2));
	            one(values).getColumnCount();
	        	will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(1));
	            one(values).getValue(0, 1);
	            will(returnValue(8.0));
	            one(values).getValue(1, 0);
	            will(returnValue(1));
	            one(values).getValue(1, 1);
	            will(returnValue(2.5));
	        }
	    });
		int column = 1;
	    double actual = DataUtilities.calculateColumnTotal(values, column);
	    double expected = 10.5;
	    assertEquals(expected, actual, .000000001d);
	}
	
//	@Test
//	public void calculateColumnTotalForNullValues() {
//		mockingContext.checking(new Expectations() {
//	        {
//	        	one(values).getRowCount();
//	        	will(returnValue(2));
//	            one(values).getColumnCount();
//	        	will(returnValue(1));
//	            one(values).getValue(0, 0);
//	            will(returnValue(null));
//	            one(values).getValue(1, 0);
//	            will(returnValue(7));
//	        }
//	    });
//		int column = 0;
//	    double actual = DataUtilities.calculateColumnTotal(values, column);
//	    double expected = 0.0;
//	    assertEquals(expected, actual, .000000001d);
//	}

	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateColumnTotalForInvalidIndex(){
		mockingContext.checking(new Expectations() {
	        {
	        	one(values).getRowCount();
	        	will(returnValue(1));
	            one(values).getColumnCount();
	        	will(returnValue(1));
	            one(values).getValue(0, -1);
	            will(throwException(new IndexOutOfBoundsException()));         
	        }
	    });
		int column = -1;
	    DataUtilities.calculateColumnTotal(values, column);
	    fail();
	}
	
	
//	@Test ( expected = InvalidParameterException.class)
//	public void calculateColumnTotalForNull() {
//	    try {
//	        DataUtilities.calculateColumnTotal(null, 0);
//	        fail("The InvalidParameterException was not thrown.");
//	    } catch (InvalidParameterException e) {
//	        return;
//	    }
//	    catch(Exception e) {}
//	}
	
	
	
	
// TEST CASES FOR: calculateRowTotal
	@Test
	public void calculateRowTotalForTwoValues() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	        	will(returnValue(2));
	            one(values).getColumnCount();
	        	will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(1));
	            one(values).getValue(0, 1);
	            will(returnValue(8.0));
	            one(values).getValue(1, 0);
	            will(returnValue(1.6));
	            one(values).getValue(1, 1);
	            will(returnValue(2.5));
	        }
	    });
		int row = 1;
	    double actual = DataUtilities.calculateRowTotal(values, row);
	    double expected = 4.1;
	    assertEquals(expected, actual, .000000001d);
	}
	
//	@Test
//	public void calculateRowTotalForNullValues() {
//		mockingContext.checking(new Expectations() {
//	        {
//	        	one(values).getRowCount();
//	        	will(returnValue(1));
//	            one(values).getColumnCount();
//	        	will(returnValue(2));
//	            one(values).getValue(0, 0);
//	            will(returnValue(null));
//	            one(values).getValue(0, 1);
//	            will(returnValue(7));
//	        }
//	    });
//		int row = 0;
//	    double actual = DataUtilities.calculateRowTotal(values, row);
//	    double expected = 0.0;
//	    assertEquals(expected, actual, .000000001d);
//	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateRowTotalForInvalidIndex(){
		mockingContext.checking(new Expectations() {
	        {
	        	one(values).getRowCount();
	        	will(returnValue(1));
	            one(values).getColumnCount();
	        	will(returnValue(1));
	            one(values).getValue(-1, 0);
	            will(throwException(new IndexOutOfBoundsException()));         
	        }
	    });
		int row = -1;
		double actual = DataUtilities.calculateRowTotal(values, row);
	    double expected = 0.0;
	    assertEquals(expected, actual, .000000001d);
	}
	
	@Test
	public void createPositive2DArray() {
		Number [][] expectedValue = {{1.0,2.0,3.0},{3.0,2.0,1.0}};
		double [][] doubleArray = {{1.0,2.0,3.0},{3.0,2.0,1.0}};
		Number[][] actualValue = DataUtilities.createNumberArray2D(doubleArray);
		assertArrayEquals("The createNumberArray2d did not create the number array correctly.", expectedValue, actualValue);
	}
	
	@Test
	public void createNegative2DArray() {
		Number [][] expectedValue = {{-1.0,-2.0,-3.0},{-3.0,-2.0,-1.0}};
		double [][] doubleArray = {{-1.0,-2.0,-3.0},{-3.0,-2.0,-1.0}};
		Number[][] actualValue = DataUtilities.createNumberArray2D(doubleArray);
		assertArrayEquals("The createNumberArray2d did not create the negativity number array correctly.", expectedValue, actualValue);
	}
	
	@Test
	public void createUneven2DArray() {
		Number [][] expectedValue = {{10.0, 2.0, 1.0, 10.0},{3.0}};
		double [][] doubleArray = {{10.0, 2.0, 1.0, 10.0},{3.0}};
		Number [][] actualValue = DataUtilities.createNumberArray2D(doubleArray);
		assertArrayEquals("The createNumberArray2d did not create an uneven array.", expectedValue, actualValue);
	}
	
	@Test
	public void create2DNullArray() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail();
		} catch (Exception e) {
			assertEquals("Exception IllegalArgumentException", IllegalArgumentException.class, e.getClass());
		}
	}
	
	@Test
	public void create2DNumberArray_MultipleRowMultipleColumns() {
	    // Arrange
	    mockingContext.checking(new Expectations() {{
	        one(values).getRowCount();
	        will(returnValue(2));
	        one(values).getColumnCount();
	        will(returnValue(3));
	        
	        allowing(values).getValue(0, 0);
	        will(returnValue(1.0));
	        allowing(values).getValue(0, 1);
	        will(returnValue(2.0));
	        allowing(values).getValue(0, 2);
	        will(returnValue(3.0));
	        
	        allowing(values).getValue(1, 0);
	        will(returnValue(3.0));
	        allowing(values).getValue(1, 1);
	        will(returnValue(2.0));
	        allowing(values).getValue(1, 2);
	        will(returnValue(1.0));
	    }});

	    // Act
	    Number[][] result = new Number[][] {{
	        values.getValue(0, 0),
	        values.getValue(0, 1),
	        values.getValue(0, 2),
	    },{
	        values.getValue(1, 0),
	        values.getValue(1, 1),
	        values.getValue(1, 2)
	    }};

	    // Assert
	    Number[][] expected = new Number[][] {{1.0, 2.0, 3.0}, {3.0,2.0,1.0}};
	    assertArrayEquals(expected, result);
	}
	
	@Test
	public void createEmpty2DArray() {
		Number [][] expectedValue = {{},{}};
		double [][] doubleArray = {{},{}};
		Number [][] actualValue = DataUtilities.createNumberArray2D(doubleArray);
		assertArrayEquals("The createNumberArray2d did not create the empty number array correctly.", expectedValue, actualValue);
	}

	// Test Cases for: createNumberArray()
	    @Test
	    public void createNumberArrayPositive() {
	        double[] data = new double[] {1.0, 2.0, 3.0};
	        Number[] result = DataUtilities.createNumberArray(data);
	        Number[] expectedResult = new Number[] {1.0, 2.0, 3.0};
	        assertArrayEquals(expectedResult, result);
	    }

	    @Test
	    public void createNumberArrayNegative() {
	        double[] data = new double[] {-1.0, -2.0, -3.0};
	        Number[] result = DataUtilities.createNumberArray(data);
	        Number[] expectedResult = new Number[] {-1.0, -2.0, -3.0};
	        assertArrayEquals(expectedResult, result);
	    }

	    @Test
	    public void createNumberArrayZeros() {
	        double[] data = new double[] {0.0, 0.0, 0.0};
	        Number[] result = DataUtilities.createNumberArray(data);
	        Number[] expectedResult = new Number[] {0.0, 0.0, 0.0};
	        assertArrayEquals(expectedResult, result);
	    }

	    @Test
	    public void createNumberArrayMixed() {
	        double[] data = new double[] {1.0, -1.0};
	        Number[] result = DataUtilities.createNumberArray(data);
	        Number[] expectedResult = new Number[] {1.0, -1.0};
	        assertArrayEquals(expectedResult, result);
	    }

	    @Test
	    public void createNumberArrayNothing(){
	        double[] data = new double[] {};
	        Number[] result = DataUtilities.createNumberArray(data);
	        Number[] expectedResult = new Number[] {};
	        assertArrayEquals(expectedResult, result);
	    }
	    @Test
	    public void createNumberArrayPositiveNumbers() {
	    	mockingContext.checking(new Expectations() {
	    	{
	    		oneOf(values).getRowCount(); 
	    		will(returnValue(5));
	    		oneOf(values).getValue(0, 0); 
	    		will(returnValue(1.0));
	    		oneOf(values).getValue(1, 0); 
	    		will(returnValue(2.0));
	    		oneOf(values).getValue(2, 0); 
	    		will(returnValue(3.0));
	    		oneOf(values).getValue(3, 0); 
	    		will(returnValue(4.0));
	    		oneOf(values).getValue(4, 0); 
	    		will(returnValue(5.0));
	    	}
	    });

		    double[] data = new double[] {
			        (double) values.getValue(0, 0),
			        (double) values.getValue(1, 0),
			        (double) values.getValue(2, 0),
			        (double) values.getValue(3, 0),
			        (double) values.getValue(4, 0)
			    };

			    // Act
			    Number[] result = DataUtilities.createNumberArray(data);

			    // Assert
			    Number[] expected = new Number[] {1.0, 2.0, 3.0, 4.0, 5.0};
			    assertArrayEquals(expected, result);
	    }
	    @Test
	    public void createNumberArrayNegativeNumbers() {
	    	mockingContext.checking(new Expectations() {
	    	{
	    		oneOf(values).getRowCount(); 
	    		will(returnValue(5));
	    		oneOf(values).getValue(0, 0); 
	    		will(returnValue(-1.0));
	    		oneOf(values).getValue(1, 0); 
	    		will(returnValue(-2.0));
	    		oneOf(values).getValue(2, 0); 
	    		will(returnValue(-3.0));
	    		oneOf(values).getValue(3, 0); 
	    		will(returnValue(-4.0));
	    		oneOf(values).getValue(4, 0); 
	    		will(returnValue(-5.0));
	    	}
	    });

		    double[] data = new double[] {
			        (double) values.getValue(0, 0),
			        (double) values.getValue(1, 0),
			        (double) values.getValue(2, 0),
			        (double) values.getValue(3, 0),
			        (double) values.getValue(4, 0)
			    };

			    // Act
			    Number[] result = DataUtilities.createNumberArray(data);

			    // Assert
			    Number[] expected = new Number[] {-1.0, -2.0, -3.0, -4.0, -5.0};
			    assertArrayEquals(expected, result);
	    }
	    
	    @Test
	    public void createNumberArrayMixedNumbers() {
	    	mockingContext.checking(new Expectations() {
	    	{
	    		oneOf(values).getRowCount(); 
	    		will(returnValue(5));
	    		oneOf(values).getValue(0, 0); 
	    		will(returnValue(-1.0));
	    		oneOf(values).getValue(1, 0); 
	    		will(returnValue(2.0));
	    		oneOf(values).getValue(2, 0); 
	    		will(returnValue(-3.0));
	    		oneOf(values).getValue(3, 0); 
	    		will(returnValue(4.0));
	    		oneOf(values).getValue(4, 0); 
	    		will(returnValue(-5.0));
	    	}
	    });

		    double[] data = new double[] {
			        (double) values.getValue(0, 0),
			        (double) values.getValue(1, 0),
			        (double) values.getValue(2, 0),
			        (double) values.getValue(3, 0),
			        (double) values.getValue(4, 0)
			    };

			    // Act
			    Number[] result = DataUtilities.createNumberArray(data);

			    // Assert
			    Number[] expected = new Number[] {-1.0, 2.0, -3.0, 4.0, -5.0};
			    assertArrayEquals(expected, result);
	    }
	    @Test
	    public void createNumberArrayMixedNumbersAndZero() {
	    	mockingContext.checking(new Expectations() {
	    	{
	    		oneOf(values).getRowCount(); 
	    		will(returnValue(5));
	    		oneOf(values).getValue(0, 0); 
	    		will(returnValue(-1.0));
	    		oneOf(values).getValue(1, 0); 
	    		will(returnValue(2.0));
	    		oneOf(values).getValue(2, 0); 
	    		will(returnValue(-3.0));
	    		oneOf(values).getValue(3, 0); 
	    		will(returnValue(4.0));
	    		oneOf(values).getValue(4, 0); 
	    		will(returnValue(0.0));
	    	}
	    });

		    double[] data = new double[] {
			        (double) values.getValue(0, 0),
			        (double) values.getValue(1, 0),
			        (double) values.getValue(2, 0),
			        (double) values.getValue(3, 0),
			        (double) values.getValue(4, 0)
			    };

			    // Act
			    Number[] result = DataUtilities.createNumberArray(data);

			    // Assert
			    Number[] expected = new Number[] {-1.0, 2.0, -3.0, 4.0, 0.0};
			    assertArrayEquals(expected, result);
	    }
	    
	    @Test
	    public void createNumberArrayZeroes() {
	    	mockingContext.checking(new Expectations() {
	    	{
	    		oneOf(values).getRowCount(); 
	    		will(returnValue(5));
	    		oneOf(values).getValue(0, 0); 
	    		will(returnValue(0.0));
	    		oneOf(values).getValue(1, 0); 
	    		will(returnValue(0.0));
	    		oneOf(values).getValue(2, 0); 
	    		will(returnValue(0.0));
	    		oneOf(values).getValue(3, 0); 
	    		will(returnValue(0.0));
	    		oneOf(values).getValue(4, 0); 
	    		will(returnValue(0.0));
	    	}
	    });

		    double[] data = new double[] {
			        (double) values.getValue(0, 0),
			        (double) values.getValue(1, 0),
			        (double) values.getValue(2, 0),
			        (double) values.getValue(3, 0),
			        (double) values.getValue(4, 0)
			    };

			    // Act
			    Number[] result = DataUtilities.createNumberArray(data);

			    // Assert
			    Number[] expected = new Number[] {0.0,0.0,0.0,0.0,0.0};
			    assertArrayEquals(expected, result);
	    }
	    
	    @Test
	    public void createNumberArrayEmptyArray() {
	    	mockingContext.checking(new Expectations() {{
	    		oneOf(values).getRowCount(); 
	    		will(returnValue(5));
	   
	    	}
	    });

		    double[] data = new double[] {};

			    // Act
			    Number[] result = DataUtilities.createNumberArray(data);

			    // Assert
			    Number[] expected = new Number[] {};
			    assertArrayEquals(expected, result);
	    }
	    
	    
	    //Assignment 3 Starts Here
	    
	    
	    @Test
	    public void equalSameValueArray() {
	        double[][] a = {{1.0, 2.0}, {3.0, 4.0}};
	        double[][] b = {{1.0, 2.0}, {3.0, 4.0}};
	        assertTrue(equal(a, b));
	    }
	    
	    @Test
	    public void equalDiffValueArray() {
	        double[][] c = {{1.0, 2.0}, {3.0, 4.0}};
	        double[][] d = {{1.0, 2.0}, {4.0, 3.0}};
	        assertFalse(equal(c, d));
	    }
	      
	    @Test
	    public void equalDiffDimensionArray() {
	        double[][] e = {{1.0, 2.0}, {3.0, 4.0}};
	        double[][] f = {{1.0, 2.0}};
	        assertFalse(equal(e, f));
	    }
	    @Test
	    public void equalNullArray2() {
	        double[][] g = {{1.0, 2.0}, {3.0, 4.0}};
	        double[][] h = null;
	        assertFalse(equal(g, h));
	    }
	    
	    @Test
	    public void equalNullArray1() {
	        double[][] i = null;
	        double[][] j = {{1.0, 2.0}, {3.0, 4.0}};
	        assertFalse(equal(i, j));
	    }

	    @Test
	    public void equalNullBoth() {
	        double[][] i = null;
	        double[][] j = {{1.0, 2.0}, {3.0, 4.0}};
	        assertFalse(equal(i, j));
	    }

	    @Test
	    public void clone_2x2Array() {
	        //Basic test with a 2x2 array
	        double[][] source1 = {{1.0, 2.0}, {3.0, 4.0}};
	        double[][] clone1 = DataUtilities.clone(source1);
	        assertTrue(Arrays.deepEquals(source1, clone1));
	    }
	    
	    @Test
	    public void clone_1x1Array() {
	        //Test with a 1x1 array
	        double[][] source2 = {{5.0}};
	        double[][] clone2 = DataUtilities.clone(source2);
	        assertTrue(Arrays.deepEquals(source2, clone2));
	    }
	    
	    @Test
	    public void clone_NullArray() {
	        //Test with an array with null elements
	        double[][] source4 = {{1.0, 2.0}, null, {3.0, 4.0}};
	        double[][] clone4 = DataUtilities.clone(source4);
	        assertTrue(Arrays.deepEquals(source4, clone4));
	    }
	    
	    @Test
	    public void clone_DiffLength() {
	        //Test with an array with different row lengths
	        double[][] source5 = {{1.0, 2.0}, {3.0, 4.0, 5.0}};
	        double[][] clone5 = DataUtilities.clone(source5);
	        assertTrue(Arrays.deepEquals(source5, clone5));
	        
	    }

	    @Test
	    public void calculateColumnTotal_ValidRows() {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.addValue(1.0, "Row 1", "Column 1");
	        dataset.addValue(2.0, "Row 1", "Column 2");
	        dataset.addValue(3.0, "Row 1", "Column 3");
	        dataset.addValue(4.0, "Row 2", "Column 1");
	        dataset.addValue(5.0, "Row 2", "Column 2");
	        dataset.addValue(6.0, "Row 2", "Column 3");
	        dataset.addValue(7.0, "Row 3", "Column 1");
	        dataset.addValue(8.0, "Row 3", "Column 2");
	        dataset.addValue(9.0, "Row 3", "Column 3");

	        int[] validRows = {0, 1, 2};
	        int column = 0;
	        
	        double expectedTotal = 12.0;
	        double actualTotal = DataUtilities.calculateColumnTotal(dataset, column, validRows);

	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }

	    @Test
	    public void calculateColumnTotal_withValidRows2() {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.addValue(1.0, "Row 1", "Column 1");
	        dataset.addValue(2.0, "Row 1", "Column 2");
	        dataset.addValue(3.0, "Row 1", "Column 3");
	        dataset.addValue(4.0, "Row 2", "Column 1");
	        dataset.addValue(5.0, "Row 2", "Column 2");
	        dataset.addValue(6.0, "Row 2", "Column 3");
	        dataset.addValue(7.0, "Row 3", "Column 1");
	        dataset.addValue(8.0, "Row 3", "Column 2");
	        dataset.addValue(9.0, "Row 3", "Column 3");

	        int[] validRows = {1, 2};
	        int column = 0;
	        
	        double expectedTotal = 11.0;
	        double actualTotal = DataUtilities.calculateColumnTotal(dataset, column, validRows);

	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }

	    @Test
	    public void calculateColumnTotal_singleRow() {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.addValue(1.0, "Row 1", "Column 1");
	        dataset.addValue(2.0, "Row 1", "Column 2");
	        dataset.addValue(3.0, "Row 1", "Column 3");
	        dataset.addValue(4.0, "Row 2", "Column 1");
	        dataset.addValue(5.0, "Row 2", "Column 2");
	        dataset.addValue(6.0, "Row 2", "Column 3");
	        dataset.addValue(7.0, "Row 3", "Column 1");
	        dataset.addValue(8.0, "Row 3", "Column 2");
	        dataset.addValue(9.0, "Row 3", "Column 3");

	        int[] validRows = {1};
	        int column = 0;
	        
	        double expectedTotal = 4.0;
	        double actualTotal = DataUtilities.calculateColumnTotal(dataset, column, validRows);

	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }
	   
	    @Test
	    public void calculateColumnTotal_Empty() {
		    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		    
		    int[] validRows = {};
		    int column = 0;
		    double expectedTotal = 0.0;
	
		    double actualTotal = DataUtilities.calculateColumnTotal(dataset, column, validRows);
	
		    assertEquals(expectedTotal, actualTotal, 0.0001);
	    }
	    
	    @Test
	    public void calculateRowTotalColumn2_0() {
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.addValue(1.0, "Row 1", "Column 1");
	        dataset.addValue(2.0, "Row 1", "Column 2");
	        dataset.addValue(3.0, "Row 1", "Column 3");
	        dataset.addValue(4.0, "Row 2", "Column 1");
	        dataset.addValue(5.0, "Row 2", "Column 2");
	        dataset.addValue(6.0, "Row 2", "Column 3");
	        dataset.addValue(7.0, "Row 3", "Column 1");
	        dataset.addValue(8.0, "Row 3", "Column 2");
	        dataset.addValue(9.0, "Row 3", "Column 3");

	        int row = 1;
	        int[] Colms = {0, 2};
	        
	        double expectedTotal = 10.0;
	        double actualTotal = DataUtilities.calculateRowTotal(dataset, row, Colms);
	        
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }

	    @Test
	    public void calculateRowTotalRow0() {
	        Values2D data = new Values2D() {
	            private final Object[][] values = {
	                {1, 2, 3, 4},
	                {null, null, null, null},
	                {5, 6, 7, 8}
	            };
	            
	            @Override
	            public int getColumnCount() {
	                return 4;
	            }

	            @Override
	            public int getRowCount() {
	                return 3;
	            }

	            @Override
	            public Number getValue(int row, int column) {
	                return (Number) values[row][column];
	            }
	        };

	        // Test the calculateRowTotal method for row 0
	        double expectedTotal = 10.0; // 1 + 2 + 3 + 4
	        double actualTotal = calculateRowTotal(data, 0);
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }
	    
	    @Test
	    public void calculateRowTotalRow1() {
	        Values2D data = new Values2D() {
	            private final Object[][] values = {
	                {1, 2, 3, 4},
	                {null, null, null, null},
	                {5, 6, 7, 8}
	            };
	            
	            @Override
	            public int getColumnCount() {
	                return 4;
	            }

	            @Override
	            public int getRowCount() {
	                return 3;
	            }

	            @Override
	            public Number getValue(int row, int column) {
	                return (Number) values[row][column];
	            }
	        };

	        // Test the calculateRowTotal method for row 1
	        double expectedTotal = 0.0; // all values are null
	        double actualTotal = calculateRowTotal(data, 1);
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    
	    }

	    @Test
	    public void calculateRowTotalRow2() {
	        Values2D data = new Values2D() {
	            private final Object[][] values = {
	                {1, 2, 3, 4},
	                {null, null, null, null},
	                {5, 6, 7, 8}
	            };
	            
	            @Override
	            public int getColumnCount() {
	                return 4;
	            }

	            @Override
	            public int getRowCount() {
	                return 3;
	            }

	            @Override
	            public Number getValue(int row, int column) {
	                return (Number) values[row][column];
	            }
	        };

	        // Test the calculateRowTotal method for row 2
	        double expectedTotal = 26.0; // 5 + 6 + 7 + 8
	        double actualTotal = calculateRowTotal(data, 2);
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    
	    }



//	    @Test
//	    public void calculateRowTotalc2Loop() {
//	        // Test that the loop with c2 variable is executed correctly
//	       Values2D data = new Values2D() {
//	            private final Object[][] values = {
//	                {1, 2, 3},
//	                {4, 5, null},
//	                {6, 7, 8}
//	            };
//	            
//	            @Override
//	            public int getColumnCount() {
//	                return 3;
//	            }
//
//	            @Override
//	            public int getRowCount() {
//	                return 3;
//	            }
//
//	            @Override
//	            public Number getValue(int row, int column) {
//	                return (Number) values[row][column];
//	            }
//	        };
//
//	        double expectedTotal = 36.0; 
//	        double actualTotal = calculateRowTotal(data, 1);
//	        assertEquals(expectedTotal, actualTotal, 0.0001);
//	    }

	    @Test
	    public void calculateRowTotal2Row0() {
	        Values2D data = new Values2D() {
	            private final Object[][] values = {
	                {1, 2, 3},
	                {4, 5, null}
	            };
	            
	            @Override
	            public int getColumnCount() {
	                return 3;
	            }

	            @Override
	            public int getRowCount() {
	                return 2;
	            }

	            @Override
	            public Number getValue(int row, int column) {
	                return (Number) values[row][column];
	            }
	        };
	        double expectedTotal = 6.0; // 1 + 2 + 3
	        double actualTotal = calculateRowTotal(data, 0);
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }
	    
	    @Test
	    public void calculateRowTotal2Row1() {
	        Values2D data = new Values2D() {
	            private final Object[][] values = {
	                {1, 2, 3},
	                {4, 5, null}
	            };
	            
	            @Override
	            public int getColumnCount() {
	                return 3;
	            }

	            @Override
	            public int getRowCount() {
	                return 2;
	            }

	            @Override
	            public Number getValue(int row, int column) {
	                return (Number) values[row][column];
	            }
	        };

	        double expectedTotal = 9.0; // 4 + 5
	        double actualTotal = calculateRowTotal(data, 1);
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }
	    
	    @Test
	    public void calculateRowTotal2AllNull() {
	        // Test the calculateRowTotal method for a row with all null values
	        Values2D data2 = new Values2D() {
	            @Override
	            public int getColumnCount() {
	                return 3;
	            }

	            @Override
	            public int getRowCount() {
	                return 1;
	            }

	            @Override
	            public Number getValue(int row, int column) {
	                return null;
	            }
	        };
	        double expectedTotal = 0.0;
	        double actualTotal = calculateRowTotal(data2, 0);
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }
	    @Test
	    public void calculateRowTotal2SomeNull() {      
	        // Test the calculateRowTotal method for a row with some null values
	        Values2D data3 = new Values2D() {
	            private final Object[][] values = {
	                {1, null, 3},
	            };
	            
	            @Override
	            public int getColumnCount() {
	                return 3;
	            }

	            @Override
	            public int getRowCount() {
	                return 1;
	            }

	            @Override
	            public Number getValue(int row, int column) {
	                return (Number) values[row][column];
	            }
	        };
	        double expectedTotal = 4.0; // 1 + 3
	        double actualTotal = calculateRowTotal(data3, 0);
	        assertEquals(expectedTotal, actualTotal, 0.0001);
	    }
	    
	    @Test
	    public void calculateRowTotalWithMockery() {
	        final Mockery context = new Mockery();
	        final Values2D mockData = context.mock(Values2D.class);

	        // Set up expectations for getValue() method calls
	        context.checking(new Expectations() {{
	            allowing(mockData).getColumnCount(); will(returnValue(3));

	            oneOf(mockData).getValue(1, 0); will(returnValue(1.0));
	            oneOf(mockData).getValue(1, 1); will(returnValue(null));
	            oneOf(mockData).getValue(1, 2); will(returnValue(3.0));
	        }});

	        // Call the method under test
	        double actualTotal = DataUtilities.calculateRowTotal(mockData, 1);

	        // Check the result against the expected value
	        double expectedTotal = 4.0;
	        assertEquals(expectedTotal, actualTotal, 0.0001);

	        // Verify that all expected method calls were made
	        context.assertIsSatisfied();
	    }
	    
	    @Test
	    public void calculateRowTotalWithNullValues() {
	        final Mockery context = new Mockery();
	        final Values2D mockData = context.mock(Values2D.class);

	        // Set up expectations for getColumnCount() method call
	        context.checking(new Expectations() {{
	            allowing(mockData).getColumnCount(); will(returnValue(3));

	            allowing(mockData).getValue(with(any(Integer.class)), with(equal(0))); will(returnValue(1.0));
	            allowing(mockData).getValue(with(any(Integer.class)), with(equal(1))); will(returnValue(null));
	            allowing(mockData).getValue(with(any(Integer.class)), with(equal(2))); will(returnValue(3.0));
	        }});

	        // Call the method under test
	        double actualTotal = DataUtilities.calculateRowTotal(mockData, 1);

	        // Check the result against the expected value
	        double expectedTotal = 4.0;
	        assertEquals(expectedTotal, actualTotal, 0.0001);

	        // Verify that all expected method calls were made
	        context.assertIsSatisfied();
	    }
	    
//	    @Test
//	    public void calculateColumnTotal_negativeRowNum() {
//	        Values2D data = new Values2D() {
//	            private final Object[][] values = {
//	                {1, 2, 3},
//	                {4, 5, 3}
//	            };
//
//	            @Override
//	            public int getColumnCount() {
//	                return 3;
//	            }
//
//	            @Override
//	            public int getRowCount() {
//	                return -2;
//	            }
//
//	            @Override
//	            public Number getValue(int row, int column) {
//	                return (Number) values[row][column];
//	            }
//	        };
//	        double expectedTotal = 5.0; // Row 0 has a sum of 5
//	        try {
//	            double actualTotal = calculateColumnTotal(data, 0);
//	            assertEquals(expectedTotal, actualTotal, 0.0001);
//	        } catch (Exception e) {
//	            fail("Calculation not computed correctly for column total.");
//	        }
//
//	    }
	    

}
