package strings.stringsubsequencecheck;

/**
 * Test sub-sequence
 * User: rpanjrath
 * Date: 11/18/13
 * Time: 5:36 PM
 */
public class TestSubsequence {

    public static void main(String[] args) {
        String parent = "rarij";
        String child = "raj";
        System.out.print(CheckStringSubsequence.isSubsequence(parent, child));
    }
}
