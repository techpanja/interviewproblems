package trees.test;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.model.SearchNode;
import trees.treeproblems.FindSumOfAllNodesExceptLeaf;

/**
 * Test class for findSumExceptLeafNodes
 * User: rpanjrath
 * Date: 10/15/13
 * Time: 4:11 PM
 */
public class TestFindSumExceptLeafNodes {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(6);
        System.out.println(FindSumOfAllNodesExceptLeaf.findSumExceptLeaf((SearchNode) binarySearchTree.retrieveTree()));
    }
}
