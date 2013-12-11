
package strings.findpermutations;

/**
 * Find permutations (ANAGRAMS) of a string. For e.g. for AB it's AB and BA...
 * User: rpanjrath
 * Date: 9/18/13
 * Time: 4:13 PM
 *
 * How it works??.. Consider input string = ABC... Call trace....
 *
 * find("ABC", "")
 *
 * inputString = ABC
 * prependString = ""
 * i = 0
 * inputString.charAt(i) = A
 * inputStringBuilder = ABC
 * inputStringBuilder.deleteCharAt(i) = BC
 * prependStringBuilder = "".append('A')
 * find(BC, A)
 *
 * inputString = BC
 * prependString = A
 * i = 0
 * inputString.charAt(i) = B
 * inputStringBuilder = BC
 * inputStringBuilder.deleteCharAt(i) = C  .... B deleted from BC
 * prependStringBuilder = "A".append('B')
 * find(C, AB)
 *
 * inputString = C
 * prependString = AB
 * length = 1
 * print AB + C
 * return
 *
 * inputString = BC
 * prependString = A
 * i = 1
 * inputString.charAt(i) = C
 * inputStringBuilder = BC
 * inputStringBuilder.deleteCharAt(i) = B .... C Deleted from BC
 * prependStringBuilder = "A".append('C')
 * find(B, AC)
 *
 * inputString = B
 * prependString = AC
 * length = 1
 * print AC + B
 * return
 *
 * ................. continue
 */
public class FindPermutations {

    public void findPermutations(String inputString) {
        findPermutations(inputString, "");
    }

    private void findPermutations(String inputString, String prependString) {
        if (inputString.length() == 1) {
            System.out.println(prependString + inputString);
            return;
        }
        for (int i = 0; i < inputString.length(); i++) {
            // E.g. Hold 1st character A in 'A'BC in 1st call
            // E.g. Hold 1st character B in 'B'C in 2nd call
            StringBuilder inputStringBuilder = new StringBuilder(inputString);
            inputStringBuilder.deleteCharAt(i);

            // E.g. Prepend will be A in 1st call
            // E.g. Prepend will be AB in 2nd call
            StringBuilder prependStringBuilder = new StringBuilder();
            prependStringBuilder.append(prependString).append(inputString.charAt(i));

            // E.g. call again for (BC, A) in 1st call
            // E.g. call again for (C, AB) in 2nd call
            findPermutations(inputStringBuilder.toString(), prependStringBuilder.toString());
        }
    }
}
