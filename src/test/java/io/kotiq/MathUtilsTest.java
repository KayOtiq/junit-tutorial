package io.kotiq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		//create new instance
		MathUtils mathUtils = new MathUtils();
		
		int expected = 2;
		int actual = mathUtils.add(1, 1); 
		assertEquals(expected,actual, "Add method should add two number and return correct results"); //message when the test fails
	}
	
	@Test
	void testAddFail() {
		//create new instance
		MathUtils mathUtils = new MathUtils();
		
		int expected = 1;
		int actual = mathUtils.add(1, 1); 
		assertEquals(expected,actual, "Add method adds 2 numbers and validates does not return incorrect results"); //message when the test fails
	}
	
	@Test
	void testComputeCircleRadius() {
		//create new instance
		MathUtils mathUtils = new MathUtils(); //why are we calling this more than once?
		
		//int expected = 10;
		//int actual = 314.1592653589; //removing unnecessary calls
		assertEquals(314.1592653589793,mathUtils.computeCircleArea(10), "Didn't correctly calc area of circle"); //message when the test fails
	}


}
