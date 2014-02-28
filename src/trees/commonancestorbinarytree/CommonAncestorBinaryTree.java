package trees.commonancestorbinarytree;

import trees.model.BinarySearchTree;
import trees.model.SearchNode;

/**
 * Find common ancestor of two nodes in a binary tree (not necessarily BST)
 * Created by techpanja
 * Created on 1/24/14 1:04 PM.
 */
public class CommonAncestorBinaryTree {

    public static SearchNode findCommonAncestor(BinarySearchTree searchTree,
                                                SearchNode node1,
                                                SearchNode node2) {
        return findCommonAncestor(searchTree.getRootOfTree(), node1, node2);
    }

    private static SearchNode findCommonAncestor(SearchNode rootOfTree, SearchNode node1, SearchNode node2) {
        if (rootOfTree == null) {
            return null;
        }

        // if either of node1 or node2 itself is the common ancestor.
        if (rootOfTree == node1 || rootOfTree == node2) {
            return rootOfTree;
        }

        // Check if node1 and node2 are in the left subtree of root.
        boolean isNode1OnLeft = isLeftOrRightNode((SearchNode) rootOfTree.getLeftChild(), node1);
        boolean isNode2OnLeft = isLeftOrRightNode((SearchNode) rootOfTree.getLeftChild(), node2);

        // If node1 and node2 on left and right branches of current root, root is the common ancestor.
        if (isNode1OnLeft != isNode2OnLeft) {
            return rootOfTree;
        }

        // if node1 and node2 and on the same side then decide on which side of the root to proceed.
        SearchNode newRoot = (SearchNode) (isNode1OnLeft ? rootOfTree.getLeftChild() : rootOfTree.getRightChild());
        return findCommonAncestor(newRoot, node1, node2);
    }

    /*
    * Returns true if given node is in the subTree of root.
    * */
    private static boolean isLeftOrRightNode(SearchNode root, SearchNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        boolean isLeft = isLeftOrRightNode((SearchNode) root.getLeftChild(), node);
        boolean isRight = isLeftOrRightNode((SearchNode) root.getRightChild(), node);
        return isLeft || isRight;
    }
}
