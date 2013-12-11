package heaps.heap.model;

/**
 * Represents a node in the heap.
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 2:24 PM
 */
public class Node {

    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return this.getData();
    }

    @Override
    public String toString() {
        return String.valueOf(this.getData());
    }
}
