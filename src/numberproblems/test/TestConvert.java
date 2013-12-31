package numberproblems.test;

import numberproblems.convertstringtonumber.ConvertStringToNum;

/**
 * Test class for string to int conversion.
 * User: rpanjrath
 * Date: 10/28/13
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestConvert {

    public static void main(String[] args) {
        int i = ConvertStringToNum.convertStringToNum("123A");
        System.out.println(i);
    }
}
