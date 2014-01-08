package trees.leastcommonancestorbst;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.model.SearchNode;

/**
 * Find least common ancestor of binary search tree.
 * Refer: http://www.fusu.us/2013/06/p3-lowest-common-ancestor-in-binary.html
 * Created by: techpanja
 * Created on: 1/7/14.
 */
public class FindLeastCommonAncestorBST {

    private FindLeastCommonAncestorBST() {
    }

    public static SearchNode findLeastCommonAncestorBST(BinarySearchTree searchTree, int node1, int node2) {
        return findLeastCommonAncestorBST(searchTree.getRootOfTree(), node1, node2);
    }

    private static SearchNode findLeastCommonAncestorBST(SearchNode currentRoot, int node1, int node2) {
        if (currentRoot == null) {
            return null;
        }
        // If both node's 1 & 2 have value greater than currentRoot then it means that they reside in right
        // subtree of currentRoot.
        if (node1 > currentRoot.getData() &&
                node2 > currentRoot.getData()) {
            return findLeastCommonAncestorBST((SearchNode) currentRoot.getRightChild(), node1, node2);
        } else if (node1 < currentRoot.getData() &&   // Both nodes are in left subtree of currentRoot.
                node2 < currentRoot.getData()) {
            return findLeastCommonAncestorBST((SearchNode) currentRoot.getLeftChild(), node1, node2);
        } else {
            return currentRoot;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(0);
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 4, 0));
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 4, 5));
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 4, 6));
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 2, 6));
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 6, 3));
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 6, 5));
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 1, 0));
        System.out.println(findLeastCommonAncestorBST(binarySearchTree, 2, 4));
    }
}
