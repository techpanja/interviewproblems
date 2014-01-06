package collections.reverselinkedlist;

import collections.customlinkedlist.LinkedList;
import collections.customlinkedlist.LinkedListImpl;

/**
 * Reverse a given linked list. O(2N) time and O(1) space.
 * Logic: Use three pointers: previous, current and next. Keep on advancing the pointers and updating the link.setNext
 * till you hit the end of the linked list.
 * Created by rpanjrath on 1/6/14.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        linkedList.addLink(1);
        linkedList.addLink(2);
        linkedList.addLink(3);
        linkedList.addLink(4);
        linkedList.displayLinkedList();
        linkedList.reverseLinkedListInPlace();
        System.out.println();
        linkedList.displayLinkedList();
        System.out.println();
        linkedList.reverseLinkedListUsingStack();
        linkedList.displayLinkedList();
    }
}
