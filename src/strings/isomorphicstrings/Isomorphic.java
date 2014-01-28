package strings.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic
 * if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all
 * occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters
 * may map to the same letter, but a letter may map to itself.
 * <p/>
 * Example:
 * given "foo", "app"; returns true
 * axy -> boo returns false
 * we can map 'f' -> 'a' and 'o' -> 'p'
 * given "bar", "foo"; returns false
 * we can't map both 'a' and 'r' to 'o'
 * <p/>
 * given "turtle", "tletur"; returns true
 * we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r'
 * <p/>
 * given "ab", "ca"; returns true
 * we can map 'a' -> 'c', 'b' -> 'a'
 * User: rpanjrath
 * Date: 11/7/13
 * Time: 7:55 PM
 */
public class Isomorphic {

    private Isomorphic() {

    }

    public static boolean isIsomorphic(String inputString1, String inputString2) {
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        if (length1 != length2) {
            return false;
        }
        if (length1 == 1) {
            return true;
        }
        Map<Character, Character> characterMap = new HashMap<Character, Character>();
        for (int i = 0; i < length1; i++) {
            if (!characterMap.containsKey(inputString1.charAt(i)) && !characterMap.containsValue(inputString2.charAt(i))) {
                characterMap.put(inputString1.charAt(i), inputString2.charAt(i));
            }
            if (characterMap.get(inputString1.charAt(i)) == null) {
                return false;
            }
            if (!characterMap.get(inputString1.charAt(i)).equals(inputString2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphicUsingPattern(String inputString1, String inputString2) {
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        if (length1 != length2) {
            return false;
        }
        if (length1 == 1) {
            return true;
        }
        Map<Character, Integer> characterMap1 = new HashMap<>();
        Map<Character, Integer> characterMap2 = new HashMap<>();
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < length1; i++) {
            char char1 = inputString1.charAt(i);
            char char2 = inputString2.charAt(i);

            if (characterMap1.get(char1) == null) {
                characterMap1.put(char1, i);
                stringBuilder1.append(i);
            } else {
                stringBuilder1.append(char1);
            }

            if (characterMap2.get(char2) == null) {
                characterMap2.put(char2, i);
                stringBuilder2.append(i);
            } else {
                stringBuilder2.append(char2);
            }

            if (!stringBuilder1.toString().equalsIgnoreCase(stringBuilder2.toString())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Isomorphic.isIsomorphic("foo", "bar"));
        System.out.println(Isomorphic.isIsomorphic("bar", "foo"));
        System.out.println(Isomorphic.isIsomorphicUsingPattern("foo", "bar"));
        System.out.println(Isomorphic.isIsomorphicUsingPattern("bar", "foo"));
        System.out.println(Isomorphic.isIsomorphic("turtle", "tletur"));
        System.out.println(Isomorphic.isIsomorphic("tletur", "turtle"));
        System.out.println(Isomorphic.isIsomorphicUsingPattern("turtle", "tletur"));
        System.out.println(Isomorphic.isIsomorphicUsingPattern("tletur", "turtle"));
    }

}
