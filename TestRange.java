package org.jfree.data;

import static org.junit.Assert.*; import org.junit.*;


public class TestRange {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        exampleRange = new Range(-1.0, 1.0);
    }
    
    //Try a value not in the range 
    @Test(expected=IllegalArgumentException.class)
    public void testrangeCreationNull() {
        exampleRange = new Range(1.0, -11.0);
        assertEquals(exampleRange, exampleRange);
    }
    
    //Try a value not in the range 
    @Test
    public void containsValueNotInRange() {
        exampleRange = new Range(-1.0, 1.0);
        assertFalse(exampleRange.contains(10.0));
    }
    
    //Try a value in the range 
    @Test
    public void containsValueInRange() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.contains(0.5));
    }
    
    //Try a value equal to the upper bound of the range 
    @Test
    public void containsValueUpperBound() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.contains(1.0));
    }
    
    //Try a value equal to the lower bound of the range 
    @Test
    public void containsValueLowerBound() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.contains(-1.0));
    }
    
    
    //Tests for shift method 
    
    //Try a shifting by 0 
    @Test
    public void shiftZero() {
        exampleRange = new Range(-1.0, 1.0);
         Range shiftZero = Range.shift(exampleRange, 0);
         assertEquals(-1.0, shiftZero.getLowerBound(), .000000001d);
         assertEquals(1.0, shiftZero.getUpperBound(), .000000001d);
    }
    
    //Try a small amount 
    @Test
    public void shiftSmall() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftSmall = Range.shift(exampleRange, 0.5);
        assertEquals(-0.5, shiftSmall.getLowerBound(), .000000001d);
        assertEquals(1.5, shiftSmall.getUpperBound(), .000000001d);
    }
    
    //Try a larger amount 
    @Test
    public void shiftLarger() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftLarger = Range.shift(exampleRange, 100.0);
        assertEquals(101.0, shiftLarger.getUpperBound(), .000000001d);
        assertEquals(0, shiftLarger.getLowerBound(), .000000001d);
    }
    
    //Try a negative amount 
    @Test
    public void shiftNegative() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftNegative = Range.shift(exampleRange, -10.0);
        assertEquals(-11.0, shiftNegative.getLowerBound(), .000000001d);
        assertEquals(0, shiftNegative.getUpperBound(), .000000001d);
    }
    
    //Try a larger amount 
    @Test
    public void shiftLargerZero() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftLarger = Range.shift(exampleRange, 100.0, true);
        assertEquals(101.0, shiftLarger.getUpperBound(), .000000001d);
        assertEquals(99.0, shiftLarger.getLowerBound(), .000000001d);
    }
    
    //Try a negative amount 
    @Test
    public void shiftNegativeZero() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftNegative = Range.shift(exampleRange, -10.0, true);
        assertEquals(-11.0, shiftNegative.getLowerBound(), .000000001d);
        assertEquals(-9.0, shiftNegative.getUpperBound(), .000000001d);
    }
    
    //Try a negative amount 
    @Test
    public void shiftNegativeZeroValue() {
        exampleRange = new Range(-1.0, 1.0);
        Range shifted = Range.shift(exampleRange, 0, true);
        assertEquals(-1.0, shifted.getLowerBound(), .000000001d);
        assertEquals(1.0, shifted.getUpperBound(), .000000001d);
    }
    
    //Try a larger amount 
    @Test
    public void shiftLargerZeroFalse() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftLarger = Range.shift(exampleRange, 100.0, false);
        assertEquals(101.0, shiftLarger.getUpperBound(), .000000001d);
        assertEquals(0.0, shiftLarger.getLowerBound(), .000000001d);
    }
    
    //Try a negative amount 
    @Test
    public void shiftNegativeZeroFalse() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftNegative = Range.shift(exampleRange, -10.0, false);
        assertEquals(-11.0, shiftNegative.getLowerBound(), .000000001d);
        assertEquals(0.0, shiftNegative.getUpperBound(), .000000001d);
    }
    
    //Try a negative amount 
    @Test
    public void shiftNegativeZeroValueFalse() {
        exampleRange = new Range(-1.0, 1.0);
        Range shifted = Range.shift(exampleRange, 0, false);
        assertEquals(-1.0, shifted.getLowerBound(), .000000001d);
        assertEquals(1.0, shifted.getUpperBound(), .000000001d);
    }

    //Tests for equals 
    
    //Try two objects that are the same 
    @Test
    public void equalsSame() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.equals(exampleRange));
    }    
    
    //Try two objects that are different 
    @Test
    public void equalsDifferent() {
        exampleRange = new Range(-1.0, 1.0);
        Range equalsTest = new Range(-2, 0);
        assertFalse(exampleRange.equals(equalsTest));
    }
    
    //Try two objects that are different 
    @Test
    public void equalsDifferentUpper() {
        exampleRange = new Range(-1.0, 1.0);
        Range equalsTest = new Range(-1.0, 0);
        assertFalse(exampleRange.equals(equalsTest));
    }
   
    //Try null 
    @Test
    public void equalsNull() {
        assertFalse(exampleRange.equals(null));
    }
    
    //Try two objects that are different 
    @Test
    public void equalsDouble() {
        exampleRange = new Range(-1.0, 1.0);
        assertFalse(exampleRange.equals((Double) 1.5d));
    }
    
    //Try two different objects with the same values 
    @Test
    public void equalsSameValues() {
        exampleRange = new Range(-1.0, 1.0);
        Range equalsTest = new Range(-1, 1);
        assertTrue(exampleRange.equals(equalsTest));
    }
    
   @Test
    public void testClosestLargerValue() {
    	assertEquals( 1, exampleRange.constrain(50), .000000001d);
    }
    
    @Test
    public void testClosestValueInRange() {
    	assertEquals( -0.3, exampleRange.constrain(-0.3), .000000001d);
    }
    
    @Test
    public void testRangeIntersectsUnder() {
    	assertTrue(exampleRange.intersects(-2, 0));
    }
    
    @Test
    public void testRangeDoesNotIntersectUnder() {
    	assertFalse(exampleRange.intersects(-20, -10));
    }
    
    @Test
    public void testRangeIntersectsOver() {
    	assertTrue(exampleRange.intersects(0, 2));
    }
    
    @Test
    public void testRangeDoesNotIntersectOver() {
    	assertFalse(exampleRange.intersects(10, 20));
    }
    
    @Test
    public void testRangeIntersectOnePoint() {
    	assertTrue(exampleRange.intersects(0, 0));
    }
    
    @Test
    public void testRangeIntersectInside() {
    	assertTrue(exampleRange.intersects(0, 0.5));
    }
    
    @Test
    public void testRangeIntersectEngluf() {
    	assertTrue(exampleRange.intersects(-2, 2));
    }
    
    @Test
    public void testRangeIntersectsRangeUnder() {
    	Range testRange = new Range(-2, 0);
    	assertTrue(exampleRange.intersects(testRange));
    }
    
    @Test
    public void testRangeDoesNotIntersectRangeUnder() {
    	Range testRange = new Range(-20, -10);
    	assertFalse(exampleRange.intersects(testRange));
    }
    
    @Test
    public void testRangeIntersectsRangeOver() {
    	Range testRange = new Range(0, 2);
    	assertTrue(exampleRange.intersects(testRange));
    }
    
    @Test
    public void testRangeDoesNotIntersectRangeOver() {
    	Range testRange = new Range(10, 20);
    	assertFalse(exampleRange.intersects(testRange));
    }
    
    @Test
    public void testRangeIntersectRangeOnePoint() {
    	Range testRange = new Range(0, 0);
    	assertTrue(exampleRange.intersects(testRange));
    }
    
    @Test
    public void testRangeIntersectRangeInside() {
    	Range testRange = new Range(0, 0.5);
    	assertTrue(exampleRange.intersects(testRange));
    }
    
    @Test
    public void testRangeIntersectRangeEngluf() {
    	Range testRange = new Range(-2, 2);
    	assertTrue(exampleRange.intersects(testRange));
    }
    
    @Test
    public void testEquals() {
    	exampleRange = new Range(-1.0, 1.0);
    	assertEquals(2 , exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void testHashCode(){
        assertEquals(-31457280,
                exampleRange.hashCode(), 0.000000001d);
    }
    
    // toString
    @Test
    public void testToString() {
    	assertEquals("Range[-1.0,1.0]", exampleRange.toString());
    }
    
    @Test
    public void testToStringNaN() {
    	exampleRange = new Range(Double.NaN, 1);
    	assertEquals("Range[NaN,1.0]", exampleRange.toString());
    }
    
    @Test
    public void testToStringNaNFull() {
    	exampleRange = new Range(Double.NaN, Double.NaN);
    	assertEquals("Range[NaN,NaN]", exampleRange.toString());
    }
    
    @Test
    public void testIsNaNRange() {
    	exampleRange = new Range(-1, 1);
    	assertFalse(exampleRange.isNaNRange());
    }
    
    @Test
    public void testIsNaNRangeOneNanLow() {
    	exampleRange = new Range(Double.NaN, 1);
    	assertFalse(exampleRange.isNaNRange());
    }
    
    @Test
    public void testIsNaNRangeOneNanHigh() {
    	exampleRange = new Range(-1, Double.NaN);
    	assertFalse(exampleRange.isNaNRange());
    }
    
    @Test
    public void testIsNaNRangeTrue() {
    	exampleRange = new Range(Double.NaN, Double.NaN);
    	assertTrue(exampleRange.isNaNRange());
    }
    
    @Test
    public void testCentralvalueSmallNegative() {
    	exampleRange = new Range(-2.0, -1.0);
    	assertEquals(-1.5, exampleRange.getCentralValue(), 0.000000001d);
    }
    
    @Test
    public void testCentralvalueSmallPositive() {
    	exampleRange = new Range(1.0, 2.0);
    	assertEquals(1.5, exampleRange.getCentralValue(), 0.000000001d);
    }
    
    @Test
    public void testCentralvalueSmallPositiveFails() {
    	exampleRange = new Range(1.0, 2.0);
    	assertNotEquals(1.4, exampleRange.getCentralValue(), 0.000000001d);
    }
    
    @Test
    public void testScaleIncrease() {
        Range compareTo = new Range(-2,2);
        assertEquals(compareTo, Range.scale(exampleRange, 2));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testScaleError() {
        Range.scale(exampleRange, -1);
    }
    
    // combine
    @Test
    public void testCombinedEqualFirstNull() {
    	assertEquals(exampleRange, Range.combine(null, exampleRange));
    }
    
    @Test
    public void testCombinedEqualSecondNull() {
    	assertEquals(exampleRange, Range.combine(exampleRange, null));
    }
    
    @Test
    public void testLowerRangeNegative() {
    	Range test = new Range(1, 10);
    	assertEquals(-1, Range.combine(exampleRange, test).getLowerBound(), .000000001d);
    }
    
    @Test
    public void testUpperBoundTwoRange() {
    	Range test = new Range(1, 10);
    	assertEquals(10, Range.combine(exampleRange, test).getUpperBound(), .000000001d);
    }
    
    @Test
    public void testCombineNullAndVariable() {
    	exampleRange = new Range(Double.NaN, Double.NaN);
    	assertNull(Range.combineIgnoringNaN(null, exampleRange));
    }
    
    @Test
    public void testCombineVariableAndNull() {
    	exampleRange = new Range(Double.NaN, Double.NaN);
    	assertNull(Range.combineIgnoringNaN(exampleRange, null));
    }
    
    
    
    
    @Test
    public void testCombineVariableNull() {
    	exampleRange = new Range(Double.NaN, Double.NaN);
    	assertNull(Range.combineIgnoringNaN(exampleRange, exampleRange));
    }
    
    @Test
    public void lowerBoundryOfCombinedRangesIgnoringNaNIsNegOne() {
    	Range test = new Range(0, 2);
    	assertEquals(-1, Range.combineIgnoringNaN(exampleRange, test).getLowerBound(), .000000001d);
    }
    
    @Test
    public void upperBoundryOfCombinedRangesIgnoringNaNIsTwo() {
    	Range test = new Range(0, 30);
    	assertEquals(30, Range.combineIgnoringNaN(exampleRange, test).getUpperBound(), .000000001d);
    }
    
    @Test
    public void testCombineIgnoringNanLowerBound() {
    	exampleRange = new Range(Double.NaN, 1.0);
    	assertEquals(Double.NaN, Range.combineIgnoringNaN(exampleRange, exampleRange).getLowerBound(), .000000001d);
    }
    
    @Test
    public void testCombineIgnoringNanUpperBound() {
    	exampleRange = new Range(-1.0, Double.NaN);
    	assertEquals(Double.NaN, Range.combineIgnoringNaN(exampleRange, exampleRange).getUpperBound(), .000000001d);
    }
    
    @Test
    public void testRangeExpandPositive() {
    	exampleRange = Range.expand(exampleRange, 1.0, 2.0);
    	Range equalRange = new Range(-3.0, 5.0);
    	assertEquals(equalRange, exampleRange);
    }
    
    @Test
    public void testExpands() {
    	exampleRange = new Range(-1.0, 1.0);
    	assertEquals(exampleRange, Range.combineIgnoringNaN(exampleRange, null));
    }
    
    @Test
    public void testExpandToIncludePositveLower() {
    	exampleRange = Range.expandToInclude(null, 1.0);
    	assertEquals(1.0, exampleRange.getLowerBound(), 0.000000001d);
    }
    
    @Test
    public void testExpandToIncludenegativeLower() {
    	exampleRange = Range.expandToInclude(null, -1.0);
    	assertEquals(-1.0, exampleRange.getLowerBound(), 0.000000001d);
    }
    
    @Test
    public void testExpandToIncludenegativeLowerWithRange() {
    	exampleRange = Range.expandToInclude(exampleRange, -2.0);
    	assertEquals(-2.0, exampleRange.getLowerBound(), 0.000000001d);
    }
    
    @Test
    public void testExpandToIncludenegativeUpperWithRange() {
    	exampleRange = Range.expandToInclude(exampleRange, 2.0);
    	assertEquals(2.0, exampleRange.getUpperBound(), 0.000000001d);
    }
    
    @Test
    public void testExpandToIncludePositveUpper() {
    	exampleRange = Range.expandToInclude(null, 2.0);
    	assertEquals(2.0, exampleRange.getUpperBound(), 0.000000001d);
    }
    
    @Test
    public void testExpandToIncludeSame() {
    	exampleRange = Range.expandToInclude(exampleRange, 0.5);
    	assertEquals(1.0, exampleRange.getUpperBound(), 0.000000001d);
    }
	
	//NEWLY ADDED
	
	
  @Test
  public void testCombineIgnoringNaNMin() {
  	exampleRange = new Range(-1.0, 2.0);
  	Range exampleRange2 = new Range(Double.NaN, Double.NaN);
  	assertEquals(exampleRange, Range.combineIgnoringNaN(exampleRange, exampleRange2));
  }
  
  
  @Test
  public void testRangeExpandNegative() {
  	Range exampleRange2 = Range.expand(exampleRange, -2.0, -1.0);
  	Range equalRange = new Range(1.0, 1.0);
  	assertEquals(equalRange, exampleRange2);
  }
	
	//1%
	@Test
    public void testMinNan () {
        Range p1 = new Range (Double.NaN, 8);
        Range p2 = new Range (Double.NaN, 3);
        Range result = Range.combineIgnoringNaN (p1, p2);
        
        if ((!Double.isNaN(result.getLowerBound())) || (result.getUpperBound() != 8.0)) {
            fail();
        }
    }
	
    @Test
    public void testLowerMin () {
        Range param1 = new Range (1,3);
        Range param2 = new Range (0,8);
        Range result = Range.combineIgnoringNaN (param1, param2);
        Range comp = new Range (0, 8);
        assertEquals (comp, result);
    }
    
    //1%
	@Test
	public void intersectrangeFalse() {
		exampleRange = new Range(2, 6);
		double lowerBound = 5;
		double upperBound = 3;
		boolean testBool = exampleRange.intersects(lowerBound, upperBound); 
		assertFalse(testBool);
	}
	
	
	@Test
	public void constrainLowerValue() {
		exampleRange = new Range(2, 6);
		double returnVal = exampleRange.constrain(1);
		assertEquals(2, returnVal, .000000001d);
	}
	
	@Test
	public void combineWithNan() {
		double null1 = Math.sqrt(-1);
		double null2 = Math.sqrt(-2);
		exampleRange = new Range(null1, null2);
		Range returnRange = Range.combineIgnoringNaN(exampleRange, exampleRange); 
		assertNull(returnRange);
	}
	
    @Test
    public void testCombinedNull() {
    	assertNull(Range.combineIgnoringNaN(null, null));
    }
    
    @Test
    public void testClosestSmallValue() {
    	assertEquals( -1, exampleRange.constrain(-50), .000000001d);
    }
    
    @Test
    public void shiftZeroCrossing() {
        exampleRange = new Range(0.0, 1.0);
        Range shiftZero = Range.shift(exampleRange, 0.0, false);
        assertEquals(exampleRange, shiftZero);
    }
	
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}