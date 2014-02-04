package trees.sortedarraytobalancedtree;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.model.TraverseType;

import java.util.List;

/**
 * Given a sorted array, create a balanced tree.
 * Created by techpanja
 * Created on 1/20/14 12:56 PM.
 */
public class SortedArrayToBalancedTree {

    private static BinarySearchTree<Integer> searchTree;

    private SortedArrayToBalancedTree() {

    }

    public static BinarySearchTree createBalancedTree(int[] inputArray) {
        searchTree = new BinarySearchTreeImpl();
        if (inputArray.length < 1) {
            return searchTree;
        }
        int low = 0;
        int high = inputArray.length - 1;
        createBalancedTree(inputArray, low, high);
        return searchTree;
    }

    /*
    * Follow binary search technique to insert nodes into the tree.
    * */
    private static void createBalancedTree(int[] inputArray, int low, int high) {
        if (high < low) {
            return;
        }
        int mid = (low + high) / 2;
        searchTree.insertNode(inputArray[mid]);
        createBalancedTree(inputArray, low, mid - 1);
        createBalancedTree(inputArray, mid + 1, high);
    }

    public static void main(String[] args) {
        createBalancedTree(new int[]{2, 5, 6, 8, 11, 22, 33});
        List<Integer> list = searchTree.traverseTree(TraverseType.INORDER);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

}
