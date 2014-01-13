package trees.isbst;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.model.SearchNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Check if tree is Binary Search Tree
 * Hint: Modified in order traversal
 * User: rahulpanjrath
 * Date: 1/11/14
 * Time: 4:18 PM
 */
public class CheckIfTreeIsBst {

    private static ArrayList<Integer> inOrderList = new ArrayList<Integer>();
    private static boolean isBst = true;

    public static boolean isBstUsingRecursion(BinarySearchTree searchTree) {
        SearchNode node = searchTree.getRootOfTree();
        if (node == null) {
            return false;
        }
        isBstUsingRecursion(node);
        return isBst;
    }

    private static void isBstUsingRecursion(SearchNode node) {
        if (node != null) {
            isBstUsingRecursion((SearchNode) node.getLeftChild());
            if (isBst) {
                inOrderList.add(node.getData());
                checkOrder();
                isBstUsingRecursion((SearchNode) node.getRightChild());
            }
        }
    }

    public static boolean isBstNonRecursive(BinarySearchTree searchTree) {
        SearchNode node = searchTree.getRootOfTree();
        if (node == null) {
            return false;
        }
        isBstNonRecursive(node);
        return isBst;
    }

    private static void isBstNonRecursive(SearchNode node) {
        Stack<SearchNode> stack = new Stack<SearchNode>();
        stack.push(node);
        while (!stack.isEmpty() && isBst) {
            while (node.getLeftChild() != null && !node.isVisited()) {
                node = (SearchNode) node.getLeftChild();
                stack.push(node);
            }
            node = stack.pop();
            node.setVisited(true);
            inOrderList.add(node.getData());
            checkOrder();
            if (node.getRightChild() != null) {
                node = (SearchNode) node.getRightChild();
                stack.push(node);
            }
        }
    }

    private static void checkOrder() {
        if (inOrderList.size() > 1) {
            if (inOrderList.get(inOrderList.size() - 1) <
                    inOrderList.get(inOrderList.size() - 2)) {
                isBst = false;
                return;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTreeImpl();
//        binarySearchTree.insertNode(3);
//        binarySearchTree.insertNode(2);
//        binarySearchTree.insertNode(4);
//        binarySearchTree.insertNode(5);
//        binarySearchTree.insertNode(6);
//        binarySearchTree.insertNode(1);
//        binarySearchTree.insertNode(0);

        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(0);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(8);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(10);
        System.out.println(isBstUsingRecursion(binarySearchTree));
        System.out.println(isBstNonRecursive(binarySearchTree));
    }
}
