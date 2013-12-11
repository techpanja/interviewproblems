package trees.test;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.treeproblems.MirrorTree;

/**
 * Check if a tree T1 is mirror of T2
 * User: rpanjrath
 * Date: 10/4/13
 * Time: 10:58 AM
 */
public class TestMirror {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree1 = new BinarySearchTreeImpl();
        binarySearchTree1.insertNode(4);
        binarySearchTree1.insertNode(2);
        binarySearchTree1.insertNode(1);
        binarySearchTree1.insertNode(8);
        BinarySearchTree<Integer> binarySearchTree2 = new BinarySearchTreeImpl();
        binarySearchTree2.insertNodeReverseOrder(3);
        binarySearchTree2.insertNodeReverseOrder(2);
        binarySearchTree2.insertNodeReverseOrder(1);
        binarySearchTree2.insertNodeReverseOrder(8);
        System.out.println(MirrorTree.checkTreeMirror(binarySearchTree1, binarySearchTree2));
    }
}
