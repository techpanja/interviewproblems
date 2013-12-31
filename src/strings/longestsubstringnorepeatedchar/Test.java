package strings.longestsubstringnorepeatedchar;

/**
 * Test class
 * User: rpanjrath
 * Date: 11/11/13
 * Time: 1:57 PM
 */
public class Test {

    public static void main(String[] args) {
        String string = "ABCADEABFTR";
//        String string = "rpanjrath";
//        String string = "AABC";
//        String string = "abcdefghijklmnopqrstuvwxyz";
//        String string = "abcdeffffffffghijklmnopq";
//        String string = "abcdefcbhcjklmc";
        System.out.println(LongestSubstringUnrepeatedChar.longestSubstringUnrepeatedChar(string));
    }
}
