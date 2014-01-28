package numberproblems.productofdigitsequaltonumber;

/**
 * Given a number N, now find the smallest number K such that product of digits of K is equal to N. If there is no such K then return -1.
 * Suppose N = 100, then K = 455
 * N=26, K = -1
 * Created by techpanja
 * Created on 1/27/14 3:10 PM.
 */
public class ProductOfDigitsEqualToNumber {

    private ProductOfDigitsEqualToNumber() {

    }

    public static int productOfDigitsEqualToNumber(int inputNumber) {
        if (0 <= inputNumber && inputNumber <= 9) {
            return inputNumber;
        }
        if (inputNumber < 0) {
            inputNumber = Math.abs(inputNumber);
        }
        int smallestNumber = 0;
        int factor = 1;
        while (inputNumber > 1) {
            for (int i = 9; i > 1; i--) {
                if (inputNumber % i == 0) {
                    inputNumber = inputNumber / i;
                    smallestNumber = smallestNumber + i * factor;
                    factor = factor * 10;
                    if (inputNumber == 1) {
                        return smallestNumber;
                    }
                    break;
                } else if (i == 2) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(productOfDigitsEqualToNumber(28));
    }
}
