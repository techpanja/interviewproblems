package numberproblems.concatenatenumbers;

/**
 * Concatenate two numbers. for e.g. 123, 456 = 123456
 * Created by rpanjrath on 1/3/14.
 */
public class ConcatenateNumbers {

    private ConcatenateNumbers() {

    }

    /*
    * Concatenate x + y
    * */
    public static void concatenateNumbers(long x, long y) {
        long temp = y;
        do {
            temp = temp / 10;
            x = x * 10;
        } while (temp > 0);
        System.out.println(x + y);
    }

    public static void main(String[] args) {
        concatenateNumbers(123, 144);
    }
}
