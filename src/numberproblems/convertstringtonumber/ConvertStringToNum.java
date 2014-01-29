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
        boolean isNegative = false;
        if (inputString.charAt(0) == '-') {
            isNegative = true;
            inputString = inputString.substring(1, inputString.length());
        }
        if (inputString.isEmpty()) {
            return -1;
        }
        int temp = 0;
        int factor = (int) Math.pow(10, inputString.length() - 1);
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                temp = Character.getNumericValue(inputString.charAt(i)) * factor + temp;
                factor = factor / 10;
            } else {
                System.out.print("Please enter numbers only. ");
                return -1;
            }
        }
        if (isNegative) {
            return -temp;
        }
        return temp;
    }

    public static void main(String[] args) {
            System.out.println(convertStringToNum("0"));
            System.out.println(convertStringToNum("123"));
            System.out.println(convertStringToNum("-34123"));
            System.out.println(convertStringToNum("-341A23"));
            System.out.println(convertStringToNum("AVC"));
    }
}
