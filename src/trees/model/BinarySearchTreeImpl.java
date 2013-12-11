package trees.model;

import java.util.ArrayList;
import java.util.List;

/**
 * BinarySearchTree implementation
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 12:40 PM
 */
public class BinarySearchTreeImpl implements BinarySearchTree<Integer> {

    private SearchNode rootNode;

    public BinarySearchTreeImpl() {
        this.rootNode = null;
    }

    @Override
    public void insertNode(Integer data) {
        if (data != null) {
            SearchNode newSearchNode = new SearchNode();
            newSearchNode.setData(data);
            if (rootNode == null) {
                rootNode = newSearchNode;
            } else {
                SearchNode currentNode = rootNode;
                while (true) {
                    if (newSearchNode.getData() < currentNode.getData()) {
                        if (currentNode.getLeftChild() == null) {
                            currentNode.setLeftChild(newSearchNode);
                            break;
                        }
                        currentNode = (SearchNode) currentNode.getLeftChild();
                    } else {
                        if (currentNode.getRightChild() == null) {
                            currentNode.setRightChild(newSearchNode);
                            break;
                        }
                        currentNode = (SearchNode) currentNode.getRightChild();
                    }
                }
            }
        }
    }

    @Override
    public void insertNodeReverseOrder(Integer data) {
        if (data != null) {
            SearchNode newSearchNode = new SearchNode();
            newSearchNode.setData(data);
            if (rootNode == null) {
                rootNode = newSearchNode;
            } else {
                SearchNode currentNode = rootNode;
                while (true) {
                    if (newSearchNode.getData() > currentNode.getData()) {
                        if (currentNode.getLeftChild() == null) {
                            currentNode.setLeftChild(newSearchNode);
                            break;
                        }
                        currentNode = (SearchNode) currentNode.getLeftChild();
                    } else {
                        if (currentNode.getRightChild() == null) {
                            currentNode.setRightChild(newSearchNode);
                            break;
                        }
                        currentNode = (SearchNode) currentNode.getRightChild();
                    }
                }
            }
        }
    }

    @Override
    public List traverseTree(TraverseType traverseType) {
        List traversedNodesList = new ArrayList();
        if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.INORDER.toString())) {
            traverseInOrder(this.rootNode, traversedNodesList);
        } else if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.POSTORDER.toString())) {
            traversePostOrder(this.rootNode, traversedNodesList);
        } else {
            traversePreOrder(this.rootNode, traversedNodesList);
        }
        return traversedNodesList;
    }

    private void traverseInOrder(SearchNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            traverseInOrder((SearchNode) searchNode.getLeftChild(), traversedNodesList);
            traversedNodesList.add(searchNode.getData());
            traverseInOrder((SearchNode) searchNode.getRightChild(), traversedNodesList);
        }
    }

    private void traversePostOrder(SearchNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            traversePostOrder((SearchNode) searchNode.getLeftChild(), traversedNodesList);
            traversePostOrder((SearchNode) searchNode.getRightChild(), traversedNodesList);
            traversedNodesList.add(searchNode.getData());
        }
    }

    private void traversePreOrder(SearchNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            traversedNodesList.add(searchNode.getData());
            traversePreOrder((SearchNode) searchNode.getLeftChild(), traversedNodesList);
            traversePreOrder((SearchNode) searchNode.getRightChild(), traversedNodesList);
        }
    }

    @Override
    public StringBuilder traverseTreeInString(TraverseType traverseType) {
        List<Integer> traversedNodesList = traverseTree(traverseType);
        StringBuilder traversedNodesBuilder = new StringBuilder();
        for (Integer integer : traversedNodesList) {
            traversedNodesBuilder.append(integer.toString());
        }
        return traversedNodesBuilder;
    }

    @Override
    public SearchNode retrieveTree() {
        return this.rootNode;
    }
}
