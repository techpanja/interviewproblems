package trees.model;

/**
 * Enum specifying the type of traversal. INORDER, POSTORDER, PREORDER
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 2:50 PM
 */
public enum TraverseType {
    INORDER("inorder"), PREORDER("preorder"), POSTORDER("postorder");

    private String orderType;

    private TraverseType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderType() {
        return orderType;
    }
}
