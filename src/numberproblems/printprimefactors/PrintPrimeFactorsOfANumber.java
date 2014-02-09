package numberproblems.printprimefactors;

/**
 * Given a number n print prime factors of the number.
 * For e.g. n = 4, factors = 2 2
 * n = 12, factors = 2 2 3
 * User: techpanja
 * Date: 2/8/14
 * Time: 6:08 PM
 */
public class PrintPrimeFactorsOfANumber {

    private PrintPrimeFactorsOfANumber() {

    }

    public static void printPrimeFactorsOfNumber(int inputNumber) {
        for (int i = 2; i <= inputNumber / 2; i++) {
            while (inputNumber % i == 0) {
                System.out.print(i + " ");
                inputNumber = inputNumber / i;
            }
        }
        if (inputNumber > 1) {
            System.out.print(inputNumber);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printPrimeFactorsOfNumber(18);
        printPrimeFactorsOfNumber(8);
        printPrimeFactorsOfNumber(9);
        printPrimeFactorsOfNumber(100);
    }
}
