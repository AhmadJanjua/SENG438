package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

import java.security.InvalidParameterException;

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
		mockingContext.checking(new Expectations() {
			{
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
			}
		});
	    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValues);
	    assertTrue(actual.equals(keyValues));
	}
	
	// Testing for valid Key, value pairs with single entries
	@Test
	public void cummulativePercentValidOneItem() {
		mockingContext.checking(new Expectations() {
			{
				// Number of items
				allowing(keyValues).getItemCount();
				will(returnValue(1));
				
				// getKey
				allowing(keyValues).getKey(0);
				will(returnValue(0));
				
				// getIndex
				allowing(keyValues).getIndex(0);
				will(returnValue(0));

				// getValue
				allowing(keyValues).getValue(0);
				will(returnValue(5));	
			}
		});
	    KeyedValues actual = DataUtilities.getCumulativePercentages(keyValues);
	    assertTrue(actual.equals(keyValues));
	}
	
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
	
	// Test for key value pair with corrupted entry
	@Test ( expected = InvalidParameterException.class)
	public void cummulativePercentInvalid() {
	    mockingContext.checking(new Expectations() {
	        {
				// Number of items
				allowing(keyValues).getItemCount();
				will(returnValue(1));
				
				// getKey
				allowing(keyValues).getKey(0);
				will(returnValue(0));
				
				// getIndex
				allowing(keyValues).getIndex(0);
				will(returnValue(0));
				
				// getValue
				allowing(keyValues).getValue(0);
				will(returnValue("1"));
	        }
	    });
	    try {
	        DataUtilities.getCumulativePercentages(keyValues);
	        fail("The InvalidParameterException was not thrown.");
	    } catch (InvalidParameterException e) {
	        return;
	    }
	    catch(Exception e) {}
	}
	
	// Test for null input to method
	@Test ( expected = InvalidParameterException.class)
	public void cummulativePercentNull() {
	    try {
	        DataUtilities.getCumulativePercentages(null);
	        fail("The InvalidParameterException was not thrown.");
	    } catch (InvalidParameterException e) {
	        return;
	    }
	    catch(Exception e) {}
	}
	
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
	
	@Test
	public void calculateColumnTotalForNullValues() {
		mockingContext.checking(new Expectations() {
	        {
	        	one(values).getRowCount();
	        	will(returnValue(2));
	            one(values).getColumnCount();
	        	will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(1, 0);
	            will(returnValue(7));
	        }
	    });
		int column = 0;
	    double actual = DataUtilities.calculateColumnTotal(values, column);
	    double expected = 0.0;
	    assertEquals(expected, actual, .000000001d);
	}

	
	
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
	
	
	@Test ( expected = InvalidParameterException.class)
	public void calculateColumnTotalForNull() {
	    try {
	        DataUtilities.calculateColumnTotal(null, 0);
	        fail("The InvalidParameterException was not thrown.");
	    } catch (InvalidParameterException e) {
	        return;
	    }
	    catch(Exception e) {}
	}
	
	
	
	
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
	
	@Test
	public void calculateRowTotalForNullValues() {
		mockingContext.checking(new Expectations() {
	        {
	        	one(values).getRowCount();
	        	will(returnValue(1));
	            one(values).getColumnCount();
	        	will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(0, 1);
	            will(returnValue(7));
	        }
	    });
		int row = 0;
	    double actual = DataUtilities.calculateRowTotal(values, row);
	    double expected = 0.0;
	    assertEquals(expected, actual, .000000001d);
	}
	
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

		@Test
		public void createNumberArray_SingleRowMultipleColumns() {
		    // Arrange
		    mockingContext.checking(new Expectations() {{
		        one(values).getRowCount();
		        will(returnValue(1));
		        one(values).getColumnCount();
		        will(returnValue(3));
		        allowing(values).getValue(0, 0);
		        will(returnValue(1.0));
		        allowing(values).getValue(0, 1);
		        will(returnValue(2.0));
		        allowing(values).getValue(0, 2);
		        will(returnValue(3.0));
		    }});

		    // Act
		    Number[] result = new Number[] {
		        values.getValue(0, 0),
		        values.getValue(0, 1),
		        values.getValue(0, 2)
		    };

		    // Assert
		    Number[] expected = new Number[] {1.0, 2.0, 3.0};
		    assertArrayEquals(expected, result);
		}

	// Test Cases for: createNumberArray()
	    @Test
	    public void createNumberArray_MultipleRowsSingleColumn() {
	        // Arrange
	        mockingContext.checking(new Expectations() {{
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(1.0));
	            one(values).getValue(1, 0);
	            will(returnValue(2.0));
	        }});

		    // Act
		    Number[] result = new Number[] {
		        values.getValue(0, 0),
		        values.getValue(1, 0),
		    };

		    // Assert
		    Number[] expected = new Number[] {1.0, 2.0};
		    assertArrayEquals(expected, result);
		}
	    
		@Test
		public void createNumberArray_SingleRowSingleColumnNegativeNumbers() {
		    // Arrange
		    mockingContext.checking(new Expectations() {{
		        one(values).getRowCount();
		        will(returnValue(1));
		        one(values).getColumnCount();
		        will(returnValue(1));
		        one(values).getValue(0, 0);
		        will(returnValue(-1.0));
		    }});

		    double[] data = new double[] {(double) values.getValue(0, 0)};

		 // Act
		 Number[] result = DataUtilities.createNumberArray(data);

		 // Assert
		 Number[] expected = new Number[] {-1.0};
		 assertArrayEquals(expected, result);
		}
		
		@Test
		public void createNumberArray_SingleRowMultipleColumnsNegativeNumbers() {
		    // Arrange
		    mockingContext.checking(new Expectations() {{
		        one(values).getRowCount();
		        will(returnValue(1));
		        one(values).getColumnCount();
		        will(returnValue(3));
		        allowing(values).getValue(0, 0);
		        will(returnValue(-1.0));
		        allowing(values).getValue(0, 1);
		        will(returnValue(-2.0));
		        allowing(values).getValue(0, 2);
		        will(returnValue(-3.0));
		    }});

		    // Act
		    Number[] result = new Number[] {
		        values.getValue(0, 0),
		        values.getValue(0, 1),
		        values.getValue(0, 2)
		    };

		    // Assert
		    Number[] expected = new Number[] {-1.0, -2.0, -3.0};
		    assertArrayEquals(expected, result);
		}
	    
	
	    @Test
	    public void createNumberArray_MultipleRowsSingleColumnNegativeNumbers() {
	        // Arrange
	        mockingContext.checking(new Expectations() {{
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(-1.0));
	            one(values).getValue(1, 0);
	            will(returnValue(-2.0));
	        }});

		    // Act
		    Number[] result = new Number[] {
		        values.getValue(0, 0),
		        values.getValue(1, 0),
		    };

		    // Assert
		    Number[] expected = new Number[] {-1.0, -2.0};
		    assertArrayEquals(expected, result);
		}
		@Test
		public void createNumberArray_NegativesPositiveZeros() {
		    // Arrange
		    mockingContext.checking(new Expectations() {{
		        one(values).getRowCount();
		        will(returnValue(1));
		        one(values).getColumnCount();
		        will(returnValue(4));
		        allowing(values).getValue(0, 0);
		        will(returnValue(-1.0));
		        allowing(values).getValue(0, 1);
		        will(returnValue(0.0));
		        allowing(values).getValue(0, 2);
		        will(returnValue(2.0));
		        allowing(values).getValue(0, 3);
		        will(returnValue(-3.0));
		    }});

		    // Act
		    Number[] result = new Number[] {
		        values.getValue(0, 0),
		        values.getValue(0, 1),
		        values.getValue(0, 2),
		        values.getValue(0, 3)
		    };

		    // Assert
		    Number[] expected = new Number[] {-1.0, 0.0, 2.0, -3.0};
		    assertArrayEquals(expected, result);
		}
		@Test
		public void createNumberArray_AllZeros() {
		    // Arrange
		    mockingContext.checking(new Expectations() {{
		        one(values).getRowCount();
		        will(returnValue(2));
		        one(values).getColumnCount();
		        will(returnValue(2));
		        allowing(values).getValue(0, 0);
		        will(returnValue(0.0));
		        allowing(values).getValue(0, 1);
		        will(returnValue(0.0));
		        allowing(values).getValue(1, 0);
		        will(returnValue(0.0));
		        allowing(values).getValue(1, 1);
		        will(returnValue(0.0));
		    }});

		    // Act
		    Number[] result = new Number[] {
		        values.getValue(0, 0),
		        values.getValue(0, 1),
		        values.getValue(1, 0),
		        values.getValue(1, 1)
		    };

		    // Assert
		    Number[] expected = new Number[] {0.0, 0.0, 0.0, 0.0};
		    assertArrayEquals(expected, result);
		}
	


}
