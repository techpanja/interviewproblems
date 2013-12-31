package collections.findNTHlastelement;

import java.util.LinkedList;

/**
 * Find nth element from end of linked list.
 * E.g. A B C D .. 2nd from last will be C.
 * http://stackoverflow.com/questions/2598348/how-to-find-nth-element-from-the-end-of-a-singly-linked-list
 * User: rpanjrath
 * Date: 9/19/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindNthLastElement {

    public String findNthLastElement(LinkedList<String> stringLinkedList, int positionFromEnd) {
        int counter1 = 0;
        int counter2 = 0;
        if (positionFromEnd > stringLinkedList.size() || positionFromEnd <= 0) {
            return "invalid position for end.";
        }
        for (int i = 1; i < positionFromEnd; i++)
            counter1 = i;
        for (int j = 1; j < stringLinkedList.size(); j++) {
            if (!stringLinkedList.get(counter1++).equals(stringLinkedList.getLast()))
                counter2 = j;
            else
                break;
        }
        return stringLinkedList.get(counter2);
    }
}
