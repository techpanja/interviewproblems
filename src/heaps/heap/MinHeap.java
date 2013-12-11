package heaps.heap;

import heaps.heap.model.Node;

/**
 * Min heap. It will always have minimum value @root or heapArray[0].
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 5:03 PM
 */
public class MinHeap extends AbstractHeap {

    private int maxSize;
    private int currentSize;
    private Node[] heapArray;

    public MinHeap(int maxSize) {
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.heapArray = new Node[maxSize];
    }

    /*
    * Insert @end of heapArray and trickle up until its less than its parent.
    * */
    @Override
    public boolean insert(int key) {
        //TODO IMPLEMENT INSERT
        if (currentSize == maxSize) {
            return false;
        }
        return false;
    }

    /*
     * Delete the root which is the min node and return. Replace it with last node
     * in heapArray. Trickle down the node until its greater than both of its children.
     * Replace it with the greater of the two children nodes.
    */

    @Override
    public Node remove() {
        //TODO IMPLEMENT REMOVE
        return null;
    }

    @Override
    protected Node[] getHeapArray() {
        return heapArray;
    }

    @Override
    protected int getCurrentSize() {
        return currentSize;
    }
}
