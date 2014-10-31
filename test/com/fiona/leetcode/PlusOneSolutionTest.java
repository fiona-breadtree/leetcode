package com.fiona.leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PlusOneSolutionTest {
	@Rule
    public TestCaseName currentTestCaseName = new TestCaseName(this);

    @Before
    public void setUp() throws Exception {
        TestSuite.printTestCaseStart(currentTestCaseName);
    }

    @After
    public void tearDown() {
        TestSuite.printTestCaseEnd(currentTestCaseName);
    }

	@Test
	public void testPlusOne() {
		PlusOneSolution  solution = new PlusOneSolution();
		int[] digits = {9,9,9};
		int[] results = solution.plusOne(digits);
		
		int[] expectedResult = {1,0,0,0};
		assertArrayEquals(expectedResult, results);
	}

}
