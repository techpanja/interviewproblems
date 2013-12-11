package trees.model;

/**
 * It represents an individual node in a tree.
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 12:07 PM
 */
public abstract class AbstractNode<T> {

    private T leftChild;
    private T rightChild;

    public T getRightChild() {
        return rightChild;
    }

    protected void setRightChild(T rightChild) {
        this.rightChild = rightChild;
    }

    public T getLeftChild() {
        return leftChild;
    }

    protected void setLeftChild(T leftChild) {
        this.leftChild = leftChild;
    }

    public abstract void displayNode();

}
