package heaps.heap;

import heaps.heap.model.Node;

/**
 * Abstract Heap Class.
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 2:29 PM
 */
public abstract class AbstractHeap implements Heap {

    Node[] heapArray;

    private int maxSize;

    private int currentSize;

    protected AbstractHeap() {
    }

    @Override
    public boolean isEmpty() {
        return getCurrentSize() == 0;
    }

    @Override
    public abstract boolean insert(int key);

    @Override
    public abstract Node remove();

    protected abstract Node[] getHeapArray();

    protected abstract int getCurrentSize();

    @Override
    public void displayHeap() {
        String dots = "...............................";
        System.out.println(dots + dots);
        System.out.print("heapArray: ");
        this.currentSize = getCurrentSize();
        this.heapArray = getHeapArray();
        for (int m = 0; m < this.currentSize; m++)
            if (this.heapArray[m] != null) {
                System.out.print(this.heapArray[m].getData() + " ");
            }
            else {
                System.out.print("-- ");
            }
        System.out.println();
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        System.out.println(dots + dots);
        while (this.currentSize > 0) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(" ");
            System.out.print(this.heapArray[j].getData());
            if (++j == this.currentSize)
                break;
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(" ");
        }
        System.out.println("\n" + dots + dots);
    }

    public Node peek() {
        this.heapArray = getHeapArray();
        if (this.heapArray.length > 0)
            return this.heapArray[0];
        return null;
    }
}
