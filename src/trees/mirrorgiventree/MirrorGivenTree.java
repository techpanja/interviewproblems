package trees.mirrorgiventree;

import trees.model.BinarySearchTree;
import trees.model.SearchNode;

/**
 * Description: Given a binary tree, mirror it.
 * User: techpanja
 */
public class MirrorGivenTree {

    public static BinarySearchTree mirrorTree(BinarySearchTree tree) {
        mirrorTreeRecursive(tree.getRootOfTree());
        return tree;
    }

    private static void mirrorTreeRecursive(SearchNode node) {
        if (node == null) {
            return;
        }
        SearchNode temp = (SearchNode) node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(temp);
        mirrorTreeRecursive((SearchNode) node.getLeftChild());
        mirrorTreeRecursive((SearchNode) node.getRightChild());
    }
}
