package trees.treeproblems;

import trees.model.SearchNode;

/**
 * Check if tree is a balanced tree.
 * http://dsinjava.blogspot.com/2011/03/how-to-check-if-tree-is-balanced.html.. final condition is wrong on site.
 *
 * a balanced binary search tree will have equal heights (plus or minus one) on the left and right sub-trees of each node.
 *
 * User: rpanjrath
 * Date: 10/4/13
 * Time: 1:57 PM
 */
public class CheckBalancedTree {

    /*
    * Enforcing use of static methods only.
    * */
    private CheckBalancedTree() {

    }

    public static boolean isTreeBalanced(SearchNode rootNode) {
        int maxDepth = maxDepth(rootNode);
        int minDepth = minDepth(rootNode);
        System.out.println("max depth " + maxDepth);
        System.out.println("min depth " + minDepth);
        return maxDepth - minDepth <= 1;
    }

    private static int maxDepth(SearchNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int maxLeft = maxDepth((SearchNode) currentNode.getLeftChild());
        int maxRight = maxDepth((SearchNode) currentNode.getRightChild());
        int max = Math.max(maxLeft, maxRight);
        return 1 + max;
    }

    private static int minDepth(SearchNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int minLeft = minDepth((SearchNode) currentNode.getLeftChild());
        int minRight = minDepth((SearchNode) currentNode.getRightChild());
        int min = Math.min(minLeft, minRight);
        return 1 + min;
    }
}
