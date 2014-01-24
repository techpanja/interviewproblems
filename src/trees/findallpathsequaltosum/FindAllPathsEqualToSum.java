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

    private static List<String> allPaths = new ArrayList<>();
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

    /*
    * Paths not necessarily starting from root.
    * */
    public static List<String> findAllPaths(SearchNode rootNode, int sum) {
        List path = new ArrayList();
        findAllPaths(rootNode, sum, path);
        for (String str : allPaths) {
            System.out.println(str);
        }
        return allPaths;
    }

    private static void findAllPaths(SearchNode node, int sum, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.getData());
        int tempSum = 0;
        // At current node, find all the paths that end at the current node and sum is equal to inputSum.
        // Basically keep on checking if the current node completes (or constitutes) a path equal to sum.
        for (int i = path.size() - 1; i >= 0; i--) {
            tempSum = tempSum + path.get(i);
            if (tempSum == sum) {
                String pathEqualToSum = "";
                for (int j = i; j <= path.size() - 1; j++) {
                    pathEqualToSum = pathEqualToSum + path.get(j) + " -> ";
                }
                allPaths.add(pathEqualToSum);
            }
        }
        findAllPaths((SearchNode) node.getLeftChild(), sum, path);
        findAllPaths((SearchNode) node.getRightChild(), sum, path);

        // Make sure to clear up the nodes once done processing.
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(-1);
        binarySearchTree.insertNode(7);
        FindAllPathsEqualToSum.findAllPathsFromRoot(binarySearchTree.getRootOfTree(), 12);
        FindAllPathsEqualToSum.findAllPaths(binarySearchTree.getRootOfTree(), 7);
    }
}
