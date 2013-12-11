package strings.stringsubsequencecheck;

/**
 * Return true if stringA is subsequence of stringB
 * User: rpanjrath
 * Date: 11/18/13
 * Time: 4:36 PM
 */
public class CheckStringSubsequence {

    private CheckStringSubsequence() {

    }

    public static boolean isSubsequence(String parentString, String childString) {
        if (childString.isEmpty() || parentString.isEmpty() || childString.length() > parentString.length()) {
            return false;
        }
        for (int i = 0; i < parentString.length(); i++) {
            if (parentString.charAt(i) == childString.charAt(0)) {
                childString = childString.substring(1, childString.length());
            }
            if (childString.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
