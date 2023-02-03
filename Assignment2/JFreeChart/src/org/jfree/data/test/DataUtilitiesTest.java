package org.jfree.data.test;

import static org.junit.Assert.*;

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
	
	@Test
	public void calculateColumnTotalForTwoValues() {
		mockingContext.checking(new Expectations() {
	        {
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
