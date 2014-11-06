
/**
* https://oj.leetcode.com/problems/reverse-words-in-a-string/
* Given an input string, reverse the string word by word.
* 
* For example,
* Given s = "the sky is blue",
* return "blue is sky the".
* 
* 
* Clarification:
* 
* What constitutes a word?
*   A sequence of non-space characters constitutes a word.
* Could the input string contain leading or trailing spaces?
*    Yes. However, your reversed string should not contain leading or trailing spaces.
* How about multiple spaces between two words?
*   Reduce them to a single space in the reversed string.
* 
* @author fiona              
*/

package com.fiona.leetcode;

public class ReverseWordsInAStr {
	public String reverseWords(String s) {
		byte[] strBytes = s.getBytes();

		String calculatedResult = "";
		int beginIndex = -1 , endIndex = 0; 
		int offset = 0;
		boolean isBlank = false;
		
		for (int i = 0; i < strBytes.length; i++) {
			isBlank = false;
			offset = 0;
			if (strBytes[i] == ' ' || i ==  (strBytes.length - 1) ) {
				if (strBytes[i] == ' ') {
					isBlank = true;
				}
				endIndex = i;
				if (endIndex - beginIndex == 1 && isBlank) {
					beginIndex++;
					continue;
				}
			
				if (isBlank) {
					offset = 1;
				}

				String tmp = new String(strBytes, beginIndex+1, (i- beginIndex - offset));

				if (calculatedResult.isEmpty()) {
					calculatedResult = tmp;
				} else {
					calculatedResult = tmp + " " + calculatedResult; 
				}
				
				beginIndex = endIndex;
			} 
		}
		
		return calculatedResult;
		
    }
	
}
