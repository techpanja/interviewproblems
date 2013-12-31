package stackqueues.test;

import stackqueues.queueusingstack.QueueUsingStack;

/**
 * Test class
 * User: rpanjrath
 * Date: 9/19/13
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStackQueue {

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
