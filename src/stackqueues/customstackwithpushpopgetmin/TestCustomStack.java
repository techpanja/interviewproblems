package stackqueues.customstackwithpushpopgetmin;

/**
 * Test class for custom stack.
 * Created by techpanja
 * Created on 1/30/14 3:21 PM.
 */
public class TestCustomStack {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStackImpl(5);
        customStack.push(5);
        customStack.push(3);
        customStack.push(2);
        customStack.push(8);
        System.out.println("Stack: " + customStack);
        System.out.println("Min: "+ customStack.getMinimum());
        System.out.println("Pop: " + customStack.pop());
        System.out.println("Stack: " + customStack);
        System.out.println("Min: "+ customStack.getMinimum());
        System.out.println("Pop: " + customStack.pop());
        System.out.println("Stack: " + customStack);
        System.out.println("Min: "+ customStack.getMinimum());
        System.out.println("Pop: " + customStack.pop());
        System.out.println("Stack: " + customStack);
        System.out.println("Min: "+ customStack.getMinimum());
        customStack.push(1);
        System.out.println("Stack: " + customStack);
        System.out.println("Min: "+ customStack.getMinimum());

    }
}
