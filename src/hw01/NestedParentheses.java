package hw01;

import static org.junit.Assert.*;
import org.junit.Test;

public class NestedParentheses {
    /**
	 * Check if the parentheses in the string str are properly nested. For
	 * example:
	 * 
	 * (()) - proper 
	 * 
	 * (() - not proper
	 * 
	 * An empty string is also considered to be a valid nesting.
	 * 
	 * @param str a string containing only the characters ( or ).
	 * @return true if the nesting is valid and false if not.
	 */
    public static boolean validNesting(String str) {
		return validNesting("",str);

	}

	private static boolean validNesting(String head, String rest){


		String newHead = "";
		if (rest.length() == 0){
			return true;
		} else {
			if (rest.length() % 2 == 0){
				int strLen = rest.length();
				String first = rest.substring(0,1);
				newHead = newHead + first;
				String last = rest.substring(strLen - 1,strLen);
				newHead = newHead + last;
				String subString = rest.substring(1,strLen - 1);
				System.out.println(subString);
				if (newHead.equals("()")) {
					return validNesting(head, subString);
				} 
			}
			return false;
	}

}

public static void main(String[] args){

	NestedParentheses p1 = new NestedParentheses();
	System.out.println(p1.validNesting("()"));

}


    @Test
	public void testEmptyString() {
		assertTrue("Incorrect result on empty string.", validNesting(""));
	}
	
	@Test
	public void testOneSetValid() {
		assertTrue("Incorrect result on ().", validNesting("()"));
	}
	
	@Test
	public void testLeftParenInvalid() {
		assertFalse("Incorrect result on (.", validNesting("("));
	}
	
	@Test
	public void testRightParenInvalid() {
		assertFalse("Incorrect result on ).", validNesting(")"));
	}
	
	@Test
	public void testTwoLeftInvalid() {
		assertFalse("Incorrect result on ((.", validNesting("(("));
	}
	
	@Test
	public void testTwoRightnvalid() {
		assertFalse("Incorrect result on ((.", validNesting("))"));
	}
	
	@Test
	public void testRightLefttnvalid() {
		assertFalse("Incorrect result on )(.", validNesting(")("));
	}
	
	@Test
	public void testMultipleValid() {
		assertTrue("Incorrect result on ((())).", validNesting("((()))"));
	}
	
	@Test
	public void testMultipleInvalid() {
		assertFalse("Incorrect result on ((((())).", validNesting("((((()))"));
	}
}
