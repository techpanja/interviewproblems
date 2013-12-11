package trees.test;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.treeproblems.CheckSubtree;

/**
 * Test class for checking subtree.
 * User: rpanjrath
 * Date: 10/4/13
 * Time: 1:22 PM
 */
public class TestSubtree {

    public static void main(String args[]) {
        BinarySearchTree parentTree = new BinarySearchTreeImpl();
        parentTree.insertNode(4);
        parentTree.insertNode(3);
        parentTree.insertNode(2);
        parentTree.insertNode(1);
        parentTree.insertNode(5);
        parentTree.insertNode(6);
        BinarySearchTree subTree = new BinarySearchTreeImpl();
        subTree.insertNode(5);
        subTree.insertNode(6);
        System.out.println(CheckSubtree.checkSubtree(parentTree, subTree));
    }
}
