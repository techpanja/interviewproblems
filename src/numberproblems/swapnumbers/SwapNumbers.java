package numberproblems.swapnumbers;

/**
 * Swap two numbers
 * User: rpanjrath
 * Date: 10/28/13
 * Time: 1:08 PM
 */
public class SwapNumbers {

    private SwapNumbers() {

    }

    public static void swapNumbersWithoutTemp(int x, int y) {
        System.out.println("Before swap: x = " + x + " y = " + y);
        x = y - x;
        y = y - x;
        x = x + y;
        System.out.println("After swap: x = " + x + " y = " + y);
    }

    public static void swapNumbersUsingXOR(int x, int y) {
        System.out.println("Before swap: x = " + x + " y = " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap: x = " + x + " y = " + y);

    }
}
