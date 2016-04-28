package numberproblems.addbinarynumbers;

/**
 * Description: Given two binary numbers, compute their sum.
 * 0 + 0 = 0
 * 1 + 0 = 1
 * 0 + 1 = 1
 * 1 + 1 = 0 carry: 1
 * 1 + 1 + 1 = 1 carry: 1
 * Author: Tech Panja
 * Date: 4/15/16 10:31 AM.
 */
public class AddBinaryNumbers {

    /**
     * Function that adds 2 binary numbers represented by String and returns it results in String.
     * Assuming only 0's and 1's are passed in number1 and number2.
     */
    private static String addBinaryNumbers(String number1, String number2) {
        int i = number1.length() - 1;
        int j = number2.length() - 1;
        if (i == 0) {
            return number2;
        } else if (j == 0) {
            return number2;
        }
        int carry = 0;
        String result = "";
        while (i >= 0 && j >= 0) {
            if (carry == 0) {
                if (number1.charAt(i) == '0' && number2.charAt(j) == '0') {
                    result = 0 + result;
                    carry = 0;
                } else if (number1.charAt(i) == '0' || number2.charAt(j) == '0') {
                    result = 1 + result;
                    carry = 0;
                } else {
                    result = 0 + result;
                    carry = 1;
                }
            } else {
                if (number1.charAt(i) == '0' && number2.charAt(j) == '0') {
                    result = 1 + result;
                    carry = 0;
                } else if (number1.charAt(i) == '0' || number2.charAt(j) == '0') {
                    result = 0 + result;
                    carry = 1;
                } else {
                    result = 1 + result;
                    carry = 1;
                }
            }
            i--;
            j--;
        }
        if (i == -1 && j == -1 && carry == 1) {
            result = carry + result;
            return result;
        }
        while (i >= 0) {
            if (carry == 0) {
                if (number1.charAt(i) == '0') {
                    result = 0 + result;
                } else {
                    result = 1 + result;
                }
            } else {
                if (number1.charAt(i) == '0') {
                    result = 1 + result;
                    carry = 0;
                } else {
                    result = 0 + result;
                    carry = 1;
                }
            }
            i--;
        }
        while (j >= 0) {
            if (carry == 0) {
                if (number2.charAt(j) == '0') {
                    result = 0 + result;
                } else {
                    result = 1 + result;
                }
            } else {
                if (number2.charAt(j) == '0') {
                    result = 1 + result;
                    carry = 0;
                } else {
                    result = 0 + result;
                    carry = 1;
                }
            }
            j--;
        }
        if (carry == 1) {
            result = 1 + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(addBinaryNumbers("100101", "10101"));
        System.out.println(addBinaryNumbers("11", "00"));
        System.out.println(addBinaryNumbers("110", "001"));
        System.out.println(addBinaryNumbers("1111", "001"));
    }
}
