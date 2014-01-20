package numberproblems.oddoreven;

/**
 * Check if a given number is odd or even without the use of following operators: / % + - *
 * Created by techpanja
 * Created on 1/20/14 1:06 PM.
 */
public class OddOrEven {

    private OddOrEven() {

    }

    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEven(4));
        System.out.println(isEven(9));
        System.out.println(isEven(3455));
        System.out.println(isEven(29));
        System.out.println(isEven(0));
    }
}
