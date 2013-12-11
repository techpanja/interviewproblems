package trees.treeproblems;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.model.TraverseType;

import java.util.Collections;
import java.util.List;

/**
 * Check if a tree T2 is mirror of BinarySearchTree T1.
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 4:53 PM
 */
public class MirrorTree {

    private MirrorTree() {

    }

    public static boolean checkTreeMirror(BinarySearchTree tree1, BinarySearchTree tree2) {
        if (tree1 instanceof BinarySearchTreeImpl && tree2 instanceof BinarySearchTreeImpl) {
            List list1 = tree1.traverseTree(TraverseType.INORDER);
            List list2 = tree2.traverseTree(TraverseType.INORDER);
            Collections.reverse(list2);
            return list1.equals(list2);
        }
        return false;
    }
}
