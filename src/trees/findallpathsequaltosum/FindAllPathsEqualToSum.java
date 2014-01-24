package trees.findallpathsequaltosum;

import trees.model.BinarySearchTree;
import trees.model.BinarySearchTreeImpl;
import trees.model.SearchNode;

import java.util.ArrayList;
import java.util.List;

/**
 * All paths with Specified Sum in Binary Tree.
 * User: rpanjrath
 * Date: 10/4/13
 * Time: 4:47 PM
 */
public class FindAllPathsEqualToSum {

    private static int sum = 10;

    /*
    * Paths starting from root only.
    * */
    public static List<String> findAllPathsFromRoot(SearchNode rootNode, int inputSum) {
        sum = inputSum;
        SearchNode currentNode = rootNode;
        List<String> pathsList = new ArrayList<>();
        findPathsFromRoot(currentNode, pathsList, 0, "");
        for (String str : pathsList) {
            System.out.println(str);
        }
        return pathsList;
    }

    private static void findPathsFromRoot(SearchNode currentNode, List<String> pathsList, int counter, String inputString) {
        if (currentNode == null) {
            return;
        }
        counter = counter + currentNode.getData();
        inputString = inputString.concat(currentNode.toString());
        if (counter == sum) {
            pathsList.add(inputString);
        }
        inputString = inputString.concat("->");
        findPathsFromRoot((SearchNode) currentNode.getLeftChild(), pathsList, counter, inputString);
        findPathsFromRoot((SearchNode) currentNode.getRightChild(), pathsList, counter, inputString);
    }

    public static List<String> findAllPaths(SearchNode rootNode, int sum) {
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(7);
        FindAllPathsEqualToSum.findAllPathsFromRoot(binarySearchTree.getRootOfTree(), 12);
    }
}
