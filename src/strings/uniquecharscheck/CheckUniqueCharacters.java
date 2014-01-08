package strings.uniquecharscheck;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if a string has all unique characters.
 * Created by techpanja
 * Created on 1/8/14.
 */
public class CheckUniqueCharacters {

    private CheckUniqueCharacters() {
    }

    /*
    * Set doesnt allow duplicates.
    * O(N) solution. O(N) space.
    * */
    public static boolean allUniqueUsingSet(String inputString) {
        Set<Character> characterSet = new HashSet<Character>();
        for (char c : inputString.toCharArray()) {
            if (!characterSet.add(c)) {
                return false;
            }
        }
        return true;
    }

    /*
    * Time: O(N2)
    * Space: O(1)
    * */
    public static boolean allUniqueQuadratic(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i + 1; j < inputString.length(); j++) {
                if (inputString.charAt(i) == inputString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allUniqueUsingSet("techpanja"));
        System.out.println(allUniqueUsingSet("techpanj"));
        System.out.println(allUniqueQuadratic("atechpanj"));
        System.out.println(allUniqueQuadratic("techpanj"));
    }
}
