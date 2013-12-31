package numberproblems.convertstringtonumber;

/**
 * Convert String to Number.
 * User: rpanjrath
 * Date: 10/28/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvertStringToNum {

    private ConvertStringToNum() {

    }

    public static int convertStringToNum(String inputString) {
        int factor = (int) Math.pow(10, inputString.length() - 1);
        int temp1;
        int temp2 = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                temp1 = Character.getNumericValue(inputString.charAt(i)) * factor;
                temp2 = temp1 + temp2;
                factor = factor / 10;
            } else {
                System.out.println("Please enter numbers only");
                return 0;
            }
        }
        return temp2;
    }
}
