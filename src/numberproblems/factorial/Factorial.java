package numberproblems.factorial;

/**
 * Find factorial of a given number.
 * e.g. 3! = 3 * 2 * 1
 * User: rpanjrath
 * Date: 12/5/13
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Factorial {

    public static long findFactorial(long number) {
        if (number == 1) {
            return 1;
        }
        return findFactorial(number - 1) * number;
    }

    public static void main(String[] args) {
        System.out.println(findFactorial(20));
    }
}
