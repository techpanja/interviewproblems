package strings.distancebetweenwords;

import java.util.StringTokenizer;

/**
 * Find minimum distance between two words (order preserved) in a big string.
 * For e.g 1. "hello how are you" - distance between "hello" and "you" is 3.
 * e.g 2. "hello how are hello you" - distance is 1
 * e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved.
 * e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 *
 * Hint: Kadane's algorithm
 *
 * Created by techpanja
 * Created on 1/28/14 3:12 PM.
 */
public class DistanceBetweenWords {

    private DistanceBetweenWords() {

    }

    /*
    * Assume words in inputBody are separated by space.
    * */
    public static int findDistanceBetweenWords(String inputBody, String pair1, String pair2) {
        if (inputBody.isEmpty() || pair1.isEmpty() || pair2.isEmpty()) {
            return -1;
        }
        if (pair1.equals(pair2)) {
            return 0;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(inputBody, " ");
        int distance = 0, globalDistance = inputBody.length();
        boolean foundPair1 = false;
        String token = "";
        while (stringTokenizer.hasMoreTokens()) {
            token = stringTokenizer.nextToken();
            if (token.equals(pair1)) {
                distance = 0;
                foundPair1 = true;
            }
            if (foundPair1) {
                distance++;
            }
            if (token.equals(pair2) && foundPair1) {
                globalDistance = Math.min(distance, globalDistance);
            }
        }
        if (globalDistance == inputBody.length()) {
            return -1;
        } else {
            return globalDistance - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findDistanceBetweenWords("hello how are you hello you", "hello", "you"));
        System.out.println(findDistanceBetweenWords("hello how are you hello", "hello", "you"));
        System.out.println(findDistanceBetweenWords("hello how are", "hello", "you"));
        System.out.println(findDistanceBetweenWords("you are how hello", "hello", "you"));
    }
}
