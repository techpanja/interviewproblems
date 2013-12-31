package collections.customlinkedlist;

/**
 * Linked List Interface
 * User: rpanjrath
 * Date: 10/29/13
 * Time: 3:36 PM
 */
public interface LinkedList {

    /*
    * adds a link into the linked list.
    * */
    boolean addLink(int data);

    /*
    * Clones a linked list and returns the head of the list.
    * Uses Cloneable.
    * */
    Link cloneLinkedList();

    /*
    * Clones a linked list using Serializable.
    * */
    Link serializeLinkedList();

    /*
    * Returns the head of linked list.
    * */
    Link getHeader();

    void displayLinkedList();



//    boolean addLink(int data, Object randomObject);
}
