package strings.distancebetweenwords;

import java.util.StringTokenizer;

/**
 * Find minimum distance between two words (order preserved) in a big string.
 * For e.g 1. "hello how are you" - distance between "hello" and "you" is 3.
 * e.g 2. "hello how are hello you" - distance is 1
 * e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved.
 * e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 * <p/>
 * Follow-up: What if the order of two input words i.e. pair1 and pair2 need not be preserved.
 * <p/>
 * Hint: Kadane's algorithm
 * <p/>
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
        int distance = 0, globalDistance = Integer.MAX_VALUE;
        String token;
        while (stringTokenizer.hasMoreTokens()) {
            token = stringTokenizer.nextToken();
            if (token.equals(pair1)) {
                distance = 0;
            } else if (token.equals(pair2)) {
                globalDistance = Math.min(distance, globalDistance);
            }
            distance++;
        }
        if (globalDistance == Integer.MAX_VALUE || globalDistance == 0) {
            return -1;
        } else {
            return globalDistance;
        }
    }

    /*
    * Input pair can be considered in any order. For e.g. "A B C D A" - Min distance between A and D is 1. With order
    * preserved it would have been 3.
    * */
    public static int findDistanceBetweenWordsUnOrdered(String inputBody, String pair1, String pair2) {
        if (inputBody.isEmpty() || pair1.isEmpty() || pair2.isEmpty()) {
            return -1;
        }
        if (pair1.equals(pair2)) {
            return 0;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(inputBody, " ");
        int distance = 0, globalDistance = Integer.MAX_VALUE;
        String previous = "";
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (previous.isEmpty()) {
                if (token.equalsIgnoreCase(pair1) || token.equalsIgnoreCase(pair2)) {
                    previous = token;
                }
            } else if (token.equalsIgnoreCase(pair1) || token.equalsIgnoreCase(pair2)) {
                if (!token.equalsIgnoreCase(previous)) {
                    globalDistance = Math.min(globalDistance, distance);
                    previous = token;
                }
                distance = 0;
            }
            distance++;
        }
        // None of the pairs were found in inputBody.
        if (previous.isEmpty() || globalDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return globalDistance;

    }

    public static void main(String[] args) {
        System.out.println(findDistanceBetweenWords("hello how are you hello you", "hello", "you"));
        System.out.println(findDistanceBetweenWords("hello how are you hello", "how", "you"));
        System.out.println(findDistanceBetweenWords("hello how are", "hello", "you"));
        System.out.println(findDistanceBetweenWords("you are how hello", "hello", "you"));
        System.out.println(findDistanceBetweenWordsUnOrdered("you are how hello a c you hello", "hello", "you"));
        System.out.println(findDistanceBetweenWordsUnOrdered("you are how hello a c you hello", "you", "hello"));
        System.out.println(findDistanceBetweenWordsUnOrdered("you are how hello", "you", "hello"));
        System.out.println(findDistanceBetweenWordsUnOrdered("you are how hello", "you", "a"));
    }
}
