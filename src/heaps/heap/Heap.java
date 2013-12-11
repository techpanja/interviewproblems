package heaps.heap;

import heaps.heap.model.Node;

/**
 * Complexity: Find min/max: O(1), Delete: O(log N), INSERT: O(log N)
 * Space: O(N)
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 2:25 PM
 */
public interface Heap {

    /*
    * Checks if the heap is empty
    * */
    boolean isEmpty();

    /*
    * Inserts a node into the heap
    * */
    boolean insert(int key);

    /*
    * Removes the root of the heap.
    * */
    Node remove();

    /*
    * Different from remove. It doesn't remove the root node just returns its value.
    * */
    Node peek();

    /*
    * Displays the heap
    * */
    void displayHeap();

}
