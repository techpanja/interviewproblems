package collections.detectlinkedlistloop;

import collections.customlinkedlist.LinkedList;
import collections.customlinkedlist.LinkedListImpl;

/**
 * Check if a linked list has loops.
 * http://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
 *
 * Created by rpanjrath on 12/30/13.
 */
public class DetectLinkedListLoop {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        linkedList.addLink(5);
        linkedList.addLink(6);
        linkedList.addLink(7);
        linkedList.addLink(8);
        linkedList.displayLinkedList();
        System.out.println();
        System.out.println(linkedList.hasLoop());
        linkedList.getTail().setNext(linkedList.getHeader());
        System.out.println(linkedList.hasLoop());
    }

}
