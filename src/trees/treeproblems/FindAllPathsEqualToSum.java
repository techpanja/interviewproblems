package trees.treeproblems;

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

    public static List<String> findAllPaths(SearchNode rootNode, int inputSum) {
        sum = inputSum;
        SearchNode currentNode = rootNode;
        List<String> pathsList = new ArrayList<String>();
        findPaths(currentNode, pathsList, 0, "");
        for (String str : pathsList) {
            System.out.println(str);
        }
        return pathsList;
    }

    private static void findPaths(SearchNode currentNode, List<String> pathsList, int counter, String inputString) {
        if (currentNode == null) {
            return;
        }
        counter = counter + currentNode.getData();
        inputString = inputString.concat(currentNode.toString());
        if (counter == sum) {
            pathsList.add(inputString);
        }
        inputString = inputString.concat("->");
        findPaths((SearchNode) currentNode.getLeftChild(), pathsList, counter, inputString);
        findPaths((SearchNode) currentNode.getRightChild(), pathsList, counter, inputString);
    }
}
