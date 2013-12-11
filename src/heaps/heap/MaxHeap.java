package heaps.heap;

import heaps.heap.model.Node;

/**
 * Max heap. It will always have maximum value @root or heapArray[0].
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 2:34 PM
 */
public class MaxHeap extends AbstractHeap {

    private int maxSize;
    private Node[] heapArray;
    private int currentSize;

    public MaxHeap(int maxSize) {
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.heapArray = new Node[maxSize];
    }

    /*
    * Insert @end of heapArray and trickle up until its greater than its parent.
    * */
    @Override
    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node node = new Node(key);
        heapArray[currentSize] = node;
        trickleUp(currentSize);
        currentSize = currentSize + 1;
        return true;
    }

    private void trickleUp(int index) {
        int parentIndex = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && bottom.getData() > heapArray[parentIndex].getData()) {
            // move smaller parent downwards.
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    /*
     * Delete the root which is the max node and return. Replace it with last node
     * in heapArray. Trickle down the node until its smaller than both of its children.
     * Replace it with the smaller of the two children nodes.
    */
    @Override
    public Node remove() {
        Node root = null;
        if (heapArray.length > 0) {
            root = heapArray[0];
            heapArray[0] = heapArray[currentSize - 1];
            trickleDown(0);
            currentSize = currentSize - 1;
        }
        System.out.println("Removing the root---------" + root);
        return root;
    }

    @Override
    protected Node[] getHeapArray() {
        return heapArray;
    }

    @Override
    protected int getCurrentSize() {
        return currentSize;
    }

    private void trickleDown(int index) {
        int largerChildIndex;
        Node top = heapArray[0];
        // while node has atleast one child.
        while (index < currentSize / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            // find the larger child of the left and right child.
            if (rightChildIndex < currentSize &&
                    heapArray[rightChildIndex].getData() > heapArray[leftChildIndex].getData()) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }
            // if parent is greater than the larger child then break.
            if (top.getData() > heapArray[largerChildIndex].getData()) {
                break;
            }
            // shift larger child up
            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex;
        }
        heapArray[index] = top;
    }
}
