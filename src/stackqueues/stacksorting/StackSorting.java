package stackqueues.stacksorting;

import java.util.Stack;

/**
 * Sort a stack using only one additional stack and no other data structure.
 * Created by techpanja
 * Created on 1/19/14 7:54 PM.
 */
public class StackSorting {

    private StackSorting() {

    }

    public static Stack<Integer> sortStack(Stack<Integer> inputStack) {
        if (inputStack.empty()) {
            return new Stack<>();
        }
        Stack<Integer> tempStack = new Stack<>();
        while (!inputStack.empty()) {
            int temp = inputStack.pop();
            if (tempStack.empty()) {
                tempStack.push(temp);
            } else {
                while (!tempStack.empty() && tempStack.peek() > temp) {
                    inputStack.push(tempStack.pop());
                }
                tempStack.push(temp);
            }
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(5);
        inputStack.push(4);
        inputStack.push(7);
        inputStack.push(7);
        inputStack.push(6);
        inputStack.push(9);
        inputStack.push(9);
        inputStack.push(1);
        inputStack.push(11);
        Stack<Integer> stack = sortStack(inputStack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
