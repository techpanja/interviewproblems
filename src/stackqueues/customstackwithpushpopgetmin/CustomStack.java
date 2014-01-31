package stackqueues.customstackwithpushpopgetmin;

/**
 * Custom Stack with push(), pop() and getMin(). O(1) complexity.
 * Created by techpanja
 * Created on 1/30/14 3:10 PM.
 */
public interface CustomStack {

    /*
    * Pushes a value into the stack. O(1)
    * */
    boolean push(Integer integer);

    /*
    * Pops the top value of the stack and returns it.
    * */
    Integer pop();

    /*
    * Returns the top of the stack but doesnt pop it.
    * */
    Integer peek();

    /*
    * Returns the minimum value in the stack.
    * */
    Integer getMinimum();
}
