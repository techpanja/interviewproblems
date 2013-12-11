package strings.findtotalpalindromes;

import strings.checkpalindrome.CheckPalindrome;

/**
 * Find total number of palindromes in a String.
 * For example the input is 'abba' then the possible palindromes= a, b, b, a, bb, ababa. Total: 6
 * User: rpanjrath
 * Date: 11/6/13
 * Time: 1:10 PM
 */
public class FindTotalNoOfPalindromes {

    private FindTotalNoOfPalindromes() {

    }

    public static int findTotalNoOfPalindromes(String inputString) {
        if (inputString.isEmpty()) {
            System.out.print("Invalid input.");
            return -1;
        }
        char[] inputStringArray = inputString.toCharArray();
        int counter = inputStringArray.length;
        for (int i = 0; i < inputStringArray.length; i++) {
            String temp = String.valueOf(inputStringArray[i]);
            for (int j = i + 1; j < inputStringArray.length; j++) {
                temp = temp + inputStringArray[j];
                if(CheckPalindrome.checkPalindromeUsingReversal(temp)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
