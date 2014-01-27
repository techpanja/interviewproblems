package stackqueues.queueusingstack;

import java.util.Stack;

/**
 * Implement a queue using stack. The idea is to use two stacks.
 * Push everything on stack1.
 * Pop everything from stack1 into push on stack2 if stack2 is not empty.
 * Queue A B C
 *     C      ->       A      ->    A B C
 *     B     pop1      B      pop
 *     A     push2     C
 *  Stack 1         Stack 2
 * User: rpanjrath
 * Date: 9/19/13
 * Time: 1:56 PM
 */
public class QueueUsingStack {

    private Stack<String> stack1 = new Stack<>();
    private Stack<String> stack2 = new Stack<>();

    public void add(String temp) {
        stack1.push(temp);
    }

    public String remove() {
        if (stack2.isEmpty()) {         // V Imp else we can concurrently modify the stacks
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.add("A");
        queueUsingStack.add("B");
        queueUsingStack.add("C");
        System.out.print(queueUsingStack.remove());
        System.out.print(queueUsingStack.remove());
        queueUsingStack.add("D");
        System.out.print(queueUsingStack.remove());
        System.out.print(queueUsingStack.remove());
    }
}
