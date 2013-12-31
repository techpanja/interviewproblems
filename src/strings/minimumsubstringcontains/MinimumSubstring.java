package strings.minimumsubstringcontains;

import java.util.ArrayList;
import java.util.List;

/**
 * Find min substring that contains all the char of target string.
 * User: rpanjrath
 * Date: 11/22/13
 * Time: 6:49 PM
 */
//TODO incomplete solution.
public class MinimumSubstring {

    private MinimumSubstring() {

    }

    public static String findMinimumSubstring(String parentString, String targetString) {
        int startWindow = 0;
        int endWindow = 0;
        int currentPosition = 0;
        for (int i = currentPosition; i < parentString.length(); i++) {
            if (targetString.indexOf(parentString.charAt(i)) != -1) {

            }
        }
        return "";
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("r");
        list.add("p");
        list.add("c");
        findMinimumSubstring("nayan", "nay");
    }
}
