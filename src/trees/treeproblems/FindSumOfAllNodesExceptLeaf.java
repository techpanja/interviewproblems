package trees.treeproblems;

import trees.model.SearchNode;

/**
 * Find sum of all nodes except the leaf nodes.
 * User: rpanjrath
 * Date: 10/15/13
 * Time: 3:36 PM
 */
public class FindSumOfAllNodesExceptLeaf {

    private static int sum = 0;

    public static int findSumExceptLeaf(SearchNode node) {
        findSum(node);
        return sum;
    }

    private static void findSum(SearchNode node) {
        if (node == null) {
            return;
        }
        if (node.getRightChild() == null && node.getLeftChild() == null) {
            return;
        }
        findSum((SearchNode) node.getLeftChild());
        findSum((SearchNode) node.getRightChild());
        sum = sum + node.getData();
    }
}
