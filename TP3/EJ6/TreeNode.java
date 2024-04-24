package TP3.EJ6;

public class TreeNode {
    private Libro value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Libro value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    public Libro getValue() {
        return value;
    }
}
