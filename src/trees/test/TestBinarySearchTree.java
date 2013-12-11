package trees.test;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.model.SearchNode;
import trees.model.TraverseType;

import java.util.Iterator;
import java.util.List;

/**
 * Test Class.
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 3:27 PM
 */
public class TestBinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(0);
        SearchNode rootNode = (SearchNode) binarySearchTree.retrieveTree();
        List list = binarySearchTree.traverseTree(TraverseType.INORDER);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
