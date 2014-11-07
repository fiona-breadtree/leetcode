package com.fiona.leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LRUCacheTest {
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
	public void testCapacityOne() {
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		int result = cache.get(2);
		assertEquals(1, result);
		
		cache.set(3, 2);
		
		result = cache.get(1);
		assertEquals(-1, result);
		
		result = cache.get(3);
		assertEquals(2, result);
	}

	@Test
	public void testCapacityTwo() {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		
		int result = cache.get(2);
		assertEquals(1, result);
		
		cache.set(4, 1);
		
		result = cache.get(1);
		assertEquals(-1, result);
		
		result = cache.get(2);
		assertEquals(1, result);
	}
	
	@Test
	public void testCapacityTwo_1() {
		LRUCache cache = new LRUCache(2);
		int result = cache.get(2);
		assertEquals(-1, result);

		cache.set(2, 6);
		
		result = cache.get(1);
		assertEquals(-1, result);
		
		cache.set(1, 5);
		cache.set(1, 2);
		
		result = cache.get(1);
		assertEquals(2, result);
		
		result = cache.get(2);
		assertEquals(6, result);
	}

}
