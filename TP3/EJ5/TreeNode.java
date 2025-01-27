package TP3.EJ5;

public class TreeNode {
    private char value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public void setValue(char value) {
        this.value = value;
    }

    public TreeNode(char value) {
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


    public char getValue() {
        return value;
    }
}
