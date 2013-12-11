package trees.model;

import java.util.List;

/**
 * BinarySearchTree Interface.
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 12:08 PM
 */
public interface BinarySearchTree<T> {

    void insertNode(T data);

    /*
    * Smaller are inserted in the right unlike regular BT.
    * */
    void insertNodeReverseOrder(T data);

    List traverseTree(TraverseType traverseType);

    AbstractNode retrieveTree();

    StringBuilder traverseTreeInString(TraverseType traverseType);
}
