package trees.test;

import trees.findallpathsequaltosum.FindAllPathsEqualToSum;
import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;

/**
 * Test class for @FindAllPathsEqualToSum
 * User: rpanjrath
 * Date: 10/4/13
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestAllPaths {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(7);
        FindAllPathsEqualToSum.findAllPaths(binarySearchTree.getRootOfTree(), 12);
    }
}
