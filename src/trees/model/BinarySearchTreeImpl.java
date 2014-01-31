package trees.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    private void traversePreOrder(SearchNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            traversedNodesList.add(searchNode.getData());
            traversePreOrder((SearchNode) searchNode.getLeftChild(), traversedNodesList);
            traversePreOrder((SearchNode) searchNode.getRightChild(), traversedNodesList);
        }
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

    @Override
    public List traverseTreeNonRecursion(TraverseType traverseType) {
        List traversedNodesList = new ArrayList();
        if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.INORDER.toString())) {
            traverseInOrderNonRecursive(this.rootNode, traversedNodesList);
        } else if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.POSTORDER.toString())) {
            traversePostOrderNonRecursive(this.rootNode, traversedNodesList);
        } else {
            traversePreOrderNonRecursive(this.rootNode, traversedNodesList);
        }
        return traversedNodesList;
    }

    private void traversePreOrderNonRecursive(SearchNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            Stack<SearchNode> nodeStack = new Stack<>();
            nodeStack.push(searchNode);
            while (!nodeStack.isEmpty()) {
                SearchNode tempNode = nodeStack.pop();
                traversedNodesList.add(tempNode);
                if (tempNode.getRightChild() != null) {
                    nodeStack.push((SearchNode) tempNode.getRightChild());
                }
                if (tempNode.getLeftChild() != null) {
                    nodeStack.push((SearchNode) tempNode.getLeftChild());
                }
            }
        }
    }

    private void traverseInOrderNonRecursive(SearchNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            Stack<SearchNode> nodeStack = new Stack<>();
            SearchNode currentNode = searchNode;
            nodeStack.push(currentNode);
            while (!nodeStack.isEmpty()) {
                while (currentNode.getLeftChild() != null) {
                    nodeStack.push((SearchNode) currentNode.getLeftChild());
                    currentNode = (SearchNode) currentNode.getLeftChild();
                }
                currentNode = nodeStack.pop();
                traversedNodesList.add(currentNode);
                if (currentNode.getRightChild() != null) {
                    currentNode = (SearchNode) currentNode.getRightChild();
                    nodeStack.push(currentNode);
                }
            }
        }
    }

    /*
    * Push root to first stack.
    * Loop while first stack is not empty {
    *  -    Pop a node from first stack and push it to second stack
    *  -    Push left and right children of the popped node to first stack
    * }
    * Print contents of second stack
    * */
    private void traversePostOrderNonRecursive(SearchNode searchNode, List traversedNodesList) {
        Stack<SearchNode> nodeStack1 = new Stack<>();
        Stack<SearchNode> nodeStack2 = new Stack<>();
        nodeStack1.push(searchNode);
        while (!nodeStack1.empty()) {
            SearchNode tempNode = nodeStack1.pop();
            nodeStack2.push(tempNode);
            if (tempNode.getLeftChild() != null) {
                nodeStack1.push((SearchNode) tempNode.getLeftChild());
            }
            if (tempNode.getRightChild() != null) {
                nodeStack1.push((SearchNode) tempNode.getRightChild());
            }
        }
        while (!nodeStack2.empty()) {
            traversedNodesList.add(nodeStack2.pop());
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
    public SearchNode getRootOfTree() {
        return this.rootNode;
    }
}
