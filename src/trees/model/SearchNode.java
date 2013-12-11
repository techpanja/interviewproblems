package trees.model;

/**
 * Binary Search BinarySearchTree AbstractNode.
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 1:24 PM
 */
public class SearchNode extends AbstractNode {

    private int data;

    protected SearchNode() {

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println(this.getData());
    }

    @Override
    public String toString() {
        return String.valueOf(this.getData());
    }
}
