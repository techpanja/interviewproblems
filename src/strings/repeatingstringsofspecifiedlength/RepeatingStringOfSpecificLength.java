package strings.repeatingstringsofspecifiedlength;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Identify all the 'n' (n will be input) letter-long sequences that occur more than once in
 * any given input string.  Write a program that prints out all such sequences to the standard output stream,
 * sorted in alphabetical order.
 *
 * This question can be twisted and asked as: "Find repeating sequences of specified length in given dna
 * chromosome sequence."
 *
 * Created by techpanja
 * Created on 1/21/14 3:37 PM.
 */
public class RepeatingStringOfSpecificLength {

    public static void printRepeatingStrings(String inputString, int sequenceLength) {
        if (inputString.isEmpty() || sequenceLength <= 0 || sequenceLength >= inputString.length()) {
            System.out.println("Invalid input");
        } else {
            int i = 0;
            int j = i + sequenceLength;
            Set<String> tempSet = new HashSet<>();
            Set<String> repeatingSequences = new TreeSet<>();
            while (j <= inputString.length()) {
                if (!tempSet.add(inputString.substring(i, j))) {
                    repeatingSequences.add(inputString.substring(i, j));
                }
                i++;
                j = i + sequenceLength;
            }
            for (String str : repeatingSequences) {
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {
        printRepeatingStrings("ABABC", 2);
        printRepeatingStrings("ABABBABBZEDZEDZE", 3);
        printRepeatingStrings("AAGATCCGTCCCCCCAAGATCCGTC", 10);
    }
}
