package strings.firstnonrepeatedchar;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Find first non-repeated character.
 * User: rpanjrath
 * Date: 11/18/13
 * Time: 1:52 PM
 */
public class FirstNonRepeatedChar {

    private FirstNonRepeatedChar() {

    }

    public static char findFirstNonRepeatedChar(String inputString) {
        Map<Character, Integer> charMapCountOne = new LinkedHashMap<Character, Integer>();
        Set<Character> repeatedCharSet = new HashSet<Character>();
        for (char c : inputString.toCharArray()) {
            if (charMapCountOne.get(c) == null && !repeatedCharSet.contains(c)) {
                charMapCountOne.put(c, 1);
            } else {
                repeatedCharSet.add(c);
                charMapCountOne.remove(c);
            }
        }
        if (charMapCountOne.isEmpty()) {
            return " ".charAt(0);
        }
        return charMapCountOne.keySet().iterator().next();
    }

    public static char firstNonRepeatedChar(String inputString) {
        char[] inputChars = inputString.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < inputChars.length; i++) {
            if (set.add(inputChars[i])) {
                for (int j = i + 1; j < inputChars.length; j++) {
                    if (inputChars[i] == inputChars[j]) {
                        break;
                    }
                    if (j == inputChars.length - 1) {
                        return inputChars[i];
                    }
                }
            }
        }
        return " ".charAt(0);
    }

    public static void main(String[] args) {
        System.out.print(FirstNonRepeatedChar.findFirstNonRepeatedChar("faaebbccad"));
        System.out.print(FirstNonRepeatedChar.firstNonRepeatedChar("faaebbccad"));
        System.out.print(FirstNonRepeatedChar.firstNonRepeatedChar("faskdfaskd"));
    }
}
