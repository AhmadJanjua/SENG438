package org.jfree.data.test;

import static org.junit.Assert.*;


import java.security.InvalidParameterException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;


public class DataUtilitiesTest extends DataUtilities {
	private Mockery mockingContext;
	private Values2D values;
	
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}
	

	/////TEST CASES FOR calculateColumnTotal

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
	
	//Unsure how to get this to work
	//Trying to test giving it a invalid data object to test the exception
	/*@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalForInvalidData() {
		mockingContext.checking(new Expectations() {
	        {
	        	never(values).getRowCount();
	        	will(returnValue(0));
	        	//one(values).getColumnCount();
	        	//will(returnValue(1));
	            //one(values).getValue(0, 0);
	            //will(returnValue(10000000000));
	            //will(throwException(new InvalidParameterException())); 
	        }
	    });
		int column = 0;
		DataUtilities.calculateColumnTotal(values, column);
		fail();
	}*/
	
	
	
	
	
	
	
    /////TEST CASES FOR calculateRowTotal
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
	    double expected = 2.6;
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
	    //fail();
	            //one(values).getRowCount();
	        	//will(returnValue(2));
	            one(values).getColumnCount();
	        	will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    double actual = DataUtilities.calculateColumnTotal(values, 0);
	    double expected = 10.0;
	    assertEquals(actual, expected, .000000001d);
	}
	
	@After
    public void tearDown() throws Exception {
		mockingContext = null;
		values = null;
	}
	

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}
}
