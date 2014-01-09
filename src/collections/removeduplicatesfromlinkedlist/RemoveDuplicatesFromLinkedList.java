package collections.removeduplicatesfromlinkedlist;

import collections.customlinkedlist.Link;
import collections.customlinkedlist.LinkedList;
import collections.customlinkedlist.LinkedListImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicate links from LinkedList.
 * Created by techpanja
 * Created on 1/8/14.
 */
public class RemoveDuplicatesFromLinkedList {

    private RemoveDuplicatesFromLinkedList() {
    }

    /*
    * Removes duplicate from the linkedList and returns the header link.
    * O(N) time and space complexity.
    * */
    public static void removeDuplicatesFromLinkedListUsingSet(LinkedList linkedList) {
        if (linkedList.getHeader() != null) {
            Set<Integer> linkSet = new HashSet<Integer>();
            Link currentLink = linkedList.getHeader();
            Link previousLink = linkedList.getHeader();
            while (currentLink != null) {
                if (!linkSet.add(currentLink.getData())) {
                    previousLink.setNext(currentLink.getNext());
                } else {
                    previousLink = currentLink;
                }
                currentLink = currentLink.getNext();
            }
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        linkedList.addLink(5);
        linkedList.addLink(6);
        linkedList.addLink(7);
        linkedList.addLink(7);
        linkedList.addLink(6);
        linkedList.addLink(8);
        linkedList.addLink(5);
        linkedList.displayLinkedList();
        removeDuplicatesFromLinkedListUsingSet(linkedList);
        System.out.println();
        linkedList.displayLinkedList();
    }
}
