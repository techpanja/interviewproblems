package objects.cloning.test;

import objects.cloning.linkedlistcloning.Link;
import objects.cloning.linkedlistcloning.LinkedList;
import objects.cloning.linkedlistcloning.LinkedListImpl;

/**
 * Test class for linked list
 * User: rpanjrath
 * Date: 10/29/13
 * Time: 3:51 PM
 */
public class TestLinkedList {

    private static final String HASH_CODE = " HashCode: ";

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        linkedList.addLink(5);
        linkedList.addLink(6);
        linkedList.addLink(7);
        linkedList.addLink(8);
        System.out.println();
        linkedList.displayLinkedList();
        System.out.println();
        System.out.println();
        System.out.println("-------------------------Before cloning:------------------------");
        System.out.println("Header: " + linkedList.getHeader());
        System.out.println("Header" + HASH_CODE + linkedList.getHeader().hashCode());
        System.out.println("Header's next" + HASH_CODE + linkedList.getHeader().getNext().hashCode());
        System.out.println("Header's next next" + HASH_CODE + linkedList.getHeader().getNext().getNext().hashCode());
        System.out.println();
        System.out.println();
        System.out.println("-------------------------After cloning:-------------------------");
        Link clonedHeaderLink = linkedList.cloneLinkedList();
//        Link clonedHeaderLink = linkedList.serializeLinkedList();
        System.out.println("Header: " + clonedHeaderLink);
        System.out.println("Header" + HASH_CODE + clonedHeaderLink.hashCode());
        System.out.println("Header's next" + HASH_CODE + clonedHeaderLink.getNext().hashCode());
        System.out.println("Header's next next" + HASH_CODE + clonedHeaderLink.getNext().getNext().hashCode());
    }
}
