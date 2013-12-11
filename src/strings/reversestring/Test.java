package strings.reversestring;

import java.util.Scanner;

/**
 * Test class.
 * User: rpanjrath
 * Date: 11/4/13
 * Time: 1:06 PM
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("Enter a string: ");
            input = scanner.next();
            if (input.equalsIgnoreCase("exit")) {
                System.exit(1);
            }
//            ReverseString.reverseStringInPlace(input);
            ReverseString.reverseStringUsingStack(input);
        }
    }
}
