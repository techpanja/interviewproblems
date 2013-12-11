package strings.longestsubstringnorepeatedchar;

import java.util.HashMap;
import java.util.Map;

/**
 * Given s string, Find max size of a sub-string, in which no duplicate chars present.
 * Hint: Kadane's algo.
 * User: rpanjrath
 * Date: 11/11/13
 * Time: 10:58 AM
 */
public class LongestSubstringUnrepeatedChar {

    private LongestSubstringUnrepeatedChar() {

    }

    public static String longestSubstringUnrepeatedChar(String inputString) {
        String longestSoFar = "";
        String longestSubstringResult = "";
        if (inputString.isEmpty()) {
            return "";
        }
        if (inputString.length() == 1) {
            return inputString;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < inputString.length(); i++) {
            char currentCharacter = inputString.charAt(i);
            if (longestSoFar.indexOf(currentCharacter) == -1) {
                if (!map.containsKey(currentCharacter)) {
                    map.put(currentCharacter, i);
                }
                longestSoFar = longestSoFar + currentCharacter;
            } else {
                longestSoFar = inputString.substring(map.get(currentCharacter) + 1, i + 1);
                map.put(currentCharacter, i);
            }
            if (longestSoFar.length() > longestSubstringResult.length()) {
                longestSubstringResult = longestSoFar;
            }
        }
        return longestSubstringResult;
    }
}
