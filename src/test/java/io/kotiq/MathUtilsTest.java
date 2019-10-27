package io.kotiq;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

	//11. Changing default behavior
	@TestInstance(TestInstance.Lifecycle.PER_METHOD)
	
class MathUtilsTest {
	
	MathUtils mathUtils; //part 10 - removing the redundant initialization 
	

	
	@BeforeAll
	static void  beforeAllInit() {
		System.out.println("This will run before all tests in suite");
	}
	
	@BeforeEach  //initializing this will happen in each method
	void init() {
		mathUtils = new MathUtils(); 
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up...");
	}

	@Test
	@DisplayName("Testing Add Method") //part 12 - replaces method name in results to a more readable test name (allows use of spaces)
	void testAdd() {
		//create new instance
		//MathUtils mathUtils = new MathUtils();  //part 10
		
		int expected = 2;
		int actual = mathUtils.add(1, 1); 
		assertEquals(expected,actual, "Add method should add two number and return correct results"); //message when the test fails
	}
	
	@Test
	void testAddFail() {
		//create new instance
		//MathUtils mathUtils = new MathUtils(); //part 10
		
		int expected = 1;
		int actual = mathUtils.add(1, 1); 
		assertNotEquals(expected,actual, "Add method adds 2 numbers and validates does not return incorrect results"); //message when the test fails
	}
	
	@Test
	void testdivide() {
		//create new instance
		//MathUtils mathUtils = new MathUtils(); //part 10
		
		
		//#13 - Assumptions Example
		boolean isServerUp = false;
		Assumptions.assumeTrue(isServerUp);
		
		//this will test if a divide by zero occurs and if the wrong method is thrown
		Assertions.assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw exception");
		
		//Assertions.assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw exception"); //shows incorrect error msg
		
	}
	
	
	@Test
	void testComputeCircleRadius() {
		//create new instance
		MathUtils mathUtils = new MathUtils(); //why are we calling this more than once?
		
		//int expected = 10;
		//int actual = 314.1592653589; //removing unnecessary calls
		assertEquals(314.1592653589793,mathUtils.computeCircleArea(10), "Didn't correctly calc area of circle"); //message when the test fails
	}
	
	@Test
	@DisplayName("multiply method")
	void testMultiply( ) {
		//some code goes here to show failure
		//assertEquals(4, mathUtils.multiply(2, 2), "should return correct method");
		Assertions.assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1))
				);
	}
	
	@Test
	@Disabled //shows as a skipped test. u
	@DisplayName("TDD method showing disble test")
	void testDisabled( ) {
		//some code goes here to show failure
		fail("this test should be disabled");
	}


}
