package strings.checkpalindrome;

import java.util.Stack;

/**
 * a word, phrase, or sequence that reads the same backward as forward, e.g., madam
 * Using Stack
 * Alternate solution is to start at 0 and length - 1 index and compare char at (0 and len - 1), (1 and len - 2) ....
 * Alternate str.equals(new StringBuffer().append(str).reverse().toString()).. reverse and compare 2 strings.
 * User: rpanjrath
 * Date: 9/18/13
 * Time: 3:37 PM
 */
public class CheckPalindrome {

    public boolean checkPalindromeUsingStack(String inputString) {
        boolean isPalindrome = true;
        Stack<Character> tempStack = new Stack<Character>();
        int i, j = 0;
        if (inputString.length() % 2 == 0) {
            i = inputString.length() / 2 - 1;
            j = i + 1;
        } else {
            i = inputString.length() / 2;
            j = i;
        }
        char[] stringArray = inputString.toCharArray();
        if (stringArray[i] != stringArray[j]) {
            isPalindrome = false;
            return isPalindrome;
        }
        for (int k = 0; k < i; k++) {
            tempStack.push(stringArray[k]);
        }
        for (int l = j + 1; l < inputString.length(); l++) {
            if (stringArray[l] == tempStack.pop()) {
                continue;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static boolean checkPalindromeUsingReversal(String inputString) {
        String reverseString = new StringBuilder(inputString).reverse().toString();
        return reverseString.equals(inputString);
    }
}
