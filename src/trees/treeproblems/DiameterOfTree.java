package trees.treeproblems;

import trees.model.SearchNode;

/**
 * Diameter of a Tree is defined as the number of nodes on the longest path between two leaves in the tree.
 * http://crackinterviewtoday.wordpress.com/2010/03/11/diameter-of-a-binary-tree/
 * User: rpanjrath
 * Date: 10/15/13
 * Time: 3:21 PM
 */

public class DiameterOfTree {

    public int diameterOfTree(SearchNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightOfTree((SearchNode) node.getLeftChild());
        int rightHeight = heightOfTree((SearchNode) node.getRightChild());
        int leftDiameter = diameterOfTree((SearchNode) node.getLeftChild());
        int rightDiameter = diameterOfTree((SearchNode) node.getRightChild());
        int pathLengthTroughRoot = leftHeight + rightHeight + 1;
        int maxOfLeftAndRightDiameter = Math.max(leftDiameter, rightDiameter);
        return Math.max(pathLengthTroughRoot, maxOfLeftAndRightDiameter);
    }

    /*
    * Find max height of tree. Similar to balanced tree.
    * */
    private int heightOfTree(SearchNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeftHeight = heightOfTree((SearchNode) node.getLeftChild());
        int maxRightHeight = heightOfTree((SearchNode) node.getRightChild());
        int max = Math.max(maxLeftHeight, maxRightHeight);
        return 1 + max;
    }
}
