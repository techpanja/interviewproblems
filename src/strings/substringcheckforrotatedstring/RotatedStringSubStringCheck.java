package strings.substringcheckforrotatedstring;

/**
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g.,"panjatech" is a rotation of "techpanja").
 * Time Complexity: O(N)
 * Created by techpanja
 * Created on 1/8/14.
 */
public class RotatedStringSubStringCheck {

    private RotatedStringSubStringCheck() {}

    public static boolean isRotatedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s1 = s1 + s1;
        return isSubString(s1, s2);
    }

    /*
    * Checks if string s2 is a substring of string s1
    * */
    private static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isRotatedString("techpanja", "panjatech"));
        System.out.println(isRotatedString("techpanja", "panja"));
        System.out.println(isRotatedString("abcd", "dabc"));
    }
}
