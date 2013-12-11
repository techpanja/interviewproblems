package heaps.test;

import heaps.heap.Heap;
import heaps.heap.MaxHeap;

/**
 * Test class for max heap
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 2:51 PM
 */
public class TestMaxHeap {

    public static void main(String[] args) {
        Heap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(9);
        maxHeap.insert(19);
        maxHeap.insert(50);
        maxHeap.insert(23);
        maxHeap.insert(98);
        maxHeap.displayHeap();
        System.out.println();
        System.out.println("Root or max of heap:-------- " + maxHeap.peek());
        maxHeap.remove();
        maxHeap.displayHeap();
        System.out.println("Root or max of heap:-------- " + maxHeap.peek());
        maxHeap.remove();
        maxHeap.displayHeap();
        System.out.println("Root or max of heap:-------- " + maxHeap.peek());
        maxHeap.remove();
        maxHeap.displayHeap();
        System.out.println("Root or max of heap:-------- " + maxHeap.peek());
        maxHeap.remove();
        maxHeap.displayHeap();
        System.out.println("Root or max of heap:-------- " + maxHeap.peek());
    }
}
