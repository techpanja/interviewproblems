package numberproblems.findmissingnumber;

/**
 * Find missing number in stream of numbers 1 to N.
 * User: rpanjrath
 * Date: 10/28/13
 * Time: 12:10 PM
 *
 */
public class FindMissingNumber {

    private FindMissingNumber() {

    }

    // does not work for zero.
    public static int findMissingNumberUsingXOR(int[] inputArray) {
        int xor1 = 1;
        int xor2 = inputArray[0];
        int length = inputArray.length;
        for (int i = 2; i <= length + 1; i++) {
            xor1 = xor1 ^ i;
        }
        for (int i = 1; i < length; i++) {
            xor2 = xor2 ^ inputArray[i];
        }
        return xor1 ^ xor2;
    }

    // does not work for zero.
    public static int findMissingNumberUsingFormula(int[] inputArray) {
        int sum = 0;
        for (int i : inputArray) {
            sum = i + sum;
        }
        // actual size of array is length + 1 since one number is missing.
        int length = inputArray.length + 1;
        int factor = length * (length + 1) / 2;
        return  factor - sum;
    }
}
