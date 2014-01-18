package numberproblems.exponentialnumber;

/**
 * Find exponential of a number in fastest time.
 * For e.g. 2^2 = 4, 2^4 = 16, 2^6 = 64
 * 2^1 = 2, 2^3 = 8, 2^5 = 32
 * <p/>
 * Created by techpanja
 * Created on 1/17/14 3:35 PM.
 */
public class ExponentialOfNumber {

    private ExponentialOfNumber() {

    }

    /*
    * Exponentfactor must be positive.
    * */
    public static int findExponentialOfNumber(int number, int exponentFactor) {
        int result = 1;
        while (exponentFactor > 0) {
            if (exponentFactor % 2 == 1) {
                result = result * number;
            }
            exponentFactor = exponentFactor / 2;
            number *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findExponentialOfNumber(4, 4));
        System.out.println(findExponentialOfNumber(2, 3));
        System.out.println(findExponentialOfNumber(2, 6));
        System.out.println(findExponentialOfNumber(3, 3));
    }
}
