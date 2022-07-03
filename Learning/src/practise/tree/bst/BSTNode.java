package practise.tree.bst;

public class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(int data) {
        this.data  = data;
        this.left  = null;
        this.right = null;
    }

    public BSTNode(int data, BSTNode left, BSTNode right) {
        this.data  = data;
        this.left  = left;
        this.right = right;
    }
}