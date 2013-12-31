package collections.customlinkedlist;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Custom Linked List Implementation.
 * User: rpanjrath
 * Date: 10/29/13
 * Time: 3:35 PM
 */
public class LinkedListImpl implements LinkedList {

    private Link headerLink;
    private Link currentLink;

    public LinkedListImpl() {
        headerLink = null;
        currentLink = null;
    }

    @Override
    public boolean addLink(int data) {
        Link link = new Link(data);
//        link.setRandom(randomObject);
        if (headerLink == null) {
            headerLink = link;
            currentLink = headerLink;
        } else {
            currentLink.setNext(link);
            currentLink = link;
        }
        return true;
    }

    @Override
    public Link cloneLinkedList() {
        HashSet<Link> hashSet = new LinkedHashSet<Link>();
        Link currentLink = headerLink;
        while (currentLink != null) {
            try {
                Link clonedLink = currentLink.clone();
                clonedLink.setNext(null);
                hashSet.add(clonedLink);
                currentLink = currentLink.getNext();
            } catch (CloneNotSupportedException e) {
                System.out.println("Cannot clone linked list.");
                return null;
            }
        }
        recreateLinkedList(hashSet);
        return hashSet.iterator().next();
    }

    @Override
    public Link serializeLinkedList() {
        Link currentLink = headerLink;
        HashSet<Link> hashSet = new LinkedHashSet<Link>();
        while (currentLink != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(currentLink);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Link link = (Link) objectInputStream.readObject();
                hashSet.add(link);
                currentLink = currentLink.getNext();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return hashSet.iterator().next();
    }

    private void recreateLinkedList(HashSet<Link> hashSet) {
        for (int i = 0; i < hashSet.size(); i++) {
            if (i + 1 != hashSet.size())
                ((Link) hashSet.toArray()[i]).setNext((Link) hashSet.toArray()[i + 1]);
            else
                ((Link) hashSet.toArray()[i]).setNext(null);
        }
    }

    @Override
    public Link getHeader() {
        return headerLink;
    }

    @Override
    public void displayLinkedList() {
        Link tempLink = headerLink;
        System.out.print("Header -> ");
        while (tempLink != null) {
            System.out.print(tempLink + " -> ");
            tempLink = tempLink.getNext();
        }
        System.out.print("null");
    }
}
