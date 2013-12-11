package trees.model;

/**
 * Binary BinarySearchTree Generic Node.
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 2:37 PM
 */
public class GenericNode extends AbstractNode {

    private String data;

    @Override
    public void displayNode() {
        System.out.println(this.data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
