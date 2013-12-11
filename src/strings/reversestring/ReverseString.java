package strings.reversestring;

import java.util.Stack;

/**
 * Reverse a string using DS or in-place.
 * User: rpanjrath
 * Date: 11/4/13
 * Time: 12:57 PM
 */
public class ReverseString {

    private ReverseString() {

    }

    /*
    * Do not use additional data structure.
    * */
    public static void reverseStringInPlace(String inputString) {
        int i = 0;
        int j = inputString.length() - 1;
        if (inputString.isEmpty()) {
            System.out.println("Please enter a valid string.");
        } else if (i == j) {
            System.out.println(inputString);
        } else {
            System.out.println("Original String: " + inputString);
            StringBuilder stringBuilder = new StringBuilder(inputString);
            while (i < j) {
                stringBuilder.setCharAt(i, inputString.charAt(j));
                stringBuilder.setCharAt(j, inputString.charAt(i));
                i++;
                j--;
            }
            System.out.println("Reversed String: " + stringBuilder.toString());
        }
    }

    public static void reverseStringUsingStack(String inputString) {
        if (inputString.isEmpty()) {
            System.out.println("Please enter a valid string.");
        } else if (inputString.length() == 1) {
            System.out.println(inputString);
        } else {
            Stack<Character> stack = new Stack<Character>();
            String reverseString = "";
            int counter = 0;
            while (counter < inputString.length()) {
                stack.push(inputString.charAt(counter));
                counter++;
            }
            while (!stack.isEmpty()) {
                reverseString = reverseString + stack.pop();
            }
            System.out.println("Original String: " + inputString);
            System.out.println("Reversed String: " + reverseString);
        }
    }
}
