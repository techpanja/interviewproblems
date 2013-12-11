package trees.treeproblems;

import trees.model.BinarySearchTree;
import trees.model.TraverseType;

/**
 * Check if a tree T1 is a sub tree of tree T2.
 * User: rpanjrath
 * Date: 10/4/13
 * Time: 12:49 PM
 */
public class CheckSubtree {

    public static boolean checkSubtree(BinarySearchTree parentTree, BinarySearchTree subTree) {
        StringBuilder parentInorder = parentTree.traverseTreeInString(TraverseType.INORDER);
        StringBuilder parentPreOrder = parentTree.traverseTreeInString(TraverseType.PREORDER);
        StringBuilder subInorder = subTree.traverseTreeInString(TraverseType.INORDER);
        StringBuilder subPreorder = subTree.traverseTreeInString(TraverseType.PREORDER);

        return parentInorder.toString().contains(subInorder.toString()) &&
                parentPreOrder.toString().contains(subPreorder.toString());
    }
}
