package strings.findlongestpalindrome;

import strings.checkpalindrome.CheckPalindrome;

/**
 * Find longest palindrome string in a given input string.
 * User: rpanjrath
 * Date: 9/18/13
 * Time: 5:53 PM
 */
public class FindLongestPalindrome {

    public static String findLongestPalindrome(String inputString) {
        if (inputString.isEmpty()) {
            System.out.print("Invalid input.");
            return "";
        }
        char[] inputStringArray = inputString.toCharArray();
        String longestPalindrome = "";
        for (int i = 0; i < inputStringArray.length; i++) {
            String temp = String.valueOf(inputStringArray[i]);
            for (int j = i + 1; j < inputStringArray.length; j++) {
                temp = temp + inputStringArray[j];
                if(CheckPalindrome.checkPalindromeUsingReversal(temp)) {
                    if (temp.length() > longestPalindrome.length()) {
                        longestPalindrome = temp;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    //TODO come up with better solution
}
