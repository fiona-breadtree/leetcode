package com.fiona.leetcode;

/**
 * @author fiona
 * https://oj.leetcode.com/problems/plus-one/
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOneSolution {
	
    public int[] plusOne(int[] digits) {
    	int[] newDigits = null;
    	int newLength = 0;
    	int pre = 0;
    	
        for (int i = digits.length - 1; i >= 0; i--) {
        	if ( i == digits.length - 1) {
        		digits[i] += (1 + pre);
        	} else {
        		digits[i] += pre;
        	}
        	pre = 0;
        	if (digits[i]/10 > 0) {
        		pre = digits[i]/10;
        		digits[i] = digits[i] % 10;
         	}
        }
        if (pre > 0) {
        	newLength = digits.length + 1;
        } else {
        	newLength = digits.length;
        }
        newDigits = new int[newLength];
        int offset = 0;
        if (pre > 0) {
        	offset = 1;
        	newDigits[0] = pre;
        }
        for (int i= offset; i < newLength; i++) {
        	newDigits[i] = digits[i-offset];
        }
        return newDigits;
    }
    
    
}
