package numberproblems.factorial;

/**
 * Find no of trailing zeroes.
 * 5  -- 1
 * 10 -- 2
 * 15 -- 3
 * 20 -- 4
 * User: rpanjrath
 * Date: 12/5/13
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class FactorialNoOfTrailingZeroes {

    public static int findTrailingZeroes(int number) {
        return number / 5;
    }

    public static void main(String[] args) {
        System.out.println(findTrailingZeroes(22));
    }
}
