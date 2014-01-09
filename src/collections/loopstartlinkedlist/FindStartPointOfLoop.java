package collections.loopstartlinkedlist;

import collections.customlinkedlist.LinkedList;
import collections.customlinkedlist.LinkedListImpl;

/**
 * Find the loop starting point in a LinkedList if it contains loop.
 *
 * Algo:-
 * 1. Create two pointers slow and fast.
 * 2. At each iteration, slow jumps once and fast jumps twice.
 * 3. When they collide (if linked list contains loop), move slow to linked list header. Don't move fast.
 * 4. Now move slow and fast at the rate of one jump. When they collide, the collision point is the start of loop.
 *
 * Created by: techpanja
 * Created on: 1/9/14
 */
public class FindStartPointOfLoop {

    private FindStartPointOfLoop() {

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        linkedList.addLink(5);
        linkedList.addLink(6);
        linkedList.addLink(7);
        linkedList.addLink(8);
        // 5 -> 6 -> 7 ->8 ->6
        linkedList.getTail().setNext(linkedList.getHeader().getNext());
        System.out.println();
        System.out.println(linkedList.findLoopStart());
    }
}
